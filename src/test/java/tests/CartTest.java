package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .addProductToCart("Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getTotalElementsInCart(), 2, "Product wasn't added correctly!");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage()
                .deleteProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertFalse(cartPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

    @Test
    public void cartEmptyForNewUserTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.logout();
        productsPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(cartPage.getQuantityOfProducts("Sauce Labs Bolt T-Shirt"), 0);
    }
}