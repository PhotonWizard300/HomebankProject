package NegativeTests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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

public class TransferToPhysicalPersonNegative {
    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Перевод на счёт физического лица'(Негативный)")
    public void testTransferToPhysicalPerson() {
        clickTransfer();
        inputOTP("1111");
        clickAllTransfers();
        clickPhoneAccount();
        clickReceiverAccount();
        inputIIN();
        clickNextButton();
        setPayment();
        clickAgreeButton();
        showListAccounts();
        chooseAccount();
        chooseSum();
        clickConfirmButton();
        inputSMS("1111");
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

    @Description("Нажать на 'Все переводы'")
    public void clickAllTransfers() {
        WebElement clickAllTransfers =
                androidDriver.findElement(By.xpath(Locators.ALL_TRANSFERS_BUTTON));
        clickAllTransfers.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Все переводы'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Кликнуть 'На номер счёта'")
    public void clickPhoneAccount() {
        // Прокрутка экрана вниз
        scrollDown();

        WebElement phoneAccount =
                androidDriver.findElement(By.xpath(Locators.TO_PHONE_NUMBER_BUTTON));
        phoneAccount.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Кликнуть 'На номер счёта'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Введите счёт получателя")
    public void clickReceiverAccount() {
        WebElement receiverAccount = androidDriver.findElement(By.xpath(Locators.ACCOUNT_RECEIVER));
        receiverAccount.click();
        receiverAccount.sendKeys("KZ606017523000054543");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Введите счёт получателя", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Введите ИИН/БИН")
    public void inputIIN() {
        WebElement iin = androidDriver.findElement(By.xpath(Locators.INPUT_IIN));
        iin.click();
        iin.sendKeys("880722450387");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Введите ИИН/БИН", "image/png",
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

    @Description("Указать назнанение платежа")
    public void setPayment() {
        WebElement paymentPurpose = androidDriver.findElement(By.xpath(Locators.PAYMENT_PURPOSE));
        paymentPurpose.click();
        paymentPurpose.sendKeys("17");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Указать назнанение платежа", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Подвердить соглашение")
    public void clickAgreeButton() {
        WebElement agreeButton = androidDriver.findElement(By.xpath(Locators.AGREE_BUTTON));
        agreeButton.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Подвердить соглашение", "image/png",
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

    @Description("Введите сумму перевода")
    public void chooseSum() {
        WebElement chooseSum = androidDriver.findElement(By.xpath(Locators.CHOOSE_SUM));
        chooseSum.click();
        chooseSum.sendKeys("100");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Введите сумму перевода", "image/png",
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

    @Description("Ввести SMS-код")
    public void inputSMS(String code) {
        WebElement smsCode = androidDriver.findElement(By.id(Locators.SMS_FIELD));
        smsCode.click();

        // Определение x и y координаты
        int x = 270;
        int y = 1720;

        // Воспроизведение клика по заданным координатам
        for (int i = 0; i <= code.length(); i++) {
            TouchAction touchAction = new TouchAction(androidDriver);
            touchAction
                    .tap(PointOption.point(x, y))
                    .perform();
        }

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Ввести SMS-код", "image/png",
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
