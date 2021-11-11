package pages;

public class SearchResultsPage extends BasePage{
    /**
    * Region Variables
    */
    private String paginationButton = "//ul[@class='a-pagination'] //a[contains(text(),'$NumberPage')]";
    private String itemFound = "//div[@data-component-type='s-search-result'][$NumberItem] //h2 /a";

    /**
    * Region Constructor
    */
    public SearchResultsPage(){
        super(driver);
    }

    /**
    * Region Methods
    */

    /**
    * Click on a pagination button taking into consideration that button could be out of scope of visbility, therefore is needed to move cursor up to webelement before clicking it.
    * @param numberPage Specify number page you want to access from results obtained from search
    */
    public void changeToPage(String numberPage){
        String pageToClick = paginationButton.replace("$NumberPage", numberPage);
        moveNclick(pageToClick);
    }

    /**
    * Click on a pagination button taking into consideration that button could be out of scope of visbility, therefore is needed to move cursor up to webelement before clicking it.
    * @param numberItem Specify number page you want to access from results obtained from search
    */
    public void clickOnItem(String numberItem){
        String innerLocator = itemFound.replace("$NumberItem", numberItem);
        moveNclick(innerLocator);
    }

}
