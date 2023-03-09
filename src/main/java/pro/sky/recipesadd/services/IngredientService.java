package pro.sky.recipesadd.services;

import pro.sky.recipesadd.Exceptions.WrongIngredientException;
import pro.sky.recipesadd.model.Ingredient;

import java.util.Collections;

public interface IngredientService {


    public Ingredient addIngredient(Ingredient ingredient) throws WrongIngredientException;

    public Ingredient getIngredientByID(long ingredientID);

    public Ingredient updateIngredient (long ingredientID, Ingredient ingredient) throws WrongIngredientException;


    public Ingredient deleteIngredient(long ingredientID);

    void inIt() throws WrongIngredientException;
}
