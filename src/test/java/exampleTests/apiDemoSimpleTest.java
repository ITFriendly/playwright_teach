package exampleTests;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import core.BasePlayWrightTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.annotations.Test;


import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class apiDemoSimpleTest extends BasePlayWrightTest  {


    @Test
    public void apiResponeTest(){

        APIResponse response1 = page.request().get("https://demoqa.com/browser-windows");
        System.out.println(response1.headers());
        System.out.println("<<" + response1.status() + " " + response1.url());
        assertThat(response1).isOK();
    }



}
