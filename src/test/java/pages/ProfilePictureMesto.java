package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePictureMesto {

    private WebDriver driver;
    JavascriptExecutor js;
    public By editAvatarButton = By.cssSelector(".profile__image");
    private By newAvatarLink = By.id("owner-avatar");
    private By saveAvatarButton = By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']");

    private ExpectedCondition<WebElement> expectedAvatarLink = ExpectedConditions.visibilityOfElementLocated(newAvatarLink);

    public ProfilePictureMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForAvatarWindow() {
        new WebDriverWait(driver, 3).until(expectedAvatarLink);
    }

    public void updateAvatar(String link) {
        driver.findElement(editAvatarButton).click();
        waitForAvatarWindow();
        driver.findElement(newAvatarLink).sendKeys(link);
        driver.findElement(saveAvatarButton).click();
    }

    public String getAvatarLink() {
        return driver.findElement(editAvatarButton).getCssValue("background-image").split("[(\")]+")[1];

    }

    public void waitForAvatarLink(String link) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.attributeContains(editAvatarButton, "style", link));
    }
}
