package pages;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NotepadPage extends BasePage{
    public NotepadPage(WindowsDriver desiredDriver) {
        super(desiredDriver);
    }
    private WebElement settingsButton = driver.findElementByClassName("Button");
    private WebElement fileButton = driver.findElementByName("File");
    private WebElement notepadBody = driver.findElement(By.className("Notepad"));

    public void enterTextInNotes(String text){
        notepadBody.sendKeys(text);
    }
    public void openSettingsPage(){
        settingsButton.click();
    }
    public void saveNotepad(String notepadName){
        fileButton.click();
        driver.findElementByName("Save").click();
        driver.findElementByAccessibilityId("1001").sendKeys(notepadName + Math.random());
        driver.findElementByAccessibilityId("1").click();
    }
    public String getNotepadText(){
        return notepadBody.getText();
    }
    public String getNotepadNameAfterSaving(){
        return driver.findElement(By.className("Notepad")).getText();
    }
}