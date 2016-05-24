/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.UniqueBook;
import se.nackademin.librarytest.pages.MenuPage;

/**
 *
 * @author nicklas
 */
public class BookUpdateAllFields {
    
    
    public void bookUpdateAllFields(){
        
        UserHelper.loginAsUser("admin","1234567890");
        
        MenuPage menuPage = page(MenuPage.class);
        // Navigating to add book page
        menuPage.navigateToAddBooks();
        
        // Creating a unique book
        UniqueBook uniqueBook=new UniqueBook(null,null,null,null,null,null);
        
        
    }
}
