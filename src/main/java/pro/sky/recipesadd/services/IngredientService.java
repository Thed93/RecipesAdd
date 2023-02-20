package pro.sky.recipesadd.services;

import pro.sky.recipesadd.model.Ingredient;

public interface IngredientService {


    public Ingredient addIngredient(Ingredient ingredient);

    public Ingredient getIngredientByID(long ingredientID);

    public Ingredient updateIngredient (long ingredientID, Ingredient ingredient);

    public Ingredient deleteIngredient(long ingredientID);

    void inIt();
}
