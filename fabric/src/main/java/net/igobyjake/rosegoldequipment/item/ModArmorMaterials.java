package net.igobyjake.rosegoldequipment.item;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> ROSE_GOLD_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(rosegoldequipment.MOD_ID, "rose_gold"));

    public static final ArmorMaterial ROSE_GOLD_ARMOR_MATERIAL = new ArmorMaterial(20, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 2);
        map.put(EquipmentType.LEGGINGS, 5);
        map.put(EquipmentType.CHESTPLATE, 7);
        map.put(EquipmentType.HELMET, 3);
        map.put(EquipmentType.BODY, 4);
    }), 45, SoundEvents.ITEM_ARMOR_EQUIP_GOLD,0,0, ModTags.Items.ROSE_GOLD_REPAIR, ROSE_GOLD_KEY);
}
