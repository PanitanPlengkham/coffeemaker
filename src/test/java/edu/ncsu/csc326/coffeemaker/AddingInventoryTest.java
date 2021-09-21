package edu.ncsu.csc326.coffeemaker;

import io.cucumber.java.en.Given;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;


public class AddingInventoryTest {

    private CoffeeMaker coffeeMaker;

    @Given("I check stock for inventory")
    public void i_check_stock_for_inventory() {
        coffeeMaker = new CoffeeMaker();
    }

    @When("I adding {word} {int}")
    public void i_adding_item(String ingredient,Integer unit) throws InventoryException {
        if (ingredient.equals("chocolate")){
            coffeeMaker.addInventory("0","0","0",unit.toString());
        }
        if (ingredient.equals("coffee")){
            coffeeMaker.addInventory(unit.toString(),"0","0","0");
        }
        if (ingredient.equals("milk")){
            coffeeMaker.addInventory("0",unit.toString(),"0","0");
        }
        if (ingredient.equals("sugar")){
            coffeeMaker.addInventory("0","0",unit.toString(),"0");
        }
    }

    @Then("{int} coffee, {int} milk, {int} sugar, {int} chocolate( is filled)")
    public void chocolate_coffee_milk_sugar_is_filled(Integer coffee, Integer milk, Integer sugar, Integer chocolate) {
        String message = String.format("Coffee: %s\nMilk: %s\nSugar: %s\nChocolate: %s\n",coffee.toString(),milk.toString(),sugar.toString(),chocolate.toString());
        assertEquals(message,coffeeMaker.checkInventory());
    }

}
