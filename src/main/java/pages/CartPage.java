package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final String CONTINUE_SHOPPING_BTN = "//*[@data-test = 'error']";
    private static final String CHECKOUT_BTN = "//*[@data-test = 'checkout']";
    private static final String QUANTITY = "cart_quantity";
    private static final String REMOVE_BTN = "//*[@data-test = 'remove-sauce-labs-bolt-t-shirt']";


    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public int getQuantityOfProducts() {
        String quantityText = driver.findElement(By.className(QUANTITY)).getText();
        return Integer.parseInt(quantityText);
    }

    public void deleteProduct() {
        driver.findElement(By.xpath(REMOVE_BTN)).click();
    }

    public void proceedShopping() {
        driver.findElement(By.xpath(CONTINUE_SHOPPING_BTN)).click();
    }

    public void proceedCheckout() {
        driver.findElement(By.xpath(CHECKOUT_BTN)).click();
    }
}