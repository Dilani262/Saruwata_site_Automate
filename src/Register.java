import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Register {
    WebDriverWait wait;

    @Test
    public void register_test() {

        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata-uat.azurewebsites.net/Account/Register");
        System.out.println(driver.getTitle());

        driver.findElement(By.id("fname")).clear();
        driver.findElement(By.id("fname")).sendKeys("DilaniTest16");

        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("dilani+31@mimobimedia.com");

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("Test@123");

        driver.findElement(By.id("cPsw")).clear();
        driver.findElement(By.id("cPsw")).sendKeys("Test@123");

        Boolean isenabled = driver.findElement(By.id("signupBtn")).isEnabled();

        if (isenabled) {
            System.out.println("Form filled");

            driver.findElement(By.id("signupBtn")).click();
            System.out.println(" clicked");
            //    System.out.println(" Test is passed,Check Your mail");

            String URL = "https://saruwata-uat.azurewebsites.net/Account/sucess?RegisterSuccessMsg=Successfully%20created%20new%20account!%20Log%20into%20new%20account&buttion=Back%20to%20home&header=Successfully%20Registered&LoginMsg=Welcome%20to%20saruwata.lk";

            if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {
                System.out.println("Successfully Registered ! ");
            }

            WebElement same = driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[2]/strong"));
            String samealert = same.getText();

            if (samealert.equalsIgnoreCase("User Already Exists")) {
                Assert.fail("..OH..! Already You are register with the same credential");
            }

            if (samealert.equalsIgnoreCase("Error")) {
                Assert.fail("..OH..! Page error occured");
            } else {

                System.out.println("No Register Option here");
            }

        }
    }

}
     /*   else {
        try {
        if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[2]")).isDisplayed()) ;
        } catch (Exception e) {
        System.out.println("Error is" + e.getMessage());
        System.out.println("Error is" + e.getCause());
        }*/