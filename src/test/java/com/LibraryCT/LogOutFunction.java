package com.LibraryCT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutFunction {
    public static void main(String[] args) {

        // set up chrome driver , open chrome browser
        WebDriverManager.chromedriver().setup();
        // navigate to that html file using that path you copied from the browser
        WebDriver driver = new ChromeDriver();
        //     file:///Users/training/Desktop/b23-prep/HTML_Class/Day2.html
        // YOU NEED TO REPLACE IT WITH YOUR OWN FILE PATH ON YOUR COMPUTER
        driver.get("file:///Users/training/Desktop/b23-prep/HTML_Class/Day2.html");

    }
}
