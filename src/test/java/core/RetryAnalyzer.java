package core;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import lombok.Data;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

@Data
public class RetryAnalyzer implements IRetryAnalyzer {


    private int retryCount = 0;
    private static final int maxRetryCount = 3; // Максимальное количество попыток перезапуска

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() && retryCount < maxRetryCount) {
            retryCount++;
            Allure.getLifecycle().updateTestCase(testResult -> testResult.setStatus(Status.FAILED)); // Устанавливаем статус BROKEN для Allure
            Allure.addAttachment("Attach", getClass().getName()+ " " + getRetryCount());
            Allure.getLifecycle().updateTestCase(result.getTestName(), testResult -> testResult.setStatus(Status.valueOf("Brooooooken")));
            return true; // Перезапустить тест еще раз
        }
        return false;
    }

}