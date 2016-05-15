/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class ViewAuthorPage extends PageBase{
    @FindBy(css="#gwt-uid-3")
    private SelenideElement authorName;
    
    @FindBy(css="#gwt-uid-5")
    private SelenideElement country;
    
    @FindBy(css="#gwt-uid-7")
    private SelenideElement biography;
    
    public String getAuthorName(){
        return authorName.getText();
    }
    
    public String getCountry(){
        return country.getText();
    }
    public String getBiography(){
        return biography.getText();
    }
}
