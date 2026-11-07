package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

class CheckoutTest extends BaseTest {
    private CheckoutPage checkout;

    @BeforeEach
    void goToCheckoutForm() {
        LoginPage login = new LoginPage(driver).open();
        login.login("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        assertThat(inventory.getCartCount()).isEqualTo("1");
        inventory.openCart();
        new CartPage(driver).clickCheckout();
        checkout = new CheckoutPage(driver);
    }

    @Test
    void completeOrderWithValidData() {
        checkout.fillInfo("Nikhil", "DP", "560064");
        checkout.finishOrder();
        assertThat(checkout.getCompleteMessage()).isEqualTo("Thank you for your order!");
    }

    @ParameterizedTest(name = "[{index}] first=''{0}'' last=''{1}'' zip=''{2}''")
    @CsvSource({
        "'', DP, 560064, Error: First Name is required",
        "Nikhil, '', 560064, Error: Last Name is required",
        "Nikhil, DP, '', Error: Postal Code is required"
    })
    void missingFieldShowsError(String first, String last, String zip, String expectedError) {
        checkout.fillInfo(first, last, zip);
        assertThat(checkout.getErrorMessage()).isEqualTo(expectedError);
    }
}