package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnravan on 3/28/17.
 */
public class InventoryTest {

    private Inventory inventory;
    private Recipe recipe;

    @Before
    public void setUp() throws RecipeException {
        inventory = new Inventory();
        recipe = new Recipe();

        inventory.setCoffee(10);
        recipe.setAmtCoffee("1");

        inventory.setMilk(10);
        recipe.setAmtMilk("1");

        inventory.setSugar(10);
        recipe.setAmtSugar("1");

        inventory.setChocolate(10);
        recipe.setAmtChocolate("1");
    }

    @Test
    public void testGetChocolate() {
        inventory.setChocolate(20);

        assertNotNull(inventory);
        assertEquals(inventory.getChocolate(), 20);

        inventory.setChocolate(50);
        assertEquals(inventory.getChocolate(), 50);

        inventory.setChocolate(-1);
        assertEquals(inventory.getChocolate(), 50);
    }

    @Test
    public void testAddChocolate() throws InventoryException {

        inventory.setChocolate(10);
        inventory.addChocolate("10");

        assertEquals(inventory.getChocolate(), 20);
    }

    @Test(expected = InventoryException.class)
    public void testAddChocolate_Exception_NonInteger() throws InventoryException {
        inventory.addChocolate("potato");
    }

    @Test(expected = InventoryException.class)
    public void testAddChocolate_Exception_NegativeNumber() throws InventoryException {
        inventory.addChocolate("-1");
    }

    @Test
    public void testGetCoffee() {
        inventory.setCoffee(20);

        assertNotNull(inventory);
        assertEquals(inventory.getCoffee(), 20);

        inventory.setCoffee(50);
        assertEquals(inventory.getCoffee(), 50);

        inventory.setCoffee(-1);
        assertEquals(inventory.getCoffee(), 50);
    }

    @Test
    public void testAddCoffee() throws InventoryException {

        inventory.setCoffee(10);
        inventory.addCoffee("10");

        assertEquals(inventory.getCoffee(), 20);
    }

    @Test(expected = InventoryException.class)
    public void testAddCoffee_Exception_NonInteger() throws InventoryException {
        inventory.addCoffee("potato");
    }

    @Test(expected = InventoryException.class)
    public void testAddCoffee_Exception_NegativeNumber() throws InventoryException {
        inventory.addCoffee("-1");
    }

    @Test
    public void testGetMilk() {
        inventory.setMilk(20);

        assertNotNull(inventory);
        assertEquals(inventory.getMilk(), 20);

        inventory.setMilk(50);
        assertEquals(inventory.getMilk(), 50);

        inventory.setMilk(-1);
        assertEquals(inventory.getMilk(), 50);
    }

    @Test
    public void testAddMilk() throws InventoryException {

        inventory.setMilk(10);
        inventory.addMilk("10");

        assertEquals(inventory.getMilk(), 20);
    }

    @Test(expected = InventoryException.class)
    public void testAddMilk_Exception_NonInteger() throws InventoryException {
        inventory.addMilk("potato");
    }

    @Test(expected = InventoryException.class)
    public void testAddMilk_Exception_NegativeNumber() throws InventoryException {
        inventory.addMilk("-1");
    }

    @Test
    public void testGetSugar() {
        inventory.setSugar(20);

        assertNotNull(inventory);
        assertEquals(inventory.getSugar(), 20);

        inventory.setSugar(50);
        assertEquals(inventory.getSugar(), 50);

        inventory.setSugar(-1);
        assertEquals(inventory.getSugar(), 50);
    }

    @Test
    public void testAddSugar() throws InventoryException {

        inventory.setSugar(10);
        inventory.addSugar("10");

        assertEquals(inventory.getSugar(), 20);
    }

    @Test(expected = InventoryException.class)
    public void testAddSugar_Exception_NonInteger() throws InventoryException {
        inventory.addSugar("potato");
    }

    @Test(expected = InventoryException.class)
    public void testAddSugar_Exception_NegativeNumber() throws InventoryException {
        inventory.addSugar("-1");
    }

    @Test
    public void testEnoughIngredients_True() throws RecipeException {

        boolean isEnough = inventory.enoughIngredients(recipe);

        assertTrue(isEnough);
    }

    @Test
    public void testEnoughIngredients_False_Coffee() throws RecipeException {

        inventory.setCoffee(1);
        recipe.setAmtCoffee("10");

        boolean isEnough = inventory.enoughIngredients(recipe);

        assertFalse(isEnough);
    }

    @Test
    public void testEnoughIngredients_False_Milk() throws RecipeException {

        inventory.setMilk(1);
        recipe.setAmtMilk("10");

        boolean isEnough = inventory.enoughIngredients(recipe);

        assertFalse(isEnough);
    }

    @Test
    public void testEnoughIngredients_False_Sugar() throws RecipeException {

        inventory.setSugar(1);
        recipe.setAmtSugar("10");

        boolean isEnough = inventory.enoughIngredients(recipe);

        assertFalse(isEnough);
    }

    @Test
    public void testEnoughIngredients_False_Chocolate() throws RecipeException {

        inventory.setChocolate(1);
        recipe.setAmtChocolate("10");

        boolean isEnough = inventory.enoughIngredients(recipe);

        assertFalse(isEnough);
    }

    @Test
    public void testUseIngredients() {

        boolean isUsed = inventory.useIngredients(recipe);

        assertTrue(isUsed);
        assertEquals(inventory.getCoffee(), 9);
        assertEquals(inventory.getMilk(), 9);
        assertEquals(inventory.getSugar(), 9);
        assertEquals(inventory.getChocolate(), 9);
    }

    @Test
    public void testUseIngredients_False() throws RecipeException {

        inventory.setCoffee(1);
        recipe.setAmtCoffee("10");

        inventory.setMilk(1);
        recipe.setAmtMilk("10");

        inventory.setSugar(1);
        recipe.setAmtSugar("10");

        inventory.setChocolate(1);
        recipe.setAmtChocolate("10");

        boolean isUsed = inventory.useIngredients(recipe);

        assertFalse(isUsed);
        assertEquals(inventory.getCoffee(), 1);
        assertEquals(inventory.getMilk(), 1);
        assertEquals(inventory.getSugar(), 1);
        assertEquals(inventory.getChocolate(), 1);

    }

    @Test
    public void testToString() {
        String rtnString = inventory.toString();

        assertEquals(rtnString, "Coffee: 10\nMilk: 10\nSugar: 10\nChocolate: 10\n");
    }
}
