package pro.sky.recipesadd.services.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.Exceptions.WrongIngredientException;
import pro.sky.recipesadd.Exceptions.WrongRecipeException;
import pro.sky.recipesadd.services.FilesService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class FilesServiceImpl implements FilesService {


    @Value("${path.to.data.file.for.ingredients}")
    private String dataFilePathForIngredients;

    @Value("${name.of.data.file.ingredients}")
    private String nameOfDataFileIngredients;

    @Value("${path.to.data.file.for.recipes}")
    private String dataFilePathForRecipes;

    @Value("${name.of.data.file.recipes}")
    private String nameOfDataFileRecipes;


    @Override
    public boolean saveToIngredientFile(String json){
        try {
            cleanIngredientDataFile();
            Files.writeString(Path.of(dataFilePathForIngredients, nameOfDataFileIngredients), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean saveToRecipeFile(String json){
        try {
            Files.writeString(Path.of(dataFilePathForRecipes, nameOfDataFileRecipes), json);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String readFromIngredientFile() throws WrongIngredientException {
        try {
            return Files.readString(Path.of(dataFilePathForIngredients, nameOfDataFileIngredients));
        } catch (IOException e) {
            throw new WrongIngredientException("Некорректный ингредиент");
        }
    }

    @Override
    public String readFromRecipeFile() throws WrongRecipeException {
        try {
            return Files.readString(Path.of(dataFilePathForRecipes, nameOfDataFileRecipes));
        } catch (IOException e) {
            throw new WrongRecipeException("Некорректный рецепт");
        }
    }
    @Override
    public boolean cleanIngredientDataFile() {
        try {
            Path path = Path.of(dataFilePathForIngredients, nameOfDataFileIngredients);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean cleanRecipeDataFile() {
        try {
            Path path = Path.of(dataFilePathForRecipes, nameOfDataFileRecipes);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public File getIngredientDataFile() {
        return new File(dataFilePathForIngredients + "/" + dataFilePathForIngredients);
    }

    @Override
    public File getRecipeDataFile() {
        return new File(dataFilePathForRecipes + "/" + dataFilePathForRecipes);
    }

    @Override
    public Path createIngredientsTempFile(String suffix) throws WrongIngredientException {
        try {
            return Files.createTempFile(Path.of(dataFilePathForIngredients), "IngredientsTempFile", suffix);
        } catch (IOException e) {
            throw new WrongIngredientException("Некорректный ингредиент");
        }
    }

    @Override
    public Path createRecipesTempFile(String suffix) throws WrongRecipeException {
        try {
            return Files.createTempFile(Path.of(dataFilePathForRecipes), "RecipesTempFile", suffix);
        } catch (IOException e) {
            throw new WrongRecipeException("Некорректный рецепт");
        }
    }



}
