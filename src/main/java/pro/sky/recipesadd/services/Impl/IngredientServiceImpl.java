package pro.sky.recipesadd.services.Impl;

import org.springframework.stereotype.Service;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final Map<Integer, Ingredient> ingredients = new HashMap<>();
    private int id = 1;

    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        ingredients.put(id, ingredient);
        id++;
        return ingredient;
    }

    @Override
    public Ingredient getIngredientByID(int ingredientID) {
        return ingredients.get(ingredientID);
    }
}
