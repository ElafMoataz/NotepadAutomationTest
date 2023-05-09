package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    static WindowsDriver driver;
    BasePage(WindowsDriver desiredDriver){
        driver = desiredDriver;
        PageFactory.initElements(driver, this);
    }
}
