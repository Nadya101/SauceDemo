package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test = 'error']");

    public LoginPage openPage() {
        openPage(BASE_URL);
        waitForPageLoaded();
        return this;
    }



    @Step("Login as username: '{username}' and password: '{password}'")
    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        clickOnLoginButton();
        return new ProductsPage(driver);
    }

    @Step("Click on 'Login' button on Login page")
    public void clickOnLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getUrl(){
      return  driver.getCurrentUrl();
    }
}