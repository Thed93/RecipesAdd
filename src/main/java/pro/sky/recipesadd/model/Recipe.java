package pro.sky.recipesadd.model;

import pro.sky.recipesadd.services.IngredientService;

public class Recipe {

    private String name;

    private long id;

    private int time;

    private IngredientService ingredients;

    private String steps;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
