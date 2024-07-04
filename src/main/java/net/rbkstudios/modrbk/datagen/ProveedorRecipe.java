package net.rbkstudios.modrbk.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ProveedorRecipe extends RecipeProvider implements IConditionBuilder {


    public ProveedorRecipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }


    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

    }
}
