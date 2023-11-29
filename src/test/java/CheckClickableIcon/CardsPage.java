package CheckClickableIcon;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Utils.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import jdk.jfr.Description;

public class CardsPage {
    private AndroidDriver androidDriver;

    public void setUp() {
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: Проверка кликабельности кнопок на странице 'Карты'")
    public void testCards() {

    }
    @AfterAll
    public void tearDown() {
        androidDriver.quit();
    }
}
