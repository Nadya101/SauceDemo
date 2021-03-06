package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CartPage;
import pages.MenuModalPage;
import pages.ProductsPage;
import pages.LoginPage;

public class BaseTest {
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;
    MenuModalPage menuModalPage;
    LoginPage loginPage;

    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        String driverVariable= "driver";
        context.setAttribute(driverVariable, driver);
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        menuModalPage = new MenuModalPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}