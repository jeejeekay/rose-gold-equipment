package net.igobyjake.rosegoldequipment.datagen;

import net.igobyjake.rosegoldequipment.trim.ModTrimMaterials;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.client.renderer.item.properties.select.TrimMaterialProperty;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.ArrayList;
import java.util.List;

/**
 * Item models for rose gold armor that show trims on the icon.
 *
 * Vanilla's ItemModelGenerators#generateTrimmableItem only knows the vanilla trim
 * materials, so a rose gold helmet trimmed WITH rose gold would show no trim on its
 * icon. This does the same thing as vanilla (Minecraft 26.3 version), plus one
 * extra case for our own rose gold trim material.
 *
 * Identical file in fabric/ and neoforge/ — it only uses vanilla classes.
 */
public final class TrimmedArmorModels {
    private TrimmedArmorModels() {}

    public static void generate(ItemModelGenerators generators, Item armor, Identifier slotTrimPrefix) {
        Identifier modelLocation = ModelLocationUtils.getModelLocation(armor);
        Material itemTexture = TextureMapping.getItemTexture(armor);

        List<SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>>> cases = new ArrayList<>();
        for (ItemModelGenerators.TrimMaterialData material : ItemModelGenerators.TRIM_MATERIAL_MODELS) {
            cases.add(trimCase(generators, modelLocation, itemTexture, slotTrimPrefix,
                    material.palette().suffix(), material.materialKey()));
        }
        cases.add(trimCase(generators, modelLocation, itemTexture, slotTrimPrefix,
                "rose_gold", ModTrimMaterials.ROSE_GOLD));

        // Untrimmed model + the item definition that picks a model per trim material.
        ModelTemplates.FLAT_ITEM.create(modelLocation, TextureMapping.layer0(itemTexture), generators.modelOutput);
        generators.itemModelOutput.accept(armor, ItemModelUtils.select(new TrimMaterialProperty(),
                ItemModelUtils.plainModel(modelLocation), cases));
    }

    private static SelectItemModel.SwitchCase<ResourceKey<TrimMaterial>> trimCase(
            ItemModelGenerators generators, Identifier modelLocation, Material itemTexture,
            Identifier slotTrimPrefix, String suffix, ResourceKey<TrimMaterial> material) {
        Identifier trimModel = modelLocation.withSuffix("_" + suffix + "_trim");
        generators.generateLayeredItem(trimModel, itemTexture, new Material(slotTrimPrefix.withSuffix("_" + suffix)));
        return ItemModelUtils.when(material, ItemModelUtils.plainModel(trimModel));
    }
}
