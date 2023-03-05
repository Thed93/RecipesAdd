package pro.sky.recipesadd.services;

import pro.sky.recipesadd.Exceptions.WrongRecipeException;
import pro.sky.recipesadd.model.Recipe;

public interface RecipeService {

    public Recipe addRecipe (Recipe recipe) throws WrongRecipeException;


    void inIt() throws WrongRecipeException;

    public Recipe getRecipeById (long recipeID);

    public Recipe updateRecipe (long recipeID, Recipe recipe) throws WrongRecipeException;

    public Recipe deleteRecipe (long recipeID);
}