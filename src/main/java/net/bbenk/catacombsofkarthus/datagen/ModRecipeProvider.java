package net.bbenk.catacombsofkarthus.datagen;

import net.bbenk.catacombsofkarthus.CatacombsofKarthus;
import net.bbenk.catacombsofkarthus.block.ModBlocks;
import net.bbenk.catacombsofkarthus.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOULSTONE_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SOULSTONE.get())
                .unlockedBy("has_ssoulcrystal", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.SOULSTONE.get()).build())).save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SOULSTONE.get(), 9). requires(ModBlocks.SOULSTONE_BLOCK.get())
                .unlockedBy("has_soulcrystal_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.SOULSTONE_BLOCK.get()).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_PICK.get())
                .pattern("AAA")
                .pattern(" B ")
                .pattern(" C ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.LAPIS_LAZULI)
                .define('C', Items.STICK)
                .unlockedBy("has_lapislazui", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.LAPIS_LAZULI).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_AXE.get())
                .pattern("AA ")
                .pattern("AB ")
                .pattern(" C ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.LAPIS_LAZULI)
                .define('C', Items.STICK)
                .unlockedBy("has_lapislazui", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.LAPIS_LAZULI).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_HOE.get())
                .pattern("AA ")
                .pattern(" B ")
                .pattern(" C ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.LAPIS_LAZULI)
                .define('C', Items.STICK)
                .unlockedBy("has_lapislazui", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.LAPIS_LAZULI).build())).save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GEM_SHOVEL.get())
                .pattern(" A ")
                .pattern(" B ")
                .pattern(" C ")
                .define('A', Items.GOLD_INGOT)
                .define('B', Items.LAPIS_LAZULI)
                .define('C', Items.STICK)
                .unlockedBy("has_lapislazui", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.LAPIS_LAZULI).build())).save(pWriter);

        //nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.ITEMCRAFTSINTO.get(), RecipeCategory.MISC, ModBlocks.THEBLOCKCRAFTED.get(),
        // "Catacombsofkarthus:rawgroup, null, RAWBLOCK, rawgroup);
        //oreBlasting(pWriter, CatacombsofKarthus_SMELTABLES, RecipeCategory.MISC, ModItems.ITEMTOSMELT.get(), exp, cooktime, "oregroup");
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients,
                                      RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience,
                pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime,
                                     String pGroup, String pRecipeName) {
        Iterator var9 = pIngredients.iterator();

        while(var9.hasNext()) {
            ItemLike itemlike = (ItemLike)var9.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, CatacombsofKarthus.MODID + ":" + pRecipeName + "_" + getItemName(itemlike));
        }

    }
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

}
