package pages;

import constants.IConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Log4j2
public class BasePage implements IConstants {
    WebDriver driver;

    public static final String BASE_URL = "https://www.saucedemo.com";

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        log.debug("Initializing PageFactory");
    }


    @Step("Opening url: '{url}'")
    public void openPage(String url) {
        log.info("Open URL: "+ url);
        driver.get(url);
    }

    public String getUrl(){
        return  driver.getCurrentUrl();
    }

    public void clickUsingJS(WebDriver driver, WebElement element) {
        log.warn("Warning: JS click is used!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("" + element, "");
    }

}