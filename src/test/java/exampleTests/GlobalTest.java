package exampleTests;

import core.BasePlayWrightTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class GlobalTest extends BasePlayWrightTest {

    @Test
    public void checkTest() {

        page.navigate("https://demoqa.com/alerts");
        assertThat(page.locator("//button[@id='alertButton']")).isVisible();
    }

}
