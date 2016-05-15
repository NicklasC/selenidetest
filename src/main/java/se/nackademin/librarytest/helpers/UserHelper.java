/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.helpers;

import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.pages.AddUserPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import se.nackademin.librarytest.pages.SignInPage;

/**
 *
 * @author nicklas
 */
public class UserHelper {
    
    static MenuPage menuPage = page(MenuPage.class);
    
    public static void createNewUser(String userName, String passWord){
        
        // Create profile
        menuPage.navigateToAddUser();
        
        AddUserPage addUserPage = page(AddUserPage.class);
        addUserPage.setUserName(userName);
        addUserPage.setPassword(passWord);
        addUserPage.clickAddUserButton();

    }
    public static void loginAsUser(String userName, String passWord){
        
        menuPage.navigateToSignIn();
        SignInPage signInPage = page(SignInPage.class);
        signInPage.setUserName(userName);
        signInPage.setPassword(passWord);
        signInPage.clickLogInButton();
    
    }
    
    public static void updateUserEmailAdress(String newEmailAdress){
        // Navigate to My Profile
        menuPage.navigateToMyProfile();
        
        // Change email adress
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        myProfilePage.clickEditUserButton();
        myProfilePage.setEmailAdress(newEmailAdress);
        myProfilePage.clickSaveUserButton();

    }

}
