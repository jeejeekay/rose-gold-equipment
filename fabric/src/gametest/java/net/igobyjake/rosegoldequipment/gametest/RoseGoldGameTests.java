package net.igobyjake.rosegoldequipment.gametest;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

// Fabric runs every @GameTest method listed through the "fabric-gametest" entrypoint
// (src/gametest/resources/fabric.mod.json). The checks themselves are in RoseGoldChecks.
public class RoseGoldGameTests {
    @GameTest
    public void trimMaterial(GameTestHelper helper) { RoseGoldChecks.trimMaterial(helper); }

    @GameTest
    public void trimSmithing(GameTestHelper helper) { RoseGoldChecks.trimSmithing(helper); }

    @GameTest
    public void armor(GameTestHelper helper) { RoseGoldChecks.armor(helper); }

    @GameTest
    public void tools(GameTestHelper helper) { RoseGoldChecks.tools(helper); }

    @GameTest
    public void blockDrops(GameTestHelper helper) { RoseGoldChecks.blockDrops(helper); }

    @GameTest
    public void foods(GameTestHelper helper) { RoseGoldChecks.foods(helper); }

    @GameTest
    public void showcaseLoads(GameTestHelper helper) { RoseGoldChecks.showcaseLoads(helper); }
}
