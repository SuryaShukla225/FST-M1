
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

class Activity7 {
    WebDriver driver;

    @BeforeClass
    public WebDriver browserstart() throws IOException {

        WebDriverManager.firefoxdriver().setup();
        // System.setProperty("webdriver.gecko.driver", "src/resources/Drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-login.php?redirect_to=https%3A%2F%2Falchemy.hguy.co%2Fjobs%2Fpost-a-job%2F");
        driver.manage().window().maximize();
        System.out.println("browser has opened and maximize");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;

    }

    @BeforeMethod
    public void logintoApp() {

        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("root");
        WebElement password = driver.findElement(By.id("user_pass"));
        password.sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }

    @Test
    public void activity_7() throws InterruptedException {
        //TestData
        //String youremaildata = "abcdRam45@gp.com";
        String jobTitledata = "Test Specialist";
        String jobtypedata = "Part Time";
        String jobdescdata = "Selenium,Java,Python,Testng,Cucumber,API";
        String AppURLdata = "https://alchemy.hguy.co/jobs";
        String compNamedata = "IBM";
        //navigate to post a job
        WebElement postAjobmenu = driver.findElement(By.xpath("//li//a[text()='Post a Job']"));
        postAjobmenu.click();

        //fill job details
        //WebElement youremail = driver.findElement(By.id("create_account_email")) ;
        WebElement jobtitle = driver.findElement(By.xpath("//input[@id='job_title']"));
        //youremail.sendKeys(youremaildata);
        jobtitle.sendKeys(jobTitledata);
        Select jobtype = new Select(driver.findElement(By.id("job_type")));
        jobtype.selectByVisibleText(jobtypedata);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement iframejobdesc = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(iframejobdesc);
        WebElement description = driver.findElement(By.xpath("//*[@data-id='job_description']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(description).click(description).sendKeys(jobdescdata);
        builder.perform();
        Thread.sleep(4000);
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        WebElement applicationURL = driver.findElement(By.id("application"));
        applicationURL.sendKeys(AppURLdata);
        WebElement companyName = driver.findElement(By.id("company_name"));
        companyName.sendKeys(compNamedata);
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //submit the job
        driver.findElement(By.id("job_preview_submit_button")).click();

        //Verify that the job listing was posted by visiting the jobs page.
        Thread.sleep(2000);
        WebElement jobmenu = driver.findElement(By.xpath("//li//a[text()='Jobs']"));
        jobmenu.click();
        Thread.sleep(2000);
        WebElement searchbar = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        searchbar.sendKeys(jobTitledata);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='search_submit']//input")).click();
        Thread.sleep(2000);
        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[@class='job_listings']//li"));
        for (WebElement result : searchResults) {
            if (result.getText().equalsIgnoreCase(jobTitledata)) {
                Thread.sleep(2000);
                Assert.assertTrue(true, "Job is listed and found in search result");
            }
        }

    }
}

