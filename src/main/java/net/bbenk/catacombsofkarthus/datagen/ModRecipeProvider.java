package net.bbenk.catacombsofkarthus.datagen;

import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOULCRYSTAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SSOULCRYSTAL.get())
                .unlockedBy("has_ssoulcrystal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.SSOULCRYSTAL.get()).build())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SSOULCRYSTAL.get(), 9). requires(ModBlocks.SOULCRYSTAL_BLOCK.get())
                .unlockedBy("has_soulcrystal_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.SOULCRYSTAL_BLOCK.get()).build())).save(pWriter);

        //nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.ITEMCRAFTSINTO.get(), RecipeCategory.MISC, ModBlocks.THEBLOCKCRAFTED.get());
    }
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

}
