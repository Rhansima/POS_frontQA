package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest {
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
    public void InventoryDashboard() throws InterruptedException{
        loginAsStockUser();
        WebElement inventoryDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Inventory']")
        ));
        inventoryDashboard.click();

        WebElement inventoryDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Inventory']")
        ));
        assert  inventoryDashboardShow.isDisplayed();

        Thread.sleep(3000);

    }

    @Test
    public void ShowroomInbutton() throws InterruptedException {
        loginAsStockUser();

        WebElement inventoryDashboard = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Inventory']")
        ));
        inventoryDashboard.click();

        WebElement inventoryDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Inventory']")
        ));
        assert inventoryDashboardShow.isDisplayed();

        WebElement showroomButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Showroom In']")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showroomButtonClick);

        // Wait for modal header to appear
        WebElement showroomPopupHeader = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h3[contains(text(), 'Showroom')]")
        ));
        wait.until(ExpectedConditions.visibilityOf(showroomPopupHeader));
        assert showroomPopupHeader.isDisplayed();

        Thread.sleep(2000);
    }

    @Test
    public void updateShowroomQtyPopupTest() throws InterruptedException {
        loginAsStockUser();


        WebElement inventoryMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Inventory']")));
        inventoryMenu.click();


        WebElement inventoryHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Inventory']")));
        assert inventoryHeader.isDisplayed();


        WebElement showroomInBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Showroom In']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", showroomInBtn);


        WebElement popupHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[contains(text(), 'Update Showroom Qty')]")));
        assert popupHeader.isDisplayed();
        System.out.println("Popup opened: " + popupHeader.getText());


        WebElement qtyInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='In' or @type='text']")));
        qtyInput.clear();
        qtyInput.sendKeys("Out");

        // Click Save
        WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Save']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveBtn);


        Thread.sleep(2000); // Just to observe result if needed
    }


    @AfterTest
    public void teardownTest() {
        tearDown();
    }
}
