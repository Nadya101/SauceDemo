package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test = 'error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        openPage(BASE_URL);
        Waiters.waitForPageLoaded();
        return this;
    }

    @Step("Login as username: '{username}' and password: '{password}'")
    public ProductsPage login(String username, String password) {
        log.info(String.format("Type text: '%s' into username input", username));
        log.debug("Locator is: " + USERNAME_INPUT);
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info(String.format("Type text: '%s' into password input", password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        clickOnLoginButton();
        return new ProductsPage(driver);
    }

    @Step("Click on 'Login' button on Login page")
    public void clickOnLoginButton(){
        log.info("Click login button");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }


    public String getUrl(){
        return  driver.getCurrentUrl();
    }

}