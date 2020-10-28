import com.sun.org.apache.xpath.internal.operations.Mod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CommunityPage {
    WebDriver webDriver;
    public CommunityPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By SearchField = By.xpath("//input[@placeholder='Search...']");
    By AddCommunityButton = By.xpath("//div[@class='search-block f-c-s']/button");
    By Title = By.xpath("//input[@name='title']");
    By Description = By.xpath("//textarea[@name='description']");
    String PathToImage = "/home/user/Desktop/гребля.jpg";
    By CreateCommunityButton =By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By EditCommmunityButton = By.xpath("//div[@class='f-s-sb']/button");
    By BlockCommunityButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[3]");
    By UpdateCommunityButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By FollowersTab = By.xpath("//h3[contains(text(),'Followers')]");
    By ModeratorsTab = By.xpath("//h3[contains(text(),'Moderators')]");
    By ActiveNewTab = By.xpath("//h3[contains(text(),'Active News')]");
    By CreateNewsButton = By.xpath("//div[@class='search-block']/button");
    By CreateNewsButtonFinal = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By DeleteNewsButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[1]");



    public void WaiuUntilElementLocated(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void SearchCommmunity(String nameOFCommunity) {
        webDriver.findElement(SearchField).sendKeys(nameOFCommunity);
        WebElement FoundCommunity = webDriver.findElement(By.xpath("//td/span[contains(text()," + "'" + nameOFCommunity + "')]"));
        FoundCommunity.click();
    }
    public void ClickOnTheAddCommunityButtton(){
        WaiuUntilElementLocated(4,AddCommunityButton);
        webDriver.findElement(AddCommunityButton).click();
    }
    public void EnterTitle(String TitleOfSurvey){
       WaiuUntilElementLocated(4,Title);
       webDriver.findElement(Title).clear();
        webDriver.findElement(Title).sendKeys(TitleOfSurvey);
    }
    public void EnterDescription(String DescriptionOfSurvey){
        WaiuUntilElementLocated(4,Description);
        webDriver.findElement(Description).clear();
        webDriver.findElement(Description).sendKeys(DescriptionOfSurvey);
    }
    public void AddCommunityImage(){
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        webDriver.findElement(By.xpath("//div[contains(@class,'cropper-cmp')]//input")).sendKeys(PathToImage);
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
        if(popup.isDisplayed()){
            WebElement CroupButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
            CroupButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]")));
        }
    }
    public void ClcikOnCreateCommunityButton(){
        WaiuUntilElementLocated(4,CreateCommunityButton);
        webDriver.findElement(CreateCommunityButton).click();
    }

    public void ProccedToCoomuntyFromListOfCommunities(){
        WaiuUntilElementLocated(4,By.xpath("//tr[1]//td[2]"));
        List<WebElement> ListOfCommunities = new ArrayList<WebElement>();
        for (int i = 1 ; i<10; i++){
            WebElement Community = webDriver.findElement(By.xpath("//tr["+ i +"]//td[2]"));
            ListOfCommunities.add(Community);
        }
        ListOfCommunities.get(7).click();
    }
    public void ProccedToRandomCoomunty() {
        int Random = (int) (Math.random() *10);
        WaiuUntilElementLocated(4, By.xpath("//tr[1]//td[2]"));
        List<WebElement> ListOfCommunities = new ArrayList<WebElement>();
        for (int i = 1; i < 11; i++) {
            WebElement Community = webDriver.findElement(By.xpath("//tr[" + i + "]//td[2]"));
            ListOfCommunities.add(Community);
        }
        ListOfCommunities.get(Random).click();
    }

    public void ClcikOnTheEditCommunityButton(){
        WaiuUntilElementLocated(4,EditCommmunityButton);
        webDriver.findElement(EditCommmunityButton).click();
    }
    public void ClickOnTheBlockCommunityButton(){
        WaiuUntilElementLocated(4,BlockCommunityButton);
        webDriver.findElement(BlockCommunityButton).click();
    }
    public void ClickonConfirmationButton(){
        WaiuUntilElementLocated(4,By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]"));
        webDriver.findElement(By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]")).click();
    }
    public void ClickOnTheUpdateCommunityButton(){
        WaiuUntilElementLocated(4,UpdateCommunityButton);
        webDriver.findElement(UpdateCommunityButton).click();
    }
    public void GotoFollowersTab(){
        WaiuUntilElementLocated(4,FollowersTab);
        webDriver.findElement(FollowersTab).click();
    }
   public void GotoModeratorsTab(){
        WaiuUntilElementLocated(4,ModeratorsTab);
        webDriver.findElement(ModeratorsTab).click();
   }
   public void GotoActiveNewsTab(){
        WaiuUntilElementLocated(4,ActiveNewTab);
        webDriver.findElement(ActiveNewTab).click();
   }
   public void ClickOnTheCreateNewsButton(){
        WaiuUntilElementLocated(4,CreateNewsButton);
        webDriver.findElement(CreateNewsButton).click();
   }
   public void CreateNews(){
        WaiuUntilElementLocated(4,CreateNewsButtonFinal);
        webDriver.findElement(CreateNewsButtonFinal).click();
   }
   public void ProccedToFirstNews(){
        WaiuUntilElementLocated(4,By.xpath("//tbody/tr[1]/td[2]"));
        webDriver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
   }
   public void ClickOnTheDeleteNewsButton(){
        WaiuUntilElementLocated(4,DeleteNewsButton);
        webDriver.findElement(DeleteNewsButton).click();
   }

}
