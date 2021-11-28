package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "userInvalidData", dataProviderClass = TestDataProvider.class, description = "Login with invalid data")
    @Description("Login with invalid data")
    public void loginWithInvalidDataTest(String login, String password, String result) {
        loginPage.openLoginPage()
                .login(login, password);
        Assert.assertEquals(loginPage.getErrorText(), result);
    }

    @Test(description = "Login with valid data")
    @Description("Login with valid data: login: 'standard_user' and password: 'secret_sauce'")
    public void loginWithValidDataTest() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(description = "Login with empty field")
    @Description("Login with empty login and password field")
    public void loginWithEmptyFieldsTest() {
        loginPage.openLoginPage()
                .login("", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test(description = "Login with empty login field")
    @Description("Login with empty login field")
    public void loginWithEmptyLoginFieldTest() {
        loginPage.openLoginPage()
                .login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required");
    }

    @Test(description = "Login with empty password field")
    @Description("Login with empty password field")
    public void loginWithEmptyPasswordFieldTest() {
        loginPage.openLoginPage()
                .login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required");
    }

    @Test(description = "Login with the same login and password")
    @Description("Login with password: 'standard_user' and username: 'standard_user'")
    public void loginWhenLoginAndPasswordMatchTest() {
        loginPage.openLoginPage()
                .login("standard_user", "standard_user");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Login with wrong password")
    @Description("Login with valid loging: 'standard_user' and wrong password: '111111111111'")
    public void loginWithIncorrectPasswordTest() {
        loginPage.openLoginPage()
                .login("standard_user", "111111111111");
        Assert.assertEquals(loginPage.getErrorText(),
                "Epic sadface: Username and password do not match any user in this service");
    }

    @Test(description = "Login for locking user")
    @Description("Login for locking user")
    public void lockingUserTest() {
        loginPage.openLoginPage()
                .login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Logout user")
    @Description("Logout user")
    public void logoutUser() {
        loginPage.openLoginPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openMenu()
                .clickLogoutButton();
        Assert.assertEquals(loginPage.getUrl(), "https://www.saucedemo.com/");
    }
}