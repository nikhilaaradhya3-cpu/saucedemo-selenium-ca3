package tests;

import static org.assertj.core.api.Assertions.assertThat;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

class LoginTest extends BaseTest {

    @Test
    void validLoginReachesInventory() {
        LoginPage login = new LoginPage(driver).open();
        login.login("standard_user", "secret_sauce");
        assertThat(login.isOnInventoryPage()).isTrue();
    }

    @ParameterizedTest(name = "[{index}] user=''{0}'' pass=''{1}''")
    @CsvSource({
    	"locked_out_user, secret_sauce, 'Epic sadface: Sorry, this user has been locked out.'",
        "standard_user, wrong_pass, Epic sadface: Username and password do not match any user in this service",
        "'', secret_sauce, Epic sadface: Username is required",
        "standard_user, '', Epic sadface: Password is required"
    })
    void invalidLoginShowsError(String user, String pass, String expectedError) {
        LoginPage login = new LoginPage(driver).open();
        login.login(user, pass);
        assertThat(login.getErrorMessage()).isEqualTo(expectedError);
    }
}