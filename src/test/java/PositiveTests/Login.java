package PositiveTests;

import Utils.PrivateData;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;

import Utils.AppiumDriver;


import Utils.Locators;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Login {
    AndroidDriver androidDriver;
    utils.AllureReportGenerator allureReportGenerator;

    @BeforeAll
    public void setUp() {
        androidDriver = AppiumDriver.getAndroidDriver(true);
        allureReportGenerator = new utils.AllureReportGenerator();
    }
    @Test
    @Description("Tестовый кейс: 'Вход в приложение'")
    public void testLogin() {
        clickSkipButton();
        clickProfileIcon();
        inputPhoneNumber();
        clickNextButton();
        inputPassword();
        clickNextButton();
//        clickSignIn();
        inputOTP("1111" + "1111");
        // Генерация отчета Allure после выполнения всех тестов
    }

    @Description("Нажать на кнопку пропустить")
    public void clickSkipButton() {
        WebElement skipButton = androidDriver.findElement(By.xpath(Locators.SKIP_BUTTON));
        skipButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кнопку 'Пропустить'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
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

    @Description("Ввести номер телефона")
    public void inputPhoneNumber() {
        WebElement phoneNumber = androidDriver.findElement(By.id(Locators.INPUT_PHONE_NUMBER));
        phoneNumber.click();
        PrivateData login = new PrivateData();
        phoneNumber.sendKeys(login.getPhoneNumber());

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести номер телефона", "image/png",
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

    @Description("Введите пароль")
    public void inputPassword() {
        WebElement pwd = androidDriver.findElement(By.id(Locators.INPUT_PASSWORD));
//        pwd.click();
        PrivateData password = new PrivateData();
        androidDriver.getKeyboard().
                pressKey(password.getPassword());

//        androidDriver.getKeyboard().
//                pressKey(Keys.ENTER);

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Введите пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

//    @Description("Нажать на кнопку 'Вход'")
//    public void clickSignIn() {
//        WebElement signIn = androidDriver.findElement(By.xpath(Locators.SIGN_IN_BUTTON));
//        signIn.click();
//
//        byte[] screenshot = ((TakesScreenshot) androidDriver)
//                .getScreenshotAs(OutputType.BYTES);
//
//        Allure.addAttachment("Нажать на кнопку 'Вход'", "image/png",
//                new ByteArrayInputStream(screenshot), "png");
//    }

    @Description("Создание код-пароля")
    public void inputOTP(String otpCode) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        WebElement otp = androidDriver.findElement(By.id(Locators.OTP_CODE_PATH));

        wait.until(ExpectedConditions.elementToBeClickable(otp));

        for (int i = 1; i <= otpCode.length(); i++) {
            otp.click();
        }

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Создание код-пароля", "image/png",
                new ByteArrayInputStream(screenshot), "png");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterAll
    public void tearDown() {
        androidDriver.quit();
        // Генерация отчета Allure после выполнения всех тестов
        allureReportGenerator.generateAllureReport();
    }
}
