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

public class PointsOagePositiveScenarios {

    WebDriver webDriver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public static WebDriverWait wait;
    PointsPage pointsPage;


    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        pointsPage = new PointsPage(webDriver);


        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoPointsPage();

    }

    @Test
    public void ChangeCreateCommunityCost(){
        int Random = (int) (Math.random() *10);
        String Points = "100" + Random;

       pointsPage.EnterCommunitySum(Points).
               ClcikOnTheSaveButton();

       try {
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Updated successfully')]")));
           WebElement CreateCommunityPoints = webDriver.findElement(pointsPage.CreateCommunityField);
           Assert.assertEquals(Points,CreateCommunityPoints.getAttribute("value"));
       } catch (TimeoutException TimeOut){
           Assert.fail("Probably Community cost was not updated!");
       }
    }
    @Test
    public void ChangeCreateSurveyCost(){
        int Random = (int) (Math.random() *10);
        String Points = "100" + Random;
        pointsPage.EnterSurveyCost(Points).
                ClcikOnTheSaveButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Updated successfully')]")));
            WebElement CreateSurrveyPoints = webDriver.findElement(pointsPage.CreateSurveyField);
            Assert.assertEquals(Points,CreateSurrveyPoints.getAttribute("value"));
        } catch (TimeoutException TimeOut){
            Assert.fail("Probably Survey cost was not updated!");
        }

    }

    @Test
    public void HideCommunityActionCostSection(){
        pointsPage.ClickOnTheHideCommunityActionSection();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(pointsPage.CreateCommunityField));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Community Action Cost Panel was not Hide!");
        }
    }
}
