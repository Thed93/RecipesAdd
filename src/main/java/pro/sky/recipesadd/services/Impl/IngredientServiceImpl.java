package pro.sky.recipesadd.services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Long, Ingredient> ingredients = new HashMap<Long, Ingredient>();
    private long id = 1;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        id++;
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByID(long ingredientID) {
        return ingredients.get(ingredientID);
    }

    @Override
    public Ingredient updateIngredient(long ingredientID, Ingredient ingredient) {
        ingredients.put(ingredientID, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(long ingredientID) {
        return ingredients.remove(ingredientID);
    }
}
