import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {
    WebDriver webDriver;
    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By PhoneField = By.xpath("//input[@name=\"username\"]");
    By PasswordField = By.xpath("//input[@name=\"password\"]");
    By LoginButton = By.xpath("//button[@type=\"submit\"]");
    By ForgotPasswodLink = By.xpath("//span[contains(text(),'Forgot Password?')]");
    By ShowPasswordButton = By.xpath("//span[@class='ant-input-suffix']/i");

     public LoginPage open(){
         Selenide.open("http://192.168.88.89");
         return this;
     }
    public void WaitUntilElementBeLoketed(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public LoginPage TypePhone(String Phone){
      WaitUntilElementBeLoketed(4,PhoneField);
      webDriver.findElement(PhoneField).sendKeys(Phone);
      return this;
    }
    public void TypePassword(String Password){
        WaitUntilElementBeLoketed(4,PasswordField);
        webDriver.findElement(PasswordField).sendKeys(Password);

    }
    public void ClickOnTheLoginButton(){
        WaitUntilElementBeLoketed(4,LoginButton);
        webDriver.findElement(LoginButton).click();
    }
    public void ClickOnTheShowHidePasswordbutton(){
         WaitUntilElementBeLoketed(4,ShowPasswordButton);
         webDriver.findElement(ShowPasswordButton).click();
    }
    public void ClickOnTheForgotPasswordLink(){
         WaitUntilElementBeLoketed(4,ForgotPasswodLink);
         webDriver.findElement(ForgotPasswodLink).click();
    }


}
