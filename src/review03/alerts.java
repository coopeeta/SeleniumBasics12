package review03;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class alerts {
    public static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

//        find the alert and click on it
        WebElement SimpleAlert=driver.findElement(By.xpath("//button[@onclick=\"myAlertFunction()\"]"));
        SimpleAlert.click();
//        handling the alert
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

//
        WebElement jsalert = driver.findElement(By.xpath("//button[@onclick='myPromptFunction()']"));
        jsalert.click();
        Thread.sleep(2000);
        driver.switchTo().alert();

        Thread.sleep(4000);
        alert.sendKeys("hello everyone !!!");
        alert.accept();


    }
}
