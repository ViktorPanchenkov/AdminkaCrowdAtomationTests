import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CommunityPagePositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    public static WebDriverWait wait;
    DashboardPage dashboardPage;
    CommunityPage communityPage;

    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        communityPage = new CommunityPage(webDriver);

        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoCommunitiesTab();

    }

    @Test
    public void SearchCommunity(){
        String NameOfCommunity ="14 Soviet army";
        communityPage.SearchCommmunity(NameOfCommunity);
        WebElement CommuntyTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(@class,'category-header-cmp-title')]")));
        Assert.assertEquals(CommuntyTitle.getText(),NameOfCommunity);
    }

    @Test
    public void AddCommunity(){
        int Random = (int) (Math.random() *10);
        String TitleofCommunity = "Community by autotest" + Random;
        String DescriptionofCommunity = "Description by autotest";
        communityPage.ClickOnTheAddCommunityButtton();
        communityPage.EnterTitle(TitleofCommunity);
        communityPage.EnterDescription(DescriptionofCommunity);
        communityPage.AddCommunityImage();
        communityPage.ClcikOnCreateCommunityButton();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-message')]//span")));
        } catch (TimeoutException TimeOut){
            Assert.fail("Community Create pop-up is not dispalyed!");
            return;
        }
        try {
            communityPage.SearchCommmunity(TitleofCommunity);
            Assert.assertTrue(true);
        } catch (NoSuchElementException NoElem){
            Assert.fail("Created community was not found!");
        }
    }
    @Test
    public void BlockCommunity(){
    communityPage.ProccedToCoomuntyFromListOfCommunities();

    communityPage.ClickOnTheBlockCommunityButton();
    communityPage.ClickonConfirmationButton();
    WebElement BlockButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[3]")));
    String BlockButtonText = BlockButton.getText();
    System.out.println(BlockButtonText);
    Assert.assertEquals(BlockButtonText,"UNBLOCK COMMUNITY");

    }
    @Test
    public void UnblockCommunity(){
        communityPage.ProccedToCoomuntyFromListOfCommunities();
        WebElement BlockButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[3]")));
        if (BlockButton.getText().equals("BLOCK COMMUNITY")){
            Assert.fail("Community was not Bloked!");
            return;
        }

        communityPage.ClickOnTheBlockCommunityButton();
        communityPage.ClickonConfirmationButton();


        System.out.println(BlockButton.getText());

        Assert.assertEquals(BlockButton.getText(),"BLOCK COMMUNITY");
    }
    @Test
    public void UpdateCommunity(){
        String newTitle = "QA commnuity";
        String newDescription = "Updated Description by autotests";
        communityPage.ProccedToCoomuntyFromListOfCommunities();
        communityPage.ClcikOnTheEditCommunityButton();
        communityPage.EnterTitle(newTitle);
        communityPage.EnterDescription(newDescription);
        communityPage.ClickOnTheUpdateCommunityButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+ newDescription+"')]")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'"+newTitle+"')]")));

        } catch (TimeoutException TimeOut){
            Assert.fail("Title and Description was not updated!");
        }

    }
    @Test
    public void GotoFollowersTab(){
        communityPage.ProccedToRandomCoomunty();
        communityPage.GotoFollowersTab();
        List<WebElement> ListOfFollowers = new ArrayList<WebElement>();
        ListOfFollowers = webDriver.findElements(By.xpath("//tr[@class='hoverable']"));
        Assert.assertNotNull(ListOfFollowers);
    }
    @Test
    public void GotoModeratorsTab(){
        communityPage.ProccedToRandomCoomunty();
        communityPage.GotoModeratorsTab();
        List<WebElement> ListOfModerators = new ArrayList<WebElement>();
        ListOfModerators = webDriver.findElements(By.xpath("//tr[@class='hoverable']"));
        Assert.assertNotNull(ListOfModerators);
    }
    @Test
    public void CreateNews(){
        String TitleOfNews = "News Created By autotest";
        String DescriptionOfNews = "Selenium news";
        communityPage.ProccedToRandomCoomunty();
        communityPage.GotoActiveNewsTab();
        communityPage.ClickOnTheCreateNewsButton();
        communityPage.EnterTitle(TitleOfNews);
        communityPage.EnterDescription(DescriptionOfNews);
        communityPage.AddCommunityImage();
        communityPage.CreateNews();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'News created successfully.')]"),"News created successfully."));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'"+ TitleOfNews +"')]")));
        } catch (TimeoutException TimeOut){
            Assert.fail("Probably news was not added!");
        }
    }
    @Test
    public void DeleteNews(){
        communityPage.ProccedToRandomCoomunty();
        communityPage.GotoActiveNewsTab();
        try {
            communityPage.ProccedToFirstNews();
        } catch (TimeoutException TimeOut){
            Assert.fail("There are no any news!");
            return;
        }
        communityPage.ClickOnTheDeleteNewsButton();
        communityPage.ClickonConfirmationButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'News deleted successfully.')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Probaly news was not deleted!");
        }
    }
    @After
    public void Close(){
        webDriver.quit();
    }

}
