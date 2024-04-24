package alertsFramesWindows;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import io.qameta.allure.Flaky;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
@Flaky
public class FramesTest extends BasePlayWrightTest {

    @Test
    void fram1test() {
        page.navigate("https://demoqa.com/frames");
        assertThat(page.locator("#framesWrapper")).containsText("Frames");
        page.frameLocator("#frame1").getByRole(AriaRole.HEADING, new FrameLocator.GetByRoleOptions().setName("This is a sample page")).click();
        assertThat(page.frameLocator("#frame1").locator("#sampleHeading")).containsText("This is a sample page");
        Locator framelocator = page.frameLocator("#frame1").locator("body");
        System.out.println(framelocator.textContent());
    }
    @Test
    void fram2test() {
     //   page.navigate("https://demoqa.com/frames");
        FrameLocator frameLocator2 =  page.frameLocator("#frame2");
        System.out.println(frameLocator2.getByTitle("#frame2"));
        assertThat(page.frameLocator("#frame2").locator("body")).containsText("This is a sample page");
       // assertThat(frameLocator2.getByTitle("#frame2")).containsText("frame2");
        System.out.println( page.frameLocator("#frame2").locator("body"));

    }
}
