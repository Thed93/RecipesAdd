package pro.sky.recipesadd.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.FilesService;
import pro.sky.recipesadd.services.RecipeService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class RecipeServiceImpl implements RecipeService {
    private TreeMap<Long, Recipe> recipes = new TreeMap<>();

    private FilesService filesService;
    private long id;

    @Override
    public Recipe addRecipe (Recipe recipe) {
        recipes.put(id, recipe);
        id++;
        saveToFile();
        return recipe;
    }

    @PostConstruct
    public void inIt(){
        readFromFile();
    }
    @Override
    public Recipe getRecipeById (long recipeId) {
        return recipes.get(recipeId);
    }

    @Override
    public Recipe updateRecipe(long recipeId, Recipe recipe) {
        recipes.put(recipeId,recipe);
        saveToFile();
        return recipe;
    }

    @Override
    public Recipe deleteRecipe(long recipeID) {
        return recipes.remove(recipeID);
    }
    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipes);
            filesService.saveToRecipeFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = filesService.readFromRecipeFile();
        try {
            recipes = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
