package pages;

public class ItemPage extends BasePage{
    /**
    * Region Variables
    */
    String addToCartBtn = "//input[@id='add-to-cart-button']";
    String qtyItemCart =  "//div[@id='nav-cart-count-container'] /span[@id='nav-cart-count']";

    /**
    * Region Constructor
    */
    public ItemPage(){
        super(driver);
    }

    /**
    * Region Methods
    */

    public int getAddToCartSize(){
        return getAllElements(addToCartBtn).size();
    }
}
