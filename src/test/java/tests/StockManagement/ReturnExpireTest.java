package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReturnExpireTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(ReturnExpireTest.class);

    @BeforeMethod
    public void setupTest() {
        setUp(); // Call BaseTest setup

    }

    public void loginAsStockUser() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[1]/input")
        ));
        usernameField.sendKeys("stock@example.com");

        WebElement passwordField = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[2]/input")
        );
        passwordField.sendKeys("stock123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
    }
    @Test
    public void returnExpire() throws InterruptedException{
        loginAsStockUser();
        WebElement returnExpireMenuClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text() = 'Return & Expire']")
        ));
        returnExpireMenuClick.click();

        WebElement returnExpireDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text() ='Return & Expire Goods']")
        ));

        wait.until(ExpectedConditions.visibilityOf(returnExpireDashboard));
        assert returnExpireDashboard.isDisplayed();

    }
    @AfterTest
    public void teardownTest() {
        tearDown();
    }
}
