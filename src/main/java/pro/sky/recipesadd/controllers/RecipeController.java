package pro.sky.recipesadd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.RecipeService;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe/add")
    public ResponseEntity createRecipe (@RequestBody Recipe recipe) {
        Recipe createRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipe/get")
    public ResponseEntity getRecipeByID (@PathVariable long recipeID) {
        Recipe recipe = recipeService.getRecipeById(recipeID);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/recipe/update")
    public ResponseEntity updateRecipe (@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipeService.updateRecipe(recipe.getId(), recipe);
        return  ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipe/delete")
    public ResponseEntity deleteRecipe (@PathVariable long recipeID) {
        Recipe recipe = recipeService.deleteRecipe(recipeID);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
