package pro.sky.recipesadd.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.recipesadd.Exceptions.WrongRecipeException;
import pro.sky.recipesadd.model.Recipe;
import pro.sky.recipesadd.services.RecipeService;

import java.util.Collection;

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
    @ApiResponses (value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт добавлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema (schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )
    })
    public ResponseEntity createRecipe (@RequestBody Recipe recipe) throws WrongRecipeException {
        Recipe createRecipe = recipeService.addRecipe(recipe);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/recipe/{id}")
    @Operation(
            summary = "Поиск рецепта по ID"
    )
    @ApiResponses (value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт найден",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema (schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )
    })
    @Parameters(value = {
            @Parameter(name = "id",
            example = "натуральное число")
    })
    public ResponseEntity getRecipeByID (@PathVariable long id) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @GetMapping
    @Operation(summary = "Получение всех рецептов", description = "Поиск без параметров")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепты получены",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Recipe.class)
                            )
                    }
            )})
    public Collection<Recipe> getAll() {
        return this.recipeService.getAll();
    }

    @PutMapping("/recipe/{id}")
    @Operation(
            summary = "Обновление рецепта"
    )
    @ApiResponses (value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт обновлен",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema (schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )
    })
    public ResponseEntity updateRecipe (@RequestBody Recipe recipe) throws WrongRecipeException {
        Recipe updateRecipe = recipeService.updateRecipe(recipe.getId(), recipe);
        return  ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    @Operation(
            summary = "Удаление рецепта"
    )
    @ApiResponses (value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Рецепт удален",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema (schema = @Schema(implementation = Recipe.class))
                            )
                    }
            )
    })
    public ResponseEntity deleteRecipe (@PathVariable long id) {
        Recipe recipe = recipeService.deleteRecipe(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }
}
