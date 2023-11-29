package PositiveTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

import Utils.AppiumDriver;
import Utils.Locators;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ChangeCode {

    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Смена кода'")
    public void testChangeCode() {
        clickProfileIcon();
        inputOTP("1111");
        clickMenu();
        clickSettings();
//        clickCodeAccess();
        clickChangeCode();
//        inputOTP("1111");
//        setAccessCode();
    }

    @Description("Кликнуть на иконку профиля")
    public void clickProfileIcon() {
        WebElement profileIcon = androidDriver.findElement(By.id(Locators.PROFILE_ICON_PATH));
        profileIcon.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Кликнyть на иконку профиля", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести код-пароль")
    public void inputOTP(String otpCode) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        WebElement otp = androidDriver.findElement(By.id(Locators.OTP_CODE_PATH));
        wait.until(ExpectedConditions.elementToBeClickable(otp));

        for (int i = 1; i <= otpCode.length(); i++) {
            otp.click();
        }

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести код-пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на кнопку 'Меню'")
    public void clickMenu() {
        WebElement menu = androidDriver.findElement(By.xpath(Locators.MENU_BUTTON));
        menu.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кнопку 'Меню'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на 'Профиль и настройки'")
    public void clickSettings() {
        WebElement settings = androidDriver.findElement(By.xpath(Locators.SETTINGS_BUTTON));
        settings.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Профиль и настройки'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

//    @Description("Использовать код доступа")
//    public void clickCodeAccess() {
//        WebElement codeAccess = androidDriver.findElement(By.xpath(Locators.USING_ACCESS_CODE));
//        codeAccess.click();
//
//        byte[] screenshot = ((TakesScreenshot) androidDriver)
//                .getScreenshotAs(OutputType.BYTES);
//
//        Allure.addAttachment("Использовать код доступа", "image/png",
//                new ByteArrayInputStream(screenshot), "png");
//    }


    @Description("Нажать на 'Изменить код доступа'")
    public void clickChangeCode() {
        // Прокрутка экрана вниз
        scrollDown();

        WebElement changeCode = androidDriver.findElement(By.xpath(Locators.CHANGE_ACCESS_CODE));
        changeCode.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Изменить код доступа'", "image/png",
                new ByteArrayInputStream(screenshot), "png");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Description("Установка кода доступа")
    public void setAccessCode() {
        WebElement accessCode = androidDriver.findElement(By.xpath(Locators.INPUT_OTP_CODE));
        for (int i = 1; i <= 4; i++)
            accessCode.click();
        for (int i = 1; i <= 4; i++)
            accessCode.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Установка кода доступа", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    public void scrollDown() {
        // Получить размер мобильного утройства
        Dimension windowSize = androidDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Sleep for 7 seconds
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Задание начальных и конечных координат
        int startX = 50 * screenWidth / 100;
        int endX = startX;
        int startY = 90 * screenHeight / 100;
        int endY = 10 * screenHeight / 100;

        // Прокпутить экран вниз
        PointOption startPoint = new PointOption().withCoordinates(startX, startY);
        PointOption endPoint = new PointOption().withCoordinates(endX, endY);

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction
                .press(startPoint)
                .waitAction(new WaitOptions().withDuration(Duration.ofSeconds(1)))
                .moveTo(endPoint)
                .release()
                .perform();
    }

    @AfterAll
    public void tearDown() {
        androidDriver.quit();
    }
}

