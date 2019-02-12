/**
 * A class representing a {@link GroceryItem} in a store.
 */
public class GroceryItem implements Comparable<GroceryItem> {
    /**
     * Used to determine the product numbers of grocery items
     * as they are created.
     */
    private static int PRODUCT_NUMBER = 100000;

    /**
     * The name of the item. Once assigned, it does not change (which is
     * why it's final).
     */
    private final String name;

    /**
     * The automatically assigned product number. Once assigned, it does
     * not change (which is why it's final).
     */
    private final int productNumber;

    /**
     * The current price.
     */
    private double price;

    /**
     * The number of the aisle in which the item can be found within the
     * store.
     */
    private int aisle;

    /**
     * Makes a new {@link GroceryItem} with the specified attributes.
     *
     * @param name The name of the new item.
     * @param price The current price of the item.
     * @param aisle The current aisle number.
     */
    public GroceryItem(String name, double price, int aisle) {
        this.name = name;
        this.price = price;
        this.aisle = aisle;

        productNumber = PRODUCT_NUMBER++;
    }

    public int getAisle() {
        return aisle;
    }

    public void setAisle(int aisle) {
        this.aisle = aisle;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GroceryItem{name=" + name +
                ", productNumber=" + productNumber +
                ", price=" + price +
                ", aisle=" + aisle + "}";
    }

    /**
     * Returns the hash code for this {@link GroceryItem}. A hash code
     * should never change, and so is based on the fields of the item
     * that do not change (name, product number).
     *
     * @return The hash code for the {@link GroceryItem}.
     */
    @Override
    public int hashCode() {
        return name.hashCode() * productNumber;
    }

    /**
     * Compares this {@link GroceryItem} to the specified object for
     * equality. Returns true iff the object is an instance of the
     * same class and has the same name and product number.
     *
     * @param o The object to which the {@link GroceryItem} is being
     *          compared.
     * @return True of the object is a {@link GroceryItem} with the
     * same name and product number; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof GroceryItem) {
            GroceryItem gi = (GroceryItem)o;
            // equals must be consistent with hash code such that
            // two grocery items that are considered equal return
            // the same hash code; for this reason we will compare
            // the same state used by hash code to determine equality.
            return gi.name.equals(this.name) &&
                    gi.productNumber == this.productNumber;
        } else {
            return false;
        }
    }

    /**
     * Establishes a natural order for {@link GroceryItem grocery items}.
     * The order is based on the lexicographic ordering of the names of
     * the two items. If both items have the same name, the product number
     * is used instead.
     * @param o The other {@link GroceryItem} to which this
     * {@link GroceryItem} is being compared.
     *
     * @return An integer that is <0, 0, or 0 if this {@link GroceryItem}
     * comes before, is the same as, or comes after in the natural ordering.
     */
    @Override
    public int compareTo(GroceryItem o) {
        int result = name.compareTo(o.name);
        if(result == 0) {
            result = productNumber - o.productNumber;
        }
        return result;
    }
}
