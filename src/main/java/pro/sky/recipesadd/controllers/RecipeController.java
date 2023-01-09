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
    public ResponseEntity getRecipeByID (@PathVariable int recipeID) {
        Recipe recipe = recipeService.getRecipeById(recipeID);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
