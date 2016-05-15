/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import se.nackademin.librarytest.helpers.StringHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;



/**
 *
 * @author nicklas
 */

public class ChangeEmailAdress extends TestBase{

    @Test
    public void changeEmailAdress(){    
        
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        //Creating user data
        String userName=StringHelper.randomString();
        String password=StringHelper.randomString();
        
        // Creating a new user
        UserHelper.createNewUser(userName,password);
        
        // Logging in with user created above
        UserHelper.loginAsUser(userName, password);
        
        // Navigate to My Profile
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToMyProfile();
        
        // Change email adress
        String newEmailAdress=StringHelper.randomString()+"@test.com";
        UserHelper.updateUserEmailAdress(newEmailAdress);
        
        // Navigating to my profile again
        menuPage.navigateToMyProfile();
        
        // Verifying my email adress is updated
        
        assertEquals("Email adress should be updated",newEmailAdress,myProfilePage.getEmailAdress());
        
    }
    
    
    
    
}
