import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class TestPageSamokat extends BaseTests {

    @Test
    public void fillingOrderForm() {
        // Открытие страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Обработка окна согласия с cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //ожно сменить  на другие локаторы эти не проходили
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
            cookieButton.click();
        } catch (Exception e) {
            // Если окно с cookies уже закрыто или не появляется
            System.out.println("Cookie consent window not found or already accepted");
        }

        // Нажатие на кнопку заказа
        driver.findElement(By.cssSelector("button[class='Button_Button__ra12g']")).click();

        // Заполнение полей формы
        driver.findElement(By.cssSelector("input[placeholder='* Имя']")).sendKeys("Иван");
        driver.findElement(By.cssSelector("input[placeholder='* Фамилия']")).sendKeys("Грозный");
        driver.findElement(By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']")).sendKeys("Домой");
        driver.findElement(By.cssSelector("input[placeholder='* Станция метро']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.xpath("//div[text()='Черкизовская']")).click();
        driver.findElement(By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']")).sendKeys("12345678900");

        // Ожидание появления и клик по кнопке
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']")));
        orderButton.click();
        driver.findElement(By.cssSelector("input[placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.cssSelector("div[aria-label='Choose четверг, 11-е сентября 2025 г.']")).click();
        driver.findElement(By.cssSelector("div[class='Dropdown-placeholder'")).click();
        driver.findElement(By.xpath("//div[text()='сутки']")).click();
        //выбор цвета самоката
        driver.findElement(By.cssSelector("input[id='grey']")).click();
        driver.findElement(By.cssSelector("input[placeholder='Комментарий для курьера']")).sendKeys("Комментарий");
        driver.findElement(By.cssSelector("button[class='Button_Button__ra12g Button_Middle__1CSJM']")).click();
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Да']")));
        confirmButton.click();
        assertTrue(driver.findElement(By.className("Order_ModalHeader__3FDaJ")).isDisplayed());

        WebElement confirmationText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".Order_ModalHeader__3FDaJ")
        ));
        String actualText = confirmationText.getText();

        // Проверка результата

        assertTrue(actualText.contains("Заказ оформлен"));
    }

   @Test
    public void dropDownList() {
        // Открытие страницы
        driver.get("https://qa-scooter.praktikum-services.ru/");


        // Обработка окна согласия с cookies
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //ожно сменить  на другие локаторы эти не проходили
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("rcc-confirm-button")));
            cookieButton.click();
        } catch (Exception e) {
            // Если окно с cookies уже закрыто или не появляется
            System.out.println("Cookie consent window not found or already accepted");

            driver.findElement(By.xpath("//div[id='accordion__heading-16']")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
        }
    }
}
