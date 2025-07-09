package tests.Admin;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class attendanceTest extends BaseTest {
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
    public void attendanceMenuClick() throws InterruptedException{
        loginAsAdminUser();

        WebElement attendanceMenuClickTest = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Attendance']")
        ));
        attendanceMenuClickTest.click();

        WebElement attendanceDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Attendance']")
        ));
        assert  attendanceDashboardShow.isDisplayed();

        Thread.sleep(3000);
    }
    @Test
    public void attendanceFilter() throws InterruptedException {
        loginAsAdminUser();

        // Navigate to Attendance menu
        WebElement attendanceMenuClickTest = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='Attendance']")));
        attendanceMenuClickTest.click();

        WebElement attendanceDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Attendance']")));
        Assert.assertTrue(attendanceDashboardShow.isDisplayed());

        // Employee dropdown
        Select employeeDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//select[contains(@class, 'bg-blue-50')])[1]"))));
        employeeDropdown.selectByVisibleText("Eva");

        // Designation dropdown
        Select designationDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//select[contains(@class, 'bg-blue-50')])[2]"))));
        designationDropdown.selectByVisibleText("Admin");

        // Status dropdown
        Select statusDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//select[contains(@class, 'bg-blue-50')])[3]"))));
        statusDropdown.selectByVisibleText("Present");

        // Date range input
        WebElement dateRangeInput = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[contains(@placeholder, 'Date Range')]")));
        dateRangeInput.clear();
        dateRangeInput.sendKeys("2025/06/10 - 2025/06/30");

        // Click Filter button
        WebElement filterBtn = driver.findElement(By.xpath("//button[text()='Filter']"));
        filterBtn.click();

        // Wait for table to update
        Thread.sleep(2000); // OR use WebDriverWait if there's a known update trigger

        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table")));
        Assert.assertTrue(table.getText().contains("Eva"));
    }
        @Test
        public void exportButton() throws InterruptedException{

            loginAsAdminUser();

            WebElement attendanceMenuClickTest = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Attendance']")
            ));
            attendanceMenuClickTest.click();

            WebElement attendanceDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h1[text()='Attendance']")
            ));
            assert  attendanceDashboardShow.isDisplayed();

        WebElement exportButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Filter']")
        ));
        exportButtonClick.click();
        }


//    @Test
//    public void exportPDFButton() throws InterruptedException {
//        loginAsAdminUser();
//
//        // Navigate to Attendance
//        WebElement attendanceMenuClickTest = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//span[text()='Attendance']")
//        ));
//        attendanceMenuClickTest.click();
//
//        // Verify attendance page loaded
//        WebElement attendanceDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//h1[text()='Attendance']")
//        ));
//        assert attendanceDashboardShow.isDisplayed();
//
//        // Wait for UI to load fully
//        Thread.sleep(2000);
//
//        // Click on Export button
//        WebElement exportBtn = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[contains(., 'Export')]")
//        ));
//        exportBtn.click();
//
//        // Wait for download to start
//        Thread.sleep(5000); // Adjust based on your app's export delay
//
//        // Verify that file exists in Downloads
//        File downloadFolder = new File(System.getProperty("user.home") + "/Downloads");
//        File[] files = downloadFolder.listFiles((dir, name) -> name.toLowerCase().contains("attendance") && name.endsWith(".pdf"));
//
//        boolean fileFound = false;
//        if (files != null) {
//            for (File file : files) {
//                if (file.lastModified() > System.currentTimeMillis() - 60_000) { // within last minute
//                    fileFound = true;
//                    break;
//                }
//            }
//        }
//
//        assert fileFound : "Exported PDF file was not found in the Downloads folder.";
//        System.out.println("✅ Exported PDF file downloaded successfully.");
//    }


    @AfterTest
    public void teardownTest() {

        tearDown();
    }

}
