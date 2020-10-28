import Pages.BuzzPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPageNegativeScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static WebDriverWait wait;
    DashboardPage dashboardPage;
    BuzzPage buzzPage;
    @Before
    public void SetUP() {
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");

        wait = new WebDriverWait(webDriver, 8);
        dashboardPage = new DashboardPage(webDriver);
        buzzPage = new BuzzPage(webDriver);
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoTheBuzzTab();
    }

    @Test
    public void CreateBuzzWithEmptyDescrition(){
        String BuzzTitle = "Created by automation Test";
        String BuzzDescroption = "";
        String URL = "http://google.com";
        String PathToImage = "/home/user/Desktop/гребля.jpg";
        buzzPage.ClickOnTheAddBuzzbutton();
        buzzPage.EnterBuzzTitle(BuzzTitle);

        buzzPage.AddUrl(URL);
        buzzPage.AddCoverImage(PathToImage);
        buzzPage.AddPDFFile();
        buzzPage.ClickonTheSaveButton();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='anticon anticon-c-error icon-textarea']")));
            Assert.fail("Impossible to Create Buzz with Empty Description");
        } catch (TimeoutException TimeOut){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void CreateBuzzWithEmptyTitle(){
        String BuzzTitle = "Created by automation Test";
        String BuzzDescroption = "Buzz Description";
        String URL = "http://google.com";
        String PathToImage = "/home/user/Desktop/гребля.jpg";
        buzzPage.ClickOnTheAddBuzzbutton();

        buzzPage.EnterDescription(BuzzDescroption);
        buzzPage.AddUrl(URL);
        buzzPage.AddCoverImage(PathToImage);
        buzzPage.AddPDFFile();
        buzzPage.ClickonTheSaveButton();
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//i[@class='anticon anticon-c-error icon-text']")));
            Assert.fail("Impossible to Create Buzz with Empty Title");
        } catch (TimeoutException TimeOut){
            Assert.assertTrue(true);
        }
    }
    @Test
    public void CreateBuzzWithoutCoverImage(){
        String BuzzTitle = "Created by automation Test";
        String BuzzDescroption = "Buzz Description";
        String URL = "http://google.com";
        String PathToImage = "/home/user/Desktop/гребля.jpg";
        buzzPage.ClickOnTheAddBuzzbutton();
        buzzPage.EnterBuzzTitle(BuzzTitle);
        buzzPage.EnterDescription(BuzzDescroption);
        buzzPage.AddUrl(URL);

        buzzPage.AddPDFFile();
        buzzPage.ClickonTheSaveButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[2]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]/*[1]")));
            Assert.fail("Impossible to Create Buzz without Cover Image");
        } catch (TimeoutException TimeOut){
            Assert.assertTrue(true);
            return;
        }
    }
    @Test
    public void CreateBuzzWithoutPdfAndURL(){
        String BuzzTitle = "Created by automation Test";
        String BuzzDescroption = "Buzz Description";
        String URL = "http://google.com";
        String PathToImage = "/home/user/Desktop/гребля.jpg";
        buzzPage.ClickOnTheAddBuzzbutton();
        buzzPage.EnterBuzzTitle(BuzzTitle);
        buzzPage.EnterDescription(BuzzDescroption);

        buzzPage.AddCoverImage(PathToImage);

        buzzPage.ClickonTheSaveButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/*[1]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/section[1]/section[1]/main[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/span[1]/*[1]")));
            Assert.fail("Buzz shoud have at least PDF or URL");
        } catch (TimeoutException TimeOut){
            Assert.assertTrue(true);
            return;
        }
    }
    @After
    public void Close(){
        webDriver.quit();
    }
}
