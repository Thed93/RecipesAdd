package pro.sky.recipesadd.model;

public class Ingredient {

    private long id;

    private String name;

    private int amount;

    private String measureUnit;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

