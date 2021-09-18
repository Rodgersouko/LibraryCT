package com.LibraryCT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogIntFunction {
    public static void main(String[] args) throws InterruptedException {

        // set up chrome driver , open chrome browser
        WebDriverManager.chromedriver().setup();
        // navigate to that html file using that path you copied from the browser
        WebDriver driver = new ChromeDriver();
        //     file:///Users/training/Desktop/b23-prep/HTML_Class/Day2.html
        // YOU NEED TO REPLACE IT WITH YOUR OWN FILE PATH ON YOUR COMPUTER
        driver.get("https://library2.cybertekschool.com/login.html");

        WebElement EmailLogIn = driver.findElement(By.id("inputEmail"));
        EmailLogIn.sendKeys("student30@library");

        WebElement LogInPass = driver.findElement(By.id("inputPassword"));
        LogInPass.sendKeys("Sdet2022*");

        WebElement SignIn = driver.findElement(By.tagName("button"));
        SignIn.click();

        Thread.sleep(10000);
        driver.quit();

    }
}
