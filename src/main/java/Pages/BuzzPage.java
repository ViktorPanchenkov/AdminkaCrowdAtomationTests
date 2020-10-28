package Pages;

import org.apache.hc.core5.http.protocol.UriPatternMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BuzzPage {

    WebDriver webDriver;

    public BuzzPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By SearchField = By.xpath("//input[@placeholder='Search...']");
    By AddBuzzButton = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[2]/button");
    By Title = By.xpath("//input[@name='title']");
    By Description = By.xpath("//textarea[@name='description']");
    By PDFInput = By.xpath("//div[contains(@class,'form-control-download')]/input[1]");
    By URLField = By.xpath("//input[@name='webURL']");
    By Savebutton = By.xpath("//div[@class='category-header-cmp-control-btns-block']/button");
    By EditBuzzButton = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[1]/div[1]/div/button[2]");
    By DeleteCoverImageButton = By.xpath("//div[@class='preview-block f-s-sb']/button");
    By DeleteBuzzButton = By.xpath("//*[@id=\"root\"]/section/section/main/div/div[1]/div[1]/div/button[1]");
    By DeleteConfirmationButton = By.xpath("//div[@class='ant-modal-footer']/button[2]");


    public void WaitUntilElementBeLoketed(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void SearchBuzz(String TitleOfBuzz){
        WaitUntilElementBeLoketed(4,SearchField);
        webDriver.findElement(SearchField).sendKeys(TitleOfBuzz);
    }
    public void GoToFirstFoundItem(String nameOfBuzz){
        WebElement FoundBuzz = webDriver.findElement(By.xpath("//td/span[contains(text()," + "'" + nameOfBuzz + "')]"));
        FoundBuzz.click();
    }

    public void EnterTextinTheSearchfield(String NameOfBuzz){
        WaitUntilElementBeLoketed(4,SearchField);
        webDriver.findElement(SearchField).sendKeys(NameOfBuzz);
    }

    public void ClickOnTheAddBuzzbutton(){
        WaitUntilElementBeLoketed(4, AddBuzzButton);
        webDriver.findElement(AddBuzzButton).click();
    }
    public void EnterBuzzTitle(String BuzzTitle){
        WaitUntilElementBeLoketed(4, Title);
        webDriver.findElement(Title).clear();
        webDriver.findElement(Title).sendKeys(BuzzTitle);
    }
    public void EnterDescription(String BuzzDescription){
        WaitUntilElementBeLoketed(4, Description);
        webDriver.findElement(Description).clear();
        webDriver.findElement(Description).sendKeys(BuzzDescription);
    }
    public void AddCoverImage(String PathToImage){
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        webDriver.findElement(By.xpath("//div[contains(@class,'cropper-cmp')]//input")).sendKeys(PathToImage);
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
        if(popup.isDisplayed()){
            WebElement CroupButton =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-footer']/button[2]")));
            CroupButton.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]")));
        }
    }
    public void AddPDFFile()
    {
      webDriver.findElement(PDFInput).sendKeys("/home/user/Downloads/Wireframing (4).pdf");
      WaitUntilElementBeLoketed(4,By.xpath("//span[contains(text(),'pdf.pdf')]"));
    }
    public void AddUrl(String URL){
        WaitUntilElementBeLoketed(4, URLField);
        webDriver.findElement(URLField).sendKeys(URL);
    }
    public void ClickonTheSaveButton(){
        WaitUntilElementBeLoketed(4, Savebutton);
        webDriver.findElement(Savebutton).click();
    }
    public void GoToRandomBuzz(){
        int Random = (int) (Math.random() *10);
        WaitUntilElementBeLoketed(4,AddBuzzButton);
        List<WebElement> ListOfBuzzes = new ArrayList<WebElement>();
        System.out.println(Random);
        for(int i = 1; i< 10; i++){
            ListOfBuzzes.add(webDriver.findElement(By.xpath("//tr["+i+"]//td[2]")));

        }
        ListOfBuzzes.get(Random).click();
    }
    public void ClickOnTheEditBuzzButton(){
        WaitUntilElementBeLoketed(4,EditBuzzButton);
        webDriver.findElement(EditBuzzButton).click();
    }
    public void ClickOnTheDeleteCoverImageButton(){
        WaitUntilElementBeLoketed(4,DeleteCoverImageButton);
        webDriver.findElement(DeleteCoverImageButton).click();
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]")));

    }
    public void ClickOnTheDeleteButton(){
        WaitUntilElementBeLoketed(4,DeleteBuzzButton);
        webDriver.findElement(DeleteBuzzButton).click();
    }
    public void ClickOnTheDeleteConfirmationButton(){
        WaitUntilElementBeLoketed(4,By.xpath("//div[contains(@class,'ant-modal-content')]"));
        webDriver.findElement(DeleteConfirmationButton).click();
    }




}
