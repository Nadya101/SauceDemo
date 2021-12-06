package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CartPage;
import pages.MenuModalPage;
import pages.ProductsPage;
import pages.LoginPage;
import steps.CartSteps;
import steps.ProductSteps;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    ProductsPage productsPage;
    CartPage cartPage;
    MenuModalPage menuModalPage;
    LoginPage loginPage;
    ProductSteps productSteps;
    CartSteps cartSteps;

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
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}