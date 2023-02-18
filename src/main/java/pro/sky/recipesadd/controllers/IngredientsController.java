package pro.sky.recipesadd.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.model.Ingredient;
import pro.sky.recipesadd.model.Recipe;
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })

    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createIngredient = ingredientService.addIngredient(ingredient);
        return ResponseEntity.ok(createIngredient);
    }

    @GetMapping("/ingredients/{id}")
    @Operation(
            summary = "Поиск ингредиента по ID"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент обновлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
    public ResponseEntity updateIngredient (@RequestBody Ingredient ingredient) {
        Ingredient updateIngredient = ingredientService.updateIngredient(ingredient.getId(), ingredient);
        return ResponseEntity.ok(updateIngredient);
    }

    @DeleteMapping("/ingredients/{id}")
    @Operation(
            summary = "Удаление ингредиента"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Ингредиент удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Ingredient.class))
                            )
                    }
            )
    })
    public ResponseEntity deleteIngredient (@PathVariable long id) {
        Ingredient ingredient = ingredientService.deleteIngredient(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
}
