package net.igobyjake.rosegoldequipment.trim;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> ROSE_GOLD =
            ResourceKey.create(Registries.TRIM_MATERIAL, Identifier.fromNamespaceAndPath(rosegoldequipment.MOD_ID, "rose_gold"));

    // Text colour of "Rose Gold Material" in the armor tooltip (matches the trim palette).
    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ROSE_GOLD, Style.EMPTY.withColor(TextColor.parseColor("#FFBBB6").getOrThrow()));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> trimKey, Style style) {
        TrimMaterial trimmaterial = new TrimMaterial(MaterialAssetGroup.create("rose_gold"),
                Component.translatable(Util.makeDescriptionId("trim_material", trimKey.identifier())).withStyle(style));
        context.register(trimKey, trimmaterial);
    }
}
