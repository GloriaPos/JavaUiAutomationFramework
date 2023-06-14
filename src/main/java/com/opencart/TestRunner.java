package com.opencart;

import com.opencart.managers.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager driverManager = DriverManager.getInstance();
        //WebDriver driver2 = driverManager.getDriver();

        // Define a driver object that will be used for future action
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.youtube.com/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.youtube.com/watch?v=5IyHNkif7rQ");
        Thread.sleep(5000);

        driver.close();

        driver.switchTo().window(currentWindowName);
        Thread.sleep(1000);

        driver.get("https://www.youtube.com/watch?v=1EytULnyEIo");

        driver.quit();

        System.out.println("The execution was finished!");
    }
}