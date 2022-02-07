import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FbLogin {

    public static WebDriver driver;

    @BeforeTest
    public void test_start() {

        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata.site/Account/Login");
        System.out.println(driver.getTitle());

    }

    @Test(priority = 1)
    public void test_log_valid() {

        //     WebDriver driver = null;

        driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[2]/div[2]/div/input[1]")).click();

        if (driver.findElement(By.xpath("//*[@id=\"header_block\"]/span/div")).isDisplayed()) {

            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys("dilanitharanga95@gmail.com");

            driver.findElement(By.id("pass")).clear();
            driver.findElement(By.id("pass")).sendKeys("1024fb27");

            driver.findElement(By.id("loginbutton")).click();

            String URL = "https://saruwata.site/Classified/ClassifiedIndex";

            if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {
                System.out.println("Test is passed , Logged through FB Successfully");
            } else {
                System.out.println("Test is Failed,Try again to login Through FB");
            }
        }
    }

    @Test(priority = 2)
    public void test_create() {

        //     WebDriver driver = null;

        if (driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/span/a")).isDisplayed()) {

            driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div/div/span/a")).click();

            String URL2 = "https://www.facebook.com/r.php?locale=en_GB";

            if (URL2.equals(driver.getCurrentUrl())) {

                driver.findElement(By.name("firstname")).clear();
                driver.findElement(By.name("firstname")).sendKeys("Test");

                driver.findElement(By.name("lastname")).clear();
                driver.findElement(By.name("lastname")).sendKeys("Account");

                driver.findElement(By.name("reg_email__")).clear();
                driver.findElement(By.name("reg_email__")).sendKeys("dilani@gmail.com");

                driver.findElement(By.name("reg_email_confirmation__")).clear();
                driver.findElement(By.name("reg_email_confirmation__")).sendKeys("dilani@gmail.com");

                driver.findElement(By.name("reg_passwd__")).clear();
                driver.findElement(By.name("reg_passwd__")).sendKeys("Test@123");

                driver.findElement(By.name("reg_passwd__")).clear();
                driver.findElement(By.name("reg_passwd__")).sendKeys("Test@123");


                if (driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[5]/div[1]")).isDisplayed()) {

                    new Select(driver.findElement(By.name("birthday_day"))).selectByVisibleText("21");
                    driver.findElement(By.name("birthday_day")).click();

                    new Select(driver.findElement(By.name("birthday_month"))).selectByVisibleText("Nov");
                    driver.findElement(By.name("birthday_month")).click();

                    new Select(driver.findElement(By.name("birthday_year"))).selectByVisibleText("1995");
                    driver.findElement(By.name("birthday_year")).click();

                }
                if (driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[7]/div[1]")).isDisplayed()) {

                    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/label")).click();
                }



                System.out.println("FIll ACCOUNT");
            }
        }

    }

}