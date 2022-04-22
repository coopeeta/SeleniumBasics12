package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class reviewtable3 {

    public static String url = "https://www.aa.com/homePage.do?locale=en_US";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//click on the calendrr to open it
        WebElement calander = driver.findElement(By.xpath("//label[@for='aa-leavingOn']/following-sibling::button"));
        calander.click();


//        check if month is july
        boolean found=false;
        while(!found) {
            //        find the month
            WebElement month = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
            String month_ = month.getText();
            if (month_.equals("July")) {
                List<WebElement> days = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"));
                for(WebElement day:days){
                    String dd = day.getText();
                    if(dd.equals("25")){
                        day.click();
                        break;
                    }

                }



                System.out.print(month_);
                found=true;
            }
            else
            {
                if(!found) {
                    WebElement nxt = driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
                    nxt.click();
                }
            }
        }


    }

}
