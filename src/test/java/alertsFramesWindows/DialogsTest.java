package alertsFramesWindows;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Flaky;
import io.qameta.allure.Step;
import io.qameta.allure.testng.Tag;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Slf4j
public class DialogsTest extends BasePlayWrightTest {

    @Test
    @Description("Test wrote by playwright recorder")
    public void smallModaltest() {
        page.navigate("https://demoqa.com/modal-dialogs");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Small modal")).click();
        assertThat(page.getByText("Small Modal", new Page.GetByTextOptions().setExact(true))).isVisible();
        assertThat(page.getByLabel("Small Modal").getByRole(AriaRole.DOCUMENT)).containsText("This is a small modal. It has very less content");
        page.locator("#closeSmallModal").click();
    }

    @Test
    public void smallModalSimpletest() {
        page.navigate("https://demoqa.com/modal-dialogs");
        page.locator("#showSmallModal").click();
        assertThat(page.locator("#example-modal-sizes-title-sm")).isVisible();
        log.info(page.getByLabel("Small Modal").textContent());
        assertThat(page.getByLabel("Small Modal")).containsText("This is a small modal. It has very less content");
        page.locator("#closeSmallModal").click();
    }

    @Test
    @Description("Test wrote by playwright recorder")
    @Step("Test wrote by playwright recorder")
    @Flaky
    @AllureId("12345")
    @Tag("Just a tag )")
    public void largeModalSimpletest() {
        page.navigate("https://demoqa.com/modal-dialogs");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Large modal")).click();
        assertThat(page.getByText("Large Modal", new Page.GetByTextOptions().setExact(true))).isVisible();
        assertThat(page.getByRole(AriaRole.PARAGRAPH)).containsText("Lorem Ipsum is simply ");
        page.locator("#closeLargeModal").click();
        largeModalSimpleSimpletest();
    }

    @Step("Run Simple Test")
    public void largeModalSimpleSimpletest() {
        page.locator("#showLargeModal").click();
        assertThat(page.locator(" #example-modal-sizes-title-lg")).isVisible();
        log.info(page.getByLabel("Large Modal").textContent().substring(0, 12));
        assertThat(page.locator("#example-modal-sizes-title-lg")).isVisible();
        assertThat(page.locator(".modal-body")).containsText("Lorem Ipsum is simply ");
        page.locator("#closeLargeModal").click();
    }
}
