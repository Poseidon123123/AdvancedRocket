package de.poseidon.advancedrocket.datagen;

import de.poseidon.advancedrocket.AdvancedRocket;
import de.poseidon.advancedrocket.block.ModBlocks;
import de.poseidon.advancedrocket.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> TIN_SMELTTABLE = List.of(ModItems.TIN_RAW.get(), ModBlocks.TIN_ORE.get());

    public ModRecipeProvider(PackOutput p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pWriter) {
        oreBlasting(pWriter, TIN_SMELTTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.4F, 80, "tin_ingot");
        oreSmelting(pWriter, TIN_SMELTTABLE, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.4F, 160, "tin_ingot");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROCKET_BUILDER.get()).pattern("SSS").pattern("SSS").pattern("SSS").define('S', ModItems.TIN_INGOT.get()).unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get())).save(pWriter);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STRAWBERRY.get(), 9).requires(ModItems.TIN_INGOT.get()).unlockedBy(getHasName(ModItems.TIN_INGOT.get()), has(ModItems.TIN_INGOT.get())).save(pWriter);
    }


    protected static void oreSmelting(@NotNull RecipeOutput recipeOutput, List<ItemLike> itemLikes, @NotNull RecipeCategory recipeCategory, @NotNull ItemLike itemLike, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, itemLikes, recipeCategory, itemLike, experience, cookingTime, group, "_from_smelting");
    }

    protected static void oreBlasting(@NotNull RecipeOutput recipeOutput, List<ItemLike> itemLikes, @NotNull RecipeCategory recipeCategory, @NotNull ItemLike itemLike, float experience, int cookingTime, @NotNull String group) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, itemLikes, recipeCategory, itemLike, experience, cookingTime, group, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> tRecipeSerializer, AbstractCookingRecipe.Factory<T> tFactory, List<ItemLike> itemLikes, RecipeCategory recipeCategory, ItemLike itemLike, float experience, int cookingTime, String group, String recpieName) {
        for(ItemLike itemlike : itemLikes) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), recipeCategory, itemLike, experience, cookingTime, tRecipeSerializer, tFactory).group(group).unlockedBy(getHasName(itemlike), has(itemlike)).save(recipeOutput, AdvancedRocket.MODID + ":" + getItemName(itemLike) + recpieName + "_" + getItemName(itemlike));
        }

    }
}
