package ca.vanier.recipeideas.tempMockData;

import java.util.ArrayList;
import java.util.List;

import ca.vanier.recipeideas.entities.Procedure;
import ca.vanier.recipeideas.entities.Recipe;

public class DataManager {

    public static List<Recipe> getMockRecipes() {

        Procedure recipe1Procedure1 = new Procedure(
            1L, 
            "Mix",
            "Combine your dry ingredients (flour, sugar, salt, baking powder) in one bowl and your wet ingredients (egg, milk, vegetable oil, mashed bananas) in another bowl. Add the dry ingredients to the bowl with the wet ingredients, then stir until they're incorporated. It's OK if your batter is slightly lumpy.");

        Procedure recipe1Procedure2 = new Procedure(
            1L, 
            "Cook",
            "Pour the batter in ¼ cup portions onto a lightly oiled pan or griddle over medium-high heat. Cook for a few minutes, flip with a spatula, and cook for another few minutes (or until each side is golden brown).");
        
        Procedure recipe1Procedure3 = new Procedure(
            1L, 
            "Serve",
            "Serve your banana pancakes immediately. They're delicious alone or with your favorite pancake toppings.");

        List<Procedure> procedures1 = new ArrayList<>();
        procedures1.add(recipe1Procedure1);
        procedures1.add(recipe1Procedure2);
        procedures1.add(recipe1Procedure3);
        
        Recipe recipe1 = new Recipe(
            1L,
            new String[]{"Banana", "Pancake"},
            "Pancakes",
            new String[]{"Banana", "Flour", "Sugar", "Baking Powder", "Salt", "Egg", "Milk", "Vegetable Oil"},
            procedures1);

        Procedure recipe2procedure1 = new Procedure(1L, 
    "Easy 5-Ingredient Chili",
    "Heat a large skillet over medium-high heat. Cook and stir ground beef  in the hot skillet until browned and crumbly, 5 to 7 minutes."
        );
        Procedure recipe2procedure2 = new Procedure(1L, 
        "Easy 5-Ingredient Chili",
        "Heat a large skillet over medium-high heat. Cook and stir ground beef  in the hot skillet until browned and crumbly, 5 to 7 minutes."
        );

        List<Procedure> procedures2 = new ArrayList<>();
        procedures2.add(recipe2procedure1);
        procedures2.add(recipe2procedure2);
        
        Recipe recipe2 = new Recipe(
            1L,
            new String[]{"Chili"},
            "Easy 5-Ingredient Chili",
            new String[]{"1 pound lean ground beef", "15 ounces tomato sauce", "1 (15 ounce) can kidney beans, drained", "1 (15 ounce) can chili beans, not drained Powder", "2 tablespoons chili powder, or to taste", "salt and freshly ground black pepper to taste"},
            procedures2);

        List<Recipe> recipes = new ArrayList<>();
        recipes.add(recipe1);
        recipes.add(recipe2);

        return recipes;
    }
    
    
}
