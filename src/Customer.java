import java.util.List;
import java.util.Set;

/**
 * Represents a {@link Customer} in a grocery store.
 */
public class Customer {
    /**
     * The customer's shopping list.
     */
    private List<String> shopping;

    /**
     * The customer's grocery cart. {@link GroceryItem items} are placed into the
     * cart as the customer shops.
     */
    private Set<GroceryItem> cart;

    /**
     * Creates a new customer with the specified shopping list and grocery cart.
     *
     * @param shopping The list of items for which the customer is shopping.
     * @param cart The cart into which the customer's grocery items are placed as
     *             the customer shops.
     */
    public Customer(List<String> shopping, Set<GroceryItem> cart) {
        this.shopping = shopping;
        this.cart = cart;
    }

    /**
     * Returns the customer's shopping list.
     *
     * @return The list of item names for which the customer is shopping.
     */
    public List<String> getShoppingList() {
        return shopping;
    }

    /**
     * Adds a {@link GroceryItem} to the customer's shopping cart.
     *
     * @param item The item to add to the shopping cart.
     */
    public void addItemToCart(GroceryItem item) {
        cart.add(item);
    }

    /**
     * Prints the current contents of the customer's shopping cart to standard
     * output.
     */
    public void printCartContents() {
        for(GroceryItem item : cart) {
            System.out.println(item);
        }
    }
}
