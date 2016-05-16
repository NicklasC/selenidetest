package se.nackademin.librarytest;


import static com.codeborne.selenide.Selenide.*;


import java.util.UUID;
import se.nackademin.librarytest.pages.MenuPage;
import se.nackademin.librarytest.pages.MyProfilePage;
import static org.junit.Assert.*;
import org.junit.Ignore;
import se.nackademin.librarytest.helpers.BookHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Book;


public class SelenideTest extends TestBase{
    
    public SelenideTest() {
    }
    
    //@Test
    @Ignore
    public void testFetchBook(){
        Book book = BookHelper.fetchBook("Guards!");
        assertEquals("book title should be 'Guards guards","Guards! Guards!",book.getTitle());
    }
    
    //@Test
    @Ignore
    public void testLogin(){
        String uuid = UUID.randomUUID().toString();
        MenuPage menuPage = page(MenuPage.class);
        
        UserHelper.createNewUser(uuid, uuid);
        UserHelper.loginAsUser(uuid, uuid);
        
        // My profile
        menuPage.navigateToMyProfile();
        MyProfilePage myProfilePage = page(MyProfilePage.class);
         
        assertEquals("Username should be shown in profile",uuid,myProfilePage.getUserName());
    }
}
