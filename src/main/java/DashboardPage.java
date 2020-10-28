import Pages.OffenciveWordsPage;
import com.google.inject.internal.cglib.core.$ClassNameReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    WebDriver webDriver;
    public DashboardPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By BuzzTub = (By.xpath("//span[contains(text(),'The Buzz')]"));
    By SurveyTab = By.xpath("//span[contains(text(),'Surveys')]");
    By ContacRequestTab = By.xpath("//span[contains(text(),'Contact Requests')]");
    By CommunitiesTab = By.xpath("//span[contains(text(),'Communities')]");
    By OffensiveWordsTab = By.xpath("//span[contains(text(),'Offensive Words')]");
    By UsersTab = By.xpath("//span[contains(text(),'Users')]");
    By CategorisTab = By.xpath("//span[contains(text(),'Categories')]");
    By PointsTab = By.xpath("//span[contains(text(),'Points')]");
    By StayInTouchEmailsTab = By.xpath("//span[contains(text(),'Stay In Touch Emails')]");

    public void WaitUntilElementBeLoketed(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void GotoTheBuzzTab(){
        WaitUntilElementBeLoketed(4,BuzzTub);
        webDriver.findElement(BuzzTub).click();
    }
    public void GotoSurveysTab(){
        WaitUntilElementBeLoketed(4,SurveyTab);
        webDriver.findElement(SurveyTab).click();
    }
    public void GotoCommunitiesTab(){
        WaitUntilElementBeLoketed(4,CommunitiesTab);
        webDriver.findElement(CommunitiesTab).click();
    }
    public void GotoUsersPage(){
        WaitUntilElementBeLoketed(4,UsersTab);
        webDriver.findElement(UsersTab).click();
    }
    public void GotoContactRequestsTab(){
        WaitUntilElementBeLoketed(4,ContacRequestTab);
        webDriver.findElement(ContacRequestTab).click();
    }
    public void GotoStayinTouchEmailsTab(){
        WaitUntilElementBeLoketed(4,StayInTouchEmailsTab);
        webDriver.findElement(StayInTouchEmailsTab).click();
    }

    public void GotoCategoriesTab(){
        WaitUntilElementBeLoketed(4,CategorisTab);
        webDriver.findElement(CategorisTab).click();
    }
    public  PointsPage GotoPointsPage(){
        WaitUntilElementBeLoketed(4,PointsTab);
        webDriver.findElement(PointsTab).click();
        return new PointsPage(webDriver);
    }
    public OffenciveWordsPage GotoOffenciveWordsPage(){
        WaitUntilElementBeLoketed(4,OffensiveWordsTab);
        webDriver.findElement(OffensiveWordsTab).click();
        return  new OffenciveWordsPage(webDriver);

    }
}
