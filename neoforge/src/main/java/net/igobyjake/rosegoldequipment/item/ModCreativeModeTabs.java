package net.igobyjake.rosegoldequipment.item;

import net.igobyjake.rosegoldequipment.rosegoldequipment;
import net.igobyjake.rosegoldequipment.block.ModBlocks;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, rosegoldequipment.MOD_ID);

    public static final Supplier<CreativeModeTab> ROSE_GOLD_ITEMS_TAB = CREATIVE_MODE_TAB.register("rose_gold_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ROSE_GOLD_INGOT.get()))
                    .title(Component.translatable("creativetab.rosegoldequipment.rose_gold_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ROSE_GOLD_INGOT);
                        output.accept(ModItems.ROSE_GOLD_NUGGET);
                        output.accept(ModItems.RAW_ROSE_GOLD);

                        output.accept(ModItems.ROSE_MUSHROOM_CRUMBS);
                        output.accept(ModItems.ROSE_MUSHROOM_PARTIAL);
                        output.accept(ModItems.ROSE_MUSHROOM_OMELETTE);
                        output.accept(ModItems.ROSE_HALF_JELLY);
                        output.accept(ModItems.ROSE_FULL_JELLY);
                        output.accept(ModItems.ROSE_GILDED_BEETROOT);
                        output.accept(ModItems.ROSE_GILDED_COOKIE);
                        output.accept(ModItems.ROSE_GILDED_MUSHROOM);
                        output.accept(ModItems.ROSEY_BEETROOT_STEW);

                        output.accept(ModItems.ROSE_GOLDEN_SWORD);
                        output.accept(ModItems.ROSE_GOLDEN_PICKAXE);
                        output.accept(ModItems.ROSE_GOLDEN_SHOVEL);
                        output.accept(ModItems.ROSE_GOLDEN_AXE);
                        output.accept(ModItems.ROSE_GOLDEN_HOE);

                        output.accept(ModItems.ROSE_GOLDEN_HELMET);
                        output.accept(ModItems.ROSE_GOLDEN_CHESTPLATE);
                        output.accept(ModItems.ROSE_GOLDEN_LEGGINGS);
                        output.accept(ModItems.ROSE_GOLDEN_BOOTS);

                        output.accept(ModBlocks.ROSE_GOLD_BLOCK);
                        output.accept(ModBlocks.RAW_ROSE_GOLD_BLOCK);
                        output.accept(ModBlocks.ROSE_GOLD_DOOR);
                        output.accept(ModBlocks.ROSE_GOLD_TRAPDOOR);
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
