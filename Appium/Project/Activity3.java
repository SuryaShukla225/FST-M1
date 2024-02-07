package AppiumProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3 {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium page
        driver.get("https://v1.training-support.net/selenium");
    }
    @Test
    public void toDoListTask() throws InterruptedException {

        int count = 0;
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));

        //driver.findElement(AppiumBy.androidUIAutomator("className(\"android.view.View\")")).click();
      //  driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")"));
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View[2]/android.view.View[3]/android.view.View[15]/android.view.View")).click();
        //Add task
        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Task1 googly");
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Add Task\")")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.androidUIAutomator("resourceId(\"taskInput\")")).sendKeys("Task2 googly");
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Add Task\")")).click();
        Thread.sleep(2000);
        //String task = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Task1 googly\")")).getText();
        WebElement tasks = driver.findElement(AppiumBy.androidUIAutomator("textContains(\"Task1 googly\")"));
        if(tasks.getText().equals("Task1 googly")){
            count++;
        }
        if(tasks.getText().equals("Task2 googly")){
            count++;
        }
        System.out.println("Number of Task added :" +count);
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Clear List\")")).click();



    }
}
