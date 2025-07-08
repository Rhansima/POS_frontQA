package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RandomDeliveryTest extends BaseTest {
    @BeforeMethod

    public void setupTest() {
        setUp(); // Call BaseTest setup


    }

    public void loginAsStockUser(){
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

    //navigation to random delivery dashboard
    @Test
    public void randomDeliveryDashboard() throws InterruptedException {
        loginAsStockUser();

        WebElement randomClickMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[3]/span")
        ));
        randomClickMenu.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
        Thread.sleep(3000);




    }

    //add order button click

    @Test
    public void randomAdduserButton() throws InterruptedException {
        loginAsStockUser();

        WebElement randomClickMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text() = 'Random delivery']")
        ));
        randomClickMenu.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()= 'Random Delivery']")
        ));

        WebElement addOrderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='+ Add Order']")
        ));
        addOrderButton.click();

        // Wait for popup modal to appear
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text() = 'Add Order']")
        ));
        Assert.assertTrue(popup.isDisplayed(), "Add Order popup not displayed");
    }



    //add order fill the form and submit it
    @Test
    public void testAddRandomOrder() throws InterruptedException {
        loginAsStockUser();

        WebElement randomClickMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text() = 'Random delivery']")
        ));
        randomClickMenu.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()= 'Random Delivery']")
        ));

        WebElement addOrderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='+ Add Order']")
        ));
        addOrderButton.click();

        // Wait for popup modal to appear
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text() = 'Add Order']")
        ));
        Assert.assertTrue(popup.isDisplayed(), "Add Order popup not displayed");

        // Fill fields inside the popup

        WebElement dateInput = driver.findElement(By.xpath("//label[text()='Date :']"));
        dateInput.sendKeys("2025-07-02");

        WebElement nameInput = driver.findElement(By.xpath("//label[text()='Name :']"));
        nameInput.sendKeys("Hansima");

        WebElement amountInput = driver.findElement(By.xpath("//label[text()='Amount :']"));
        amountInput.sendKeys("10000");

        // Step 6: Select Item from Dropdown
        WebElement itemDropdown = driver.findElement(
                By.xpath("//option[text() ='Select']")
        );
        Select itemSelect = new Select(itemDropdown);
        itemSelect.selectByVisibleText("Atles Pen");

        // Step 7: Enter Unit Price
        WebElement unitPriceInput = driver.findElement(
                By.xpath("//input[@type='text']")
        );
        unitPriceInput.sendKeys("500");

        // Step 8: Enter Quantity
        WebElement quantityInput = driver.findElement(
                By.xpath("//input[@type='number']")
        );
        quantityInput.sendKeys("30");

        // Step 7: Click submit/save
        WebElement submitButton = driver.findElement(By.xpath("//button[text() ='Submit Order']"));
        submitButton.click();

        // Step 8: Confirm order added (e.g. table row appears or success toast)
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(text(),'Order added successfully')]")
//        ));

//        assert successMessage.isDisplayed();

        Thread.sleep(2000);
    }
    //add to grn button click
    @Test
    public void testGRN() throws InterruptedException {
        loginAsStockUser();

        // Click 'Random delivery' menu
        WebElement randomClickMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Random delivery']")
        ));
        randomClickMenu.click();

        // Wait for page heading to ensure it loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Random Delivery']")
        ));

        // Click the 'Add To GRN' button
        WebElement addToGRN = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Add To GRN']")
        ));
        addToGRN.click();

        // Wait for any visible element containing the text 'Purchase Order'
        WebElement popupText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Purchase Order')]")
        ));
        Assert.assertTrue(popupText.isDisplayed(), "Add GRN popup not displayed");
    }




    @AfterTest
public void teardownTest() {
        tearDown(); // Call BaseTest teardown
    }
}
