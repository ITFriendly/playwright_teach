package alertsFramesWindows;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import core.BasePlayWrightTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertEquals;

@Slf4j

public class WindowsTest extends BasePlayWrightTest {


    @Test
    public void newTabTest(){

        page.navigate("https://demoqa.com/browser-windows");
        Locator locator = page.locator("#tabButton");
        Page popup = page.waitForPopup(()->{
            locator.click();
        });
        popup.waitForLoadState();
        System.out.println(popup.url());
        log.info(popup.url());
        log.error(popup.url());
        log.warn(popup.content() + " newTab");

        System.out.println(popup.content() + " newTab");
        System.out.println(popup.locator("#sampleHeading").textContent());
        System.out.println(popup.locator("#sampleHeading").getClass());
        assertThat(popup).hasURL("https://demoqa.com/sample");
        assertThat(popup.locator("#sampleHeading")).hasText("This is a sample page");
        popup.close();
    }
    @Test
    public void newWindowTest(){
        page.navigate("https://demoqa.com/browser-windows");
        Locator locator = page.locator("#windowButton");
        Page popup = page.waitForPopup(()->{
            locator.click();
            System.out.println(page.locator("#sampleHeading").isVisible());
        });
        popup.waitForLoadState();
        System.out.println(popup.url());
        System.out.println(popup.content());
        System.out.println(popup.locator("#sampleHeading").textContent());
        assertThat(popup.locator("#sampleHeading")).isVisible();
        popup.close();

    }
    @Test
    public void newWindowMessageTest(){
        page.navigate("https://demoqa.com/browser-windows");
        Page popup = page.waitForPopup(()->{
            page.locator("#messageWindowButton") .click();
        });
        popup.waitForLoadState();
        System.out.println(popup.url());
        System.out.println(popup.content());
        System.out.println(popup.locator("body").textContent());
        popup.locator("body").isVisible();
        popup.locator("#body").isVisible();
        assertThat(popup.locator("body")).containsText("Knowledge increases by sharing but not by saving");

    }
}
