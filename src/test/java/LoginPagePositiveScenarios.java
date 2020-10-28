import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPagePositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static WebDriverWait wait;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");
       // baseUrl = "http://192.168.88.89";
      //  browser = "Chrome";
        wait = new WebDriverWait(webDriver,4);





    }

    @Test
    public void LoginAsOCTAdmin(){
        String Phone = "+1111111111";
        String Password = "qwerty";
      loginPage.TypePhone(Phone);
      loginPage.TypePassword(Password);
      loginPage.ClickOnTheLoginButton();

        WebElement NameOFUSER = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/header/div/a/span[2]")));
        Assert.assertEquals(NameOFUSER.getText(),"OCT Admin");
    }
    @Test
    public void LoginAsContentManager(){
        String Phone = "+1111111113";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();


        WebElement NameOFUSER = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/header/div/a/span[2]")));
        Assert.assertEquals(NameOFUSER.getText(),"OCT CONTENT MANAGER");
    }
    @Test
    public void LoginAsOctModerator(){
        String Phone = "+1111111112";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();

        WebElement NameOFUSER = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/header/div/a/span[2]")));
        Assert.assertEquals(NameOFUSER.getText(),"OCT Moderator");

    }

    @Test
    public void GotoForgotPasswordScreen(){
        loginPage.ClickOnTheForgotPasswordLink();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Enter your phone number and we’ll send you SMS with a passcode to reset your password')]")));
           WebElement ResetButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[2]/form[1]/button[1]")));
            Assert.assertTrue(true);
        } catch (org.openqa.selenium.TimeoutException Exp){
            Assert.fail("Probably Forgot PasswordPage is not opened!");
        }
    }


}
