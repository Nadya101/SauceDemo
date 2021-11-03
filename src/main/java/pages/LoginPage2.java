package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage2 extends BasePage {

    public LoginPage2(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By ERROR_MESSAGE = By.xpath("//*[@data-test = 'error']");

    public LoginPage2 openPage(){
        openPage(BASE_URL);
        waitForPageLoaded();
        return this;
    }

    public ProductsPage login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    public String getErrorText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}