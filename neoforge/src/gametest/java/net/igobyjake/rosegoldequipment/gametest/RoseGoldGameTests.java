package net.igobyjake.rosegoldequipment.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

// Registers each check as a test function. The tests themselves (which function, how long
// it may take, which structure) are the JSON files in src/gametest/resources/data/rosegoldequipment/test_instance/.
// Run them with ./gradlew runGameTestServer. The checks are in RoseGoldChecks.
@EventBusSubscriber(modid = "rosegoldequipment")
public class RoseGoldGameTests {
    @SubscribeEvent
    public static void registerTests(RegisterEvent event) {
        event.register(Registries.TEST_FUNCTION, helper -> {
            helper.register(id("trim_material"), RoseGoldChecks::trimMaterial);
            helper.register(id("trim_smithing"), RoseGoldChecks::trimSmithing);
            helper.register(id("armor"), RoseGoldChecks::armor);
            helper.register(id("tools"), RoseGoldChecks::tools);
            helper.register(id("block_drops"), RoseGoldChecks::blockDrops);
            helper.register(id("foods"), RoseGoldChecks::foods);
        });
    }

    private static Identifier id(String name) {
        return Identifier.fromNamespaceAndPath("rosegoldequipment", name);
    }
}
