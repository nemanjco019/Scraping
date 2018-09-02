package scrap.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {

    // getting webdriver za chrome
    public static WebDriver getWebDriver() {       
        String driverPath = "D:\\chromedriver_win32 (1)\\chromedriver.exe";  
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

}

