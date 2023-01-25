package pro.sky.recipesadd.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.services.IngredientService;

@RestController
@Tag(name = "Ингредиенты", description = "Добавление, удаление и обновление ингредиентов, а так же поиск по ID")

public class IngredientsController {
    private final IngredientService ingredientService;

    public IngredientsController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredients")
    @Operation(
            summary = "Добавление ингредиента"
    )

    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/ingredients/{id}")
    @Operation(
            summary = "Поиск ингредиента по ID"
    )
    public ResponseEntity getIngredient (@PathVariable long id) {
        Ingredient ingredient = ingredientService.getIngredientByID(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    @PutMapping("/ingredients/{id}")
    @Operation(
            summary = "Обновление ингредиента"
    )
    public ResponseEntity updateIngredient (@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(ingredient.getId(), ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/ingredients/{id}")
    @Operation(
            summary = "Удаление ингредиента"
    )
    public ResponseEntity deleteIngredient (@PathVariable long id) {
        Ingredient ingredient = ingredientService.deleteIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
