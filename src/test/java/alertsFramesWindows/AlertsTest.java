package alertsFramesWindows;

import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Locator;
import core.BasePlayWrightTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsTest extends BasePlayWrightTest {

    @Test
    public void allertDialogTest() {
        page.navigate("https://demoqa.com/alerts");
        //находим кнопку и выводим надпись кнопки и статус
        Locator button = page.locator("#alertButton");
        System.out.println(page.locator("//button[@id='alertButton']").textContent());
        System.out.println(page.locator("//button[@id='alertButton']").isVisible());
        page.onceDialog(alert -> {
            String message = alert.message();
            System.out.println(alert.type() + " - alert type");
            System.out.println(message + " - alert message");
            Assert.assertTrue(message.contains("You clicked a button"));
            alert.accept();
        });
        //кликаем и эта хрень работает!
        button.first().click();


    }

    @Test
    public void timeallertDialogTest()  {
        page.navigate("https://demoqa.com/alerts");
        Locator timealert = page.locator("#timerAlertButton");
        System.out.println(timealert.hashCode());
        page.onceDialog(alert -> {
            String message = alert.message();
            System.out.println(alert.type() + " - alert type");
            System.out.println(message + " - alert message");
            Assert.assertTrue(message.contains("This alert appeared after 5 seconds"));
            alert.accept();
        });
        timealert.click();
        page.waitForTimeout(5000);
    }


    @Test
    public void confirmButtonOk() {
        page.navigate("https://demoqa.com/alerts");
        Locator confirmButton = page.locator("#confirmButton");
        page.onceDialog(alert -> {
            String message = alert.message();
            System.out.println(alert.type() + " - alert type");
            System.out.println(message + " - alert message");
            Assert.assertTrue(message.contains("Do you confirm action?"));
            alert.accept();
        });
        confirmButton.click();
        assertThat(page.locator("#confirmResult")).containsText(
                "Ok");
    }

    @Test
    public void confirmButtonCancel() {
        page.navigate("https://demoqa.com/alerts");
        Locator confirmButton = page.locator("#confirmButton");
        page.onceDialog(Dialog::dismiss);
        confirmButton.click();
        assertThat(page.locator("#confirmResult")).containsText(
                "Cancel");
    }

    @Test
    public void promtButton() {
        page.navigate("https://demoqa.com/alerts");
        Locator confirmButton = page.locator("#promtButton");
        String text = "Hello java";
        page.onceDialog(dialog -> {
            System.out.println(dialog.type() + " - alert type");
            System.out.println(dialog.message() + " - alert message");
            dialog.accept(text);
        });
        confirmButton.click();
        assertThat(page.locator("#promptResult")).containsText(text);
    }

}



