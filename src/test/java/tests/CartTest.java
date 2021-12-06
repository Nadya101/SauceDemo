package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(description = "Add product to cart")
    @Description("Add product 'Sauce Labs Bolt T-Shirt' to the cart")
    public void addProductToCartTest() {
        cartSteps.addProductToCartAndGoToCart("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test(description = "Add two product to cart")
    @Description("Add two products 'Sauce Labs Bolt T-Shirt' and 'Sauce Labs Backpack' to the cart")
    public void addTwoProductsToCartTest() {
        cartSteps.addTwoProductsToCartAndGoToCart("standard_user", "secret_sauce",
                "Sauce Labs Bolt T-Shirt", "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getTotalElementsInCart(), 2, "Product wasn't added correctly!");
    }

    @Test(description = "Remove product from cart", retryAnalyzer = Retry.class)
    @Description("Remove product 'Sauce Labs Bolt T-Shirt' from the cart")
    public void removeProductFromCartTest() {
        cartSteps.addProductToCartAndGoToCart("standard_user", "secret_sauce", "Sauce Labs Bolt T-Shirt");
        cartPage.deleteProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertFalse(cartPage.isProductDisplayed("Sauce Labs Bolt T-Shirt"));
    }

    @Test(dataProvider = "User data", dataProviderClass = TestDataProvider.class, retryAnalyzer = Retry.class)
    @Description("Add product to cart")
    public void addProductToCartTest(String username, String password, String productName, String expectedPrice) {
        cartSteps.addProductToCartAndGoToCart(username, password, productName);
        Assert.assertEquals(cartPage.getProductPrice(productName), expectedPrice);
    }

}