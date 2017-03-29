package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnravan on 3/28/17.
 */
public class RecipeBookTest {

    private Recipe recipe;
    private RecipeBook recipeBook;

    @Before
    public void setUp() {
        recipe = new Recipe();
        recipeBook = new RecipeBook();
    }

    @Test
    public void testAddRecipe() {
        boolean isAdded = recipeBook.addRecipe(recipe);

        assertTrue(isAdded);
    }

    @Test
    public void testAddRecipe_AlreadyExists() {
        boolean isAdded = recipeBook.addRecipe(recipe);
        assertTrue(isAdded);

        isAdded = recipeBook.addRecipe(recipe);
        assertFalse(isAdded);
    }

    @Test
    public void testDeleteRecipe() {
        recipe.setName("Potato Salad");
        recipeBook.addRecipe(recipe);

        String recipeName = recipeBook.deleteRecipe(0);
        assertEquals(recipeName, "Potato Salad");

        recipeName = recipeBook.deleteRecipe(1);
        assertNull(recipeName);
    }

    @Test
    public void testEditRecipe() {
        recipe.setName("Potato Salad");
        recipeBook.addRecipe(recipe);

        Recipe newRecipe = new Recipe();
        newRecipe.setName("Pecan Pie");

        String recipeName = recipeBook.editRecipe(0, newRecipe);
        assertEquals(recipeName, "Potato Salad");

        recipeName = recipeBook.editRecipe(0, newRecipe);
        assertEquals(recipeName, "");
    }
}
