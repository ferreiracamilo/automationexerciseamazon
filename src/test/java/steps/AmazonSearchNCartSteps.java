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
        itemPage.addItemToCart(); //Add item to cart
        System.out.println("Ya hice click en el carrito");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // Assert.assertNotEquals(itemPage.getQTYcart(), 0); //Verify the number within shopping cart icon is different than zero (defect value)

        //HARD ASSERTS were used based on the fact that is there's no actual "Add to cart" button is not needed to continue remaining actions
    }
}
