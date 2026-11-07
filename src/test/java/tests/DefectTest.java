package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

class DefectTest extends BaseTest {

    @Test
    void problemUserCanReachCheckoutOverview() {
        new LoginPage(driver).open().login("problem_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.openCart();
        new CartPage(driver).clickCheckout();
        new CheckoutPage(driver).fillInfo("Nikhil", "DP", "560064");
        assertThat(driver.getCurrentUrl()).contains("checkout-step-two.html");
    }
}