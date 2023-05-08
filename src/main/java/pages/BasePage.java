package pages;

import io.appium.java_client.windows.WindowsDriver;

public class BasePage {
    static WindowsDriver driver;
    BasePage(WindowsDriver desiredDriver){
        driver = desiredDriver;
    }
}
