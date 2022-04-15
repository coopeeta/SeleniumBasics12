package com.syntax.review04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windowsHandle {

    public static String url = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drvr/dr/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

//        find all the buttons that open up new windows or tabs

        WebElement helpBtn = driver.findElement(By.xpath("//a[text()='Help']"));
        WebElement privacyBtn = driver.findElement(By.xpath("//a[text()='Privacy']"));
        WebElement termsBtn = driver.findElement(By.xpath("//a[text()='Terms']"));

//        clicking on the btns
        helpBtn.click();
        privacyBtn.click();
        termsBtn.click();
//
//        get mian page handle
        String mainPageHandle = driver.getWindowHandle();
        System.out.println("The handle for the main Page is :"+mainPageHandle);

//        get all the window handles
        Set<String> allhandles = driver.getWindowHandles();
        Iterator<String> it =allhandles.iterator();
        while(it.hasNext()) {
            String handle = it.next();
            if (!mainPageHandle.equals(handle)) {
//                switch to the new tab
                driver.switchTo().window(handle);
//            check if it is the desired tab
                String title = driver.getTitle();
                if (title.equalsIgnoreCase("Privacy Policy – Privacy & Terms – Google")) {

                    System.out.println("hurray you are on the right page i.e Privacy and terms");
                    System.out.println(driver.getTitle());
                    System.out.println(driver.getCurrentUrl());
                    break;
                }
            }
        }
    }
}