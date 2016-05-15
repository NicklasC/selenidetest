/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;

import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.StringHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.page;


/**
 *
 * @author nicklas
 */
public class BorrowBook extends TestBase{
    @Test
    public void borrowBook(){
        
        // Creating a new user and logging in
        String userName=StringHelper.randomString();
        String password=StringHelper.randomString();

        UserHelper.createNewUser(userName, password);
        UserHelper.loginAsUser(userName, password);
    
        BookPage bookPage=page(BookPage.class);
        BookHelper.fetchBook("Good Omens");
        Integer copiesAvailable=Integer.parseInt(bookPage.getCopiesAvailable());
        bookPage.clickBorrowBookButton();
        
        
        bookPage.clickConfirmOKbutton();
        
        assertEquals("Copies available should be reduced by one",copiesAvailable-1,Integer.parseInt(bookPage.getCopiesAvailable()));
        
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToMyProfile();
        MyProfilePage myProfilePage = page(MyProfilePage.class);
        myProfilePage.clickFirstBookInProfile();
        myProfilePage.clickReturnBookButton();
        bookPage.clickConfirmOKbutton();
        
    
    }
    
}
