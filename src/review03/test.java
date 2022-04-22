package review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {
    public static String url = "https://www.aa.com/en-us/flights?c=SEM%7CMSFT%7Calways_on%7CMKT%7CUSM%7CTXT%7Camerican%20airlines%7CUS_US_MKT_Bing_Brand_X_National_X_EN_X$$&msclkid=060ba2ce0a8a18c4aa5dc096150ba93a";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver,20);//define explicit wait

        WebElement depart=driver.findElement(By.id("em__b-UID__booking-departure"));
        depart.click();
        WebElement next= driver.findElement(By.cssSelector("button[aria-label*='Next Month, June 2022']"));
        next.click();
        WebElement dayD= driver.findElement(By.cssSelector("div[aria-label*='Thu May 12, 2022']"));
        dayD.click();
        WebElement retu=driver.findElement(By.id("em__b-UID__booking-return"));
        retu.click();
        WebElement next2= driver.findElement(By.cssSelector("button[aria-label*='Next Month, July 2022']"));
        next2.click();
        WebElement dayR= driver.findElement(By.cssSelector("div[aria-label*='Wed Jul 6, 2022']"));
        dayR.click();

        WebElement from=driver.findElement(By.xpath("//div[text()='City or airport']"));

        from.sendKeys("indianapolis");
        WebElement indy=driver.findElement(By.xpath("//div[text()='IND - Indianapolis International']"));

        if(indy.isDisplayed()) {
            indy.click();
        }

        WebElement to=driver.findElement(By.id("em__b-UID__booking-destination-selector-container"));
        to.click();
        to.sendKeys("tampa");
        WebElement tpa=driver.findElement(By.xpath("//div[text()='TPA - Tampa International']"));
        if(tpa.isDisplayed()){
            tpa.click();
        }


    }
}
