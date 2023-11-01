package ca.vanier.recipeideas.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.vanier.recipeideas.entities.Recipe;
import ca.vanier.recipeideas.tempMockData.DataManager;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @GetMapping("")
    public List<Recipe> getAll() {
        return DataManager.getMockRecipes();
    }

    @GetMapping("/ingredient")
    public List<Recipe> getByIngredient(String[] ingredients) {
        List<Recipe> recipes = new ArrayList<>();

        DataManager.getMockRecipes().forEach(recipe -> {
            boolean contains = false;

            for (String recIngredient : recipe.getIngredients()) {
                contains = Arrays.stream(ingredients).anyMatch(recIngredient.toLowerCase()::equals);
                if (contains) {
                    System.out.println("Adding: " + recipe.getDescription());
                    recipes.add(recipe);
                    break;
                }
            };
            
            if (!contains) {
                System.out.println("Ignoring: " + recipe.getDescription());
                contains = false;
            }
        });

        return recipes;
    }
    
}
