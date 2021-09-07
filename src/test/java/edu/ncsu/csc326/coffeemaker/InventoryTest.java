package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;

/**
 * Unit tests for Inventory class.
 *
 * @author Panitan Plengkham
 */

public class InventoryTest {

    /**
     * The object under test.
     */
    private Inventory inventory;

    /**
     * Initializes some inventory to test with and the {@link Inventory}
     * object we wish to test.
     */
    @Before
    public void setUp() {
        inventory = new Inventory();
    }


    /**
     * Test set the amount of chocolate
     */
    @Test
    public void testSetChocolate() {
        inventory.setChocolate(-1);
        assertEquals(15, inventory.getChocolate());
        inventory.setChocolate(50);
        assertEquals(50, inventory.getChocolate());
        inventory.setChocolate(95);
        assertEquals(95, inventory.getChocolate());
        inventory.setChocolate(100);
        assertEquals(100, inventory.getChocolate());
    }

    /**
     * Test add the amount of chocolate
     */
    @Test
    public void testAddChocolate() throws InventoryException {
        inventory.addChocolate("15");
        assertEquals(30, inventory.getChocolate());
        inventory.addChocolate("55");
        assertEquals(85, inventory.getChocolate());
        inventory.addChocolate("10");
        assertEquals(95, inventory.getChocolate());
    }

    /**
     * Test add the amount of chocolate with string
     */
    @Test(expected = InventoryException.class)
    public void testAddChocolateWithNoneNumber() throws InventoryException {
        inventory.addChocolate("Fifty");
        inventory.addChocolate("Fourty");
    }

    /**
     * Test add amount of chocolate with negative number
     */
    @Test(expected = InventoryException.class)
    public void testAddChocolateWithNegativeNumber() throws InventoryException {
        inventory.addChocolate("-2");
        inventory.addChocolate("-1");
        inventory.addChocolate("-3");
    }

    /**
     * Test set the amount of coffee
     */
    @Test
    public void testSetCoffee() {
        inventory.setCoffee(-1);
        assertEquals(15, inventory.getCoffee());
        inventory.setCoffee(50);
        assertEquals(50, inventory.getCoffee());
        inventory.setCoffee(100);
        assertEquals(100, inventory.getCoffee());
    }

    /**
     * Test add the amount of coffee
     */
    @Test
    public void testAddCoffee() throws InventoryException {
        inventory.addCoffee("10");
        assertEquals(25, inventory.getCoffee());
        inventory.addCoffee(("15"));
        assertEquals(40, inventory.getCoffee());
    }

    /**
     * Test add the amount of coffee with string
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeWithNoneNumber() throws InventoryException {
        inventory.addCoffee("Twenty");
        inventory.addCoffee("TwentyFive");
    }

    /**
     * Test add amount of coffee with negative number
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeWithNegativeNumber() throws InventoryException {
        inventory.addCoffee("-1");
        inventory.addCoffee("-2");
        inventory.addCoffee("-3");
    }

    /**
     * Test set the amount of milk
     */
    @Test
    public void testSetMilk() {
        inventory.setMilk(-1);
        assertEquals(15, inventory.getMilk());
        inventory.setMilk(50);
        assertEquals(50, inventory.getMilk());
        inventory.setMilk(70);
        assertEquals(70, inventory.getMilk());
        inventory.setMilk(80);
        assertEquals(80, inventory.getMilk());
    }

    /**
     * Test add the amount of milk properly
     */
    @Test
    public void testAddMilk() throws InventoryException {
        inventory.addMilk("25");
        assertEquals(40, inventory.getMilk());
        inventory.addMilk(("15"));
        assertEquals(55, inventory.getMilk());
        inventory.addMilk(("10"));
        assertEquals(65, inventory.getMilk());
    }

    /**
     * Test add the amount of milk with none string
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkWithNoneNumber() throws InventoryException {
        inventory.addMilk("Thirty");
    }

    /**
     * Test add the amount of milk with negative number
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkWithNegativeNumber() throws InventoryException {
        inventory.addMilk("-1");
    }

    /**
     * Test set the amount of sugar
     */
    @Test
    public void testSetSugar() {
        inventory.setSugar(-1);
        assertEquals(15, inventory.getSugar());
        inventory.setSugar(40);
        assertEquals(40, inventory.getSugar());
        inventory.setSugar(90);
        assertEquals(90, inventory.getSugar());
    }

    /**
     * Test add the amount of sugar
     */
    @Test
    public void testAddSugar() throws InventoryException {
        inventory.addSugar("0");
        assertEquals(15, inventory.getSugar());
        inventory.addSugar(("15"));
        assertEquals(30, inventory.getSugar());
    }

    /**
     * Test add the amount of sugar with string
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarWithNoneNumber() throws InventoryException {
        inventory.addSugar("Ten");
    }

    /**
     * Test add the amount of sugar with negative number
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarWithNegativeNumber() throws InventoryException {
        inventory.addSugar("-1");
    }

    /**
     * When we want to add some ingredients that is insufficient to our coffee, it should return false.
     * @throws RecipeException if there was an error parsing the ingredient
     * amount when setting up the recipe.
     */
    @Test
    public void testEnoughIngredients() throws RecipeException {
        Recipe recipe1 = new Recipe();
        recipe1.setAmtCoffee("100");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtChocolate("50");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtMilk("500");
        assertFalse(inventory.enoughIngredients(recipe1));
        recipe1.setAmtSugar("1000");
        assertFalse(inventory.enoughIngredients(recipe1));
    }

}