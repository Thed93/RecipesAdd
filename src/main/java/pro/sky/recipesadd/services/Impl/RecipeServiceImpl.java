package pro.sky.recipesadd.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.Exceptions.WrongRecipeException;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.FilesService;
import pro.sky.recipesadd.services.RecipeService;

import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private TreeMap<Long, Recipe> recipes = new TreeMap<>();

    private FilesService filesService;
    private long id;

    @Override
    public Recipe addRecipe (Recipe recipe) throws WrongRecipeException {
        recipes.put(id, recipe);
        id++;
        saveToFile();
        return recipe;
    }

    @Override
    public void inIt() throws WrongRecipeException {
        readFromFile();
    }
    @Override
    public Recipe getRecipeById (long recipeId) {
        return recipes.get(recipeId);
    }

    @Override
    public Recipe updateRecipe(long recipeId, Recipe recipe) throws WrongRecipeException {
        recipes.put(recipeId,recipe);
        saveToFile();
        return recipe;
    }

    @Override
    public Recipe deleteRecipe(long recipeID) {
        return recipes.remove(recipeID);
    }
    private void saveToFile() throws WrongRecipeException {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            throw new WrongRecipeException("Некорректный рецепт");
        }
    }

    private void readFromFile() throws WrongRecipeException {
        String json = filesService.readFromRecipeFile();
        try {
            recipes = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new WrongRecipeException("Некорректный рецепт");
        }
    }
}
