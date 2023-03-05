package pro.sky.recipesadd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.TreeMap;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class Ingredient extends TreeMap<Long, Ingredient> {

    private long id;

    private String name;

    private int amount;

    private String measureUnit;



    @Override
    public Ingredient getOrDefault(Object key, Ingredient defaultValue) {
        return super.getOrDefault(key, defaultValue);
    }

    @Override
    public boolean remove(Object key, Object value) {
        return super.remove(key, value);
    }
}

