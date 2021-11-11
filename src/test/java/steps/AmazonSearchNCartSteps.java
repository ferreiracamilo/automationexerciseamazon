package steps;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.BasePage;
import pages.HomePage;
import pages.ItemPage;
import pages.SearchResultsPage;

public class AmazonSearchNCartSteps {
    HomePage homepage = new HomePage();
    SearchResultsPage resultsPage = new SearchResultsPage();
    ItemPage itemPage = new ItemPage();

    @Given("^the user navigates to www.amazon.com$")
    public void navigateToAmazon(){
        BasePage.navigateTo("https://www.amazon.com/");
    }

    @And("^searches for (.+)$")
    public void completeSearchForItem(String itemName){
        homepage.doSearchByCriteria(itemName);
    }

    @And("^navigates to the page (.+)$")
    public void changePageNumber(String pageNumber){
        resultsPage.changeToPage(pageNumber);
    }

    @And("^selects the item (.+)$")
    public void selectItemByIndex(String itemNumber){
        resultsPage.clickOnItem(itemNumber);
    }

    @Then("^assert that the item would be available for purchase$")
    public void verifyRules(){
        Assert.assertNotEquals(itemPage.getAddToCartSize(), 0); //Verify size of driver find elements of "Add to cart" is greather than zero (defect value)
    }
}
