import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Login {

    public static WebDriver driver;

    @Test(priority = 1)
    public void test_login_valid() {

        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata.site/Account/Login");
        System.out.println(driver.getTitle());
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 0);

        if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/div[1]")).isDisplayed()) {

            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("dilani+15@mimobimedia.com");

            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("Test@123");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div/div/div[2]/div[2]/div[2]/div/button"))).click();

            String URL = "https://saruwata.site/Classified/ClassifiedIndex";
            String UR = driver.getCurrentUrl();

            if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {
                System.out.println("Test is passed , Login Successfully");
            }
            else {
                System.out.println("Test is Failed,Try to login again");
            }
           return;
        }
    }

    //@Test(priority = 2)
    public void test_blank_field() {
        driver.get("https://saruwata.site/Account/Login");
        WebElement umail = driver.findElement(By.id("email"));
        WebElement upass = driver.findElement(By.id("title"));

        umail.sendKeys("");
        upass.sendKeys("");

        String msg = umail.getAttribute("validationMessage");
        String msg2 = upass.getAttribute("validationMessage");
        String Warning = "Please fill out this field.";
      /*  System.out.println(msg);
        System.out.println(upass);*/


        if (msg.equals(Warning) & msg2.equals(Warning) && msg.equals(Warning) | msg2.equals(Warning)) {
            System.out.println("This fields are required fill to login");
        } else {
            System.out.println("You can't log, Check attributes of locator");
        }
    }

}