package review03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class waits {
    public static String url = "http://syntaxprojects.com/dynamic-elements-loading.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement btn = driver.findElement(By.id("startButton"));
        btn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Welcome')]")));
        WebElement WelcomeMsg=driver.findElement(By.xpath("//*[contains(text(), 'Welcome Syntax')]"));
        System.out.println(WelcomeMsg.getText());


    }
}
