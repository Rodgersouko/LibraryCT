package US7_BookFillter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class TC1_VeifyBookCategory {




        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            ArrayList<String> Users = new ArrayList<>();
            Users.add("librarian47@library");
            Users.add("librarian17@library");
            Users.add("student94@library");
            Users.add("student95@library");
            Users.add("student96@library");



            //Given user is on the loginPage
            driver.get("http://library2.cybertekschool.com/login.html");

            for (String eachUser : Users) {

                //When user enters valid email address and password
                Thread.sleep(1000);
                WebElement userNameBox = driver.findElement(By.id("inputEmail"));
                userNameBox.sendKeys(eachUser);
                WebElement passwordBox = driver.findElement(By.id("inputPassword"));
                passwordBox.sendKeys("Sdet2022*");

                //And user click sign in button

                Thread.sleep(1000);
                WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
                singInButton.click();
                Thread.sleep(1000);
                //verify land to homepage
                String expectedResult = "Library";
                String actualResult = (driver.getTitle());

                if (actualResult.equalsIgnoreCase(expectedResult)) {
                    System.out.println(eachUser + ":PASSED-Browser landing homepage successfully");
                } else {
                    System.out.println(eachUser + ":FAILED-Browser not on the homepage");
                }
                Thread.sleep(1000);

                //   click book module

                if(eachUser.equalsIgnoreCase("librarian47")|| eachUser.equalsIgnoreCase("librarian17")) {
                    driver.findElement(By.cssSelector("#menu_item > li:nth-child(3) > a > span.title")).click();
                }else{
                    driver.findElement(By.xpath("//ul[@id='menu_item']//a[@href='#books']/span[@class='title']")).click();
                }
                Thread.sleep(1000);

                //click book category dropdown

                driver.findElement(By.id("book_categories")).click();
                Thread.sleep(1000);
                //verify 21 modules

                List<WebElement> bookDropDown = driver.findElements(By.xpath("//select[@id='book_categories']/option"));
                // System.out.println("bookDropDown.size() = " + bookDropDown.size());
                Thread.sleep(1000);
                int expectedResult1=21;
                int actualResult1=bookDropDown.size();

                if(expectedResult1==actualResult1){
                    System.out.println("PASSED--" + eachUser + " has 21 options in the book categories dropdown");
                }else{
                    System.out.println("FAILED--" + eachUser + " has " + actualResult1 + " options in the book categories dropdown");
                }
                Thread.sleep(1000);

                //click user name on the right corner and log out

                driver.findElement(By.id("navbarDropdown")).click();
                Thread.sleep(1000);

                driver.findElement(By.linkText("Log Out")).click();

                Thread.sleep(1000);

            }
            //close browser
            driver.quit();
        }
}
