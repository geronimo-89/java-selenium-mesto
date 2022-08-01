package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CardsPageMesto {
    private WebDriver driver;
    private JavascriptExecutor js;
    private By newCardButton = By.className("profile__add-button");
    private By newCardName = By.name("name");
    private By newCardLink = By.name("link");
    private By saveCardButton = By.xpath(".//form[@name='new-card']/button[text()='Сохранить']");
    private By header = By.className("header__user");
    private By deleteCardButton = By.xpath(".//button[@class='card__delete-button card__delete-button_visible']");
    private By lastCard = By.xpath(".//li[@class='places__item card'][last()]");
    private By card = By.className("places__item");

    private ExpectedCondition<WebElement> expectedHeader = ExpectedConditions.visibilityOfElementLocated(header);
    private ExpectedCondition<WebElement> expectedDeleteButton = ExpectedConditions.visibilityOfElementLocated(deleteCardButton);
    private ExpectedCondition<WebElement> expectedCard = ExpectedConditions.visibilityOfElementLocated(card);

    public CardsPageMesto(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForHeader() {
        new WebDriverWait(driver, 3).until(expectedHeader);
    }

    public void waitForDeleteButton() {
        new WebDriverWait(driver, 3).until(expectedDeleteButton);
    }

    public void waitForCard() {
        new WebDriverWait(driver, 3).until(expectedCard);
    }

    public void addNewCard(String name, String link) {
        driver.findElement(newCardButton).click();
        driver.findElement(newCardName).sendKeys(name);
        driver.findElement(newCardLink).sendKeys(link);
        driver.findElement(saveCardButton).click();
    }

    public void deleteCard () {
        driver.findElement(deleteCardButton).click();
    }

    public void scrollToLastCard() {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(lastCard));
    }
}
