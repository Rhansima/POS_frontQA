package tests.Cashier;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dashboard extends BaseTest{

    @BeforeMethod
    public void setupTest() {
        setUp(); // Call BaseTest setup

    }
    public void loginAsCashierUser() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[1]/input")
        ));
        usernameField.sendKeys("cashier@example.com");

        WebElement passwordField = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[2]/input")
        );
        passwordField.sendKeys("cashier123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
    }

    @Test
    public void cashierDashboard() throws InterruptedException {
        loginAsCashierUser();

        WebElement cashierDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Dashboard']")
        ));
        cashierDashboard.click();


        WebElement cashierDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Cashier Dashboard']")
        ));
        assert cashierDashboardShow.isDisplayed();


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);


        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }







    @AfterTest
    public void teardownTest() {
        tearDown();
    }
}
