package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OffenciveWordsPage {
      WebDriver webDriver;
      public OffenciveWordsPage(WebDriver webDriver){
          this.webDriver = webDriver;
      }
       By OffenciveWordsInput = By.xpath("//input");
       By AddOfeenciveWordButton = By.xpath("//div[@class='offensive-words-page__field']/button");
       By OffenciveWordDeleteButton = By.xpath("//span[@class='ant-tag c-tag']/span");
       By OffenciveWord = By.xpath("//span[@class='ant-tag c-tag']");




      public void WaitVisabilityOfElement(int time, By locator){
          WebDriverWait wait = new WebDriverWait(webDriver,time);
          wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      }

      public OffenciveWordsPage EnterNewOffencivewordInInput(String OffenciveWord){
          WaitVisabilityOfElement(4,OffenciveWordsInput);
          webDriver.findElement(OffenciveWordsInput).sendKeys(OffenciveWord);
          return this;
      }
      public OffenciveWordsPage ClcikOnAddOfenciveWordButton(){
          WaitVisabilityOfElement(4,AddOfeenciveWordButton);
          webDriver.findElement(AddOfeenciveWordButton).click();
          return this;
      }
      public OffenciveWordsPage ClcikOnDeleteButtonFromListofWords(){
          WaitVisabilityOfElement(4,OffenciveWordDeleteButton);
          List<WebElement> ListOfdeleteButtons = webDriver.findElements(OffenciveWordDeleteButton);
          ListOfdeleteButtons.get(0).click();
          return this;

      }

}
