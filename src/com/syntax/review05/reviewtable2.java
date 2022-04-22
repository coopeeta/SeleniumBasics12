package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class reviewtable2 {

    public static String url = "http://syntaxprojects.com/table-pagination-demo.php";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

//        get all rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr"));
        System.out.println(rows.size());
//        finding next button
        WebElement nxt = driver.findElement(By.cssSelector("a.next_link"));

     for(int i=0; i<3;i++) {
         for (WebElement row : rows) {

             String text = row.getText();
             System.out.println(text);

         }
         nxt.click();
     }


    }
}