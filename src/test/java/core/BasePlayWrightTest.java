package core;

import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

public class BasePlayWrightTest {
    protected Page page;
    private Browser browser;
    private BrowserContext context;
    private Boolean isTraceEnabled = true;
    private Boolean isHeadlessEnabled = true;

    /**
     * Инициализация браузера и его настроек перед запуском всех тестов в классе
     */
    @BeforeClass
    public void setUp() {

        if (System.getProperty("os.name").toLowerCase().contains("windows")) isHeadlessEnabled = false;
        // System.out.println(System.getProperty("os.name"));
        //инициализация браузера с настройками

        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(isHeadlessEnabled).setChannel("chrome"));

        //создаем контекст для браузера
        context = browser.newContext(new Browser.NewContextOptions()
                .setLocale("uk-UA"));

        //трейсинг замедляет скорость заполнение полей
        if (isTraceEnabled) {
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));
        }
        //создаем новую страницу
        page = context.newPage();
    }

    /**
     * Закрывает браузер после выполнения всех тестов в классе
     */
    @AfterClass
    public void tearDown() {
        browser.close();
        //для возможности оставлять браузер открытым
        //        if (browser != null) {
//            browser.close();
//            browser = null;
//        }
    }

    /**
     * Добавляет вложения к упавшему тесту. Скриншот, исходный код страницы, трейсинг
     *
     * @param result данные о тесте
     * @throws IOException
     */

    @AfterMethod
    public void attachFilesToFailedTest(ITestResult result) throws IOException {
        String uuid = UUID.randomUUID().toString();
        String randomStr = String.valueOf(new Random().nextInt(100));
        if (!result.isSuccess()) {
            byte[] screenshot = page.screenshot(new Page.ScreenshotOptions()
                    .setPath(Paths.get("target/allure-results/screenshot_" + uuid + "screenshot.png"))
                    .setFullPage(true));

            Allure.addAttachment(uuid, new ByteArrayInputStream(screenshot));
            Allure.addAttachment("source.html", "text/html", page.content());

            if (isTraceEnabled) {
                String traceFileName = String.format("target/%s_trace.zip", randomStr);
                Path tracePath = Paths.get(traceFileName);
                context.tracing()
                        .stop(new Tracing.StopOptions()
                                .setPath(tracePath));
                Allure.addAttachment("traceForPlayWright.zip", new ByteArrayInputStream(Files.readAllBytes(tracePath)));
                Allure.addAttachment("Link", "https://trace.playwright.dev/");
            }
        }
    }


    public void addLog() throws IOException {
        String logfile = String.format("target/itfriendly-test.log");
        Path logpath = Paths.get(logfile);
        Allure.addAttachment("itfriendly-test.log", new ByteArrayInputStream(Files.readAllBytes(logpath)));
    }
}
