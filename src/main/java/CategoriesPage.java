import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoriesPage {
    WebDriver webDriver;
    public CategoriesPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    By SearchField = By.xpath("//input[@placeholder='Search...']");
    By AddCategoryButton = By.xpath("//div[@class='search-block f-c-s']/button");
    By Title = By.xpath("//input[@name='categoryName']");
    By CoverImageInput = By.xpath("//div[contains(@class,'ant-modal-body')]//div[2]//div[1]//div[1]//div[1]//div[2]//input[1]");
    By CategoryIcon = By.xpath("//div//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]");
    By Create_UpdateCategoryButton = By.xpath("//div[@class='ant-modal-footer']/button[2]");
    By DeleteCategoryButton = By.xpath("//div[@class='category-card-buttons']/button[1]");
    By ConfirmationDeleteButton = By.xpath("//body/div[4]/div[1]/div[2]/div[1]/div[2]/div[3]/button[2]");
    By EditCategoryButton = By.xpath("//div[@class='category-card-buttons']/button[2]");



    public void WaitUntilElementLocated(int time, By locator){
        WebDriverWait wait = new WebDriverWait(webDriver,time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void ClickOnTheAddCategoryButton(){
        WaitUntilElementLocated(4,AddCategoryButton);
        webDriver.findElement(AddCategoryButton).click();
    }
    public void EnterTitle(String TitleofCategory){
        WaitUntilElementLocated(4,Title);
        webDriver.findElement(Title).clear();
        webDriver.findElement(Title).sendKeys(TitleofCategory);
    }
    public void AddCoverImage(){
        webDriver.findElement(CoverImageInput).sendKeys("/home/user/Desktop/гребля.jpg");
        WebDriverWait wait =new WebDriverWait(webDriver,8);
        WebElement PopUP = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
        if(PopUP.isDisplayed()){

            WebElement CroupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]")));
            CroupButton.click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'preview-block f-s-sb')]//img")));
        }
        public void AddCategoryIcon(){
            WebDriverWait wait =new WebDriverWait(webDriver,8);
            webDriver.findElement(CategoryIcon).sendKeys("/home/user/Desktop/гребля.jpg");
            WebElement PopUP2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-modal-content']")));
            if(PopUP2.isDisplayed()){

                WebElement CroupButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/div[3]/button[2]")));
                CroupButton.click();
            }
            WebElement img2 =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/form/div[3]/div/div/div[2]/div")));
        }
        public void ClcikOnTheCreateCategoryButton(){
        WaitUntilElementLocated(4,Create_UpdateCategoryButton);
        webDriver.findElement(Create_UpdateCategoryButton).click();
        }
        public void ClickOnTheRandomEditButton(){
        int Random = (int) (Math.random() *10);
        WaitUntilElementLocated(4,EditCategoryButton);
            List<WebElement> ListOfEditButtons = webDriver.findElements(EditCategoryButton);
            ListOfEditButtons.get(Random).click();
        }
        public void ClickOnDeleteCategoryButton(){
            WaitUntilElementLocated(4,DeleteCategoryButton);
            List<WebElement> ListofDeleteButtons = webDriver.findElements(DeleteCategoryButton);
            ListofDeleteButtons.get(1).click();
        }

    public CategoriesPage ClickonConfirmationButton(){
        WaitUntilElementLocated(4,By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]"));
        webDriver.findElement(By.xpath("//div[contains(@class,'ant-modal-root')]//button[2]")).click();
        return  this;
    }

    }

