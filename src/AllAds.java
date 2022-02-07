import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AllAds {

    WebDriver driver;
    String all = "https://saruwata-uat.azurewebsites.net/Ad/GetAdsByCategoryAndProduct";

    @Test(priority = 1)
    public void test_all_ads() {

        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata-uat.azurewebsites.net/Classified/ClassifiedIndex");
        System.out.println(driver.getTitle());

        if (driver.findElement(By.xpath("/html/body/div[2]/div/section/div[2]/div[1]/div[1]")).isDisplayed()) {
            System.out.println("You are in Home page");
            driver.findElement(By.xpath("/html/body/header/div/div/div[2]/ul/li/a")).click();

            if (driver.getCurrentUrl().equalsIgnoreCase(all)) {
                System.out.println("You can see all the ads");
            }
        }
    }

    // Search option
    @Test(priority = 2)
    public void test_search()
    {

        WebElement search = driver.findElement(By.id("adSearchInputClick"));

        if((driver.getCurrentUrl().equalsIgnoreCase(all) & search.isDisplayed()))
        {
            System.out.println("Search option is available");

            //Search start

            search.sendKeys("Land", "Motor");
            driver.findElement(By.id("adSearchBtn")).click();
            System.out.println("Check the all Land are filtered");
        }
        else{
            System.out.println("Web Page URL Wrong or NO Search Function");
        }

    }

}
