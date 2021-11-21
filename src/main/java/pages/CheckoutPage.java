package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOG_OUT_BUTTON = By.id("logout_sidebar_link");
    private static final By MENU_BUTTON = By.id("react-burger-menu-btn");

    @Step("Logout user ")
    public void logout() {
        driver.findElement(MENU_BUTTON).click();
        driver.findElement(LOG_OUT_BUTTON).click();
    }
}
