import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPagePositiveScenarios {

    WebDriver webDriver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    public static WebDriverWait wait;
    CategoriesPage categoriesPage;


    @Before
    public void SetUP(){
        System.setProperty("webdriver.chrome.driver", "/home/user/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.88.89/");
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver,4);
        dashboardPage = new DashboardPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
        webDriver.manage().window().maximize();


        String Phone = "+1111111111";
        String Password = "qwerty";
        loginPage.TypePhone(Phone);

        loginPage.TypePassword(Password);
        loginPage.ClickOnTheLoginButton();
        dashboardPage.GotoCategoriesTab();


    }

    @Test
    public void AddNewCategory(){
        int Random = (int) (Math.random() * 10);
        String CategoryTitle = "Selenium" + Random;
      categoriesPage.ClickOnTheAddCategoryButton();
      categoriesPage.EnterTitle(CategoryTitle);
      categoriesPage.AddCoverImage();
      categoriesPage.AddCategoryIcon();
      categoriesPage.ClcikOnTheCreateCategoryButton();

      try {
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Category created successfully')]")));
          Assert.assertTrue(true);
          return;
      } catch (TimeoutException TimeOut){
          Assert.fail("Category was not Created!");
      }
    }
    @Test
    public void EditCategory(){
        String NewTitle = "Updated Category";
       categoriesPage.ClickOnTheRandomEditButton();
       categoriesPage.EnterTitle(NewTitle);
       categoriesPage.ClcikOnTheCreateCategoryButton();

       try {
           wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'Category updated successfully')]"),"Category updated successfully"));
           Assert.assertTrue(true);
           return;
       } catch (TimeoutException TimeOut){
           Assert.fail("Category was not updated!");
       }
    }
    @Test
    public void DeleteCategory(){

     categoriesPage.ClickOnDeleteCategoryButton();
     categoriesPage.ClickonConfirmationButton();
     try {
         wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[contains(text(),'Category deleted successfully')]"),"Category deleted successfully"));
         Assert.assertTrue(true);
         return;
     } catch (TimeoutException Timeout){
         Assert.fail("Category was not deleted!");
     }

    }
    @After
    public void Quit(){
        webDriver.quit();
    }
}
