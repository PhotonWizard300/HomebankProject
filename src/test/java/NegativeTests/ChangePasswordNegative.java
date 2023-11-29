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

public class ChangePasswordNegative {

    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Смена пароля'")
    public void testChangePassword() {
        clickProfileIcon();
        clickCodeAccess();
        inputOTP("1111");
        clickMenu();
        clickSettings();
        changePass();
        showPass();
        createPass();
        repeatPass();
        clickNextButton();
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

    @Description("Нажать на 'Смена пароля'")
    public void changePass() {
        WebElement changePass =
                androidDriver.findElement(By.id(Locators.CHANGE_PASSWORD));
        changePass.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Смена пароля'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Показать пароль")
    public void showPass() {
        WebElement eye_icon =
                androidDriver.findElement(By.id(Locators.SHOW_ICON));
        eye_icon.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Показать пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Придумайте пароль")
    public void createPass() {
        WebElement newPass = androidDriver.findElement(By.id(Locators.CREATE_PASSWORD));
        newPass.click();
        newPass.sendKeys("AluaHomebank1");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Придумайте пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Повторите пароль")
    public void repeatPass() {;
        WebElement password = androidDriver.findElement(By.xpath(Locators.REPEAT_PASSWORD));
        password.click();
        password.sendKeys("AluaHomebank1");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Повторите пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на кнопку 'Далее'")
    public void clickNextButton() {
        WebElement nextButton = androidDriver.findElement(By.xpath(Locators.NEXT_BUTTON));
        nextButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кнопку 'Далее'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @AfterAll
    public void tearDown() {
        // Close the Appium Driver after test execution
        androidDriver.quit();
    }
}
