package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, InterruptedException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        Thread.sleep(5000);
    }
    @Test
    public void createListofActivites() throws InterruptedException {
        // Perform the calculation
        Thread.sleep(3000);
        //adding 1st activitylist
        WebElement createnewnotebtn = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/new_note_button")));
        createnewnotebtn.click();
        WebElement titleinput = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        // input.click();
        titleinput.sendKeys("Appium activity2");
        WebElement Descinput = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/edit_note_text")));
        // input.click();
        Descinput.sendKeys("Complete Activity with Google Tasks ghghg ghg");
        WebElement backbtn = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Navigate up")));
        backbtn.click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.id("com.google.android.keep:id/open_search_bar_text_view")).click();
        WebElement searchbar = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/search_actionbar_query_text")));
        searchbar.click();
        searchbar.sendKeys("Appium activity2");
        Thread.sleep(2000);
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/index_note_title")));
        String resulttext = result.getText();
        System.out.println(resulttext);
        Assert.assertEquals(resulttext,"Appium activity2");


    }

}
