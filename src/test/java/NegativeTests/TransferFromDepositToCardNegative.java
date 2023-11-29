package NegativeTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.time.Duration;

import Utils.AppiumDriver;
import Utils.Locators;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferFromDepositToCardNegative {
    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Перевод c депозита на карту'(Негатвный)")
    public void testTransferFromDepositToCard() throws IOException {
        clickTransfer();
        inputOTP("1111");
        clickBetweenAccounts();
        showListAccounts();
        chooseDeposit();
        chooseCard();
        chooseSum();
        chooseCurrency();
        clickNextButton();
        clickConfirmButton();
    }
    @Description("Нажать на кнопку 'Переводы'")
    public void clickTransfer() {
        WebElement clickTransfer = androidDriver.findElement(By.xpath(Locators.TRANSFER_BUTTON))    ;
        clickTransfer.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

    @Description("Выбор депозит, где есть 'EUR' - Дирхам")
    public void chooseDeposit() {
        // Прокрутка экрана вниз
        scrollDown();

        // Выбор депозит-счёта
        WebElement chooseCard = androidDriver.findElement(By.xpath(Locators.CHOOSE_DEPOSIT));
        chooseCard.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выбор депозит, где есть 'EUR' - Дирхам", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Выбрать карту, куда будет совершён перевод")
    public void chooseCard() {
        // Выбор карты
        WebElement chooseCard = androidDriver.findElement(By.xpath(Locators.ACCOUNT));
        chooseCard.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Screenshot", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }


    @Description("Введите сумму перевода")
    public void chooseSum() {
        WebElement chooseSum = androidDriver.findElement(By.xpath(Locators.CHOOSE_SUM));
        chooseSum.click();
        chooseSum.sendKeys("100");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Screenshot", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Выбрать валюту(Дирхам)")
    public void chooseCurrency() {
        // Открыть список валют
        WebElement currencyList = androidDriver.findElement(By.id(Locators.CHOOSE_CURRENCY));
        currencyList.click();

        // Выбрать валюту - Дирхам
        WebElement DirkhanCurrecncy = androidDriver.findElement(By.xpath(Locators.DIRKHAM_CURRENCY));
        DirkhanCurrecncy.click();

        // прокрутка экрана вниз
        scrollDown();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выбрать валюту(Дирхам)", "image/png",
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
}
