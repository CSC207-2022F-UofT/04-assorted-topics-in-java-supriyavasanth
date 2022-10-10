/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.ArrayList;
import java.util.List;

public class DrivableTrader<D> {
    private final List<D> inventory;
    private final List<D> wishlist;
    private int money;


    /**
     * Construct a Trader, giving them the given inventory,
     * wishlist, and money.
     *
     * @param inventory Objects in this Trader's inventory
     * @param wishlist  Objects in this Trader's wishlist
     * @param money     The Trader's money
     */
    public DrivableTrader(List<D> inventory, List<D> wishlist,
                  int money) {
        this.inventory = inventory;
        this.wishlist = wishlist;
        this.money = money;
    }

    public DrivableTrader(int money){
        this.inventory = null;
        this.wishlist = null;
        this.money = money;
    }

    public void addToWishlist(D item){
        this.wishlist.add(item);
    }

    public int getSellingPrice(D item){
        if (item instanceof Tradable)
        {
            return ((Tradable) item).getPrice() + ((Drivable) item).getMaxSpeed();
        }

        return Tradable.MISSING_PRICE;
    }
}