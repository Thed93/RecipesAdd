package pro.sky.recipesadd.services;

import pro.sky.recipesadd.model.Recipe;

public interface RecipeService {

    public Recipe addRecipe (Recipe recipe);


    public Recipe getRecipeById (int recipeID);

}