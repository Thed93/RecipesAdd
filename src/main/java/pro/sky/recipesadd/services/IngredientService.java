package pro.sky.recipesadd.services;

import pro.sky.recipesadd.model.Ingredient;

public interface IngredientService {


    public Ingredient addIngredient(Ingredient ingredient);

    public Ingredient getIngredientByID(int ingredientID);

}
