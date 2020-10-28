import Pages.BuzzPage;
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

public class BuzzPagePositiveScenarios {

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
        // baseUrl = "http://192.168.88.89";
        //  browser = "Chrome";
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
    public void SearchBuzz(){
        String NameOfBuzz = "Created by automation Test";
        buzzPage.SearchBuzz(NameOfBuzz);
        buzzPage.GoToFirstFoundItem(NameOfBuzz);
    }

    @Test
    public void AddBuzzWithPDFAndURL() {
        String BuzzTitle = "Created by automation Test";
        String BuzzDescroption = "Buzz Description";
        String URL = "http://google.com";
        String PathToImage = "/home/user/Desktop/гребля.jpg";
        buzzPage.ClickOnTheAddBuzzbutton();
        buzzPage.EnterBuzzTitle(BuzzTitle);
        buzzPage.EnterDescription(BuzzDescroption);
        buzzPage.AddUrl(URL);
        buzzPage.AddCoverImage(PathToImage);
        buzzPage.AddPDFFile();
        buzzPage.ClickonTheSaveButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/main/div/div[2]/button")));
        try {
            buzzPage.SearchBuzz(BuzzTitle);
            buzzPage.GoToFirstFoundItem(BuzzTitle);
        } catch (TimeoutException TimeOut) {
            Assert.fail("Buzz is not found!");
        }
        WebElement TitleOfFoundBuzz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
        Assert.assertEquals(TitleOfFoundBuzz.getText(), BuzzTitle);
        WebElement DescriptionOfBuzz = webDriver.findElement(By.xpath("//span[contains(text(),'" + BuzzDescroption + "')]"));
        Assert.assertEquals(DescriptionOfBuzz.getText(), BuzzDescroption);
    }
    @Test
    public void EditBuzz(){
        String newTitle = "New Buzz Title";
        String newDescription = "new Buzz Description";
        String PathToImage = "/home/user/Desktop/Blue.png";
       buzzPage.GoToRandomBuzz();
       buzzPage.ClickOnTheEditBuzzButton();
       buzzPage.EnterBuzzTitle(newTitle);
       buzzPage.EnterDescription(newDescription);
       buzzPage.ClickOnTheDeleteCoverImageButton();
       buzzPage.AddCoverImage(PathToImage);
       buzzPage.ClickonTheSaveButton();


        WebElement TitleOfFoundBuzz = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
        Assert.assertEquals(TitleOfFoundBuzz.getText(), newTitle);
        WebElement DescriptionOfBuzz = webDriver.findElement(By.xpath("//span[contains(text(),'" + newDescription + "')]"));
        Assert.assertEquals(DescriptionOfBuzz.getText(), newDescription);
    }

    @Test
    public void DeleteBuzz(){
        buzzPage.GoToRandomBuzz();
        buzzPage.ClickOnTheDeleteButton();
        buzzPage.ClickOnTheDeleteConfirmationButton();


        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-message')]//span")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("The Buzz was not removed!");
        }
    }
    @After
    public void Close(){
        webDriver.quit();
    }




        }




