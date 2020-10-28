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

import java.util.concurrent.TimeUnit;

public class UsersPagePositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    public static WebDriverWait wait;
    DashboardPage dashboardPage;
    UsersPage usersPage;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        usersPage = new UsersPage(webDriver);

        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoUsersPage();
    }


    @Test
    public void NotifyEvereyone(){
        String TextOfNotfication = "Notification sent by autotest";
        usersPage.ClickOntheNotifyEvereyoneButton();
        usersPage.EnterTextOfNotification(TextOfNotfication);
        usersPage.ClickOnTheCreateNotificationButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Notification was sent successfully')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Probably notification was not sent!");
        }
    }

    @Test
    public void BanUser(){
        String nameOfUser = "User For Ban";
        usersPage.FindUser(nameOfUser);
        WebElement TextOfBanbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(usersPage.BanUserButton));
        System.out.println(TextOfBanbutton.getText());
        if (TextOfBanbutton.getText().equals("BAN USER")){
            usersPage.ClcikOnTheBanUserButton();
            usersPage.ClickonConfirmationButton();

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User banned successfully')]")));
                wait.until(ExpectedConditions.textToBe(usersPage.BanUserButton,"UNBAN USER"));
            } catch (TimeoutException TimeOut){
                Assert.fail("The User was not banned!");
            }
        } else {
            Assert.fail("The User Already banned!");
        }
    }
    @Test
    public void UnbanUser(){
        String nameOfUser = "User For Ban";
        usersPage.FindUser(nameOfUser);
        WebElement TextOfBanbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(usersPage.BanUserButton));
        System.out.println(TextOfBanbutton.getText());
        if (TextOfBanbutton.getText().equals("UNBAN USER")){
            usersPage.ClcikOnTheBanUserButton();
            usersPage.ClickonConfirmationButton();

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'User unbanned successfully')]")));
                wait.until(ExpectedConditions.textToBe(usersPage.BanUserButton,"BAN USER"));
            } catch (TimeoutException TimeOut){
                Assert.fail("The User was not unbanned!");
            }
        } else {
            Assert.fail("The User was not  banned!");
        }
    }
    @Test
    public void GotoOwnedCommunitiesTab(){
        usersPage.GotoAnyUsersProfile();
        usersPage.GotoOwenCommunitiesTab();
        WebElement OwenedTab = webDriver.findElement(usersPage.OwenedCommunitiesTab);
        System.out.println(OwenedTab.getCssValue("color"));

        if (OwenedTab.getCssValue("color").equals("rgba(153, 204, 0, 1)")){
            Assert.assertTrue(true);
            return;
        } else {
            Assert.fail("Owened Communities Tab is not selected!");
        }
    }
    @Test
    public void GotoUserSurveysTab(){
        usersPage.GotoAnyUsersProfile();
        usersPage.GoToUsersSurveyTab();

        WebElement SurveysTab = webDriver.findElement(usersPage.UsersSurveysTab);
        if (SurveysTab.getCssValue("color").equals("rgba(153, 204, 0, 1)")){
            Assert.assertTrue(true);
            return;
        } else {
            Assert.fail("Surveys tab is not selected!");
        }
    }
    @Test
    public void GivePoins()  {
        String Points = "100";
        usersPage.GotoAnyUsersProfile();
        WebElement CurrentSum = webDriver.findElement(By.xpath("//div[@class='card profile-statistic']/h3[1]"));
        System.out.println(CurrentSum.getText());

        usersPage.ClickOnTheGivePointsButton();
       usersPage.EnterSumofPoints(Points);
       usersPage.ClickOnTheGetPointsButton();
    }


}
