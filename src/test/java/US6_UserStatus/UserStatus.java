package US6_UserStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.List;

public class UserStatus {


        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            ArrayList<String> librarianUsers = new ArrayList<>();
            librarianUsers.add("librarian47@library");
            librarianUsers.add("librarian17@library");
            // System.out.println(librarianUsers.size());
            // System.out.println(librarianUsers);

            //Given librarian is on the loginPage
            driver.get("http://library2.cybertekschool.com/login.html");

            for (String eachLibrarianUser : librarianUsers) {

                //When librarian enters valid email address and password
                Thread.sleep(1000);
                WebElement userNameBox = driver.findElement(By.id("inputEmail"));
                userNameBox.sendKeys(eachLibrarianUser);
                WebElement passwordBox = driver.findElement(By.id("inputPassword"));
                passwordBox.sendKeys("Sdet2022*");

                //And librarian click sign in button

                Thread.sleep(1000);
                WebElement singInButton = driver.findElement(By.xpath("//button[@class=\"btn btn-lg btn-primary btn-block\"]"));
                singInButton.click();
                Thread.sleep(3000);
                //verify land to homepage
                String expectedResult = "Library";
                String actualResult = (driver.getTitle());

                if (actualResult.equalsIgnoreCase(expectedResult)) {
                    System.out.println(eachLibrarianUser + ":PASSED-Browser landing homepage successfully");
                } else {
                    System.out.println(eachLibrarianUser + ":FAILED-Browser not on the homepage");
                }
                Thread.sleep(1000);

                //click user module
                driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[2]/a/span[1]")).click();
                Thread.sleep(1000);

                //click status dropdown

                driver.findElement(By.id("user_status")).click();
                Thread.sleep(3000);

                //verify options

                //verify first option

                WebElement firstOption=driver.findElement(By.xpath("//select[@id='user_status']/option[@value='ACTIVE']"));

                String expectedResult1="ACTIVE";
                String actualResult1=firstOption.getText();

                if(actualResult1.equalsIgnoreCase(expectedResult1)){
                    System.out.println(eachLibrarianUser + ":PASSED--First option verified");
                }else{
                    System.out.println(eachLibrarianUser + ":FAILED--First option didn't verify");
                }
                Thread.sleep(2000);

                //verify second option

                WebElement secondOption=driver.findElement(By.xpath("//select[@id='user_status']/option[@value='INACTIVE']"));

                String expectedResult2="INACTIVE";
                String actualResult2=secondOption.getText();
                if(actualResult2.equalsIgnoreCase(expectedResult2)){
                    System.out.println(eachLibrarianUser + ":PASSED--Second option verified");
                }else{
                    System.out.println(eachLibrarianUser + ":FAILED--Second option didn't verify");
                }
                Thread.sleep(2000);

                //verify number of option

                List<WebElement>statusDropDown=driver.findElements(By.xpath("//select[@id='user_status']/option"));
                //System.out.println("statusDropDown.size() = " + statusDropDown.size());

                int expectedResult3=2;
                int actualResult3=statusDropDown.size();

                if(expectedResult3==actualResult3){
                    System.out.println("PASSED--" + eachLibrarianUser + " has 2 options");
                }else{
                    System.out.println("FAILED--" + eachLibrarianUser + " has " + actualResult3 + " option(s)");
                }
                Thread.sleep(2000);

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
