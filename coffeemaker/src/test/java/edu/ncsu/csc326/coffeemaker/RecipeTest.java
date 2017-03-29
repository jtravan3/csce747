package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johnravan on 3/28/17.
 */
public class RecipeTest {

    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = new Recipe();
    }

    @Test
    public void testSetAmtChocolate() throws RecipeException {

        recipe.setAmtChocolate("10");

        assertEquals(recipe.getAmtChocolate(), 10);
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtChocolate_Exception_NonInteger() throws RecipeException {
        recipe.setAmtChocolate("potato");
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtChocolate_Exception_NegativeNumber() throws RecipeException {
        recipe.setAmtChocolate("-1");
    }

    @Test
    public void testSetAmtCoffee() throws RecipeException {

        recipe.setAmtCoffee("10");

        assertEquals(recipe.getAmtCoffee(), 10);
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtCoffee_Exception_NonInteger() throws RecipeException {
        recipe.setAmtCoffee("potato");
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtCoffee_Exception_NegativeNumber() throws RecipeException {
        recipe.setAmtCoffee("-1");
    }

    @Test
    public void testSetAmtMilk() throws RecipeException {

        recipe.setAmtMilk("10");

        assertEquals(recipe.getAmtMilk(), 10);
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtMilk_Exception_NonInteger() throws RecipeException {
        recipe.setAmtMilk("potato");
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtMilk_Exception_NegativeNumber() throws RecipeException {
        recipe.setAmtMilk("-1");
    }

    @Test
    public void testSetAmtSugar() throws RecipeException {

        recipe.setAmtSugar("10");

        assertEquals(recipe.getAmtSugar(), 10);
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtSugar_Exception_NonInteger() throws RecipeException {
        recipe.setAmtSugar("potato");
    }

    @Test(expected = RecipeException.class)
    public void testSetAmtSugar_Exception_NegativeNumber() throws RecipeException {
        recipe.setAmtSugar("-1");
    }

    @Test
    public void testGetName_Null() {
        recipe.setName(null);
        String name = recipe.getName();

        assertNotNull(name);
        assertEquals(name, "");
    }

    @Test
    public void testGetName() {
        recipe.setName("Potato Salad");
        String name = recipe.getName();

        assertNotNull(name);
        assertEquals(name, "Potato Salad");
    }

    @Test
    public void testSetPrice() throws RecipeException {

        recipe.setPrice("10");

        assertEquals(recipe.getPrice(), 10);
    }

    @Test(expected = RecipeException.class)
    public void testSetPrice_Exception_NonInteger() throws RecipeException {
        recipe.setPrice("potato");
    }

    @Test(expected = RecipeException.class)
    public void testSetPrice_Exception_NegativeNumber() throws RecipeException {
        recipe.setPrice("-1");
    }

    @Test
    public void testToString() {
        recipe.setName("Potato Salad");
        String rtnString = recipe.toString();

        assertNotNull(rtnString);
        assertEquals(rtnString, "Potato Salad");
    }
}
