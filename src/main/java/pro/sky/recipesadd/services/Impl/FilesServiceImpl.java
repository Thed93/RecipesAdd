package pro.sky.recipesadd.services.Impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pro.sky.recipesadd.services.FilesService;

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
    public String readFromIngredientFile() {
        try {
            return Files.readString(Path.of(dataFilePathForIngredients, nameOfDataFileIngredients));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String readFromRecipeFile() {
        try {
            return Files.readString(Path.of(dataFilePathForRecipes, nameOfDataFileRecipes));
        } catch (IOException e) {
            throw new RuntimeException(e);
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




}