/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;

import org.junit.Test;
import se.nackademin.librarytest.helpers.AuthorHelper;
import se.nackademin.librarytest.pages.MenuPage;

import static se.nackademin.librarytest.helpers.StringHelper.randomString;
import se.nackademin.librarytest.helpers.UserHelper;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import se.nackademin.librarytest.pages.ViewAuthorPage;

/**
 * Task 1: Create new author
 * @author nicklas
 */

public class CreateNewAuthor extends TestBase{
    
    @Test
    public void createNewAuthor(){
        
        MenuPage menuPage = page(MenuPage.class);
        
        // Generate new author data
        String firstName = randomString();
        String lastName = randomString();
        String country = randomString();
        String biography = randomString();

        
        // Login
        UserHelper.loginAsUser("admin","1234567890");
        
        // Creating new author
        AuthorHelper.addNewAuthor(firstName, lastName, country, biography);
        
        // Now verifying that the author got added correctly...
        AuthorHelper.searchAndDisplayAuthor(firstName, lastName, country);
        
        ViewAuthorPage viewAuthorPage=page(ViewAuthorPage.class);
        assertEquals("Author title should be '"+firstName +" "+lastName,firstName +" "+lastName,viewAuthorPage.getAuthorName());
        assertEquals("Country should be "+country,country,viewAuthorPage.getCountry());
        assertEquals("Biography should be "+biography,biography,viewAuthorPage.getBiography());
        
    }
    
    
}
