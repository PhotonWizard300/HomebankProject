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

public class PaymentOnayNegative {

    public AndroidDriver androidDriver;

    @BeforeAll
    public void setup() {
        // Launch Appium Driver
        androidDriver = AppiumDriver.getAndroidDriver(false);
    }

    @Test
    @Description("Тестовый кейс: 'Платеж онай карты'(Негативный)")
    public void testPaymentOnay() {
        clickProfileIcon();
        clickCodeAccess();
        inputOTP("1111");
        clickPayments();
        clickOnay();
        checkBalance();
        inputSum();
        chooseWayPayment();
        payDo();
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

    @Description("Нажать на 'Платежи'")
    public void clickPayments() {
        WebElement payment = androidDriver.findElement(By.xpath(Locators.PAYMENTS_SECTION));
        payment.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Платежи'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на иконку 'Онай'")
    public void clickOnay() {
        WebElement onay = androidDriver.findElement(By.xpath(Locators.ONAY_ICON));
        onay.click();


        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на иконку 'Онай'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Проверка баланса")
    public void checkBalance() {
        WebElement balance = androidDriver.findElement(By.xpath(Locators.CHECK_ICON));
        balance.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Проверка баланса", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Введите сумму к оплате")
    public void inputSum() {
        WebElement sum = androidDriver.findElement(By.xpath(Locators.PAYMENT_FIELD));
        sum.click();
        sum.sendKeys("10");

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Введите сумму к оплате", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Выберете способ оплаты")
    public void chooseWayPayment() {
        // Клик на иконку со списком счетов
        WebElement clickPhone = androidDriver.findElement(By.xpath(Locators.CLICK_ACCOUNTS));
        clickPhone.click();

        // Выбор счёта
        WebElement chooseAccount = androidDriver.findElement(By.xpath(Locators.CHOOSE_CARD_ICON));
        chooseAccount.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Выберете способ оплаты", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @Description("Нажать на 'Оплатить'")
    public void payDo() {
        WebElement pay =androidDriver.findElement(By.xpath(Locators.PAY_BUTTON));
        pay.click();

        byte[] screenshot = ((TakesScreenshot) androidDriver)
                .getScreenshotAs(OutputType.BYTES);

        Allure.addAttachment("Нажать на 'Оплатить'", "image/png",
                new ByteArrayInputStream(screenshot), "png");
    }

    @AfterAll
    public void tearDown() {
        androidDriver.quit();
    }
}
