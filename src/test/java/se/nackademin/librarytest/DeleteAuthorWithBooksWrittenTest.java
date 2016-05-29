package se.nackademin.librarytest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.nackademin.librarytest.helpers.AuthorHelper;
import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.Table;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Author;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.ViewAuthorPage;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class DeleteAuthorWithBooksWrittenTest extends TestBase{

    @Test
    public void deleteAuthorWithBooksWrittenTest(){
        
        ViewAuthorPage viewAuthorPage = page(ViewAuthorPage.class);
        UserHelper.loginAsAdmin();

           // Creating new author
        Author newAuthor = AuthorHelper.addNewAuthor(null, null, null, null);
        
        // Create 2 new books with above author
        Book book1 = BookHelper.createBook(null, newAuthor.getFirstName()+" "+newAuthor.getLastName(), null, null, null, null);
        Book book2 = BookHelper.createBook(null, newAuthor.getFirstName()+" "+newAuthor.getLastName(), null, null, null, null);
        
        AuthorHelper.searchAndDisplayAuthor(newAuthor.getFirstName(), newAuthor.getLastName(), newAuthor.getCountry());
        
        Table table = new Table($("table"));
        assertEquals("Two books should be registred on the new author",2,table.getRowCount()-1);
        
        // Now trying to delete the author
        viewAuthorPage.clickDeleteAuthorButton();
        viewAuthorPage.clickConfirmOkButton();
        
        assertEquals("Author should still have two books registred",2,table.getRowCount()-1);
        
        // Delete the two books...
        BookHelper.deleteBook(book1.getTitle());
        BookHelper.deleteBook(book2.getTitle());
        
        // Navigating back to the author again...
        AuthorHelper.searchAndDisplayAuthor(newAuthor.getFirstName(), newAuthor.getLastName(), newAuthor.getCountry());
        assertEquals("No books should be registred on the new author",0,table.getRowCount()-1);

        // Now trying to delete the author
        viewAuthorPage.clickDeleteAuthorButton();
        viewAuthorPage.clickConfirmOkButton();
        
        String text=$(".v-margin-top > div:nth-child(3) > div:nth-child(1)").getText();
        assertEquals("We should now be at the start page","Welcome to the Library Test Application!",text);
    }
    
    //@Test
    public void labb(){
        AuthorHelper.searchAndDisplayAuthor("Terry","Pratchett",null);
        
        Table table = new Table($("table"));
        System.out.println(table.getRowCount());
        System.out.println(table.getColCount());
    }
}
