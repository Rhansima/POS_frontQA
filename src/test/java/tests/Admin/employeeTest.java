package tests.Admin;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class employeeTest extends BaseTest {
    @BeforeMethod
    public void setupTest() {
        setUp();

    }

    public void loginAsAdminUser() {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[1]/input")
        ));
        usernameField.sendKeys("admin@example.com");

        WebElement passwordField = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[2]/input")
        );
        passwordField.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
    }

    @Test
    public void employeeDashboard() throws InterruptedException {
        loginAsAdminUser();

        WebElement employeeMenuClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Employees']")
        ));
        employeeMenuClick.click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Salary Calculation of month of March 2024']")
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
    public void downloadButton() throws InterruptedException{
        loginAsAdminUser();

        WebElement employeeMenuClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Employees']")
        ));
        employeeMenuClick.click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Salary Calculation of month of March 2024']")
        ));
        assert dashboardHeader.isDisplayed();

        Thread.sleep(1000);


        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                dashboardHeader
        );


        WebElement downloadSlipButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()=' Download Pay Slip']")
        ));
        downloadSlipButton.click();

        WebElement showDownloadSlipButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='Salary Calculation of month of March 2024']")
        ));
        assert showDownloadSlipButton.isDisplayed();

        Thread.sleep(3000);
    }






    @AfterTest
    public void teardownTest() {
        tearDown();
    }
}
