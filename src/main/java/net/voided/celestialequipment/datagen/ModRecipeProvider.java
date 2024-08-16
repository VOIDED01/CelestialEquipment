package net.voided.celestialequipment.datagen;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.MinecartItem;
import net.voided.celestialequipment.CelestialEquipment;
import net.voided.celestialequipment.block.ModBlocks;
import net.voided.celestialequipment.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.xml.transform.Result;
import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CELESTIUM_SMELTABLES = List.of(ModItems.RAW_CELESTIUM.get(),
            ModBlocks.DEEPSLATE_CELESTIUM_ORE.get());



    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }


    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, CELESTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CELESTIUM_INGOT.get(), 10, 200, "celestium");
        oreBlasting(pWriter, CELESTIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CELESTIUM_INGOT.get(), 10, 200, "celestium");

        // Shaped Recipe for Celestium Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CELESTIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.RAW_CELESTIUM.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        // Shapeless Recipe for Celestium Ingots from Celestium Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CELESTIUM_INGOT.get(), 9)
                .requires(ModBlocks.CELESTIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CELESTIUM_BLOCK.get()), has(ModBlocks.CELESTIUM_BLOCK.get()))
                .save(pWriter);

        // Shaped Recipe for Raw Celestial Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CELESTIUM_BLOCK.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.RAW_CELESTIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_CELESTIUM.get()), has(ModItems.RAW_CELESTIUM.get()))
                .save(pWriter);

        // Shapeless Recipe for Raw Celestium from Raw Celestium Block
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CELESTIUM.get(), 9)
                .requires(ModBlocks.RAW_CELESTIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_CELESTIUM_BLOCK.get()), has(ModBlocks.RAW_CELESTIUM_BLOCK.get()))
                .save(pWriter);

        // Shaped Recipe for Celestium Rod
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CELESTIUM_ROD.get())
                .pattern(" # ")
                .pattern(" # ")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        // Celestial Armor Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIAL_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIAL_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIAL_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.CELESTIAL_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        // Celestial Tools Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIAL_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" / ")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .define('/', ModItems.CELESTIUM_ROD.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIAL_PICKAXE.get())
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .define('/', ModItems.CELESTIUM_ROD.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIAL_AXE.get())
                .pattern("## ")
                .pattern("#/ ")
                .pattern(" / ")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .define('/', ModItems.CELESTIUM_ROD.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIAL_SHOVEL.get())
                .pattern("#")
                .pattern("/")
                .pattern("/")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .define('/', ModItems.CELESTIUM_ROD.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CELESTIAL_HOE.get())
                .pattern("## ")
                .pattern(" / ")
                .pattern(" / ")
                .define('#', ModItems.CELESTIUM_INGOT.get())
                .define('/', ModItems.CELESTIUM_ROD.get())
                .unlockedBy(getHasName(ModItems.CELESTIUM_INGOT.get()), has(ModItems.CELESTIUM_INGOT.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CELESTIAL_COAL.get()) // Replace ModItems.SOME_NEW_ITEM with your desired result item
                .pattern("gcg")
                .pattern("cgc")
                .pattern("gcg")
                .define('g', Items.GUNPOWDER)
                .define('c', Items.COAL)
                .unlockedBy(getHasName(Items.GUNPOWDER), has(Items.GUNPOWDER))
                .unlockedBy(getHasName(Items.COAL), has(Items.COAL))
                .save(pWriter);



    }



    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, CelestialEquipment.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
