package alertsFramesWindows;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import core.RetryAnalyzer;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


@Slf4j
public class DialogsTest extends BasePlayWrightTest {

    @Test (groups = {"flaky"})
    @Description("Test wrote by playwright recorder")
    public void smallModaltest() throws IOException {
       try {
           log.info("Retry " + new RetryAnalyzer().getRetryCount());
           page.navigate("https://demoqa.com/modal-dialogs");
           page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Small modal")).click();
           assertThat(page.getByText("Small Modal", new Page.GetByTextOptions().setExact(true))).isVisible();
           assertThat(page.getByLabel("Small Modal").getByRole(AriaRole.DOCUMENT)).containsText("This is a small modal. It has very less content");
           page.locator("#closeSmallModal").click();
       } catch (PlaywrightException e) {
           log.error(e.getMessage() + " this is a  " + e.getClass());
           addLog();
       }
    }

    @Test (groups = {"flaky"})
    public void smallModalSimpletest() throws IOException {
       try {
           page.navigate("https://demoqa.com/modal-dialogs");
           page.locator("#showSmallModal").click();
           assertThat(page.locator("#example-modal-sizes-title-sm")).isVisible();
           log.info(page.getByLabel("Small Modal").textContent());
           assertThat(page.getByLabel("Small Modal")).containsText("This is a small modal. It has very less content");
           page.locator("#closeSmallModal").click();
       } catch (PlaywrightException e) {
           log.error(e.getMessage() + " this is a  " + e.getClass());
           addLog();
       }

    }

    @Test (groups = {"flaky"})
    @Description("Test wrote by playwright recorder")
    @Step("Test wrote by playwright recorder")
    @Flaky
    @AllureId("12345")
    @Tag("Just a tag )")
    @Link(name = "DEMOQA_TRAINING", url = "https://github.com/orgs/ITFriendly/projects/1/views/1?pane=issue&itemId=58709797")
    public void largeModalSimpletest() throws IOException {
        page.navigate("https://demoqa.com/modal-dialogs");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Large modal")).click();
        assertThat(page.getByText("Large Modal", new Page.GetByTextOptions().setExact(true))).isVisible();
        assertThat(page.getByRole(AriaRole.PARAGRAPH)).containsText("Lorem Ipsum is simply ");
        page.locator("#closeLargeModal").click();
        largeModalSimpleSimpletest();
    }

    @Step("Run Simple Test")
    public void largeModalSimpleSimpletest() throws IOException {
        try {
            page.locator("#showLargeModal").click();
            assertThat(page.locator(" #example-modal-sizes-title-lg")).isVisible();
            log.info(page.getByLabel("Large Modal").textContent().substring(0, 12));
            assertThat(page.locator("#example-modal-sizes-title-lg")).isVisible();
            assertThat(page.locator(".modal-body")).containsText("Lorem Ipsum is simply ");
            page.locator("#closeLargeModal").click();
        } catch (PlaywrightException e){
            log.error(e.getMessage() + " this is a  " + e.getClass());
            addLog();

        }

    }

}
