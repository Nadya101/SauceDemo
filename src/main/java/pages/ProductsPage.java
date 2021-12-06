package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        log.info("Open Product page url");
        openPage(BASE_URL + PRODUCT_URL);
        return this;
    }

    @Step("Add product '{productName}' to the cart'")
    public CartPage addProductToCart(String productName) {
        log.info("Add product "+productName+" to cart" );
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return new CartPage(driver);
    }

}