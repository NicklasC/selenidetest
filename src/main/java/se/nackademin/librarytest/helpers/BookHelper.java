package se.nackademin.librarytest.helpers;

import static com.codeborne.selenide.Selenide.page;
import se.nackademin.librarytest.model.Book;
import se.nackademin.librarytest.pages.BookPage;
import se.nackademin.librarytest.pages.BrowseBooksPage;
import se.nackademin.librarytest.pages.MenuPage;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.page;
public class BookHelper {
    
    public static void addNewBook(Book book){
       
   
    }
    public static Book fetchBook(String searchQuery){
        MenuPage menuPage = page(MenuPage.class);
        menuPage.navigateToBrowseBooks();
        BrowseBooksPage browseBooksPage = page(BrowseBooksPage.class);
        browseBooksPage.setTitleField(searchQuery);
        browseBooksPage.clickSearchBooksButton();
        browseBooksPage.clickFirstResultTitle();
        
        BookPage bookPage = page(BookPage.class);
        Book book = new Book();
        book.getTitle();
        book.setTitle(bookPage.getTitle());
        book.setAuthor(bookPage.getAuthor());
        book.setDescription(bookPage.getDescription());
        return book;
    }
    
}
