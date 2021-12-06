package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import utils.Waiters;

@Log4j2
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']" +
            "//*[@class='inventory_item_price']";
    private static final String CHECKOUT_BUTTON = "//*[@data-test = 'checkout']";
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item_label']" +
            "//*[@class='btn btn_secondary btn_small cart_button']";
    private static final String SEARCH_ELEMENT_BY_NAME = "//*[text()='%s']/ancestor::*[@class='cart_item_label']" +
            "//*[@class='inventory_item_name']";
    private static final String PRODUCT_QUANTITY = "//*[text()='%s']/ancestor::*[@class='cart_item']" +
            "//*[@class='cart_quantity']";
    private static final String SHOPPING_CART_BADGE = "//*[@class = 'shopping_cart_badge']";
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public CartPage openProductPage() {
           openPage(CART_URL);
        Waiters.waitForPageLoaded();
        return this;
    }

    public String getProductPrice(String productName) {
        log.info("Get price for product: "+productName);
        String productPrice= driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Price is: "+productPrice);
        return productPrice;
    }

    @Step("Delete product '{productName}' from the cart")
    public void deleteProduct(String productName) {
        log.info("Click on Remove button");
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public boolean isProductDisplayed(String productName) {
        log.info("Check if product is displayed");
        List<WebElement> elements = driver.findElements(By.xpath(String.format(SEARCH_ELEMENT_BY_NAME, productName)));
        return elements.size() > 0;
    }

    public int getTotalElementsInCart() {
        log.info("Get number of products in cart");
        String total = driver.findElement(By.xpath(SHOPPING_CART_BADGE)).getText();
        return Integer.parseInt(total);
    }

    @Step("Open menu")
    public MenuModalPage openMenu() {
        WebElement menuButton = driver.findElement(MENU_BUTTON);
        log.info("Click on Menu button");
        menuButton.click();
        return new MenuModalPage(driver);
    }
}