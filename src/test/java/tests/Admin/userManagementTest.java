package tests.Admin;

import base.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class userManagementTest extends BaseTest {
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
    public void userManagementDashboard() throws InterruptedException{
        loginAsAdminUser();
        WebElement userManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='User Management']")
        ));
        userManagementMenu.click();

        WebElement userManagementDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='User Management']")
        ));
        assert userManagementDashboardShow.isDisplayed();

        Thread.sleep(3000);

    }

    @Test
    public void addUserButton() throws InterruptedException{
        loginAsAdminUser();
        WebElement userManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='User Management']")
        ));
        userManagementMenu.click();

        WebElement userManagementDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='User Management']")
        ));
        assert userManagementDashboardShow.isDisplayed();

        WebElement addUserButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='+ Add User']")
        ));
        addUserButtonClick.click();

        WebElement addUserPopUpHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Add User']")
        ));
        assert  addUserPopUpHeader.isDisplayed();
    }

    @Test
    public void fillForm() throws InterruptedException{
        loginAsAdminUser();
        WebElement userManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='User Management']")
        ));
        userManagementMenu.click();

        WebElement userManagementDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='User Management']")
        ));
        assert userManagementDashboardShow.isDisplayed();

        WebElement addUserButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='+ Add User']")
        ));
        addUserButtonClick.click();

        WebElement addUserPopUpHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Add User']")
        ));
        assert  addUserPopUpHeader.isDisplayed();

        // Fill the form
        WebElement nameField = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        nameField.sendKeys("Kasun Perera");

        WebElement statusField = driver.findElement(By.xpath("//input[@placeholder='Enter Status']"));
        statusField.sendKeys("Active");

        WebElement roleField = driver.findElement(By.xpath("//input[@placeholder='Enter Role']"));
        roleField.sendKeys("Admin");

        WebElement emailField = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
        emailField.sendKeys("kasun@example.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        passwordField.sendKeys("Password123");

        WebElement confirmPasswordField = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
        confirmPasswordField.sendKeys("Password123");


        WebElement submitBtn = driver.findElement(By.xpath("//button[text()='Submit']"));
        submitBtn.click();


        WebElement successAlert = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'successfully')]"))); // Adjust this message
        assert successAlert.isDisplayed();

        System.out.println("✅ Add User form submitted successfully!");
    }

    @Test
    public void editButton() throws InterruptedException{
        loginAsAdminUser();
        WebElement userManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='User Management']")
        ));
        userManagementMenu.click();

        WebElement userManagementDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='User Management']")
        ));
        assert userManagementDashboardShow.isDisplayed();

        WebElement editButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()= 'Edit']")
        ));
        editButtonClick.click();

        WebElement editPopUp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Edit User']")
        ));
        assert  editPopUp.isDisplayed();

        // Clear and update fields
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        name.clear();
        name.sendKeys("Eva Fernando");

        WebElement status = driver.findElement(By.xpath("//input[@placeholder='Enter Status']"));
        status.clear();
        status.sendKeys("inactive");

        WebElement role = driver.findElement(By.xpath("//input[@placeholder='Enter Role']"));
        role.clear();
        role.sendKeys("Manager");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter Email']"));
        email.clear();
        email.sendKeys("eva.fernando@example.com");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        password.sendKeys("NewPass123");

        WebElement confirmPassword = driver.findElement(By.xpath("//input[@placeholder='Confirm Password']"));
        confirmPassword.sendKeys("NewPass123");


        WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
        saveBtn.click();


        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'updated successfully')]"))); // update message as per actual content
        assert successMessage.isDisplayed();

        System.out.println("✅ Edit User successfully tested.");

        Thread.sleep(3000);
    }

    @Test
    public void deleteButton() throws InterruptedException{
        loginAsAdminUser();
        WebElement userManagementMenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[text()='User Management']")
        ));
        userManagementMenu.click();

        WebElement userManagementDashboardShow = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='User Management']")
        ));
        assert userManagementDashboardShow.isDisplayed();

        WebElement deleteButtonClick = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Delete']")
        ));
        deleteButtonClick.click();

        WebElement deletePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[text()='Delete User']")
        ));
        assert deletePopup.isDisplayed();

        // Click "Delete" in popup
        WebElement confirmDelete = driver.findElement(By.xpath("//button[text()='Delete']"));
        confirmDelete.click();

        // Wait for success message or deletion confirmation (customize this)
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'deleted successfully')]"))); // update based on your system
        assert successMsg.isDisplayed();

        System.out.println(" User deleted successfully.");

    }



    @AfterClass
    public void teardownTest() {

        tearDown();
    }

}
