package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Ingredient {

    private long id;

    private String name;

    private int amount;

    private String measureUnit;

}

