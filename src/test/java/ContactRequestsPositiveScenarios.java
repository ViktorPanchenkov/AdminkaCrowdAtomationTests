import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactRequestsPositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    public static WebDriverWait wait;
    DashboardPage dashboardPage;
    ContactRequestsPage contactRequestsPage;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        contactRequestsPage = new ContactRequestsPage(webDriver);
        webDriver.manage().window().maximize();

        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoContactRequestsTab();

    }

    @Test
    public void SolveRequest(){
        try {
            contactRequestsPage.ClickOnTheFirstSolevedButton();
        } catch (TimeoutException TimeOut){
            Assert.fail("There are no any requests to Solve!");
        }

     try {
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Request marked as solved successfully.')]")));
         Assert.assertTrue(true);
         return;
     } catch (TimeoutException TimeOut){
         Assert.fail("Probably Request Was not solved!");
     }
    }
    @Test
    public void OpenContactRequestInfoInRequestedTab(){
         contactRequestsPage.ClickOnFirstRequestFromList();
         try {
             wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(),'Contact Request Info')]"),"Contact Request Info"));
             Assert.assertTrue(true);
             contactRequestsPage.ClickOnCanselButton();
             return;
         } catch (TimeoutException TimeOut ){
             Assert.fail("Contact info was not displayed!");
         }

    }
    @Test
    public void OpenContactRequestInfoInSolvedTab(){
        contactRequestsPage.GotoSolvedTab();
        contactRequestsPage.ClickOnFirstRequestFromList();

        try {
            wait.until(ExpectedConditions.textToBe(By.xpath("//div[contains(text(),'Contact Request Info')]"),"Contact Request Info"));
            Assert.assertTrue(true);
            contactRequestsPage.ClickOnCanselButton();
            return;
        } catch (TimeoutException TimeOut ){
            Assert.fail("Contact info was not displayed!");
        }
    }

}
