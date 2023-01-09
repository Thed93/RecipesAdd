package pro.sky.recipesadd.services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Long, Recipe> recipes = new HashMap<Long, Recipe>();

    private long id;

    @Override
    public Recipe addRecipe (Recipe recipe) {
        recipes.put(id, recipe);
        id++;
        return recipe;
    }
    @Override
    public Recipe getRecipeById (long recipeID) {
        return recipes.get(recipeID);
    }

    @Override
    public Recipe updateRecipe(long recipeID, Recipe recipe) {
        recipes.put(recipeID,recipe);
        return recipe;
    }

    @Override
    public Recipe deleteRecipe(long recipeID) {
        return recipes.remove(recipeID);
    }
}
