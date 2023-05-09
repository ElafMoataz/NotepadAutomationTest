package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SettingsPage extends BasePage {
    public SettingsPage(WindowsDriver desiredDriver) {
        super(desiredDriver);
    }
    @FindBy(name = "Font")
    private WebElement fontDropdown;
    @FindBy(className = "ComboBoxItem")
    private List<WebElement> fontList;
    @FindBy(xpath = "//ComboBox[@AutomationId='FontSizeComboBox']")
    private WebElement sizeTextBox;
    @FindBy(className = "TextBlock")
    private WebElement sizeIcon;
    public void changeFontOptions(){
        fontDropdown.click();
    }
    public void changeFontStyle(String fontStyle){
        changeFontOptions();
        fontList.get(1).click();
        driver.findElementByName(fontStyle).click();
    }
    public void changeFontSize(String fontSize){
        changeFontOptions();
        sizeTextBox.sendKeys("0"+fontSize);
        sizeIcon.click();
    }
    public void navigateToNotepadPage(){
        driver.findElementByAccessibilityId("Button").click();
    }

    public String getFontStyle(){
        changeFontOptions();
        return fontList.get(1).getAttribute("Name");
    }
    public String getFontSize(){
        changeFontOptions();
        return sizeTextBox.findElement(By.className("ComboBoxItem")).getAttribute("Name");
    }
}