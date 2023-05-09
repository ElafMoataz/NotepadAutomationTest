package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NotepadPage extends BasePage{
    public NotepadPage(WindowsDriver desiredDriver) {
        super(desiredDriver);
    }
    @FindBy(className = "Button")
    private WebElement settingsButton;
    @FindBy(name = "File")
    private WebElement fileButton;
    @FindBy(className = "Notepad")
    private WebElement notepadBody;
    @FindBy(name = "Save")
    private WebElement saveButton;

    public void enterTextInNotes(String text){
        notepadBody.sendKeys(text);
    }
    public void openSettingsPage(){
        settingsButton.click();
    }
    public void saveNotepad(String notepadName){
        fileButton.click();
        saveButton.click();
        driver.findElementByAccessibilityId("1001").sendKeys(notepadName + Math.random());
        driver.findElementByAccessibilityId("1").click();
    }
    public String getNotepadText(){
        return notepadBody.getText();
    }
    public String getNotepadNameAfterSaving(){
        return notepadBody.getText();
    }
}