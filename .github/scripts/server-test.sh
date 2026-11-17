#!/usr/bin/env bash
# Starts a vanilla Minecraft server with the datapack, makes every rose gold item, and fails if
# anything didn't load. Used by .github/workflows/datapack.yml.  usage: server-test.sh <minecraft version>
set -euo pipefail
MC="$1"
ROOT="$(cd "$(dirname "$0")/../.." && pwd)"
RUN="$ROOT/run"
ITEMS=$(grep -c '^execute if entity' "$ROOT/datapack/data/rosegoldequipment/function/test/selftest.mcfunction")

rm -rf "$RUN" && mkdir -p "$RUN/world/datapacks" && cd "$RUN"

# 1. The official server jar for this version, from Mojang's version list.
VERSION_URL=$(curl -fsS https://piston-meta.mojang.com/mc/game/version_manifest_v2.json |
  python3 -c "import json,sys; print(next(v['url'] for v in json.load(sys.stdin)['versions'] if v['id']=='$MC'))")
SERVER_URL=$(curl -fsS "$VERSION_URL" | python3 -c "import json,sys; print(json.load(sys.stdin)['downloads']['server']['url'])")
curl -fsS -o server.jar "$SERVER_URL"

# 2. A small flat test world with the datapack in it.
echo "eula=true" > eula.txt
cat > server.properties <<EOF
level-type=minecraft\:flat
generate-structures=false
online-mode=false
spawn-protection=0
view-distance=3
simulation-distance=3
EOF
cp -r "$ROOT/datapack" world/datapacks/rosegoldequipment

# 3. Start it, feeding commands through a pipe.
mkfifo console
java -Xmx2G -jar server.jar nogui < console > server.log 2>&1 &
PID=$!
exec 3> console

wait_for() {  # wait_for <text> <seconds>
  for _ in $(seq 1 "$2"); do
    grep -q "$1" server.log && return 0
    kill -0 $PID 2>/dev/null || { echo "server stopped early"; return 1; }
    sleep 1
  done
  echo "timed out waiting for: $1"; return 1
}

status=0
if wait_for 'Done (' 600; then
  echo "datapack list enabled" >&3
  echo "forceload add 0 0" >&3
  sleep 5
  echo "function rosegoldequipment:test/selftest" >&3
  wait_for "SELFTEST-DONE" 60 || status=1
fi
echo "stop" >&3
exec 3>&-
wait $PID || true

# 4. Results.
echo "----- server log -----"; cat server.log; echo "----------------------"
fail() { echo "::error::$1"; status=1; }
grep -q 'file/rosegoldequipment' server.log || fail "the datapack was not enabled"
grep -q 'SELFTEST-DONE' server.log || fail "the self test did not finish"
ok=$(grep -c 'SELFTEST-OK' server.log || true)
[ "$ok" -eq "$ITEMS" ] || fail "only $ok of $ITEMS items came out right"
for item in $(grep -o 'SELFTEST-OK [a-z_]*' "$ROOT/datapack/data/rosegoldequipment/function/test/selftest.mcfunction" | cut -d' ' -f2); do
  grep -q "SELFTEST-OK $item" server.log || fail "item did not come out right: $item"
done
# Anything that failed to load (recipes, loot tables, functions, tags, trim material) is logged as an error or warning.
bad=$(grep -E '(ERROR|WARN)' server.log | grep -iE 'rosegoldequipment|datapack|data pack|parse|Failed to load|Couldn.t' || true)
[ -z "$bad" ] || fail "errors while loading the datapack: $(echo "$bad" | head -20)"
exit $status
