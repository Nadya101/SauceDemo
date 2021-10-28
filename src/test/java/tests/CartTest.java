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
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.proceedShopping();
        productsPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getQuantityOfProducts(), 2, "Product 2 replace product 1!");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.deleteProduct();
        Assert.assertEquals(cartPage.getQuantityOfProducts(), 0);
    }

    @Test
    public void cartEmptyForNewUserTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.logout();
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(cartPage.getQuantityOfProducts(), 0);
    }
}