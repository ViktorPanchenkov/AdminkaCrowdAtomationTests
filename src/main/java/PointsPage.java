import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PointsPage {
    WebDriver webDriver;
    public PointsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
     By CreateCommunityField = By.xpath("//input[@name='createCommunity']");
    By CreateSurveyField = By.xpath("//input[@name='createSurvey']");
    By SaveChangesButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By HideCommunityActionCostSection = By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div/div[1]/div[1]");

    public void WaitPresentOfElement(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public PointsPage EnterCommunitySum(String points){
        webDriver.manage().window().maximize();
        WaitPresentOfElement(4,CreateCommunityField);
        webDriver.findElement(CreateCommunityField).clear();
        webDriver.findElement(CreateCommunityField).sendKeys(points);
        return  this;
    }
    public PointsPage EnterSurveyCost(String points){
        WaitPresentOfElement(4,CreateSurveyField);
        webDriver.findElement(CreateSurveyField).clear();
        webDriver.findElement(CreateSurveyField).sendKeys(points);
        return this;
    }

    public PointsPage ClcikOnTheSaveButton(){
        webDriver.manage().window().maximize();
        WaitPresentOfElement(4,SaveChangesButton);
        webDriver.findElement(SaveChangesButton).click();
        return this;
    }
    public PointsPage ClickOnTheHideCommunityActionSection(){
        WaitPresentOfElement(4,HideCommunityActionCostSection);
        webDriver.findElement(HideCommunityActionCostSection).click();
        return this;
    }

}
