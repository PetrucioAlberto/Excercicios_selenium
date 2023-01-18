package Core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriveFactory {

    private static WebDriver driver;
    private DriveFactory(){}
    public static  WebDriver getDriver(){
        if (driver == null){
            driver = new ChromeDriver();
            getDriver().manage().window().setSize(new Dimension(1200,765));
        }
        return driver;
    }

    public static void KillDriver(){
        if (driver != null){
            getDriver().quit();
            driver = null;
        }
    }
}
