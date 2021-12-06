package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartSteps {
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    public CartSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    public CartSteps addProductToCartAndGoToCart(String username, String password, String productName) {
        loginPage.openLoginPage()
                .login(username, password)
                .addProductToCart(productName);
        cartPage.openProductPage();
        return this;
    }

    public CartSteps addTwoProductsToCartAndGoToCart(String username, String password, String firstProductName, String secondProductName) {
        loginPage.openLoginPage()
                .login(username, password)
                .addProductToCart(firstProductName);
        productsPage.addProductToCart(secondProductName)
                .openProductPage();
        return this;
    }
}