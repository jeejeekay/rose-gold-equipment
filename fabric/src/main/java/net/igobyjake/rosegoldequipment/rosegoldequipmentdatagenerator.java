package net.igobyjake.rosegoldequipment;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.igobyjake.rosegoldequipment.datagen.ModBlockTagProvider;
import net.igobyjake.rosegoldequipment.datagen.ModItemTagProvider;
import net.igobyjake.rosegoldequipment.datagen.ModModelProvider;
import net.igobyjake.rosegoldequipment.datagen.ModRegistryDataGenerator;
import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class rosegoldequipmentdatagenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRegistryDataGenerator::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModTrimMaterials::bootstrap);
    }
}
