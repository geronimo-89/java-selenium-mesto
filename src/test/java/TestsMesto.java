import io.github.bonigarcia.wdm.WebDriverManager; //нужно импортировать в каждый класс теста
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CardsPageMesto;
import pages.LoginPageMesto;
import pages.ProfilePictureMesto;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class TestsMesto {
    private WebDriver driver;
    private JavascriptExecutor js;
    LoginPageMesto objLoginPage;
    CardsPageMesto objCardsPage;
    ProfilePictureMesto objProfilePicture;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup(); //WebDriverManager нужно инициализировать перед каждым тестом
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.get("https://qa-mesto.praktikum-services.ru/");
        objLoginPage = new LoginPageMesto(driver);
        objCardsPage = new CardsPageMesto(driver);
        objProfilePicture = new ProfilePictureMesto(driver);
        objLoginPage.login("timey-wimey-kid@yandex.ru", "password");
    }

    @Test
    public void addDeleteNewCard() {
        objCardsPage.waitForHeader();
        objCardsPage.addNewCard("Australia", "https://i.imgur.com/cBLPgqb.png");
        objCardsPage.waitForDeleteButton();
        objCardsPage.deleteCard();
    }

    @Test
    public void scrollToLastCard() {
        objCardsPage.waitForCard();
        objCardsPage.scrollToLastCard();
    }

    @Test
    public void updateProfilePicture() throws InterruptedException {
        String link = "https://i.imgur.com/AdJjzyR.png";
        objCardsPage.waitForHeader();
        objProfilePicture.updateAvatar(link);
        objProfilePicture.waitForAvatarLink(link);
        String actual = objProfilePicture.getAvatarLink();
        assertEquals(link, actual);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

