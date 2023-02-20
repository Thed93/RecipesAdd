package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Ingredient {

    private long id;

    private String name;

    private int amount;

    private String measureUnit;

}

