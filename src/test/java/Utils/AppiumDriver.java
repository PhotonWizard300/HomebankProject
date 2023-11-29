package Utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class AppiumDriver {
    public static AndroidDriver getAndroidDriver(boolean isLoginClass) {

        try {
            AndroidDriver androidDriver;
            // Устанавливаем значение noReset в true, если это не класс Login
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            // Установка параметров для Appium Server
            desiredCapabilities.setCapability("noReset", !isLoginClass);
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appPackage", "kz.kkb.homebank.dev");
            desiredCapabilities.setCapability("appActivity",
                    "kz.beemobile.homebank.ui.splash.SplashActivity");
            desiredCapabilities.setCapability("automationName", "uiautomator2");
            desiredCapabilities.setCapability("app", "/Users/zhanibek/Downloads/Telegram Desktop/" +
                    "HomebankProject/src/test/resources/app/v5.34.26(500)-qa-debug.apk");

            // URL-адрес сервера
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            // Передача параметров подключения к эмулятору и URL сервера
            androidDriver = new AndroidDriver(appiumServer, desiredCapabilities);

            // Ожидание сервера, в случае возникновения ошибок
            androidDriver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);

            return androidDriver;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
