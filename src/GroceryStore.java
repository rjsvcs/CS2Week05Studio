import java.util.*;

/**
 * Simulates a {@link GroceryStore} stocked with {@link GroceryItem items}.
 */
public class GroceryStore {
    /**
     * A warehouse of products organized by aisle number.
     */
    private Map<Integer, List<GroceryItem>> warehouse;

    /**
     * Tracks the available quantity of each product.
     */
    private Map<GroceryItem,Integer> stock;

    /**
     * Used to quickly retrieve a {@link GroceryItem} given its name.
     */
    private Map<String,GroceryItem> products;

    public GroceryStore() {
        // the warehouse is organized by aisle number, and so
        // a TreeMap is used
        this.warehouse = new TreeMap<>();
        // order doesn't matter for the stock, and so the higher
        // performance of a HashMap is preferred
        this.stock = new HashMap<>();
        // order is also not important for the products
        products = new HashMap<>();
    }

    /**
     * Prints the contents of the warehouse to standard output.
     */
    public void printWarehouse() {
        for(int aisle: warehouse.keySet()) {
            List<GroceryItem> items = warehouse.get(aisle);
            System.out.println("AISLE #" + aisle);
            for(GroceryItem item: items) {
                System.out.println("  " + item);
            }
        }
    }

    /**
     * Prints the current stock.
     */
    public void printStock() {
       for(GroceryItem item: stock.keySet()) {
           System.out.println(item + ":" + stock.get(item));
       }
    }

    /**
     * Makes a shopping list by choosing n random grocery items from the
     * available stock.
     *
     * @param n The length of the shopping list.
     *
     * @return The list of item names to shop for.
     */
    public List<String> makeList(int n) {
        List<GroceryItem> items = new ArrayList<>();
        // use the addAll method on list to add all of the grocery
        // item names all at once
        items.addAll(stock.keySet());

        // randomize the order of the items in the list
        Collections.shuffle(items);

        // copy the name of the first n items in the randomized list
        // to the shopping list
        List<String> shopping = new LinkedList<>();
        for(int i=0; i<n; i++) {
            shopping.add(items.get(i).getName());
        }
        return shopping;
    }

    /**
     * Simulates a shopping trip by one customer.
     *
     * @param customer The customer that is shopping.
     */
    public void shop(Customer customer) {
        for(String name: customer.getShoppingList()) {
            GroceryItem item = products.get(name);
            System.out.println("Customer adds " + name + " to their cart.");
            customer.addItemToCart(item);
        }

        System.out.println("The customer unloads their cart...");
        customer.printCartContents();
    }
}
