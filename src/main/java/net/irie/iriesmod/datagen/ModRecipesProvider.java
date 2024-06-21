package net.irie.iriesmod.datagen;

import net.irie.iriesmod.IriesMod;
import net.irie.iriesmod.block.ModBlocks;
import net.irie.iriesmod.item.ModItems;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipesProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
            ModBlocks.SAPPHIRE_ORE.get(),
            ModBlocks.NETHER_SAPPHIRE_ORE.get(),
            ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(),
            ModBlocks.END_STONE_SAPPHIRE_ORE.get());

    public ModRecipesProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> p_251297_) {
        oreBlasting(p_251297_, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(),0.25f, 100, "sapphire");
        oreSmelting(p_251297_, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(),0.25f, 200, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.PINE_CHEST_BOAT.get(), 1)
                .pattern("   ")
                .pattern("CB ")
                .pattern("   ")
                .define('C', Items.CHEST)
                .define('B', ModItems.PINE_BOAT.get())
                .unlockedBy(getHasName(ModItems.PINE_BOAT.get()), has(ModItems.PINE_BOAT.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PINE_SIGN.get(), 3)
                .pattern("PPP")
                .pattern("PPP")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('P', ModBlocks.PINE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PINE_PLANKS.get()), has(ModBlocks.PINE_PLANKS.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.PINE_HANGING_SIGN.get(), 6)
                .pattern("C C")
                .pattern("PPP")
                .pattern("PPP")
                .define('C', Items.CHAIN)
                .define('P', ModBlocks.PINE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PINE_PLANKS.get()), has(ModBlocks.PINE_PLANKS.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, ModItems.PINE_BOAT.get(), 1)
                .pattern("P P")
                .pattern("PPP")
                .pattern("   ")
                .define('P', ModBlocks.PINE_PLANKS.get())
                .unlockedBy(getHasName(ModBlocks.PINE_PLANKS.get()), has(ModBlocks.PINE_PLANKS.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SAPPHIRE_BLOCK.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MOD_PORTAL.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_STAIRS.get(), 3)
                .pattern("O  ")
                .pattern("OO ")
                .pattern("OOO")
                .define('O', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_FENCE.get(), 6)
                .pattern("OIO")
                .pattern("OIO")
                .pattern("   ")
                .define('I', ModBlocks.SAPPHIRE_BLOCK.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_FENCE_GATE.get(), 3)
                .pattern("   ")
                .pattern("IOI")
                .pattern("IOI")
                .define('I', ModBlocks.SAPPHIRE_BLOCK.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(4),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_DOOR.get(), 2)
                .pattern("OO ")
                .pattern("OO ")
                .pattern("OO ")
                .define('O', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(6),ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_SLAB.get(), 6)
                .pattern("OOO")
                .define('O', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(3),ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_WALL.get(), 6)
                .pattern("OOO")
                .pattern("OOO")
                .pattern("   ")
                .define('O', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(6),ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_TRAPDOOR.get(), 3)
                .pattern("OOO")
                .pattern("OOO")
                .pattern("   ")
                .define('O', ModBlocks.SAPPHIRE_SLAB.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_SLAB.get()), has(MinMaxBounds.Ints.atLeast(6),ModBlocks.SAPPHIRE_SLAB.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_PRESSURE_PLATE.get(), 3)
                .pattern("OO ")
                .define('O', ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(MinMaxBounds.Ints.atLeast(2),ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ORE_DETECTOR.get(), 1)
                .pattern("  O")
                .pattern(" O ")
                .pattern("I  ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SWORD.get(), 1)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" O ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(1),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_SHOVEL.get(), 1)
                .pattern(" I ")
                .pattern(" O ")
                .pattern(" O ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_AXE.get(), 1)
                .pattern(" II")
                .pattern(" OI")
                .pattern(" O ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_PICKAXE.get(), 1)
                .pattern("III")
                .pattern(" O ")
                .pattern(" O ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SAPPHIRE_HOE.get(), 1)
                .pattern("II ")
                .pattern(" O ")
                .pattern(" O ")
                .define('I', ModItems.SAPPHIRE.get())
                .define('O', Items.STICK)
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(2),Items.STICK))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_HELMET.get(), 1)
                .pattern("   ")
                .pattern("III")
                .pattern("I I")
                .define('I', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(5),ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_CHESTPLATE.get(), 1)
                .pattern("I I")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(8),ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_LEGGINGS.get(), 1)
                .pattern("III")
                .pattern("I I")
                .pattern("I I")
                .define('I', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(7),ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.SAPPHIRE_BOOTS.get(), 1)
                .pattern("   ")
                .pattern("I I")
                .pattern("I I")
                .define('I', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(MinMaxBounds.Ints.atLeast(4),ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.SAPPHIRE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SAPPHIRE_BLOCK.get()), has(ModBlocks.SAPPHIRE_BLOCK.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAPPHIRE_BUTTON.get(), 1)
                .requires(ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(p_251297_);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINE_PLANKS.get(), 4)
                .requires(ModBlocks.PINE_LOG.get())
                .unlockedBy(getHasName(ModBlocks.PINE_LOG.get()), has(ModBlocks.PINE_LOG.get()))
                .save(p_251297_);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> p_250654_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(p_250654_, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> p_248775_, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(p_248775_, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> p_250791_, RecipeSerializer<? extends AbstractCookingRecipe> pSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pSerializer).group(pGroup).unlockedBy(getHasName(itemlike),has(itemlike))
                    .save(p_250791_, IriesMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}
