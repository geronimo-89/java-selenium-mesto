package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMesto {
    private WebDriver driver;
    private By emailField = By.cssSelector("input[id='email']");
    private By passwordField = By.cssSelector("input[id='password']");
    private By logInButton = By.cssSelector("[class='auth-form__button']");
    public LoginPageMesto(WebDriver driver) {
        this.driver = driver;
    }
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    public void clickLogInButton() {
        driver.findElement(logInButton).click();
    }
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLogInButton();
    }

}
