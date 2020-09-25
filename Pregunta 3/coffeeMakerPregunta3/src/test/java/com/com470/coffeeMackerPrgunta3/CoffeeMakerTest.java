package com.com470.coffeeMackerPrgunta3;

import com.com470.coffeeMackerPregunta3.CoffeeMaker;
import com.com470.coffeeMackerPregunta3.Recipe;
import com.com470.coffeeMackerPregunta3.Inventory;
import com.com470.coffeeMackerPregunta3.RecipeBook;
import com.com470.coffeeMackerPregunta3.exceptions.InventoryException;
import com.com470.coffeeMackerPregunta3.exceptions.RecipeException;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

public class CoffeeMakerTest {

    /**
     * The object under test.
     */
    private CoffeeMaker coffeeMaker;
    private RecipeBook recipeBook;

    // Sample recipes to use in testing.
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;

    private Recipe recipeEdit;
    private Inventory inv;

    @Before
    public void setUp() throws RecipeException{
        iniciarRecetas();
    }
    public void iniciarRecetas() throws RecipeException{
        coffeeMaker = new CoffeeMaker();

        recipe1 = crearRecetas(recipe1,"Coffee","0","3","1","1","50");
        recipe2 = crearRecetas(recipe2,"Mocha","24","3","1","1","75");
        recipe3 = crearRecetas(recipe3,"Latte","0","4","4","1","100");
        recipe4 = crearRecetas(recipe4,"Hot Chocolate","4","0","1","1","65");
        recipe5 = crearRecetas(recipe5,"Hot Milk","16","16","17","19","78");

        inv = new Inventory();
    }
    public Recipe crearRecetas(Recipe recipex,String name,String chocolate,String cafe,String milk,String sugar,String precio) throws RecipeException{
        recipex = new Recipe();
        recipex.setName(name);
        recipex.setAmtChocolate(chocolate);
        recipex.setAmtCoffee(cafe);
        recipex.setAmtMilk(milk);
        recipex.setAmtSugar(sugar);
        recipex.setPrice(precio);
        return recipex;
    }

    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("4", "7", "0", "9");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException() throws InventoryException {
        coffeeMaker.addInventory("4", "-1", "asdf", "3");
    }

    @Test
    public void testMakeCoffee() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));
    }


    @Test
    public void testDeleteCoffee() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.deleteRecipe(0);
        String auxDR1 = coffeeMaker.deleteRecipe(0);
        assertNull(auxDR1);
    }

    @Test
    public void testDeleteCoffee2() {
        boolean add1 = coffeeMaker.addRecipe(recipe1);
        assertTrue(add1);
        String auxDR1 = coffeeMaker.deleteRecipe(0);
        assertTrue(auxDR1 == recipe1.getName());
    }

    @Test
    public void testEditCoffee() {
        coffeeMaker.addRecipe(recipe1);
        String auxDR1 = coffeeMaker.editRecipe(0, recipe1);
        //System.out.println("edit is>>"+auxDR1);
        String auxDR2 = coffeeMaker.editRecipe(0, recipe1);
        //System.out.println("edit is2>>"+auxDR2);
        assertEquals(auxDR1, auxDR2);
    }

    @Test
    public void testEditCoffeeVacio() {
        String auxDR1 = null;
        String auxDR2 = coffeeMaker.editRecipe(0, recipe1);
        assertEquals(auxDR1, auxDR2);
    }

    @Test
    public void testAddInventoryChocolate() throws InventoryException {
        Inventory inv = new Inventory();
        coffeeMaker.addInventory("0", "0", "0", "2");
        assertEquals(17, inv.getChocolate());
    }

    @Test(expected = InventoryException.class)
    public void testAddInventorycholate() throws InventoryException {
        inv.addChocolate("-2");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryCoffee2() throws InventoryException {
        inv.addCoffee("-2");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryMilk2() throws InventoryException {
        inv.addMilk("-2");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventorySugar2() throws InventoryException {
        inv.addSugar("-2");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryWrongChocolate() throws InventoryException {
        inv.addChocolate("a");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryWrongCoffee() throws InventoryException {
        inv.addCoffee("a");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryWrongMilk() throws InventoryException {
        inv.addMilk("a");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryWrongSugar() throws InventoryException {
        inv.addSugar("a");
    }

    @Test
    public void testAddRecipeChocolate() throws InventoryException {
        Inventory inv = new Inventory();
        coffeeMaker.addInventory("0", "0", "0", "2");
        assertEquals(17, inv.getChocolate());
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipecholate() throws RecipeException {
        recipe1.setAmtChocolate("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeCoffee2() throws RecipeException {
        recipe1.setAmtCoffee("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeWrong() throws RecipeException {
        recipe1.setAmtChocolate("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeMilk2() throws RecipeException {
        recipe1.setAmtMilk("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeSugar2() throws RecipeException {
        recipe1.setAmtSugar("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeWrongChocolate() throws RecipeException {
        recipe1.setAmtChocolate("a");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeWrongCoffee() throws RecipeException {
        recipe1.setAmtCoffee("a");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeWrongMilk() throws RecipeException {
        recipe1.setAmtMilk("a");
    }

    @Test(expected = RecipeException.class)
    public void testAddRecipeWrongSugar() throws RecipeException {
        recipe1.setAmtSugar("a");
    }

    @Test(expected = RecipeException.class)
    public void testAddReciPrice() throws RecipeException {
        recipe1.setPrice("-2");
    }

    @Test(expected = RecipeException.class)
    public void testAddReciWrongPrice() throws RecipeException {
        recipe1.setPrice("a");
    }

    @Test
    public void testnameRecipe() throws RecipeException {
        String expResult = "Coffee";
        String result = recipe1.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testhashcode() throws RecipeException {
        int expResult = recipe1.hashCode();
        int result = recipe1.hashCode();
        assertEquals(expResult, result);
    }

    @Test
    public void testnumIngredientes() throws RecipeException {
        int expResult = recipe1.hashCode();
        int result = recipe1.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Given a coffee maker with the default inventory When we add inventory
     * with well-formed quantities (Chocolate) Then we check the amount added to
     * each item
     */
    @Test
    public void testAddInventorySugar() throws InventoryException {
        Inventory inv = new Inventory();
        //System.out.println("inventory initial sugar>>"+inv.getSugar());
        coffeeMaker.addInventory("0", "0", "3", "0");
        //System.out.println("inventory final sugar>>"+inv.getSugar());
        assertEquals(18, inv.getSugar());
    }

    /**
     * Given a coffee maker with the default inventory When we add inventory
     * with well-formed quantities (Coffee) Then we check the amount added to
     * each item
     */
    @Test
    public void testAddInventoryCoffee() throws InventoryException {
        Inventory inv = new Inventory();
        //System.out.println("inventory initial coffee>>"+inv.getCoffee());
        coffeeMaker.addInventory("1", "0", "0", "0");
        //System.out.println("inventory final coffee>>"+inv.getCoffee());
        assertEquals(16, inv.getCoffee());
    }

    /**
     * Given a coffee maker with the default inventory When we add inventory
     * with well-formed quantities (Coffee) Then we check the amount added to
     * each item
     */
    @Test
    public void testAddInventoryMilk() throws InventoryException {
        Inventory inv = new Inventory();
        //System.out.println("inventory initial milk>>"+inv.getMilk());
        coffeeMaker.addInventory("0", "4", "0", "0");
        //System.out.println("inventory final coffee>>"+inv.getMilk());
        assertEquals(19, inv.getMilk());
    }

    /**
     * Given a coffee maker with the default inventory
     */
    @Test
    public void testCheckInventory() {
        String out = coffeeMaker.checkInventory().toString();
        assertEquals("Coffee: " + 15 + "\n" + "Milk: " + 15 + "\n" + "Sugar: " + 15 + "\n" + "Chocolate: " + 15 + "\n", out);
    }
    ///////

    @Test
    public void testMakeCoffee2() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);

        coffeeMaker.makeCoffee(0, 75);
        assertTrue(true);
        coffeeMaker.makeCoffee(1, 40);
        assertTrue(true);
        coffeeMaker.makeCoffee(0, 0);
        assertTrue(true);
        coffeeMaker.makeCoffee(2, 0);
        assertTrue(true);
        coffeeMaker.makeCoffee(1, 75);
        assertTrue(true);

    }

    @Test
    public void testGetRecipe() {
        coffeeMaker.getRecipes();
        assertTrue(true);
    }

    @Test
    public void testDeleteRecipe() {
        boolean statusAdd = coffeeMaker.addRecipe(recipe1);
        assertTrue(statusAdd);
        String statusDeleted = coffeeMaker.deleteRecipe(0);
        assertTrue(statusDeleted == recipe1.getName());

    }

    @Test
    public void testEditRecipe() {
        coffeeMaker.addRecipe(recipe2);
        assertTrue(true);
        coffeeMaker.editRecipe(0, recipe1);
        assertTrue(true);

    }

    @Test
    public void testEditRecipe2() {
        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);
        coffeeMaker.editRecipe(1, recipe2);
        assertTrue(true);
    }

    @Test
    public void testEditRecipe4() {
        coffeeMaker.addRecipe(recipe1);
        Recipe newRecipe = new Recipe();
        newRecipe = recipe1;
        try {
            newRecipe.setAmtSugar("2");
        } catch (RecipeException e) {
            e.printStackTrace();
        }
        assertEquals("Coffee", coffeeMaker.editRecipe(0, newRecipe));

    }

    @Test
    public void testRecipeNameUnique() throws RecipeException {
        String name = "Macchiato";
        Recipe r1 = new Recipe();
        Recipe r2 = new Recipe();

        r1.setName(name);
        r2.setName(name);

        coffeeMaker.addRecipe(r2);
    }

    @Test
    public void testDeleteRecipe5() {
        int index = -1;
        String result = coffeeMaker.deleteRecipe(index);
        assertNull(result);
    }

    @Test
    public void testEditRecipe5() {
        int index = -1;
        Recipe r1 = new Recipe();

        String result = coffeeMaker.editRecipe(index, r1);
        assertNull(result);
    }

    @Test
    public void testAddInventory2132() throws InventoryException {
        coffeeMaker.addInventory("2", "1", "3", "2");
        String result = coffeeMaker.checkInventory();
        String expected = "Coffee: 17\n"
                + "Milk: 16\n"
                + "Sugar: 18\n"
                + "Chocolate: 17\n";

        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    public void testPurchaseBeverage() {
        int amountPaid = 42;
        int change = coffeeMaker.makeCoffee(-1, 42);

        assertEquals(amountPaid, change);
    }

    @Test
    public void testMakeCoffee6() {
        coffeeMaker.addRecipe(recipe1);
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));
        coffeeMaker.addRecipe(recipe2);
        assertEquals(40, coffeeMaker.makeCoffee(0, 40));
        coffeeMaker.addRecipe(recipe2);
        assertEquals(40, coffeeMaker.makeCoffee(3, 40));
    }

    @Test
    public void testCheckInventory6() throws InventoryException {
        String expResult = "Coffee: 15\n"
                + "Milk: 15\n"
                + "Sugar: 15\n"
                + "Chocolate: 15\n";
        String result = coffeeMaker.checkInventory();
        assertEquals(expResult, result);
    }

    @Test
    public void testAgregarReceta() {
        coffeeMaker = new CoffeeMaker();
        boolean resultadoUno = coffeeMaker.addRecipe(recipe1);
        boolean resultadoDos = coffeeMaker.addRecipe(recipe2);
        boolean resultadoTres = coffeeMaker.addRecipe(recipe3);
        boolean resultadoCuatro = coffeeMaker.addRecipe(recipe4);

        assertThat(resultadoUno, is(true));
        assertThat(resultadoDos, is(true));
        assertThat(resultadoTres, is(true));
        assertThat(resultadoCuatro, is(false));
    }

    @Test
    public void testEliminarReceta() {
        coffeeMaker = new CoffeeMaker();

        coffeeMaker.addRecipe(recipe1);
        coffeeMaker.addRecipe(recipe2);
        coffeeMaker.addRecipe(recipe3);

        String r1 = coffeeMaker.deleteRecipe(0);
        String r2 = coffeeMaker.deleteRecipe(1);
        String r3 = coffeeMaker.deleteRecipe(2);

        assertThat(r1, is("Coffee"));
        assertThat(r2, is("Mocha"));
        assertThat(r3, is("Latte"));

        String r4 = coffeeMaker.deleteRecipe(56);
        String r5 = coffeeMaker.deleteRecipe(-1);

        assertThat(r4, nullValue());
        assertThat(r5, nullValue());
    }

    @Test
    public void testAddInventory7() throws InventoryException {
        coffeeMaker.addInventory("2", "3", "1", "4");
        coffeeMaker.addInventory("3", "4", "2", "5");
        coffeeMaker.addInventory("4", "5", "3", "6");
        coffeeMaker.addInventory("5", "6", "4", "7");
    }

    @Test(expected = InventoryException.class)
    public void testAddInventoryException7() throws InventoryException {
        coffeeMaker.addInventory("4", "-1", "Alpha", "3");
        coffeeMaker.addInventory("4", "-10", "Betha", "3");
        coffeeMaker.addInventory("4", "-100", "Gamma", "3");
    }

    @Test
    public void testMakeCoffee7() {
        boolean value1 = coffeeMaker.addRecipe(recipe1);
        boolean value2 = coffeeMaker.addRecipe(recipe2);
        boolean value3 = coffeeMaker.addRecipe(recipe3);

        assertTrue(value1);
        assertTrue(value2);
        assertTrue(value3);
    }

}