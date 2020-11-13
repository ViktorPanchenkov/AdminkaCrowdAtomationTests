import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StayInTouchEmailsPositiveScenarios {

    WebDriver webDriver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public static WebDriverWait wait;
    StayInTouchEmailsPage stayInTouchEmailsPage;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        stayInTouchEmailsPage = new StayInTouchEmailsPage(webDriver);
        webDriver.manage().window().maximize();

        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoStayinTouchEmailsTab();

    }
    @Test
    public void DeleteUserFromSubscribedTab(){
        try {
            stayInTouchEmailsPage.ClickOnTheDeleteButtonFromList();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Stay in Touch Email! ");
        }

       try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User was deleted')]")));
           Assert.assertTrue(true);
           return;
       } catch (TimeoutException TimeOut){
           Assert.fail("User was not Deleted!");
       }
    }
    @Test
    public void DeleteUserFromUnsubscribedTab(){
        stayInTouchEmailsPage.GotoUnsubscribedTab();
        try {
            stayInTouchEmailsPage.ClickOnTheDeleteButtonFromList();
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Stay in Touch Email! ");
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User was deleted')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("User was not Deleted!");
        }
    }
}
