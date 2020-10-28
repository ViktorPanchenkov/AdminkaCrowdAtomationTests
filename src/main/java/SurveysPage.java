import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class SurveysPage {

    WebDriver webDriver;
    public SurveysPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

     By AddOfficialSurveyButton = By.xpath("//div[@class='search-block f-c-s']/button");
     By Title = By.xpath("//input[@name='title']");
     By Description = By.xpath("//textarea[@name='description']");
     By CreateSurveyButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[2]");
     By PulseTab = By.xpath("//h3[contains(text(),'Pulses')]");
     By AddPulseButton = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[2]/button");
     By CreatePulseButton = By.xpath("//button[contains(@class,'btn-default btn-default-success ant-btn-default')]");
     By SurveyStatus = By.xpath("//span[@class='c-success']");
     By CompleteSurveyButton =By.xpath("//button[contains(@class,'btn-default btn-default-success ant-btn-default')]");
     By DeleteSurveyButton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button[1]");
     By UserSurveysTab = By.xpath("//h3[contains(text(),'User Surveys')]");
     By CloneSurveyButton = By.xpath("//body//button[3]");
     By BackToLiveSurveyButton = By.xpath("//button[contains(@class,'btn-default btn-default-success ant-btn-default')]");
     By EditDraftbutton = By.xpath("//body//button[2]");
     By PublishDraftButton = By.xpath("//body//button[2]");
     By ApproveSurveyButton = By.xpath("//button[contains(@class,'btn-default btn-default-success ant-btn-default')]");
     By RejectSurveyButton = By.xpath("//button[contains(@class,'btn-default btn-default-error ant-btn-default')]");

    public void WaitUntilElementBeLoketed(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void ClickOnTheAddOffisialSurveyButton(){
        WaitUntilElementBeLoketed(4,AddOfficialSurveyButton);
        webDriver.findElement(AddOfficialSurveyButton).click();
    }
    public void EnterTitle(String TitleOfSurvey){
        WaitUntilElementBeLoketed(4,Title);
        webDriver.findElement(Title).sendKeys(TitleOfSurvey);
    }
    public void EnterDescription(String DescriptionOfSurvey){
        WaitUntilElementBeLoketed(4,Description);
        webDriver.findElement(Description).sendKeys(DescriptionOfSurvey);
    }
    public void EnterTextOfFirstQuestion(String TextOfQuestion){
        WebDriverWait wait = new WebDriverWait(webDriver,4);
        WebElement FirstQuestionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/section/section/main/div/form/div[2]/ol/li/div[2]/div/span[1]/input")));
        FirstQuestionInput.sendKeys(TextOfQuestion);
    }
    public void EnterTextToAnswerOptions(String Answer1, String Answer2){
        WebDriverWait wait = new WebDriverWait(webDriver,4);
        WebElement AnswerOption1 = webDriver.findElement(By.xpath("//input[@name='questionDtoList[0].optionList[0].text']"));
        WebElement AnswerOption2 = webDriver.findElement(By.xpath("//input[@name='questionDtoList[0].optionList[1].text']"));
        AnswerOption1.sendKeys(Answer1);
        AnswerOption2.sendKeys(Answer2);
    }
    public void ClickOnTheCreateSurveyButton(){
        WaitUntilElementBeLoketed(4,CreateSurveyButton);
        webDriver.findElement(CreateSurveyButton).click();
    }
    public void GoToPuslesTab(){
        WaitUntilElementBeLoketed(4,PulseTab);
        webDriver.findElement(PulseTab).click();
    }
    public void ClickOnAddPulseButton(){
        WaitUntilElementBeLoketed(4,AddPulseButton);
        webDriver.findElement(AddPulseButton).click();
    }
    public void EnterQuestionforPulse(String PulseQuestion){
        WebDriverWait wait = new WebDriverWait(webDriver,4);
        WebElement PulseQuestionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/section[contains(@class,'main-wrapper ant-layout ant-layout-has-sider')]/section[contains(@class,'ant-layout')]/main[contains(@class,'ant-layout-content')]/div[contains(@class,'f-column')]/form[contains(@class,'survey-edit-form flex')]/div[contains(@class,'survey-edit-form-right-side card')]/ol/li/div[contains(@class,'form-group--counter')]/div[contains(@class,'form-control-wrapper')]/span[contains(@class,'text-input ant-input-affix-wrapper')]/input[1]")));
        PulseQuestionInput.sendKeys(PulseQuestion);
    }
    public void ClickONTheCreatePusleButton(){
        WaitUntilElementBeLoketed(4,CreatePulseButton);
        webDriver.findElement(CreatePulseButton).click();
    }
    public void GotoRandomPulse(){
        WaitUntilElementBeLoketed(4,By.xpath("//tr[1]//td[2]"));
        int Random = (int) (Math.random() *10);
        System.out.println(Random);
        List<WebElement> ListOfPulses = new ArrayList();
        for (int i =1; i< 10; i++){
            WebElement Pulse = webDriver.findElement(By.xpath("//tr["+ i +"]//td[2]"));
            ListOfPulses.add(Pulse);
        }
        ListOfPulses.get(Random).click();
    }

    public void ClickOnTheCompletePulseButton(){
       WaitUntilElementBeLoketed(4,CompleteSurveyButton);
       webDriver.findElement(CompleteSurveyButton).click();
    }
    public void ClickOnTheComplete_ReOpenConfirmationButton(){
        WaitUntilElementBeLoketed(4,By.xpath("//div[contains(@class,'ant-modal-content')]"));
        WebElement ConfirmationButton = webDriver.findElement(By.xpath("//div[contains(@class,'ant-modal-footer')]//button[contains(@class,'btn-default btn-default-success ant-btn-default')]"));
        ConfirmationButton.click();

    }
    public void ClickOnTheDeleteSurveyButton(){
        WaitUntilElementBeLoketed(4,DeleteSurveyButton);
        webDriver.findElement(DeleteSurveyButton).click();
    }
    public void ClickOnTheDeleteSurveyConfirmation(){
        WaitUntilElementBeLoketed(4,By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]"));
        webDriver.findElement(By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]")).click();
    }
    public void GotoUserSurveysTab(){
        WaitUntilElementBeLoketed(4,UserSurveysTab);
        webDriver.findElement(UserSurveysTab).click();
    }
    public void GotoRandomUserSurvey(){
        WaitUntilElementBeLoketed(4,By.xpath("//tr[1]//td[2]"));
        int Random = (int) (Math.random() *10);
        System.out.println(Random);
        List<WebElement> ListOfPulses = new ArrayList();
        for (int i =1; i< 10; i++){
            WebElement Pulse = webDriver.findElement(By.xpath("//tr["+ i +"]//td[2]"));
            ListOfPulses.add(Pulse);
        }
        ListOfPulses.get(Random).click();
    }
    public void ClcikOnTheCloneSurveyButton(){
        WaitUntilElementBeLoketed(4,CloneSurveyButton);
        webDriver.findElement(CloneSurveyButton).click();
    }
    public void ClickOnTheBackToLiveButton(){
        WaitUntilElementBeLoketed(4,BackToLiveSurveyButton);
        webDriver.findElement(BackToLiveSurveyButton).click();
    }
    public void ClcikOnTheEditDraftButton(){
        WaitUntilElementBeLoketed(4,EditDraftbutton);
        webDriver.findElement(EditDraftbutton).click();
    }
    public void ClickOnThePublishDraftbutton(){
        WaitUntilElementBeLoketed(4,PublishDraftButton);
        webDriver.findElement(PublishDraftButton).click();
    }
    public void GotoSurveyWithModerationStatus(){
        WaitUntilElementBeLoketed(4,By.xpath("//tr[1]//td[7]"));
        List<WebElement> ListOfSurveyStatus = new ArrayList();
        for (int i =1; i< 17; i++){
            WebElement Status = webDriver.findElement(By.xpath("//tr["+ i +"]//td[7]"));
            ListOfSurveyStatus.add(Status);
        }
        for (int i =1; i< ListOfSurveyStatus.size(); i++){
            if(ListOfSurveyStatus.get(i).getText().equals("In Moderation")){
                ListOfSurveyStatus.get(i).click();
            }

           }
        }

        public void ClckOnTheAprroveSurveyButton(){
        WaitUntilElementBeLoketed(4, ApproveSurveyButton);
        webDriver.findElement(ApproveSurveyButton).click();
        }
        public void ClickOnTheRejectSurveyButton(){
        WaitUntilElementBeLoketed(4,RejectSurveyButton);
        webDriver.findElement(RejectSurveyButton).click();
        }
        public void EnterReasonOfRejection(String ReasonOfRejection){
        WaitUntilElementBeLoketed(4,By.xpath("//textarea[contains(@placeholder,'Enter a reason')]"));
        webDriver.findElement(By.xpath("//textarea[contains(@placeholder,'Enter a reason')]")).sendKeys(ReasonOfRejection);
        }
        public void ConfirmRejection(){
        WaitUntilElementBeLoketed(4,By.xpath("//div[contains(@class,'ant-modal-content')]"));
        webDriver.findElement(By.xpath("//div[@class='ant-modal-footer']/button[2]")).click();
        }



    }






