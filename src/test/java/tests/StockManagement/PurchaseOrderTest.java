package tests.StockManagement;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class PurchaseOrderTest extends BaseTest {

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
    public void testDashboardMenuNavigation() throws InterruptedException {
        loginAsStockUser();

        Thread.sleep(2000);


    }

    @Test
    public void PurchaseOrder() throws InterruptedException {
        loginAsStockUser();

        // Step 2: Wait for dashboard to confirm login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));

        // Step 3: Click Purchase Order menu
        WebElement purchaseOrderMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[2]")
        ));
        purchaseOrderMenu.click();

        // Step 4: Verify Purchase Order dashboard is shown
        WebElement purchaseOrderHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
        assert purchaseOrderHeader.isDisplayed();

        Thread.sleep(2000);


    }

    @Test
    public void testAddPurchaseOrder() throws InterruptedException {
        loginAsStockUser();

        // Step 2: Confirm dashboard loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='root']/div/div[2]/div[2]/div[1]/h1")
        ));

        // Step 3: Click Purchase Order menu
        WebElement purchaseOrderMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='root']/div/div[1]/div/div[2]/nav/a[2]")
        ));
        purchaseOrderMenu.click();

        // Step 4: Click "Add Order" button
        WebElement addOrderButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/button[1]")
        ));
        addOrderButton.click();

        // Step 5: Wait for popup modal to appear
        WebElement popupTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[1]")
        ));
        popupTitle.isDisplayed();

        // Step 6: Fill fields inside the popup
        WebElement supplierInput = driver.findElement(By.xpath("//input[@placeholder='Enter supplier name']"));
        supplierInput.sendKeys("ABC Supplier");

        WebElement dateInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[1]/input"));
        dateInput.sendKeys("2025-07-02");

        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/input"));
        nameInput.sendKeys("Hansima");

        WebElement amountInput = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[3]/input"));
        amountInput.sendKeys("10000");

        // Step 6: Select Item from Dropdown
        WebElement itemDropdown = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[4]/div[2]/select")
        );
        Select itemSelect = new Select(itemDropdown);
        itemSelect.selectByVisibleText("Atles Pen");

        // Step 7: Enter Unit Price
        WebElement unitPriceInput = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[4]/div[2]/input[1]")
        );
        unitPriceInput.sendKeys("500");

        // Step 8: Enter Quantity
        WebElement quantityInput = driver.findElement(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[4]/div[2]/input[2]")
        );
        quantityInput.sendKeys("30");

        // Step 7: Click submit/save
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div/div/div[2]/div[5]/button"));
        submitButton.click();

        // Step 8: Confirm order added (e.g. table row appears or success toast)
//        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[contains(text(),'Order added successfully')]")
//        ));

//        assert successMessage.isDisplayed();

        Thread.sleep(2000);
    }


    @Test
    public void testSearch() throws InterruptedException{
        loginAsStockUser();

        // Step 2: Wait for dashboard to confirm login
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));

        // Step 3: Click Purchase Order menu
        WebElement purchaseOrderMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[2]")
        ));
        purchaseOrderMenu.click();

        // Step 4: Verify Purchase Order dashboard is shown
        WebElement purchaseOrderHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));
        assert purchaseOrderHeader.isDisplayed();

        WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/input")
        ));
        searchBar.click();
        searchBar.clear();
        searchBar.sendKeys("P01");
        Thread.sleep(3000);

    }

    @Test
    public void testViewButton() throws InterruptedException {
        loginAsStockUser();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));

        WebElement purchaseOrderMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[2]")
        ));
        purchaseOrderMenu.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
        ));

        WebElement viewButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table/tbody/tr[1]//button[contains(.,'View')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewButton);

        // Optional debug wait
        Thread.sleep(2000);

        WebElement viewDetailsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(), 'Purchase Order Details')]")
        ));
        assert viewDetailsHeader.isDisplayed();

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/table/tbody/tr[2]/td[6]/div/div/div[3]/button")
        ));
        closeButton.click();

    }

    @Test
    public void addToGRNButton() throws Exception {
        loginAsStockUser();

        // Navigate to Purchase Order Menu
        WebElement purchaseOrderMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//nav//a[contains(., 'Purchase Order')]")
        ));
        purchaseOrderMenu.click();

        // Wait for at least one row to appear in the table
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//table/tbody/tr[1]")
        ));

        // Find and click 'Add to GRN' button (use JavaScript in case click fails)
        WebElement addToGRNButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table/tbody/tr[1]/td[7]//button")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToGRNButton);

        // Wait for the modal content (not just header text)
        WebElement modalContent = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#root > div > div.flex-1.p-4.md\\:p-6.bg-\\[\\#BED0DB\\].w-full.overflow-y-auto > div.p-4.md\\:p-6.bg-\\[\\#BED0DB\\].min-h-screen > div.overflow-x-auto.bg-white.rounded-lg.shadow > table > tbody > tr:nth-child(1) > td:nth-child(7) > button") // adjust if your modal uses different class
        ));

        // Confirm modal is displayed
        Assert.assertTrue(modalContent.isDisplayed(), "Modal did not appear after clicking Add to GRN");


    }

    //Add to grn filled and go to the GRN table







    @AfterMethod
    public void teardownTest() {
        tearDown(); // Call BaseTest teardown
    }
}
