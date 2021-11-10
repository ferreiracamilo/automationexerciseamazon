package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    /**
    * Region Variables
    */
    protected static WebDriver driver;
    private static WebDriverWait wait;
    //private static Actions action;

    static {
        // System.setProperty("webdriver.chrome.driver", "D:/Workspace/vscode-workspace/seleniumCucumberJavaPato/src/test/resources/files/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/auxfiles/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("ignore-certificate-errors"); //to ignore HTTPS lack certificate
        driver = new ChromeDriver (chromeOptions);
        wait = new WebDriverWait(driver,10);
    }

    /**
    * Region Constructor
    */
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    /**
    * Region Methods
    */

    public static void navigateTo(String url){
        driver.get("https://www.amazon.com/");
    }

    public static void closeBrowser(){
        driver.quit();
    }

    /**
    * Get a webelement along applying <mark>wait</mark> to ensure element is available
    * @param locator xpath locator
    * @return WebElement will be <b>null</b> if <b>locator doesn't match to an actual element from form</b>
    */
    protected WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement (String locator){
        Find(locator).click();
    }

    public void write (String locator,String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public String textFromElement (String locator){
        return Find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public List<WebElement> getAllElements(String locator){
        return driver.findElements(By.xpath(locator));
    }
}