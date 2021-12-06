package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiters;

public class LoginPageFactory extends BasePage{

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='bot_column']")
    WebElement botLogo;

    public void login(String username, String password) {
       // Waiters.waitForElementLocated(driver, userNameInput, 10);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

}