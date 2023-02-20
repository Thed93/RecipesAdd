package pro.sky.recipesadd.services.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.Exceptions.WrongIngredientException;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.FilesService;
import pro.sky.recipesadd.services.IngredientService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    public Ingredient addIngredient(Ingredient ingredient) throws WrongIngredientException {
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
    public Ingredient updateIngredient(long ingredientId, Ingredient ingredient) throws WrongIngredientException {
        ingredients.put(ingredientId, ingredient);
        saveToFile();
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(long ingredientID) {
        return ingredients.remove(ingredientID);
    }

    @Override
    public void inIt() throws WrongIngredientException {
        readFromFile();
        Files.isExecutable((Path) ingredients);
    }
    private void saveToFile() throws WrongIngredientException {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredients);
            filesService.saveToIngredientFile(json);
        } catch (JsonProcessingException e) {
            throw new WrongIngredientException("Некорректный ингредиент");
        }
    }

    private void readFromFile() throws WrongIngredientException {
        String json = filesService.readFromIngredientFile();
        try {
            ingredients = new ObjectMapper().readValue(json, new TypeReference<TreeMap<Long, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new WrongIngredientException("Некорректный ингредиент");
        }
    }

    public Path createIngredient (Ingredient ingredient){
        TreeMap<Long, Ingredient> newIngredient = ingredients.getOrDefault();
        for (Ingredient ingredient1 : ingredients)
    }

}
