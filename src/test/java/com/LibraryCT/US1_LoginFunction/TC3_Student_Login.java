package com.LibraryCT.US1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class TC3_Student_Login {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        ArrayList<String> studentUsers=new ArrayList<>();
        studentUsers.add("student94@library");
        studentUsers.add("student95@library");
        studentUsers.add("student96@library");

        //Given student is on the loginPage

        driver.get("http://library2.cybertekschool.com/login.html");

//        for (int i = 0; i < studentUsers.size(); i++) {
//
//        }
        for (String eachstudentUser : studentUsers) {
            //Then verify that the title is “Login - Library”

            if (driver.getTitle().equalsIgnoreCase("Login - Library")) {
                System.out.println(eachstudentUser+" verified Page title(Login - Library)");
            } else {
                System.out.println(eachstudentUser+" Page title not verified");
            }
            //When student enters valid email address and password
            Thread.sleep(500);
            WebElement userNameBox = driver.findElement(By.id("inputEmail"));
            userNameBox.sendKeys(eachstudentUser);
            WebElement passwordBox = driver.findElement(By.id("inputPassword"));
            passwordBox.sendKeys("Sdet2022*");


            //And student click sign in button

            WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
            singInButton.click();

            Thread.sleep(1000);
            //Then verify that there are 2 modules the page

            List<WebElement> allModules = driver.findElements(By.xpath("//span[@class=\"title\"]"));
            System.out.println("allModules.size() = " + allModules.size());

            if (allModules.size() == 2) {
                System.out.println(eachstudentUser+" Test Pass: 2 modules are appeared on the page");
            } else {
                System.out.println(eachstudentUser+" Test fail: 2 modules didn't appear on the page");
            }

            driver.findElement(By.id("navbarDropdown")).click();
            Thread.sleep(500);

            driver.findElement(By.linkText("Log Out")).click();
            Thread.sleep(1000);
        }

        //close browser
        driver.quit();


    }
}
