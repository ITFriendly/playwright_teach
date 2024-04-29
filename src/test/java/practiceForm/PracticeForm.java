package practiceForm;

import core.BasePlayWrightTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PracticeForm extends BasePlayWrightTest {

    @Test
    public void checkTest() {

        page.navigate("https://demoqa.com/automation-practice-form");
        assertThat(page.locator("//button[@id='alertButton']")).isVisible();
    }

}
