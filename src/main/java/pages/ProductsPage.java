package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public static final String PRODUCT_URL = "/inventory.html";
    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";


    public ProductsPage openPage() {
        openPage(BASE_URL + PRODUCT_URL);
        return this;
    }

    @Step("Add product '{productName}' to the cart'")
    public CartPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return new CartPage(driver);
    }

}