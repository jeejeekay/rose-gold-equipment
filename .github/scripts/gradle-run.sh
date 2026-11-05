#!/usr/bin/env bash
# Runs a Gradle command; if it fails, copies the useful part of the log into a
# GitHub "error annotation" so it shows on the commit's checks without opening logs.
# usage: .github/scripts/gradle-run.sh <label> <gradle args...>
label="$1"; shift
log="$(mktemp)"
./gradlew "$@" --console=plain 2>&1 | tee "$log"
code=${PIPESTATUS[0]}
if [ "$code" -ne 0 ]; then
  {
    grep -E "^\S+\.java:[0-9]+: error:|^e: |error: |^> |What went wrong|Could not|Caused by|Exception|FAILED" "$log" \
      | grep -vE "^> (Task|Configure)" | head -60
  } > "$log.err"
  msg=$(sed 's/%/%25/g' "$log.err" | awk '{printf "%s%%0A", $0}')
  echo "::error title=${label} failed::${msg}"
fi
exit "$code"
