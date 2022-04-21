package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {

    // I created common methods so I can reuse them when I work on automating test case

    public static WebDriver driver;

    /**
     * this method opens a browser, maximizes window and sets implicit wait
     */
    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        initializePageObjects();
    }

    /*
        this method will clear out the text field before entering text into that
    */
    public static void sendText(WebElement element, String textToSend) {
        element.clear();
        element.sendKeys(textToSend);
    }

    /**
     * this is method gets time of explicit wait
     *
     * @return WebDriverWait
     */
    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        return wait;
    }

    /**
     * this method wait until element will be clickable
     *
     * @param element - webElement which we need to click
     */
    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * this method makes click on webElement
     *
     * @param element - webElement which we need to click
     */
    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }


    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    /**
     * this method makes click on webElement
     *
     * @param element webElement which we need to click using JS click
     */
    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    //for dropdown selection using text
    public static void selectDropdown(WebElement element, String text) {
        Select s = new Select(element);
        s.selectByVisibleText(text);
    }


    /**
     * this method takes screenshot and save file in Screenshot folder
     *
     * @param fileName - name for screenshot file
     * @return - screenshot in array of bytes for report
     */
    /*public static byte[] takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH + fileName + " " +
                    getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"
            ));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }*/

    /**
     * this method returns date in String with specific pattern
     *
     * @param pattern - YYYY-MM-DD-HH-MM-SS-MS
     * @return - data in String
     */
    /*public static String getTimeStamp(String pattern) {
        Date date = new Date();
        //yyyy-mm-dd-hh-mm-ss-ms
        //to format the date according to out choice we have to use this function
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }*/

    /**
     * Method checks if radio/checkbox is enabled and clicks it
     *
     * @param radioOrcheckbox
     * @param value
     */
    public static void clickRadioOrCheckbox(List<WebElement> radioOrcheckbox, String value) {

        String actualValue;

        for (WebElement el : radioOrcheckbox) {
            actualValue = el.getText();
            System.out.println(actualValue);
            if (!el.isSelected() && el.isEnabled() && actualValue.equals(value)) {
                el.click();
                break;
            }
        }
    }


    /**
     * Method that selects value by index from dropDown
     *
     * @param element
     * @param index
     */
    public static void selectDdValue(WebElement element, int index) {

        try {
            Select select = new Select(element);
            int size = select.getOptions().size();

            if (size > index) {
                select.selectByIndex(index);
            }
        } catch (UnexpectedTagNameException e) {
            e.printStackTrace();
        }
    }


    /**
     * this method checks do we have specific text in DropDownBox
     *
     * @param element - webElement of DropDownBox
     * @param text    - specific Text
     * @return - boolean
     */
    public static boolean isTextEnableInDropDown(WebElement element, String text) {
        boolean isTextEnable = false;
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement op : options) {
            if (op.getText().equals(text)) {
                isTextEnable = true;
            }
        }
        return isTextEnable;
    }

    //this method quit the browser
    public static void closeBrowser() {
        driver.quit();
    }
}
