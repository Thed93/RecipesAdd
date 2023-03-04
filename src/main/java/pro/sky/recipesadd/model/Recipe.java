package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pro.sky.recipesadd.services.IngredientService;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Recipe {

    private String name;

    private long id;

    private int time;

    private List<Ingredient> ingredients = new ArrayList<>();

    private List<String> steps = new ArrayList<>();

}
