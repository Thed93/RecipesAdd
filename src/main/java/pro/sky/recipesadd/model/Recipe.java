package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import pro.sky.recipesadd.services.IngredientService;
@AllArgsConstructor

public class Recipe {

    private String name;

    private long id;

    private int time;

    private IngredientService ingredients;

    private String steps;

    public long getId() {
        return id;
    }

}
