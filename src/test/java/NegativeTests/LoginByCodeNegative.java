package NegativeTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;

import Utils.AppiumDriver;
import Utils.Locators;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class LoginByCodeNegative {

    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Вход в приложение по коду'(Негативный)")
    public void testLoginByCode() {
        clickProfileIcon();
        clickCodeAccess();
        inputOTP("1111");
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

    @Description("Использовать код доступа")
    public void clickCodeAccess() {
        WebElement codeAccess = androidDriver.findElement(By.xpath(Locators.USING_ACCESS_CODE));
        codeAccess.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Использовать код доступа", "image/png",
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

    @AfterAll
    public void tearDown() {
        androidDriver.quit();
    }
}
