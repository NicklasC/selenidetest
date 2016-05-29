package se.nackademin.librarytest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import se.nackademin.librarytest.helpers.AuthorHelper;
import se.nackademin.librarytest.helpers.UserHelper;
import se.nackademin.librarytest.model.Author;
import se.nackademin.librarytest.pages.AddAuthorPage;
import se.nackademin.librarytest.pages.ViewAuthorPage;
import static se.nackademin.librarytest.helpers.StringHelper.randomString;

/**
 *
 * @author nicklas
 */

public class AuthorTest extends TestBase {
    
    @Test
    public void createAuthor(){
        ViewAuthorPage viewAuthorPage = page(ViewAuthorPage.class);
        
        UserHelper.loginAsAdmin();
        
        Author newAuthor = AuthorHelper.addNewAuthor(null, null, null, null);
        
        AuthorHelper.searchAndDisplayAuthor(newAuthor.getFirstName(),newAuthor.getLastName(), newAuthor.getCountry());
        
        assertEquals("displayed author name is correct",newAuthor.getFirstName()+" "+newAuthor.getLastName(),viewAuthorPage.getAuthorName());
        assertEquals("Author country displays correct",newAuthor.getCountry(),viewAuthorPage.getCountry());
        assertEquals("Author biography displays correct", newAuthor.getBiography(),viewAuthorPage.getBiography());
    }
    /**
 * Task 1: Create new author
 * @author nicklas
 */

    @Test
    public void createNewAuthorAndUpdate(){
       
        // Generate new author data
        String firstName = randomString();
        String lastName = randomString();
        String country = randomString();
        String biography = randomString();
        
        // Login
        UserHelper.loginAsAdmin();
        
        // Creating new author
        AuthorHelper.addNewAuthor(firstName, lastName, country, biography);
        
        // Now verifying that the author got added correctly...
        AuthorHelper.searchAndDisplayAuthor(firstName, lastName, country);
        
        ViewAuthorPage viewAuthorPage=page(ViewAuthorPage.class);
        AddAuthorPage addAuthorPage=page(AddAuthorPage.class);
        
        
        assertEquals("Author title should be '"+firstName +" "+lastName,firstName +" "+lastName,viewAuthorPage.getAuthorName());
        assertEquals("Country should be "+country,country,viewAuthorPage.getCountry());
        assertEquals("Biography should be "+biography,biography,viewAuthorPage.getBiography());
        
        // Now editing the book
        viewAuthorPage.clickEditAuthorButton();
        
        addAuthorPage.setFirstName(firstName+"x");
        addAuthorPage.setLastName(lastName+"y");
        addAuthorPage.setCountry(country+"z");
        addAuthorPage.setBiography(biography+"zz");
        addAuthorPage.clickSaveChangesButton();
        
        AuthorHelper.searchAndDisplayAuthor(firstName+"x", lastName+"y", country);
        
        assertEquals("Author name after update should be correct ",firstName+"x" +" "+lastName+"y",viewAuthorPage.getAuthorName());
        assertEquals("Country after update should be correct",country+"z",viewAuthorPage.getCountry());
        assertEquals("Biography after update should be correct",biography+"zz",viewAuthorPage.getBiography());
    }    
    
    @Test
    public void createAuthor_firstNameIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor("", randomString(),randomString(), randomString());
        assertEquals("first name is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_lastNameIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),"",randomString(), randomString());
        assertEquals("last name is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_countryIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),randomString(),"", randomString());
        assertEquals("country is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
    @Test
    public void createAuthor_biographyIsObligatory(){
    
        UserHelper.loginAsAdmin();

        AuthorHelper.addNewAuthor(randomString(),randomString(),randomString(), "");
        assertEquals("biography is obligatory, error message should display","Invalid data, please try again.",$(".v-label-undef-w").getText());
    }
}
