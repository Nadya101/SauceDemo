package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuModalPage extends BasePage {

    public MenuModalPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOG_OUT_BUTTON = By.xpath("//*[@id='logout_sidebar_link']");

    @Step("Logout user")
    public LoginPage clickLogoutButton() {
        WebElement logoutButton = driver.findElement(LOG_OUT_BUTTON);
        waitForElementLocated(logoutButton, 5);
        logoutButton.click();
        return new LoginPage(driver);
    }

}
