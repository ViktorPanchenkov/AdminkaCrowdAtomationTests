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

public class LoginPageNegativeScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static WebDriverWait wait;

    @Before
    public void SetUP() {
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");
        // baseUrl = "http://192.168.88.89";
        //  browser = "Chrome";
        wait = new WebDriverWait(webDriver, 4);
    }
    @Test
    public void LoginWithInvalidPassword(){

        loginPage.TypePhone("+1111111111");
        loginPage.TypePassword("nkvd");
        loginPage.ClickOnTheLoginButton();
         try {
             wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='password-field']/i")));
             Assert.fail("Invalid Password!");
         } catch (TimeoutException Timeout){
             Assert.assertTrue(true);
             return;
         }
    }
    @Test
    public void LoginWithInvalidPhone(){
        loginPage.TypePhone("+11111");
        loginPage.TypePassword("qwerty");
        loginPage.ClickOnTheLoginButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='anticon anticon-c-error icon-text']")));
            Assert.fail("Invalid Phone!");
        } catch (TimeoutException Timeout){
            Assert.assertTrue(true);
            return;
        }
    }
}
