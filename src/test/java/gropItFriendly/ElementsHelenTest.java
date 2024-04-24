package gropItFriendly;

import com.microsoft.playwright.Locator;
import core.BasePlayWrightTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class ElementsHelenTest extends BasePlayWrightTest {

    @Test
    @Description ("Elements_textbox testing")
    @Severity(SeverityLevel.NORMAL)
    public void elementsTextboxPositiveTest(){
    page.navigate("https://demoqa.com/text-box");
    page.getByPlaceholder("Full Name").fill("Lena as Lena");
    page.getByPlaceholder("name@example.com").fill("Lena@example.com");
    page.getByPlaceholder("Current Address").fill("Kharkov is the best city");
    page.click("[id=submit]");

        Assert.assertTrue(page.locator("text=Lena as Lena").isVisible());
        Assert.assertTrue(page.locator("text=Lena@example.com").isVisible());
        Assert.assertTrue(page.locator("text=Kharkov is the best city").isVisible());
    }

    @Test
    @Description ("Elements_checkbox testing")
    @Severity(SeverityLevel.NORMAL)
    public void elementsTextboxNegativeTest(){
        page.navigate("https://demoqa.com/text-box");
        page.getByPlaceholder("Full Name").fill("Lena as Lena");
        page.getByPlaceholder("name@example.com").fill("com");
        Locator element = page.locator("#userEmail");//уточнили элемент по айди
        String borderStyle = element.evaluate("el => window.getComputedStyle(el).border").toString(); //доступ к элементу через Элементы
        Assert.assertTrue(borderStyle.contains("solid") || borderStyle.contains("dashed")); // ИИ подсказал как проверить хайлайт рамки


    }



}
