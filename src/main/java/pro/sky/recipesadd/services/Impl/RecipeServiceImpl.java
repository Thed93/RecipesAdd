package pro.sky.recipesadd.services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.RecipeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final Map<Integer, Recipe> recipes = new HashMap<>();

    private int id;

    @Override
    public Recipe addRecipe (Recipe recipe) {
        recipes.put(id, recipe);
        id++;
        return recipe;
    }
    @Override
    public Recipe getRecipeById (int recipeID) {
        return recipes.get(recipeID);
    }
}
