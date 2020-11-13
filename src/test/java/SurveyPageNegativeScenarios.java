import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurveyPageNegativeScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static WebDriverWait wait;
    DashboardPage dashboardPage;
    SurveysPage surveysPage;

    @Before
    public void SetUP() {
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");

        wait = new WebDriverWait(webDriver, 6);
        dashboardPage = new DashboardPage(webDriver);
        surveysPage = new SurveysPage(webDriver);
        webDriver.manage().window().maximize();
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoSurveysTab();
    }
    @Test
    public void CreateSurveyWitoutTitle(){
        String SurveyDescription = "Description";
        String SurveyTitle = "Survey With Yes/No Question";
        String TextOfQuestion ="Some Text";
        surveysPage.ClickOnTheAddOffisialSurveyButton();

        surveysPage.EnterDescription(SurveyDescription);
        surveysPage.EnterTextOfFirstQuestion(TextOfQuestion);
        surveysPage.EnterTextToAnswerOptions("Yes","No");

        String EnetedTitle = webDriver.findElement(By.xpath("//input[@name='title']")).getAttribute("value");
        String EnteredDescription = webDriver.findElement(surveysPage.Description).getText();

        Assert.assertEquals(EnteredDescription,SurveyDescription);
        surveysPage.ClickOnTheCreateSurveyButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[contains(@class,'anticon anticon-c-error icon-text')]")));
           Assert.fail("It is not Possible to create Survey With Empty Title!");
        } catch (TimeoutException TimeOut){
           Assert.assertTrue(true);
        }
    }
}
