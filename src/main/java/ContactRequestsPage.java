import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class ContactRequestsPage {
    WebDriver webDriver;
    public ContactRequestsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    By SearchField = By.xpath("//input[@placeholder='Search...']");
    By SolvedTab = By.xpath("//h3[contains(text(),'Solved')]");
    By CanselButton = By.xpath("//div[@class='ant-modal-footer']/button");

    public void WaitUntilElementLocated(int time,By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void ClickOnTheFirstSolevedButton(){
        WaitUntilElementLocated(4,By.xpath("//td[@class='cell-ellipsis  without-redirect']/button"));
        List<WebElement> ListOfSoleButtons = webDriver.findElements(By.xpath("//td[@class='cell-ellipsis  without-redirect']/button"));
        ListOfSoleButtons.get(0).click();
    }
    public void ClickOnFirstRequestFromList(){
      WaitUntilElementLocated(4,By.xpath("//tr[@class='hoverable']"));
      List<WebElement> ListOfContacrRequests = webDriver.findElements(By.xpath("//tr[@class='hoverable']"));
      ListOfContacrRequests.get(0).click();
    }
    public void GotoSolvedTab(){
    WaitUntilElementLocated(4,SolvedTab);
    webDriver.findElement(SolvedTab).click();
    }
    public void ClickOnCanselButton(){
        WaitUntilElementLocated(4,CanselButton);
        webDriver.findElement(CanselButton).click();
    }
}
