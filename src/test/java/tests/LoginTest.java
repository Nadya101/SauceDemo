package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithCorrectDataTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyLoginFieldTest() {
        loginPage.openPage()
                .login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyPasswordFieldTest() {
        loginPage.openPage()
                .login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWhenLoginAndPasswordMatchTest() {
        loginPage.openPage()
                .login("standard_user", "standard_user");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithIncorrectPasswordTest() {
        loginPage.openPage()
                .login("standard_user", "111111111111");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockingUserTest() {
        loginPage.openPage()
                .login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
