package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By firstName   = By.id("first-name");
    private final By lastName    = By.id("last-name");
    private final By postalCode  = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn   = By.id("finish");
    private final By errorMsg    = By.cssSelector("[data-test='error']");
    private final By completeMsg = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInfo(String first, String last, String zip) {
        type(firstName, first);
        type(lastName, last);
        type(postalCode, zip);
        click(continueBtn);
    }

    public void finishOrder() {
        click(finishBtn);
    }

    public String getErrorMessage() {
        return getText(errorMsg);
    }

    public String getCompleteMessage() {
        return getText(completeMsg);
    }
}