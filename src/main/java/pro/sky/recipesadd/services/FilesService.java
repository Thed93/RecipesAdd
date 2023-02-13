package pro.sky.recipesadd.services;

public interface FilesService {
    boolean saveToIngredientFile(String json);

    boolean saveToRecipeFile(String json);

    String readFromIngredientFile();

    String readFromRecipeFile();

    boolean cleanIngredientDataFile();

    boolean cleanRecipeDataFile();
}
