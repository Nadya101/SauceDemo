package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithEmptyFieldsTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyLoginFieldTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithEmptyPasswordFieldTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWhenLoginAndPasswordMatchTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "standard_user");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithIncorrectPasswordTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "111111111111");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void passwordTextHiddenTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.getTypeOfPasswordField();
        Assert.assertEquals(loginPage.getTypeOfPasswordField(), "password");
    }

    @Test
    public void lockingUserTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }
}
