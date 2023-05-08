package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SettingsPage extends BasePage {
    public SettingsPage(WindowsDriver desiredDriver) {
        super(desiredDriver);
    }
    public void changeFontOptions(){
        driver.findElementByName("Font").click();
    }
    public void changeFontStyle(String fontStyle){
        changeFontOptions();
        List<WebElement> fontList = driver.findElements(By.className("ComboBoxItem"));
        fontList.get(1).click();
        driver.findElementByName(fontStyle).click();
    }
    public void changeFontSize(String fontSize){
        changeFontOptions();
        WebElement sizeTextBox = driver.findElementByXPath("//ComboBox[@AutomationId='FontSizeComboBox']");
        sizeTextBox.sendKeys("0"+fontSize);
        driver.findElementByClassName("TextBlock").click();
    }
    public void navigateToNotepadPage(){
        driver.findElementByAccessibilityId("Button").click();
    }

    public String getFontStyle(){
        changeFontOptions();
        List<WebElement> fontList = driver.findElements(By.className("ComboBoxItem"));
        return fontList.get(1).getAttribute("Name");
    }
    public String getFontSize(){
        changeFontOptions();
        return driver.findElementByXPath("//ComboBox[@AutomationId='FontSizeComboBox']").findElement(By.className("ComboBoxItem")).getAttribute("Name");
    }
}