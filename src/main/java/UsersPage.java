import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class UsersPage {
    WebDriver webDriver;
    public UsersPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By NotifyEvereyoneButtton = By.xpath("//div[@class='search-block f-c-s']/button[1]");
    By TextareaOfNotification = By.xpath("//textarea[@name='message']");
    By CreateNotificationButton = By.xpath("//div[@class='ant-modal-footer']/button[2]");
    By BanUserButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[2]");
    By SearchField = By.xpath("//input[@placeholder='Search...']");
    By OwenedCommunitiesTab = By.xpath("//h3[contains(text(),'Owned Communities')]");
    By UsersSurveysTab = By.xpath("//h3[contains(text(),'Surveys')]");
    By GivepointsButton = By.xpath("//div[@class='card profile-statistic']/button[1]");


    public void WaitUntilElementVisible(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void FindUser(String UserName){
        webDriver.findElement(SearchField).sendKeys(UserName);
        WebElement FoundSurvey = webDriver.findElement(By.xpath("//td/span[contains(text()," + "'" + UserName + "')]"));
        FoundSurvey.click();
    }

    public void ClickOntheNotifyEvereyoneButton(){
        WaitUntilElementVisible(4,NotifyEvereyoneButtton);
        webDriver.findElement(NotifyEvereyoneButtton).click();
    }
    public void EnterTextOfNotification(String Text){
        WaitUntilElementVisible(4,TextareaOfNotification);
        webDriver.findElement(TextareaOfNotification).sendKeys(Text);
    }
    public void ClickOnTheCreateNotificationButton(){
        WaitUntilElementVisible(4,CreateNotificationButton);
        webDriver.findElement(CreateNotificationButton).click();
    }
    public void GotoAnyUsersProfile(){
        int Random = (int) (Math.random() *10);
        WaitUntilElementVisible(4, NotifyEvereyoneButtton);
        List<WebElement> ListOfUsers = new ArrayList<WebElement>();
        ListOfUsers = webDriver.findElements(By.xpath("//tr[@class='hoverable']"));
        ListOfUsers.get(Random).click();
    }
    public void ClcikOnTheBanUserButton(){
        WaitUntilElementVisible(4,BanUserButton);
        webDriver.findElement(BanUserButton).click();
    }
    public void ClickonConfirmationButton(){
        WaitUntilElementVisible(4,By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]"));
        webDriver.findElement(By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]")).click();
    }
    public void GotoOwenCommunitiesTab(){
        WaitUntilElementVisible(4,OwenedCommunitiesTab);
        webDriver.findElement(OwenedCommunitiesTab).click();
    }
    public void GoToUsersSurveyTab(){
        WaitUntilElementVisible(4,UsersSurveysTab);
        webDriver.findElement(UsersSurveysTab).click();
    }
    public void ClickOnTheGivePointsButton(){
        WaitUntilElementVisible(4,GivepointsButton);
        webDriver.findElement(GivepointsButton).click();
    }
    public void EnterSumofPoints(String  Points){
        WaitUntilElementVisible(4,By.xpath("//div[@class='ant-modal-body']/input"));
        webDriver.findElement(By.xpath("//div[@class='ant-modal-body']/input")).sendKeys(Points);
    }
    public void ClickOnTheGetPointsButton(){
        WaitUntilElementVisible(4,By.xpath("//div[@class='ant-modal-footer']/button[2]"));
        webDriver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[2]")).click();
    }

}
