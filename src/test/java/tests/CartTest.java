package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add product to cart")
    @Description("Add product 'Sauce Labs Bolt T-Shirt' to the cart")
    public void addProductToCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test(description = "Add two product to cart")
    @Description("Add two products 'Sauce Labs Bolt T-Shirt' and 'Sauce Labs Backpack' to the cart")
    public void addTwoProductsToCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCart("Sauce Labs Backpack")
                .openPage();
        Assert.assertEquals(cartPage.getTotalElementsInCart(), 2, "Product wasn't added correctly!");
    }

    @Test(description = "Remove product from cart")
    @Description("Remove product 'Sauce Labs Bolt T-Shirt' from the cart")
    public void removeProductFromCartTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage()
                .deleteProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertFalse(cartPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

}