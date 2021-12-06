package constants;

public interface IConstants {
    String BASE_URL = "https://www.saucedemo.com";
    String CART_URL = BASE_URL + "/cart.html";
    String PRODUCT_URL = "/inventory.html";
    String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";

}
