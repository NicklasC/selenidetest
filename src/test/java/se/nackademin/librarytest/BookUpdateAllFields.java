/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

import org.junit.Test;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.UniqueBook;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.MenuPage;

/**
 *
 * @author nicklas
 */

public class BookUpdateAllFields extends TestBase{
    
    @Test
    public void bookUpdateAllFields(){
        
        UserHelper.loginAsUser("admin","1234567890");
        
        MenuPage menuPage = page(MenuPage.class);
        BookPage bookPage = page(BookPage.class);
        
        
        // Navigating to add book page
        menuPage.navigateToAddBooks();
        
        // Creating a unique book
        UniqueBook uniqueBook=new UniqueBook(null,null,null,null,null,null);
        bookPage.setTitle(uniqueBook.getTitle());
        bookPage.setDatePublished(uniqueBook.getDatePublished());
        System.out.println("test:"+uniqueBook.getTitle());
        sleep(7000);
        
        
    }
}
