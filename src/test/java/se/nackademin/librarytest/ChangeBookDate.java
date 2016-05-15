/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.helpers.BookHelper;
import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.pages.BookPage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;

/**
 *
 * @author nicklas
 */
public class ChangeBookDate extends TestBase{
    @Test
    public void changeBookDate(){
    
        UserHelper.loginAsUser("admin","1234567890");
        
        
        BookHelper.fetchBook("Good Omens");
        
        BookPage bookPage = page(BookPage.class);
        
        String currentDate=bookPage.getDatePublished();
        String newDate;
        if (currentDate.equals("1990-05-01")){
            newDate="1990-05-02";
        }else{
            newDate="1990-05-01";        
        }
        
        bookPage.clickEditBookButton();
        bookPage.setDatePublished(newDate);
        bookPage.clickSaveBookButton();
        
        // Verifying the changes have taken place
        
        BookHelper.fetchBook("Good Omens");
        assertEquals("Book date should have been updated",newDate,bookPage.getDatePublished());
        
    }
    
}
