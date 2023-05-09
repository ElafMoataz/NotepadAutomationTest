package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
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
    @BeforeTest
    public void resetAssertObject(){
        softAssert = new SoftAssert();
    }
    @Test(groups = "sanity")
    public void validateThatNotepadIsSavedWithCorrectNameAndFontConfigurationsAndBody(){
        String desiredStyle= "Bold";
        String desiredSize= "30";
        String documentText= "Hello";
        String notepadName= "Notepad automation test";

        notepadPage.openSettingsPage();
        settingsPage.changeFontStyle(desiredStyle);
        settingsPage.changeFontSize(desiredSize);
        softAssert.assertEquals(settingsPage.getFontStyle(), desiredStyle);
        softAssert.assertEquals(settingsPage.getFontSize(), desiredSize);
        settingsPage.navigateToNotepadPage();
        notepadPage.enterTextInNotes(documentText);
        softAssert.assertTrue(notepadPage.getNotepadText().contains(documentText));
        notepadPage.saveNotepad(notepadName);
        softAssert.assertTrue(notepadPage.getNotepadNameAfterSaving().contains(notepadName));
        softAssert.assertAll();
    }
}