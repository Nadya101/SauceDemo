package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }
public static final String CART_URL = "/cart.html";
    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']" +
            "//*[@class='inventory_item_price']";
    private static final String CHECKOUT_BUTTON = "//*[@data-test = 'checkout']";
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item_label']" +
            "//*[@class='btn btn_secondary btn_small cart_button']";
    private static final String SEARCH_ELEMENT_BY_NAME ="//*[text()='%s']/ancestor::*[@class='cart_item_label']" +
            "//*[@class='inventory_item_name']";
    private static final String PRODUCT_QUANTITY = "//*[text()='%s']/ancestor::*[@class='cart_item']" +
            "//*[@class='cart_quantity']";
    private static final String SHOPPING_CART_BADGE = "//*[@class = 'shopping_cart_badge']";

    public CartPage openPage(){
        openPage(BASE_URL+CART_URL);
        waitForPageLoaded();
        return this;
    }
    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public int getQuantityOfProducts(String productName) {
        String quantityText = driver.findElement(By.xpath(String.format(PRODUCT_QUANTITY, productName))).getText();
        return Integer.parseInt(quantityText);
    }

    public void deleteProduct(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public boolean isProductDisplayed(String productName) {
        List<WebElement> elements = driver.findElements(By.xpath(String.format(SEARCH_ELEMENT_BY_NAME, productName)));
        return elements.size() > 0;
    }

    public int getTotalElementsInCart(){
        String total = driver.findElement(By.xpath(SHOPPING_CART_BADGE)).getText();
        return Integer.parseInt(total);
    }
}