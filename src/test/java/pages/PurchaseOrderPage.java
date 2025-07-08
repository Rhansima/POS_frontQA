//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.time.Duration;
//
//public class PurchaseOrderPage {
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @BeforeClass
//    public void setup(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        driver.manage().window().maximize();
//        driver.get("http://localhost:5173");
//    }
//
//    @Test
//    public void testLogin() throws InterruptedException{
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
//         By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[1]/input")
//        ));
//
//        usernameField.clear();
//        usernameField.sendKeys("stock@example.com");
//
//        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[2]/input"));
//        passwordField.clear();
//        passwordField.sendKeys("stock123");
//
//        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/button"));
//        loginButton.click();
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//             By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
//        ));
//
//        Thread.sleep(2000);
//
//        WebElement dashboardMenuIcon = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[1]/span")
//        ));
//        dashboardMenuIcon.click();
//
//        //  Verify Stock Management dashboard is displayed
//        WebElement stockDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1")
//        ));
//
//        // Optional assertion
//        assert stockDashboard.isDisplayed() : "Stock Management Dashboard is not visible.";
//    }
//    }
//
//
//
//
//
//    @AfterClass
//    public void teardown(){
//
//        driver.quit();
//    }
//
//
//
//
//
