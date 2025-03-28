package main.najah.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import main.najah.code.RecipeBook;
import main.najah.code.Recipe;

@DisplayName("Simple RecipeBook Tests")
public class RecipeBookTest {

  
    RecipeBook recipeBook = new RecipeBook();
    Recipe[] recipes = recipeBook.getRecipes();
    Recipe coffee = new Recipe();
    Recipe tea = new Recipe();
    Recipe latte = new Recipe();
    Recipe cappuccino = new Recipe();
    Recipe espresso = new Recipe();
    
   
    {
        coffee.setName("Coffee");
        tea.setName("Tea");
        latte.setName("Latte");
        cappuccino.setName("Cappuccino");
        espresso.setName("Espresso");
    }

    @Test
    @DisplayName("Test that RecipeBook initializes with an empty array")
    void testConstructorInitializesArray() {
        assertNotNull(recipes);
        for (Recipe r : recipes) {
            assertNull(r);
        }
    }
    
    @Test
    @DisplayName("Test adding a new Recipe")
    void testAddRecipeSuccessfully() {
       
        assertTrue(recipeBook.addRecipe(coffee));
        
       
        boolean found = false;
        for (Recipe r : recipes) {
            if (coffee.equals(r)) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }
    
    @Test
    @DisplayName("Test adding a duplicate Recipe fails")
    @Timeout(value = 200,unit = TimeUnit.MILLISECONDS)
    void testAddDuplicateRecipe() {
       
        assertTrue(recipeBook.addRecipe(tea));
      
        assertFalse(recipeBook.addRecipe(tea));
    }
    
    @Test
    @DisplayName("Test deleting an existing Recipe returns its name")
    void testDeleteExistingRecipe() {
       
        recipeBook.addRecipe(latte);
        String deletedName = recipeBook.deleteRecipe(0);
        assertEquals("Latte", deletedName);
    }
    
    @Test
    @DisplayName("Test editing an existing Recipe returns original name")
    void testEditExistingRecipe() {
       
        recipeBook.addRecipe(cappuccino);
        String originalName = recipeBook.editRecipe(0, espresso);
        assertEquals("Cappuccino", originalName);
       
        assertEquals("", recipes[0].getName());
    }
}
