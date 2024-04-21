package alertsFramesWindows;

import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class NestedFramesTest extends BasePlayWrightTest {
    @Test
    public void test() {
        page.navigate("https://demoqa.com/nestedframes");
        assertThat(page.locator("#framesWrapper")).containsText("Frames");
        assertThat(page.frameLocator("#frame1").getByText("Parent frame")).isVisible();
        assertThat(page.frameLocator("#frame1").locator("body")).containsText("Parent frame");
        assertThat(page.frameLocator("#frame1").frameLocator("iframe").getByText("Child Iframe")).isVisible();
        assertThat(page.frameLocator("#frame1").frameLocator("iframe").getByRole(AriaRole.PARAGRAPH)).containsText("Child Iframe");
    }


}
