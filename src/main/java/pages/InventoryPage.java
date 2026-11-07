package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private final By addBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartLink    = By.className("shopping_cart_link");
    private final By cartBadge   = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart() {
        click(addBackpack);
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}