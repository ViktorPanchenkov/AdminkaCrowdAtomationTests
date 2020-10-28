import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StayInTouchEmailsPage {

    WebDriver webDriver;
    public StayInTouchEmailsPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By DeleteButton = By.xpath("//td[@class='cell-ellipsis  without-redirect']/button");
    By UnsubscribedTab = By.xpath("//h3[contains(text(),'Unsubscribed')]");

    public void WaitUntilElementLocated(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void ClickOnTheDeleteButtonFromList(){
    WaitUntilElementLocated(4,DeleteButton);
        List<WebElement> ListOfDeleteButtons = webDriver.findElements(DeleteButton);
        ListOfDeleteButtons.get(0).click();
    }
    public void GotoUnsubscribedTab(){
        WaitUntilElementLocated(4,UnsubscribedTab);
        webDriver.findElement(UnsubscribedTab).click();
    }
}
