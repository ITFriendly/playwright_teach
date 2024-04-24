import com.microsoft.playwright.APIResponse;
import core.BasePlayWrightTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Ignore
public class apiDemoSimpleTest extends BasePlayWrightTest {


    @Test
    public void apiResponeTest(){
        APIResponse response1 = page.request().get("https://demoqa.com/browser-windows");
        System.out.println(response1.headers());
        System.out.println("<<" + response1.status() + " " + response1.url());
        assertThat(response1).isOK();
    }

}
