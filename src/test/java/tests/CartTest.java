package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getTotalElementsInCart(), 2, "Product wasn't added!");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.deleteProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertFalse(cartPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void cartEmptyForNewUserTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.logout();
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(cartPage.getQuantityOfProducts("Sauce Labs Bolt T-Shirt"), 0);
    }
}