package pages;

public class HomePage extends BasePage{
    /**
    * Region Variables
    */
    private String searchBoxInput = "//input[@name='field-keywords']";

    /**
    * Region Constructor
    */
    public HomePage(){
        super(driver);
    }

    /**
    * Region Methods
    */

    public void doSearchByCriteria(String textToWrite){
        write(searchBoxInput, textToWrite);
        Find(searchBoxInput).submit();
    }
}
