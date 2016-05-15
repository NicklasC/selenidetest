package se.nackademin.librarytest.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends MenuPage {
    
    @FindBy(css="#input-username")
    SelenideElement userNameField;
    
    @FindBy(css="#input-password")
    SelenideElement passwordField;
    
    @FindBy(css="#login-button")
    SelenideElement logInButton;
    
    public void setUserName(String username){
        userNameField.clear();
        userNameField.sendKeys(username);
    }
    
    public void setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    
    }
    public void clickLogInButton(){
        logInButton.click();
    }
    
    
}
