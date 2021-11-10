package pages;

public class SearchResultsPage extends BasePage{
    /**
    * Region Variables
    */
    private String paginationButton = "//ul[@class='a-pagination'] //a[contains(text(),'$NumberPage')]";
    private String itemFound = "//div[@data-component-type='s-search-result'][$NumberItem]";

    /**
    * Region Constructor
    */
    public SearchResultsPage(){
        super(driver);
    }

    /**
    * Region Methods
    */

    public void changeToPage(String numberPage){
        String pageToClick = paginationButton.replace("$NumberPage", numberPage);
        Find(pageToClick).click();
    }

    public void clickOnItem(String numberItem){
        String itemToClick = itemFound.replace($NumberItem, numberItem);
        Find(itemToClick).click();
    }

}
