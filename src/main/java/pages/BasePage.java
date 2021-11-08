package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final String BASE_URL = "https://www.saucedemo.com";
    private static final By LOG_OUT_BUTTON = By.id("logout_sidebar_link");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    public void openPage(String url) {
        driver.get(url);
    }

    public void waitForPageLoaded() {
        new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
    }

    public void logout() {
        driver.findElement(MENU_BUTTON).click();
        driver.findElement(LOG_OUT_BUTTON).click();
    }
}