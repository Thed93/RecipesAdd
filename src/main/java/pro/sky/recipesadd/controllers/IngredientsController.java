package pro.sky.recipesadd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.IngredientService;

@RestController

public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredients/add")
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/ingredients/get")
    public ResponseEntity getIngredient (@PathVariable long ingredientId) {
        Ingredient ingredient = ingredientService.getIngredientByID(ingredientId);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/ingredients/update")
    public ResponseEntity updateIngredient (@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(ingredient.getId(), ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/ingredients/delete")
    public ResponseEntity deleteIngredient (@PathVariable long ingredientId) {
        Ingredient ingredient = ingredientService.deleteIngredient(ingredientId);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
