package pro.sky.recipesadd.services;

import pro.sky.recipesadd.Exceptions.WrongIngredientException;
import pro.sky.recipesadd.Exceptions.WrongRecipeException;

import java.io.File;
import java.nio.file.Path;

public interface FilesService {
    boolean saveToIngredientFile(String json);

    boolean saveToRecipeFile(String json);

    String readFromIngredientFile() throws WrongIngredientException;

    String readFromRecipeFile() throws WrongRecipeException;

    boolean cleanIngredientDataFile();

    boolean cleanRecipeDataFile();

    File getIngredientDataFile();

    File getRecipeDataFile();

    Path createIngredientsTempFile(String suffix) throws WrongIngredientException;

    Path createRecipesTempFile(String suffix) throws WrongRecipeException;

    File getRecipesDataFileTxt();
}
