package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SupplierTest extends BaseTest {
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
    public void SuppilerDashboard() throws InterruptedException{
        loginAsStockUser();

        WebElement supplierDashboardShow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Suppliers']")
        ));
        supplierDashboardShow.click();

        WebElement dashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Supplier Management']")
        ));
        assert  dashboardShow.isDisplayed();

    }

    @Test
    public void addSupplier() throws InterruptedException {
        loginAsStockUser();

        WebElement supplierDashboardShow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Suppliers']")));
        supplierDashboardShow.click();
        System.out.println("Navigated to Suppliers");

        WebElement dashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Supplier Management']")));
        assert dashboardShow.isDisplayed();

        WebElement addSupplierButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Add Supplier')]")));

        System.out.println("Clicking + Add Supplier...");
        // Use JS click for better compatibility with frontend libraries
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSupplierButton);

        // Add sleep to visually confirm modal popup
        Thread.sleep(3000);

        WebElement showPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Add Supplier')]")));
        assert showPopUp.isDisplayed();
        System.out.println("Add Supplier modal is visible");
    }

    @Test
    public void fillForm() throws InterruptedException {
        loginAsStockUser();

        WebElement supplierDashboardShow = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Suppliers']")));
        supplierDashboardShow.click();
        System.out.println("Navigated to Suppliers");

        WebElement dashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Supplier Management']")));
        assert dashboardShow.isDisplayed();

        WebElement addSupplierButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Add Supplier')]")));
        System.out.println("Clicking + Add Supplier...");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addSupplierButton);

        Thread.sleep(1000);

        WebElement showPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(), 'Add Supplier')]")));
        assert showPopUp.isDisplayed();
        System.out.println("Add Supplier modal is visible");

        // Fill the form
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/form/div[1]/input")));
        nameInput.sendKeys("ABC Suppliers");

        WebElement emailInput = driver.findElement(
                By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/form/div[2]/input"));
        emailInput.sendKeys("abc@example.com");

        WebElement phoneInput = driver.findElement(
                By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/form/div[3]/input"));
        phoneInput.sendKeys("0771234567");

        WebElement addressInput = driver.findElement(
                By.xpath("//*[@id='root']/div/div[2]/div[2]/div[4]/div/form/div[4]/input"));
        addressInput.sendKeys("123 Main Street, Colombo");


        WebElement submitBtn = driver.findElement(
                By.xpath("//button[text()='Submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitBtn);

        System.out.println("Form submitted via JS click");
        Thread.sleep(2000);
    }




    @AfterClass
    public void teardownTest() {
        tearDown();
    }
}
