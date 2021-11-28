package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add product to cart")
    @Description("Add product 'Sauce Labs Bolt T-Shirt' to the cart")
    public void addProductToCartTest() {
        loginPage.openPage()
                .login(System.getProperty("username"), System.getProperty("password"))
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test(description = "Add two product to cart")
    @Description("Add two products 'Sauce Labs Bolt T-Shirt' and 'Sauce Labs Backpack' to the cart")
    public void addTwoProductsToCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .addProductToCart("Sauce Labs Backpack");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getTotalElementsInCart(), 2, "Product wasn't added correctly!");
    }

    @Test(description = "Remove product from cart")
    @Description("Remove product 'Sauce Labs Bolt T-Shirt' from the cart")
    public void removeProductFromCartTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage()
                .deleteProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertFalse(cartPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

    @Test(description = "Checking whether cart is empty for new user", retryAnalyzer = Retry.class)
    @Description("Checking that cart is empty for new user")
    public void cartEmptyForNewUserTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        checkoutPage.logout();
        productsPage.openPage();
        loginPage.login("performance_glitch_user", "secret_sauce");
        Assert.assertEquals(cartPage.getQuantityOfProducts("Sauce Labs Bolt T-Shirt"), 0);
    }
}