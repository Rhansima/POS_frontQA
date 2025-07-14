package tests.Cashier;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Billing extends BaseTest {

    @BeforeMethod
    public void setupTest() {
        setUp();

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
    public void billingDashboard() throws InterruptedException {
        loginAsCashierUser();

        WebElement billingMenuClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Billing']")
        ));
        billingMenuClick.click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Billing']")
        ));
        assert dashboardHeader.isDisplayed();

        Thread.sleep(1000);


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                dashboardHeader
        );

        Thread.sleep(1000);
    }

    @Test
    public void payButton() throws InterruptedException{
        loginAsCashierUser();

        WebElement employeeMenuClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Billing']")
        ));
        employeeMenuClick.click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Billing']")
        ));
        assert dashboardHeader.isDisplayed();

        Thread.sleep(1000);


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                dashboardHeader
        );


        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Pay']")
        ));
        payButton.click();

        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div/div/button")
        ));
        assert closeButton.isDisplayed();

        Thread.sleep(3000);
    }






    @AfterTest
    public void teardownTest() {
        tearDown();
    }
}
