import Pages.OffenciveWordsPage;
import Steps.OffenciveWordsPageSteps;
import net.thucydides.core.annotations.Step;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OffensiveWordsPagePositiveScenarios {

    WebDriver webDriver;
    LoginPage loginPage;
    public static WebDriverWait wait;
    DashboardPage dashboardPage;
    OffenciveWordsPage offenciveWordsPage;
    OffenciveWordsPageSteps offenciveWordsPageSteps;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
       offenciveWordsPage = new OffenciveWordsPage(webDriver);
       offenciveWordsPageSteps = new OffenciveWordsPageSteps();

        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoOffenciveWordsPage();
    }

    @Test
    public void AddNewOfenciveWord(){
        int Random = (int) (Math.random() *10);
        String Word = "Dick" +Random;
        offenciveWordsPage.EnterNewOffencivewordInInput(Word).
                ClcikOnAddOfenciveWordButton();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'added successfully')]"),Word));
        } catch (TimeoutException TimeOut){
            Assert.fail("New Word Probably was not added!");
        }
    }
    @Test
    public void DeleteOfeenciveWord(){
        List<WebElement> ListOfWords = new ArrayList<WebElement>();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ant-tag c-tag']")));
             ListOfWords = webDriver.findElements(By.xpath("//span[@class='ant-tag c-tag']"));
            System.out.println(ListOfWords.get(0).getText());
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Offencive Word!");
        }
        offenciveWordsPage.ClcikOnDeleteButtonFromListofWords();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='ant-message']/span"),ListOfWords.get(0).getText()));
        } catch (TimeoutException TimeOut){
            Assert.fail("The Word Probably was not deleted!");
        }
    }
    @After
    public void Close(){
        webDriver.quit();
    }
}
