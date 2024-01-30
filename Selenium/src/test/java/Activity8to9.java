import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class Activity8to9 {
    WebDriver driver;

    @BeforeClass
    public WebDriver browserstart() throws IOException {

        WebDriverManager.firefoxdriver().setup();
        // System.setProperty("webdriver.gecko.driver", "src/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.manage().window().maximize();
        System.out.println("browser has opened and maximize");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void Activity8() throws InterruptedException {

        String expectedtitle = "Dashboard ‹ Alchemy Jobs — WordPress";
        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("root");
        WebElement password = driver.findElement(By.id("user_pass"));
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Thread.sleep(2000);
        String title  = driver.getTitle();
        System.out.println("title is =" +title);
       Assert.assertEquals(title,expectedtitle );

    }
    @Test
    public void Activity9() throws InterruptedException {

        Activity8();

        String jobpostion = "Full Stack Tester";
        String jobdetails = "Selenium,Java,C#,Cucumber,API";
        WebElement joblistingoption = driver.findElement(By.xpath("//*[@id=\"menu-posts-job_listing\"]/a/div[3]"));
        joblistingoption.click();
        Thread.sleep(3000);
        WebElement addnewbtn = driver.findElement(By.xpath("(//a[text()='Add New'])[4]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addnewbtn);
        Actions builder = new Actions(driver);
        builder.moveToElement(addnewbtn).click(addnewbtn).perform();
        WebElement positiontextarea = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        positiontextarea.sendKeys(jobpostion);
        driver.findElement(By.xpath("//*[@data-placeholder='Classic']")).click();
        Thread.sleep(2000);
        WebElement jobdesc  = driver.findElement(By.xpath("(//div[contains(@id,'editor')])[2]"));
        jobdesc.sendKeys(jobdetails);
        Thread.sleep(2000);
       WebElement publishbtn = driver.findElement(By.xpath("//button[text()='Publish…']"));
       publishbtn.click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//button[contains(text(),'Publish')])[2]")).click();
        Thread.sleep(2000);
      WebElement viewjob  = driver.findElement(By.xpath("//*[text()='View Job']"));
       if(viewjob.isDisplayed()){
           viewjob.click();
           if(driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase(jobpostion)){
               Assert.assertTrue(true);
           }
       }
    }
}
