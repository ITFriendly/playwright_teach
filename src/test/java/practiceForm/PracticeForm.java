package practiceForm;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import core.BasePlayWrightTest;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PracticeForm extends BasePlayWrightTest {

    @Test
    public void checkTest() {
        page.navigate("https://demoqa.com/automation-practice-form");
        page.navigate("https://demoqa.com/automation-practice-form");
        page.getByPlaceholder("First Name").click();
        page.getByPlaceholder("First Name").fill("test");
        page.getByPlaceholder("First Name").press("Tab");
        page.getByPlaceholder("Last Name").fill("test");
        page.getByPlaceholder("Last Name").press("Tab");
        page.getByPlaceholder("name@example.com").fill("test@test.com");
        page.getByText("Male", new Page.GetByTextOptions().setExact(true)).click();
        page.getByText("Female").click();
        page.getByText("Other").click();
        assertThat(page.getByText("Other")).isVisible();
        page.getByPlaceholder("Mobile Number").click();
        page.getByPlaceholder("Mobile Number").fill("0000000000");
        page.getByPlaceholder("Mobile Number").click();
        assertThat(page.getByPlaceholder("Mobile Number")).hasValue("0000000000");
        page.locator("#dateOfBirthInput").click();
        page.getByLabel("Choose Monday, April 1st,").click();
        page.locator("#dateOfBirthInput").click();
        assertThat(page.getByLabel("Choose Monday, April 1st,")).isVisible();
        assertThat(page.getByRole(AriaRole.COMBOBOX).nth(1)).isVisible();
        assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^JanuaryFebruaryMarchAprilMayJuneJulyAugustSeptemberOctoberNovemberDecember$"))).getByRole(AriaRole.COMBOBOX)).hasValue("3");
        assertThat(page.getByLabel("Choose Monday, April 1st,")).containsText("1");
        assertThat(page.locator("#dateOfBirth")).containsText("April 2024");
        page.locator(".subjects-auto-complete__value-container").click();
        page.locator(".subjects-auto-complete__value-container").click();
        page.locator("#subjectsInput").fill("TestSubject");
        page.locator(".subjects-auto-complete__value-container").click();
        page.locator("#subjectsInput").click();
        page.locator("#subjectsInput").fill("TestSubject");
        page.locator(".subjects-auto-complete__value-container").click();
        page.locator("#subjectsInput").fill("TestSubject");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Reading$"))).click();
        page.getByText("Music").click();
        page.getByText("Sports").click();
        assertThat(page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Sports$")))).isVisible();
        page.getByText("Reading").click();
        page.getByText("Music").click();
//  @TODO add picture upload and check
//      page.getByLabel("Select picture").click();
//      page.getByLabel("Select picture").setInputFiles(Paths.get("jmeter.log"));
//      assertThat(page.getByLabel("Select picture")).isVisible();
//      assertThat(page.getByLabel("Select picture")).hasValue("C:\\fakepath\\jmeter.log");
        page.getByPlaceholder("Current Address").click();
        page.getByPlaceholder("Current Address").fill("Adress");
        assertThat(page.getByPlaceholder("Current Address")).isVisible();
        assertThat(page.locator("#currentAddress-label")).containsText("Current Address");
        assertThat(page.getByPlaceholder("Current Address")).hasValue("Adress");
        page.getByText("Select State").click();
        page.getByText("Haryana", new Page.GetByTextOptions().setExact(true)).click();
        assertThat(page.locator("#state")).containsText("Haryana");
        page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Select City$"))).nth(3).click();
        page.getByText("Karnal", new Page.GetByTextOptions().setExact(true)).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("Student Name")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("test test")).click();
        page.getByRole(AriaRole.CELL, new Page.GetByRoleOptions().setName("test test")).click();
        assertThat(page.locator("tbody")).containsText("test test");
        assertThat(page.locator("tbody")).containsText("test@test.com");
        assertThat(page.locator("tbody")).containsText("Other");
        assertThat(page.locator("tbody")).containsText("0000000000");
        assertThat(page.locator("tbody")).containsText("01 April,2024");
        assertThat(page.locator("tbody")).containsText("Sports");
       // @TODO
       //   assertThat(page.locator("tbody")).containsText("jmeter.log");
        assertThat(page.locator("tbody")).containsText("Adress");
        assertThat(page.locator("tbody")).containsText("Haryana Karnal");
      //  page.locator("#close-fixedban").click();
      //  page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
    }
}
