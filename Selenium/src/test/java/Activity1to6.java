import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class Activity1to6 {
WebDriver driver;
String title;

    @BeforeClass
   public WebDriver browserstart() throws IOException {

        WebDriverManager.firefoxdriver().setup();
       // System.setProperty("webdriver.gecko.driver", "src/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/");
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
    public void activity1(){
        String expectedtitle = "Alchemy Jobs – Job Board Application";
        title = driver.getTitle();
        System.out.println("Title is " +title);
        Assert.assertEquals(title,expectedtitle);
    }

    @Test
    public void activity2(){
        String headingtext;
        String expectedheading = "Welcome to Alchemy Jobs";
        WebElement heading = driver.findElement(By.xpath("//*[@class='entry-title']"));
        headingtext = heading.getText();
        System.out.println("Heading is " +headingtext);
        Assert.assertEquals(headingtext,expectedheading);
    }

    @Test
    public void activity3(){
        String url = driver.getCurrentUrl();
        System.out.println("URL is " +url);
    }

    @Test
    public void activity4(){
        String headingtext;
        String expectedheading = "Quia quis non";
        WebElement heading = driver.findElement(By.tagName("//h2"));
        headingtext = heading.getText();
        System.out.println("Heading is " +headingtext);
        Assert.assertEquals(headingtext,expectedheading);
    }

    @Test
    public void activity5(){
        String pagetitle;
        String expectedpagetitle = "Jobs";
        WebElement jobmenu = driver.findElement(By.xpath("//li//a[text()='Jobs']"));
        jobmenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        pagetitle= driver.getTitle();
        System.out.println("Page title is " +pagetitle);
        Assert.assertEquals(pagetitle,expectedpagetitle);

    }
    @Test
    public void activity6(){
        String emailaddress;
        WebElement jobmenu = driver.findElement(By.xpath("//li//a[text()='Jobs']"));
        jobmenu.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        WebElement searchbar = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        searchbar.sendKeys("Banking");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.findElement(By.xpath("//div[@class='search_submit']//input")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.findElement(By.xpath("(//div[@class='position'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.findElement(By.xpath("//input[@class='application_button button']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        emailaddress = driver.findElement(By.xpath("//*[@class='job_application_email']")).getText();
        System.out.println("email address is " +emailaddress);

    }

}
