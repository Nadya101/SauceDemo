package tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider
    public static Object[][] userInvalidData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_use", "", "Epic sadface: Password is required"},
                {"user", "132163854", "Epic sadface: Username and password do not match any user in this service"},
                {"DROP TABLE", "admin", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
