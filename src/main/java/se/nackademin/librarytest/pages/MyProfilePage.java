package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends PageBase{
    
    @FindBy(css="#gwt-uid-5")
    SelenideElement userNameField;

    @FindBy(css="#gwt-uid-13")
    SelenideElement emailAdressField;
    
    @FindBy(css="#edit-user")
    SelenideElement changeUserButton;
    
    @FindBy(css="#save-user-button")
    SelenideElement saveUserButton;
    
    public String getUserName(){
        return userNameField.getText();
    }
    public String getEmailAdress(){
        return emailAdressField.getText();
    }
    public void clickEditUserButton(){
        clickButton("Edit user button",changeUserButton);
    }
    
    public void setEmailAdress(String emailAdress){
       setTextFieldValue("email adress",emailAdress,emailAdressField);
    }
    public void clickSaveUserButton(){
        clickButton("Save user button",saveUserButton);
    }
    
    
}
