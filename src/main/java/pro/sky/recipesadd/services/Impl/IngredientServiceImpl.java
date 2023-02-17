package pro.sky.recipesadd.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.FilesService;
import pro.sky.recipesadd.services.IngredientService;

import java.util.TreeMap;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final FilesService filesService;
    private TreeMap<Long, Ingredient> ingredients = new TreeMap<>();
    private long id = 1;

    public IngredientServiceImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        id++;
        saveToFile();
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByID(long ingredientId) {
        return ingredients.get(ingredientId);
    }

    @Override
    public Ingredient updateIngredient(long ingredientId, Ingredient ingredient) {
        ingredients.put(ingredientId, ingredient);
        saveToFile();
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(long ingredientID) {
        return ingredients.remove(ingredientID);
    }

    @Override
    public void inIt(){
        readFromFile();
    }
    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToIngredientFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readFromFile() {
        String json = filesService.readFromIngredientFile();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
