package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

class DefectTest extends BaseTest {

    // DEF-01: problem_user should reach checkout-step-two.html but stays on step one.
    // This test documents the current (defective) behaviour; flip it once the bug is fixed.
    @Test
    void knownDefectProblemUserBlockedAtCheckoutStepOne() {
        new LoginPage(driver).open().login("problem_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.openCart();
        new CartPage(driver).clickCheckout();
        new CheckoutPage(driver).fillInfo("Nikhil", "DP", "560064");
        assertThat(driver.getCurrentUrl()).contains("checkout-step-one.html");
    }
}