import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Home {

    WebDriver driver;
    WebDriverWait wait;

    @Test(priority = 1)
    public void test_home_func() {
        System.setProperty("webdriver.gecko.driver", "/home/admin123/Desktop/Selenium/geckodriver-v0.30.0-linux32/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://saruwata-uat.azurewebsites.net/Classified/ClassifiedIndex");
        System.out.println(driver.getTitle());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        //FAQ
        driver.findElement(By.linkText("FAQ")).click();
        String faq = "https://saruwata-uat.azurewebsites.net/home/faq";
        WebElement content = driver.findElement(By.xpath("//*[@id=\"faq\"]"));

        if (faq.equalsIgnoreCase(driver.getCurrentUrl()) & content.isDisplayed()) {
            System.out.println("FAQ page shows successfully & Not empty content ");
            driver.navigate().back();
        } else {
            Assert.fail("FAQ page shows unsuccessfully or empty content ");
            driver.navigate().back();
        }

        //Terms & Conditions

        driver.findElement(By.linkText("Terms & Conditions")).click();
        String con = "https://saruwata-uat.azurewebsites.net/home/terms";
        WebElement content2 = driver.findElement(By.xpath("/html/body/div[5]/div"));

        if (con.equalsIgnoreCase(driver.getCurrentUrl()) & content2.isDisplayed()) {
            System.out.println("Term and condition page shows successfully & Not empty content ");
            driver.navigate().back();
        } else {
            Assert.fail("Term and condition page shows unsuccessfully or empty content ");
            driver.navigate().back();
        }

        //Privacy Policy
        driver.findElement(By.linkText("Privacy Policy")).click();
        String privacy = "https://saruwata-uat.azurewebsites.net/home/privacy";
        WebElement content3 = driver.findElement(By.xpath("/html/body/div[5]/div"));

        if (privacy.equalsIgnoreCase(driver.getCurrentUrl()) & content3.isDisplayed()) {
            System.out.println("Privacy Policy page shows successfully & Not empty content ");
            driver.navigate().back();
        } else {
            Assert.fail("Privacy Policy page shows unsuccessfully or empty content ");
            driver.navigate().back();
        }

        //Membership
        WebElement member = driver.findElement(By.linkText("Membership"));
        member.click();
        Login login = new Login();

        // For Guest User
        if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/div[1]")).isDisplayed()) {
            System.out.println("Hi you are guest user, Please login first");

            //login
            if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/div[1]")).isDisplayed()) {

                driver.findElement(By.id("email")).clear();
                driver.findElement(By.id("email")).sendKeys("dilani+15@mimobimedia.com");

                driver.findElement(By.id("title")).clear();
                driver.findElement(By.id("title")).sendKeys("Test@123");

                driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[2]/div[2]/div/button")).click();

                //in membership page

                String URL = "https://saruwata-uat.azurewebsites.net/classified/membership";
                WebElement req = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div/div[1]"));
                String UR = driver.getCurrentUrl();

                if (URL.equalsIgnoreCase(driver.getCurrentUrl())) {
                    System.out.println("Login Successfully & you are in membership page");

                    js.executeScript("arguments[0].scrollIntoView();", req);

                    //membership req form
                    if (driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div")).isDisplayed()) {
                        //fill form
                        WebElement name = driver.findElement(By.id("BusinessName"));
                        name.sendKeys("Test");
                        Select list = new Select(driver.findElement(By.id("BusinessVerticalId")));
                        list.selectByValue("18");
                      //  list.selectByVisibleText("Classifieds");
                        WebElement email = driver.findElement(By.id("MembershipRequest_EmailAddress"));
                        email.sendKeys("dilani+15@mimobimedia.com");
                        WebElement mobile = driver.findElement(By.id("BusinessPhone"));
                        mobile.sendKeys("0710454882");
                        Select list2 = new Select(driver.findElement(By.name("MembershipRequest.DistrictId")));
                        list2.selectByVisibleText("COLOMBO");

                        String namealert = name.getAttribute("validationMessage");
                        String mailalert = name.getAttribute("validationMessage");
                        String mobilealert = name.getAttribute("validationMessage");

                        driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div/div[3]/div/div[6]/button")).click();
                        String alert = "Please fill the All fileds";

                        if (namealert.equalsIgnoreCase(alert) & mailalert.equalsIgnoreCase(alert) & mobilealert.equalsIgnoreCase(alert)) {
                            Assert.fail("Please fill the All fields");

                        }
                         driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div")).isDisplayed();
                        {
                            System.out.println("Your membership request is Sent");
                        }
                    }
                    else {
                        Assert.fail("Membership Req form is not displayed");
                    }
                    //membership process need to add
                }
            }
        }
    }
}
