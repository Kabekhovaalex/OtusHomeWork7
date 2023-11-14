package factories;

import data.BrowserData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import sun.plugin.dom.exception.BrowserNotSupportedException;

public interface IFactory {
    WebDriver createDriver(BrowserData data) throws BrowserNotSupportedException;
    WebDriverManager setUp(BrowserData data) throws BrowserNotSupportedException;

}
