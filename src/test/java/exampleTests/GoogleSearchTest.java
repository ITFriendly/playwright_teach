package exampleTests;

import com.microsoft.playwright.PlaywrightException;
import core.BasePlayWrightTest;
import io.qameta.allure.*;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static io.qameta.allure.SeverityLevel.TRIVIAL;


@Severity(TRIVIAL)
@Flaky
@Slf4j
public class GoogleSearchTest extends BasePlayWrightTest {


    @Step ("Open page and search")
    public void openBrowser(){
        page.navigate("https://www.google.com.ua/");
      // assertThat(page.getByLabel("Пошук", new Page.GetByLabelOptions().setExact(true))).isVisible();
    }

    @Step ("Enter text into search filed")
    public void enterIntoSearchField(String search){
       page.querySelector("//*[@id=\"APjFqb\"]").fill(search);
    }

    @Test
    @Description ("Поиск в гугле")
    @Severity(SeverityLevel.CRITICAL)
    public void searchTest() {
       openBrowser();
       enterIntoSearchField("hi google");
        page.querySelector("//*[@id=\"APjFqb\"]").press("Enter");
      try {
          assertThat(page.locator("#result-stats")).containsText("Приблизна кількість результатів:");
          assertThat(page.locator("#center_col")).containsText("google");
          // page.wait(500);
          Assert.assertTrue(page.locator("#result-stats").textContent().contains("Приблизна"));
      } catch (PlaywrightException e){
          log.error(e.getMessage());
      }

    }
}
