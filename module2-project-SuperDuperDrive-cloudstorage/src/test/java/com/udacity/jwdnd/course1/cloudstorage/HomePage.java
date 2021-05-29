package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(id = "button_logout")
    WebElement button_logout;

    @FindBy(id = "nav-notes-tab")
    WebElement tab_note;

    @FindBy(id = "button_newNote")
    WebElement button_addNote;

    @FindBy(id = "note-title")
    WebElement input_noteTitle;

    @FindBy(id = "note-description")
    WebElement input_noteDescription;

    @FindBy(id = "button_savechanges")
    WebElement button_noteSubmit;

    @FindBy(xpath = "//*[@id=\"noteTable\"]/tbody/tr[1]/th/span")
    WebElement note_firstNoteTitle;

    @FindBy(xpath = "//*[@id=\"noteTable\"]/tbody/tr[1]/td[1]/span")
    WebElement note_firstNoteDescription;

    @FindBy(xpath = "//*[@id=\"noteTable\"]/tbody/tr[1]/td[2]/button")
    WebElement buttton_editNote;

    @FindBy(xpath = "//*[@id=\"noteTable\"]/tbody/tr/td[2]/a")
    WebElement button_deleteNote;

    @FindBy(xpath = "//*[@id=\"noteTable\"]/tbody")
    WebElement tableNotesBody;


    public HomePage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
    }

    public void clickDeleteNoteButton(){
        button_deleteNote.click();
    }

    public void clickEditNoteButton(){
        buttton_editNote.click();
    }

    public void openNoteTab(){
        tab_note.click();
    }

    public void clickNewNoteButton(){
        button_addNote.click();
    }

    public void setNoteTitle(String title){
        input_noteTitle.clear();
        input_noteTitle.sendKeys(title);
    }

    public void setNodeDescription(String description){
        input_noteDescription.clear();
        input_noteDescription.sendKeys(description);
    }

    public void clickSaveButtonNewNote(){
        button_noteSubmit.click();
    }

    public Note getFirstNote(){
        if(!tableNotesBody.getText().equals("")){
            String title = note_firstNoteTitle.getText();
            String description = note_firstNoteDescription.getText();
            return new Note(1, title, description, 1);
        }
        return null;
    }

    void performLogout(){
        button_logout.click();
    }
}
