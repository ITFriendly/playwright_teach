import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class OksanaTest extends BasePlayWrightTest {

    @Step("Open tested website")
    public void openBrowser(){
        page.navigate("https://www.saucedemo.com/");
    }

    @Step("Fill in the Username field")
    public void enterUsername(String username) {
        page.getByPlaceholder("Username").fill(username);
    }
    @Step ("Fill in the Login field")
    public void enterPassword(String login) {
        page.getByPlaceholder("Password").fill(login);
    }

    @Test
    @Description ("Succesfull login")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){
        openBrowser();
        enterUsername("standard_user");
        enterPassword("secret_sauce");
        page.locator("#login-button").click();
        assertThat(page.locator(".app_logo")).containsText("Swag Labs");
    }

    @Step("Logging in")
    public void login() {
        enterUsername("standard_user");
        enterPassword("secret_sauce");
        page.locator("#login-button").click();
    }

    @Test
    @Description ("Add product to the bag")
    @Severity(SeverityLevel.CRITICAL)
    public void addToBagTest() {
        openBrowser();
        login();
        page.locator("#add-to-cart-sauce-labs-backpack").click();

        String productToBuy = page.locator("a[id='item_4_title_link'] div[class='inventory_item_name ']")
                .textContent();

        page.locator(".shopping_cart_link").click();
        Assert.assertEquals(page.locator(".inventory_item_name").textContent(), productToBuy);

    }
}
