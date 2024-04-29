package alertsFramesWindows;

import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import core.RetryAnalyzer;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j

public class NestedFramesTest extends BasePlayWrightTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test() {
        page.navigate("https://demoqa.com/nestedframes");
        assertThat(page.locator("#framesWrapper")).containsText("Frames");
        assertThat(page.frameLocator("#frame1").getByText("Parent frame")).isVisible();
        assertThat(page.frameLocator("#frame1").locator("body")).containsText("Parent frame");
        assertThat(page.frameLocator("#frame1").frameLocator("iframe").getByText("Child Iframe")).isVisible();
        assertThat(page.frameLocator("#frame1").frameLocator("iframe").getByRole(AriaRole.PARAGRAPH)).containsText("Child Iframe");
        log.error("Штрашна ажжж жуть ))) ");
    }


}
