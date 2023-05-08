package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.NotepadPage;
import pages.SettingsPage;

public class NotepadTests extends BaseTest {
    SoftAssert softAssert;
    NotepadPage notepadPage;
    SettingsPage settingsPage;
    @BeforeClass
    public void init(){
        notepadPage = new NotepadPage(driver);
        settingsPage = new SettingsPage(driver);
    }
    @Test
    public void validateThatTextIsAddedWithCorrectFontConfigurationsAfterSavingNotepad(){
        String desiredStyle= "Bold";
        String desiredSize= "30";
        String documentText= "Hello";
        String notepadName= "Notepad automation test";

        softAssert = new SoftAssert();
        notepadPage.openSettingsPage();
        settingsPage.changeFontStyle(desiredStyle);
        settingsPage.changeFontSize(desiredSize);
        String fontStyle= settingsPage.getFontStyle();
        String fontSize= settingsPage.getFontSize();
        softAssert.assertEquals(fontStyle, desiredStyle);
        softAssert.assertEquals(fontSize, desiredSize);
        settingsPage.navigateToNotepadPage();
        notepadPage.enterTextInNotes(documentText);
        softAssert.assertTrue(notepadPage.getNotepadText().contains(documentText));
        notepadPage.saveNotepad(notepadName);
        softAssert.assertTrue(notepadPage.getNotepadNameAfterSaving().contains(notepadName));
        softAssert.assertAll();
    }
}