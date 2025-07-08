//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class DashboardPage {
//    private final WebDriver driver;
//
//    private final By dashboardMenuButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[2]/nav/a[1]/span");
//
//    private final By dashboardHeader = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/h1");
//
//    public DashboardPage(WebDriver driver){
//        this.driver = driver;
//    }
//
//    public void clickDashboardMenu(){
//        driver.findElement(dashboardMenuButton).click();
//    }
//
//
//    public boolean isDashboardVisible() {
//        return driver.findElement(dashboardHeader).isDisplayed();
//    }
//
//}
