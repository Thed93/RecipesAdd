package pro.sky.recipesadd.services.Impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private long id = 1;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        id++;
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByID(long ingredientId) {
        return ingredients.get(ingredientId);
    }

    @Override
    public Ingredient updateIngredient(long ingredientId, Ingredient ingredient) {
        ingredients.put(ingredientId, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(long ingredientID) {
        return ingredients.remove(ingredientID);
    }
}
