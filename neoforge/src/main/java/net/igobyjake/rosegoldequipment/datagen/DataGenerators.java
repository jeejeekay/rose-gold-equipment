package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

import java.util.concurrent.CompletableFuture;

// Runs when you use the "data" run configuration (./gradlew runData).
@EventBusSubscriber(modid = rosegoldequipment.MOD_ID)
public class DataGenerators {
    // 26.3: datapack registry entries (our trim material) are registered here
    // instead of through a DatapackBuiltinEntriesProvider.
    @SubscribeEvent
    public static void gatherDataRegistryEntries(GatherDataRegistryEntriesEvent event) {
        event.gatherFor(rosegoldequipment.MOD_ID)
                .add(Registries.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
    }

    // GatherDataEvent.Client generates BOTH client assets and server data.
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getReloadableLookupProvider();

        generator.addProvider(true, new ModBlockTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new ModModelProvider(packOutput));
    }
}
