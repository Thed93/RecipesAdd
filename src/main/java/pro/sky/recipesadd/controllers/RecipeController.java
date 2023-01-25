package pro.sky.recipesadd.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.RecipeService;

@RestController
@Tag(name = "Рецепты", description = "Добавление, удаление и обновление рецептов, а так же поиск по ID")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/recipe")
    @Operation(
            summary = "Добавление рецепта"
    )
    public ResponseEntity createRecipe (@RequestBody Recipe recipe) {
        Recipe createRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipe/{id}")
    @Operation(
            summary = "Поиск рецепта по ID"
    )
    public ResponseEntity getRecipeByID (@PathVariable long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/recipe/{id}")
    @Operation(
            summary = "Обновление рецепта"
    )
    public ResponseEntity updateRecipe (@RequestBody Recipe recipe) {
        Recipe updateRecipe = recipeService.updateRecipe(recipe.getId(), recipe);
        return  ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    @Operation(
            summary = "Удаление рецепта"
    )
    public ResponseEntity deleteRecipe (@PathVariable long id) {
        Recipe recipe = recipeService.deleteRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
