package com.opencart.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = ConfigReaderManager.getProperty("browserType");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                if (ConfigReaderManager.getProperty("isIncognitoChromeEnabled").equals("true")) {
                    options.addArguments("--incognito");
                }
                options.addArguments("--incognito");
               // WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                System.out.println("The Chrome driver was initiated!");
                break;
            case "FIREFOX":
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                System.out.println("The FireFox driver was initiated!");
                break;
            case "EDGE":
               // WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                System.out.println("The Edge driver was initiated!");
                break;
            case "SAFARI":
               // WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                System.out.println("The Safari driver was initiated!");
                break;
            default:
                System.out.println("There is not defined such a Driver: " + webDriverType);
        }
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null ) {
            getInstance();
        }
        return driver;
    }

    public void quitTheDriver() {
        driver.quit();
        driver = null;
        instance = null;
        System.out.println("The driver is quit and the instance is reset!");
    }
}
