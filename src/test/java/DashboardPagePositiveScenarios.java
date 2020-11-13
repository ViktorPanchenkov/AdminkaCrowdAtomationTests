import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPagePositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static  WebDriverWait wait;
    DashboardPage dashboardPage;
    @Before
    public void SetUP() {
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");
        // baseUrl = "http://192.168.88.89";
        //  browser = "Chrome";
        wait = new WebDriverWait(webDriver, 4);
        dashboardPage = new DashboardPage(webDriver);
        webDriver.manage().window().maximize();
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();

    }

    @Test
    public void GotoTheBuzzTab(){
        dashboardPage.GotoTheBuzzTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"The Buzz!");
    }
    @Test
    public void GotoSurveysTab(){
        dashboardPage.GotoSurveysTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Surveys");
    }
    @Test
    public void GotoCommunitiesTab(){
        dashboardPage.GotoCommunitiesTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Communities");
    }
    @Test
    public void GotoUsersTab(){
        dashboardPage.GotoUsersPage();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Users");
    }
    @Test
    public void GotoContactRequestTab(){
        dashboardPage.GotoContactRequestsTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Contact Requests");
    }
    @Test
    public void GotoStayInTouchEmails(){
        dashboardPage.GotoStayinTouchEmailsTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Stay In Touch Emails");
    }
    @Test
    public void GotoCategoriesPage(){
        dashboardPage.GotoCategoriesTab();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Categories");
    }
    @Test
    public void GotoPointsPage(){
        dashboardPage.GotoPointsPage();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Points");
    }
    @Test
    public void GotoOffensiveWordsPage(){
        dashboardPage.GotoOffenciveWordsPage();
        WebElement HederOfPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(HederOfPage.getText(),"Offensive Words");

    }
    @After
    public void Close(){
        webDriver.quit();
    }


}
