package se.nackademin.librarytest.pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author nicklas
 */
public class BrowseBooksPage extends PageBase{
    @FindBy(css="#gwt-uid-3")
    private SelenideElement titleField;
    
    @FindBy(css="#gwt-uid-5")
    private SelenideElement nameOfAuthorField;
    
    @FindBy(css="#gwt-uid-7")
    private SelenideElement isbnField;
    
    @FindBy(css="#gwt-uid-9")
    private SelenideElement datePublishedField;
    
    @FindBy(css="#search-books-button")
    private SelenideElement  searchBooksButton;
    
    @FindBy(css="td.v-grid-cell:nth-child(1) > a:nth-child(1)")
    private SelenideElement firstResultTitle;
    
    public void clickFirstResultTitle(){
        firstResultTitle.click();
    }
    
    public void setTitleField(String title){
        setTextFieldValue("title",title,titleField);
    }
    
    public void setNameOfAuthorField(String author){
        setTextFieldValue("name of author",author,nameOfAuthorField);
    }
    
    public void setIsbnField(String isbn){
        setTextFieldValue("isbn",isbn,isbnField);
    }
    public void setDatePublishedField(String datePublished){
        setTextFieldValue("date published",datePublished,datePublishedField);
    }
    
    public void clickSearchBooksButton(){
        searchBooksButton.click();
    }
}
