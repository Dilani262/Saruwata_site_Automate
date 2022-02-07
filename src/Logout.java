/*
public class Logout {*/
/*//*
/..........LOGOUT.................
            WebElement temp = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/ul/li[1]/ul"));
            actions.moveToElement(temp).click().perform();
            System.out.println(".....Mouse is moved to my account....");

            WebElement logout = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/ul/li[1]/ul"));
            logout.click();
            System.out.println(".....Mouse is moved to lgout....");
           *//*
*/
/*actions.moveToElement(temp).perform();
           actions.click();
            System.out.println(".....Mouse is moved to my account....");

*//*
*/
/*
 *//*
*/
/*  WebElement logout = driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/ul/li[1]/ul"));
            logout.isDisplayed();
            actions.moveToElement(logout).click();
            actions.perform();
            System.out.println(".....Clicked on Logout....");

            if (UR.equals(driver.getCurrentUrl())) {
                driver.findElement(By.xpath("/html/body/header/div/div/div[4]/div/ul/li[1]/ul/li[2]/a")).click();

                if (driver.findElement(By.xpath("/html/body/form/div/div/div[2]/div[1]/div[1]")).isDisplayed()) {
                    System.out.println("Your successfully Logged out");
                }
            } else {
                System.out.println("No Log out option is there");
            }
*//*

}
*/
