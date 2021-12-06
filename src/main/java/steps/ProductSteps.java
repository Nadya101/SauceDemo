package steps;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

@Log4j
public class ProductSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public ProductSteps loginAndAddProductToCart(String username, String password, String productName) {
        loginPage.openLoginPage()
                .login(username, password)
                .addProductToCart(productName);
        return this;
    }
}