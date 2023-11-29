package PositiveTests;

import Utils.AppiumDriver;
import Utils.Locators;
import Utils.PrivateData;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferFromAccountToCard {

    public AndroidDriver androidDriver;

    @BeforeAll
    public void setUp() {
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Перевод cо счета на карту'")
    public void testTransferFromAccountToCard() throws IOException {
        clickTransfer();
        inputOTP("1111");
        clickBetweenAccounts();
        showListAccounts();
        chooseAccount();
        showListAccounts();
        chooseCard();
        chooseSum();
        clickNextButton();
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

    @Description("Выбор счета, откуда будут переведены деньги")
    public void chooseAccount() {
        PrivateData accountCard = new PrivateData();
        WebElement account =
                androidDriver.findElement(By.xpath(accountCard.getAccountCardNumberPath()));
        account.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выбор счета, откуда будут переведены деньги", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Выбор карты, куда будет совершен перевод")
    public void chooseCard() {
        WebElement card =
                androidDriver.findElement(By.xpath("//android.widget.TextView[@text='•••• 0339' and @index='2']"));
        card.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выбор карты, куда будут переведены деньги", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Ввести сумму перевода")
    public void chooseSum() throws IOException {
        WebElement sum = androidDriver.findElement(By.xpath(Locators.CHOOSE_SUM));
        sum.click();
        sum.sendKeys("100");

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
