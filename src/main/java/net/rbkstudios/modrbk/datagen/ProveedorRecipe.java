package net.rbkstudios.modrbk.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.rbkstudios.modrbk.Modrbk;
import net.rbkstudios.modrbk.items.InicializarItems;

import java.util.concurrent.CompletableFuture;

public class ProveedorRecipe extends RecipeProvider implements IConditionBuilder {


    public ProveedorRecipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
     simpleCookingRecipe(recipeOutput,"smelting",RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new,200, InicializarItems.RAW_FROG_MEAT.get(),InicializarItems.COOKED_FROG_MEAT.get(),0.35f);
     simpleCookingRecipe(recipeOutput,"smoking",RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new,100, InicializarItems.RAW_FROG_MEAT.get(),InicializarItems.COOKED_FROG_MEAT.get(),0.35f);
     simpleCookingRecipe(recipeOutput,"campfire_cooking",RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new,200, InicializarItems.RAW_FROG_MEAT.get(),InicializarItems.COOKED_FROG_MEAT.get(),0.35f);





    }



    private static <T extends AbstractCookingRecipe> void simpleCookingRecipe(RecipeOutput pRecipeOutput, String pCookingMethod, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> pRecipeFactory, int pCookingTime, ItemLike pMaterial, ItemLike pResult, float pExperience) {
        SimpleCookingRecipeBuilder var10000 = SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{pMaterial}), RecipeCategory.FOOD, pResult, pExperience, pCookingTime, pCookingSerializer, pRecipeFactory).unlockedBy(getHasName(pMaterial), has(pMaterial));
        String var10002 = getItemName(pResult);
        var10000.save(pRecipeOutput, Modrbk.MODID + ":" + var10002 + "_from_" + pCookingMethod);
    }

}
