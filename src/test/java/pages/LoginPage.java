package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[1]/input");// Change to actual ID
    private final By passwordField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/div[2]/input"); // Change to actual ID
    private final By loginButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/form/button");   // Change to actual ID

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
