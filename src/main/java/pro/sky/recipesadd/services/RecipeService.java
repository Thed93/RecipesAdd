package pro.sky.recipesadd.services;

import pro.sky.recipesadd.model.Recipe;

public interface RecipeService {

    public Recipe addRecipe (Recipe recipe);


    public Recipe getRecipeById (long recipeID);

    public Recipe updateRecipe (long recipeID, Recipe recipe);

    public Recipe deleteRecipe (long recipeID);
}