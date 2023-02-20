package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.recipesadd.services.IngredientService;
@AllArgsConstructor
@Data
@NoArgsConstructor

public class Recipe {

    private String name;

    private long id;

    private int time;

    private Ingredient ingredient;

    private String steps;

}
