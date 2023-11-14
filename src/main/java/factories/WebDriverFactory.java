package factories;

import data.BrowserData;
import exception.BrowserNorSupportedException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import sun.plugin.dom.exception.BrowserNotSupportedException;

import java.util.Locale;

public class WebDriverFactory implements IFactory{
    private  String browserName  = System.getProperty("browser.name","firefox");


    @Override
    public WebDriver createDriver(BrowserData data) throws BrowserNotSupportedException {
        switch (BrowserData.valueOf(browserName .trim().toUpperCase(Locale.ROOT))) {
            case CHROME : {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                return new ChromeDriver();
            }
            case FIREFOX: {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //firefoxOptions.addArguments("--no-sandbox");
                firefoxOptions.addArguments("--start-maximized");
                //firefoxOptions.addArguments("--homepage=about:blank");
                firefoxOptions.addArguments("--ignore-certificate-errors");
                return new FirefoxDriver(firefoxOptions);
            }

            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }

    @Override
    public WebDriverManager setUp(BrowserData data) throws BrowserNotSupportedException {
        switch (BrowserData.valueOf(browserName.toUpperCase())) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return null;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                return null;
            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }
}
