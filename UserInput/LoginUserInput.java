import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Instant;
import java.util.Scanner;

public class LoginUserInput {
    WebDriver driver;


    @Test
    public void test_login_userinput() throws InterruptedException {

/*
        System.out.println("Start");
        Scanner scn = new Scanner(System.in);
*/


        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata.site/Account/Login");
        WebDriverWait wait = new WebDriverWait(driver,0);


      /*  String umail = scn.nextLine();
        String pass = scn.nextLine();*/


        if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/div[1]")).isDisplayed()) {

            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("dilani");

            driver.findElement(By.id("title")).clear();
            driver.findElement(By.id("title")).sendKeys("dil");

       
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div/div/div[2]/div[2]/div[2]/div/button"))).click();


            String URL = "https://saruwata.site/Classified/ClassifiedIndex";
            driver.getCurrentUrl();

            if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {
                System.out.println("Test is passed , Login Successfully");
            } else {
                System.out.println("Test is Failed,Try to login again");
            }
        }

    }
}