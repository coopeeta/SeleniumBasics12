package com.syntax.review05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewTables {


    public static String url = "https://www.techlistic.com/p/demo-selenium-practice.html";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//accessing the whole webtable
//        WebElement whole_table = driver.findElement(By.xpath("//table[@id='customers']"));
////        print the table
//        System.out.println(whole_table.getText());

//        accesing the rows of the table
//        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
//        for(WebElement row :rows){
//            String text = row.getText();
//            if(text.contains("Germany")) {
//                System.out.println(text);
//            }
//
//        }

//        Print all the company names that are located in UK
// get all the entery in column 3 i.e COUNTRY
        List<WebElement> countries= driver.findElements(By.xpath("//table[@id='customers']/tbody/tr/td[3]"));

        int i=1;
    for(WebElement country:countries){

        String nameofCountry = country.getText();
        if(nameofCountry.equals("UK")){
                System.out.println(i);
            WebElement company = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (i+1) + "]/td[1]"));
            System.out.println("the company name in UK is "+company.getText());
        }
        i=i+1;
    }

    }
}


// if column location may change

//get the headers ---> then find the location of column that has country---> from there he will
// get the index
//that should be place in front of td