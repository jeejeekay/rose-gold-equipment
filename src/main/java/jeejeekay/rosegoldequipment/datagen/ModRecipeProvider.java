package jeejeekay.rosegoldequipment.datagen;

import jeejeekay.rosegoldequipment.block.ModBlocks;
import jeejeekay.rosegoldequipment.item.custom.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static List<ItemConvertible> ROSE_GOLD_SMELTABLE = List.of(ModItems.RAW_ROSE_GOLD,
            ModItems.ROSE_GOLDEN_SWORD,ModItems.ROSE_GOLDEN_HOE,ModItems.ROSE_GOLDEN_PICKAXE,ModItems.ROSE_GOLDEN_SHOVEL,ModItems.ROSE_GOLDEN_AXE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //offerSmelting(exporter, ROSE_GOLD_SMELTABLE, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, 1, 200,"rose_gold_ingot");
        //offerBlasting(exporter, ROSE_GOLD_SMELTABLE, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, 1, 100,"rose_gold_ingot");

        //offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.RAW_ROSE_GOLD, RecipeCategory.DECORATIONS, ModBlocks.RAW_ROSE_GOLD_BLOCK);
        //offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.ROSE_GOLD_INGOT, RecipeCategory.DECORATIONS, ModBlocks.ROSE_GOLD_BLOCK);

        //ShapedRecipeJsonBuilder.create
    }
}
