package PositiveTests;

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
import io.qameta.allure.Step;

public class TransferFromCardToAccount {
    public AndroidDriver androidDriver;

    @BeforeAll
    public void setUp() {
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Перевод с карты на счёт'")
    public void testTransferFromCardToAccount() {
        clickTransfer();
        inputOTP("1111");
        clickBetweenAccounts();
        showListAccounts();
        chooseAccount();
        chooseSum();
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

        Allure.addAttachment("Нажать на кнопку 'Переводы'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести код-пароль")
    public void inputOTP(String otpCode) {
        WebDriverWait wait = new WebDriverWait(androidDriver, 10);
        WebElement otp =
                androidDriver.findElement(By.id(Locators.OTP_CODE_PATH));
        wait.until(ExpectedConditions.elementToBeClickable(otp));
        for (int i = 1; i <= otpCode.length(); i++) {
            otp.click();
        }
        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести код-пароль", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на кнопку 'Между своими счетами'")
    public void clickBetweenAccounts() {
        WebElement betweenAccountsButton =
                androidDriver.findElement(By.xpath(Locators.BETWEEN_ACCOUNTS));
        betweenAccountsButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на кнопку 'Между своими счетами'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Показать список счетов")
    public void showListAccounts() {
        WebElement listAccounts =
                   androidDriver.findElement(By.id(Locators.SHOW_LIST_CARDS));
        listAccounts.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Показать список счетов", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Выбор счёта, куда будет переведены деньги")
    public void chooseAccount() {
        WebElement clickAccount = androidDriver.findElement(By.xpath(Locators.ACCOUNT));
        clickAccount.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выбор счёта, куда будет переведены деньги", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести сумму перевода")
    public void chooseSum() {
        WebElement chooseSum = androidDriver.findElement(By.xpath(Locators.CHOOSE_SUM));
        chooseSum.click();
        chooseSum.sendKeys("100");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести сумму перевода", "image/png",
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
    }

    @AfterAll
    public void tearDown() {
        androidDriver.quit();
    }
}
