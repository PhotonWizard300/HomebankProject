package CheckClickableIcon;

import io.appium.java_client.android.AndroidDriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import Utils.AppiumDriver;
import io.qameta.allure.Allure;
import jdk.jfr.Description;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MainPage {
    private AndroidDriver androidDriver;
    private utils.AllureReportGenerator reportGenerator;

    @BeforeEach
    public void setUp() {
        // Инициализация драйвера перед каждым тестом
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: Проверка кликабельности кнопок на главной странице")
    public void testIcon() {
        checkClickableIcon();
    }

    public void checkClickableIcon() {
        // Массив с текстами для поиска
        String[] searchText =
                {"Карты", "Депозиты", "Кредиты", "Рассрочка",
                        "Партнеры", "Travel", "Страховка", "Маркет",
                        "Инфо", "Госуслуги", "Invest", "QR"
                };

        for (String text : searchText) {
            // Формирование xpath для каждой иконки на экране
            String xpathExpression = "//android.widget.TextView[contains(@text, '" + text + "')]";

            // Клик на иконку
            WebElement iconElement = androidDriver.findElement(By.xpath(xpathExpression));
            iconElement.click();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Формирование скриншота
            byte[] screenshot = ((TakesScreenshot) androidDriver)
                    .getScreenshotAs(OutputType.BYTES);

            Allure.addAttachment("Кликнyть на раздел " + text, "image/png",
                    new ByteArrayInputStream(screenshot), "png");

            // Закрытие текущей сессии после клика
            androidDriver.quit();

            // Инициализация новой сессии перед следующим кликом
            androidDriver = AppiumDriver.getAndroidDriver(false);
        }

    }

    @AfterEach
    public void tearDown() {
        // Завершение драйвера после каждого теста
        androidDriver.quit();
    }
}
