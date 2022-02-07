import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class RegisterUserInput {

    @Test
    public void register_test_userinput() {

        System.out.println("Start");
        Scanner scn = new Scanner(System.in);


        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata-uat.azurewebsites.net/Account/Register");
        System.out.println(driver.getTitle());

        String name = scn.nextLine();
        String uemail = scn.nextLine();
        String pass = scn.nextLine();
        String cpass = scn.nextLine();


        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("name");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("uemail");

        driver.findElement(By.id("password")).clear();
        WebElement element = driver.findElement(By.id("password"));
        element.sendKeys("pass");

        driver.findElement(By.id("cPsw")).clear();
        WebElement element2 = driver.findElement(By.id("cPsw"));
        element.sendKeys("cpass");

        Assert.assertEquals(element, element2, "Passowrd not matched");

        boolean isenabled = driver.findElement(By.id("signupBtn")).isEnabled();

        if (isenabled) {
            System.out.println("Form filled");
            driver.findElement(By.id("signupBtn")).click();

            String URL = "https://saruwata-uat.azurewebsites.net/Account/sucess?RegisterSuccessMsg=Successfully%20created%20new%20account!%20Log%20into%20new%20account&buttion=Back%20to%20home&header=Successfully%20Registered&LoginMsg=Welcome%20to%20saruwata.lk";

            if (URL.equals(driver.getCurrentUrl())) {
                System.out.println(" Test is passed,Check Your mail");
            } else {

                System.out.println("Test is Fail, Retry to register");
            }

        }


      /*  WebElement element3 = driver.findElement(By.id("signupBtn"));
        if(element3.isEnabled())
        {
        System.out.println("password Matched");
        driver.findElement(By.id("signupBtn")).click();



        if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {

        }  */
        else {

            System.out.println("Test is Fail, Retry to register");
        }

    }

}
