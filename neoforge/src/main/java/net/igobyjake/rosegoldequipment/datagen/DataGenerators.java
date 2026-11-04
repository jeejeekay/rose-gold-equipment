package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

// Runs when you use the "data" run configuration (./gradlew runData).
// GatherDataEvent.Client generates BOTH client assets and server data.
@EventBusSubscriber(modid = rosegoldequipment.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModDatapackProvider(packOutput, lookupProvider));
    }
}
