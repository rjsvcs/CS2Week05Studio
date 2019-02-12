import java.util.Comparator;

/**
 * An implementation of the {@link Comparator} interface that
 * compares {@link GroceryItem grocery items} by aisle number.
 */
public class AisleComparator implements Comparator<GroceryItem> {

    /**
     * Compares the two {@link GroceryItem grocery items} by
     * aisle number.
     * @param o1 The first {@link GroceryItem}.
     * @param o2 The second {@link GroceryItem}.
     * @return An integer that is <0, 0, or 0 if the first
     * grocery item's aisle number is less than, equal to,
     * or greater than the second.
     */
    @Override
    public int compare(GroceryItem o1, GroceryItem o2) {
        return o1.getAisle() - o2.getAisle();
    }
}
