package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By LOG_OUT = By.id("logout_sidebar_link");
    private static final By MENU = By.id("react-burger-menu-btn");

    public void openPage(String url) {
        driver.get(url);
    }

    public void logout() {
        driver.findElement(MENU).click();
        driver.findElement(LOG_OUT).click();
    }
}