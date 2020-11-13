import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SurveysPagePositiveScenarios {
    WebDriver webDriver;
    LoginPage loginPage;
    static WebDriverWait wait;
    DashboardPage dashboardPage;
    SurveysPage surveysPage;

    @Before
    public void SetUP() {
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://192.168.88.89");

        wait = new WebDriverWait(webDriver, 6);
        dashboardPage = new DashboardPage(webDriver);
        surveysPage = new SurveysPage(webDriver);
        webDriver.manage().window().maximize();
        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);
        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoSurveysTab();
    }

    @Test
    public void AddOffisialSurveyYesNo(){
        String SurveyDescription = "Description";
        String SurveyTitle = "Survey With Yes/No Question";
        String TextOfQuestion ="Some Text";
        surveysPage.ClickOnTheAddOffisialSurveyButton();
        surveysPage.EnterTitle(SurveyTitle);
        surveysPage.EnterDescription(SurveyDescription);
        surveysPage.EnterTextOfFirstQuestion(TextOfQuestion);
        surveysPage.EnterTextToAnswerOptions("Yes","No");

        String EnetedTitle = webDriver.findElement(By.xpath("//input[@name='title']")).getAttribute("value");
        String EnteredDescription = webDriver.findElement(surveysPage.Description).getText();
        Assert.assertEquals(EnetedTitle,SurveyTitle);
        Assert.assertEquals(EnteredDescription,SurveyDescription);
        surveysPage.ClickOnTheCreateSurveyButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Your survey was cuccessfully created!')]")));
            Assert.assertTrue(true);
        } catch (TimeoutException TimeOut){
            Assert.fail("Probably survey as not created!");
        }
    }
    @Test
    public void CreatePusleSurvey(){
        String AutomationTitle = "Pulse created by autotest";
        String PusleDescription = "This pulse was created by autotest";
        String Question = "Do you drink milk";
        surveysPage.GoToPuslesTab();
        surveysPage.ClickOnAddPulseButton();
        surveysPage.EnterTitle(AutomationTitle);
        surveysPage.EnterDescription(PusleDescription);
        surveysPage.EnterQuestionforPulse(Question);
        surveysPage.EnterTextToAnswerOptions("Yes","No");

        WebElement EnteredTitle = webDriver.findElement(By.xpath("//input[@name='title']"));
        WebElement EnteredDescription = webDriver.findElement(By.xpath("//textarea[@name='description']"));
        Assert.assertEquals(EnteredTitle.getAttribute("value"),AutomationTitle);
        Assert.assertEquals(EnteredDescription.getAttribute("value"),PusleDescription);
        surveysPage.ClickONTheCreatePusleButton();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Your pulse was cuccessfully created!')]")));
            Assert.assertTrue(true);
            return;

        } catch (TimeoutException TimeOut){
            Assert.fail("Probably pulse was not created! ");
        }
    }
    @Test
    public void CompletePulse(){
        surveysPage.GoToPuslesTab();
        surveysPage.GotoRandomPulse();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='c-success']"),"Live"));
        } catch (TimeoutException TimeOut){
            Assert.fail("This Pulse not in Live Status!");
        }
        surveysPage.ClickOnTheCompletePulseButton();
        surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"),"Completed"));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey Status is not Completed!");
        }
    }
    @Test
    public void DeletePulse(){
        surveysPage.GoToPuslesTab();
        surveysPage.GotoRandomPulse();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"),"Completed"));
            surveysPage.ClickOnTheDeleteSurveyButton();
            surveysPage.ClickOnTheDeleteSurveyConfirmation();

        } catch (TimeoutException TimeOut){
          surveysPage.ClickOnTheCompletePulseButton();
          surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
          surveysPage.ClickOnTheDeleteSurveyButton();
          surveysPage.ClickOnTheDeleteSurveyConfirmation();
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Survey removed successfully')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Pusle Survey was not removed!");
        }
    }
    @Test
    public void BackToLifePulseSurvey() {
        surveysPage.GoToPuslesTab();
        surveysPage.GotoRandomPulse();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"), "Completed"));
            surveysPage.ClickOnTheBackToLiveButton();

        } catch (TimeoutException TimeOut) {
            surveysPage.ClickOnTheCompletePulseButton();
            surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"), "Completed"));
            surveysPage.ClickOnTheBackToLiveButton();
            surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
        }
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Live']"), "Live"));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("The survey dont have Live Status");
        }
    }


    @Test
    public void CloneUserSurvey(){
        surveysPage.GotoUserSurveysTab();
        surveysPage.GotoRandomUserSurvey();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"),"Completed"));
            surveysPage.ClcikOnTheCloneSurveyButton();
            surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();

        } catch (TimeoutException TimeOut){
            surveysPage.ClickOnTheCompletePulseButton();
            surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
        }
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'c-hint')]"),"Draft"));
        surveysPage.ClcikOnTheEditDraftButton();
        surveysPage.ClickOnThePublishDraftbutton();

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Survey edited successfully')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Survey was not updated!");
        }
    }
    @Test
    public void DeleteUsersSurvey(){
        surveysPage.GotoUserSurveysTab();
        surveysPage.GotoRandomUserSurvey();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Completed']"),"Completed"));
            surveysPage.ClickOnTheDeleteSurveyButton();
            surveysPage.ClickOnTheDeleteSurveyConfirmation();

        } catch (TimeoutException TimeOut){
            surveysPage.ClickOnTheCompletePulseButton();
            surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
            surveysPage.ClickOnTheDeleteSurveyButton();
            surveysPage.ClickOnTheDeleteSurveyConfirmation();
        }
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Survey removed successfully')]")));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException TimeOut){
            Assert.fail("Pusle Survey was not removed!");
        }
    }

    @Test
    public void ApproveUsersSurvey(){
        surveysPage.GotoUserSurveysTab();
        try {
            surveysPage.GotoSurveyWithModerationStatus();
        } catch (StaleElementReferenceException NoElem){

        }
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'c-warning')]"),"In Moderation"));
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Survey In Moderation!");
        }
        surveysPage.ClckOnTheAprroveSurveyButton();
        surveysPage.ClickOnTheComplete_ReOpenConfirmationButton();
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Live']"), "Live"));
            Assert.assertTrue(true);
            return;
        } catch (TimeoutException Timeout){
            Assert.fail("Survey is not in Live");
        }
    }
    @Test
    public void RejectUserSurvey(){
        String ReasonOfRejection = "This survey was rejected by autotestrr!";
        surveysPage.GotoUserSurveysTab();
        try {
            surveysPage.GotoSurveyWithModerationStatus();
        } catch (StaleElementReferenceException NoElem){

        }
        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(@class,'c-warning')]"),"In Moderation"));
        } catch (TimeoutException TimeOut){
            Assert.fail("There is no any Survey In Moderation!");
        }
        surveysPage.ClickOnTheRejectSurveyButton();
        surveysPage.EnterReasonOfRejection(ReasonOfRejection);
        surveysPage.ConfirmRejection();

        try {
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='Rejected']"), "Rejected"));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[text()='"+ReasonOfRejection+"']"),ReasonOfRejection));
            Assert.assertTrue(true);
            return;


        } catch (TimeoutException TimeOut){
            Assert.fail("Rejected Status and Rejected Reason are not Displayed!");
        }
    }


}
