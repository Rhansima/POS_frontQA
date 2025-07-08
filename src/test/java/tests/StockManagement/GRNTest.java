package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class GRNTest extends BaseTest {
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
    public void GRNDashboard() throws InterruptedException {
        loginAsStockUser();

        WebElement grnDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='GRN']") // Corrected XPath
        ));
        grnDashboard.click();

        WebElement grnDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Good Received Note']") // Also corrected this one
        ));
        assert grnDashboardShow.isDisplayed();

        Thread.sleep(3000);
    }

    @Test
    public void UpdateButton() throws InterruptedException {
        loginAsStockUser();

        WebElement grnDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='GRN']")));
        grnDashboard.click();

        WebElement grnDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Good Received Note']")));
        assert grnDashboardShow.isDisplayed();

        WebElement updateGRNButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Update']")));
        updateGRNButton.click();

        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement updatePopUp = popupWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Update GRN')]")));
        assert updatePopUp.isDisplayed();

        Thread.sleep(3000);
    }

    @Test
    public void FillForm() throws InterruptedException{
        loginAsStockUser();

        WebElement grnDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='GRN']")));
        grnDashboard.click();

        WebElement grnDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Good Received Note']")));
        assert grnDashboardShow.isDisplayed();

        WebElement updateGRNButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Update']")));
        updateGRNButton.click();

        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement updatePopUp = popupWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(),'Update GRN')]")));
        assert updatePopUp.isDisplayed();

        // Fill the form fields
        WebElement returnItemsInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Return Items']/following-sibling::input")));
        returnItemsInput.clear();
        returnItemsInput.sendKeys("2");

        WebElement paidAmountInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Paid Amount']/following-sibling::input")));
        paidAmountInput.clear();
        paidAmountInput.sendKeys("2400");

        WebElement payableAmountInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[text()='Payable Amount']/following-sibling::input")));
        payableAmountInput.clear();
        payableAmountInput.sendKeys("1000");

        // Click the Save button
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Save']")));
        saveButton.click();


        Thread.sleep(3000);

    }



    @AfterClass
    public void teardownTest() {
        tearDown(); // Call BaseTest teardown
    }
}


//commit

