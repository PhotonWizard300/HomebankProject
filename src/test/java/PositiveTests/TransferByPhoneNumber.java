package PositiveTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import Utils.AppiumDriver;
import Utils.Locators;
import Utils.PrivateData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TransferByPhoneNumber {
    public AndroidDriver androidDriver;
    @BeforeAll
    public void setUp() {
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }
    @Test
    @Description("Тестовый кейс: 'Перевод по номеру телефона'")
    public void testTransferByPhoneNumber() throws IOException {
        clickTransfer();
        inputOTP("1111");
        clickAllTransfers();
        inputPhoneNumber();
        chooseSum();
        writeMwssage();
        clickNextButton();
        clickConfirmButton();
    }

    @Description("Нажать на кнопку 'Переводы'")
    public void clickTransfer() {
        WebElement transferButton =
                androidDriver.findElement(By.xpath(Locators.TRANSFER_BUTTON));
        transferButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Создание код-пароля", "image/png",
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

    @Description("Нажать на кнопку 'Все переводы'")
    public void clickAllTransfers() {
        WebElement allTransfersButton =
                androidDriver.findElement(By.id(Locators.ALL_TRANSFERS_BUTTON));
        allTransfersButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кнопку 'Все переводы'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести номер телефона")
    public void inputPhoneNumber() {
        WebElement phoneNumber =
                androidDriver.findElement(By.id(Locators.PHONE_NUMBER_FOR_TRANSFER));
        phoneNumber.click();
        PrivateData phoneNum = new PrivateData();
        phoneNumber.sendKeys(phoneNum.getPhoneNumberForTransfer());

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести номер телефона", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести сумму перевода")
    public void chooseSum() throws IOException{
        WebElement sum = androidDriver.findElement(By.xpath(Locators.CHOOSE_SUM));
        sum.click();
        sum.sendKeys("100");

        KeyEvent enterKey = new KeyEvent()
                .withKey(AndroidKey.ENTER);
        androidDriver.pressKey(enterKey);

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести сумму перевода", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Оставить комментарий к переводу")
    public void writeMwssage() {
        WebElement message = androidDriver.findElement(By.id(Locators.MESSAGE_PATH));
        message.click();
        message.sendKeys("100 KZT");

        KeyEvent enterKey = new KeyEvent()
                .withKey(AndroidKey.ENTER);
        androidDriver.pressKey(enterKey);

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Оставить комментарий к переводу", "image/png",
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

    @Description("Нажать на кнопку 'Подтвердить'")
    public void clickConfirmButton() {
        WebElement confirmButton = androidDriver.
                findElement(By.xpath(Locators.CONFIRM_BUTTON));
        confirmButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кноопку 'Подтвердить'", "image/png",
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
    }
}
