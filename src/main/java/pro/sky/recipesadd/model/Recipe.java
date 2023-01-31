package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import pro.sky.recipesadd.services.IngredientService;
@AllArgsConstructor
@Data

public class Recipe {

    private String name;

    private long id;

    private int time;

    private IngredientService ingredients;

    private String steps;

}
