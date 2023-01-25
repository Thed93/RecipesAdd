package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Ingredient {

    private long id;

    private String name;

    private int amount;

    private String measureUnit;

    public long getId() {
        return id;
    }

}

