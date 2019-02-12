import java.util.Iterator;

/**
 * An implementation of the {@link Iterator} interface that can iterate over
 * an array that is partially full of elements.
 *
 * @param <E> The type of element in the array.
 */
public class MyArrayListIterator<E> implements Iterator<E> {
    /**
     * The array of elements; it is only partially full.
     */
    private final Object[] elements;

    /**
     * The number of elements in the partially full array (the rest are
     * assumed to be garbage/null).
     */
    private final int size;

    /**
     * The iterator must remember which elements it has already returned; this
     * field is used to keep track of its current position in the array.
     */
    private int current;

    /**
     * Creates a new iterator to iterate over the specified array.
     *
     * @param elements The array of elements over which this iterator will
     *                 iterate.
     * @param size The number of valid elements in the array.
     */
    public MyArrayListIterator(Object[] elements, int size) {
        this.elements = elements;
        this.size = size;
        current = 0;
    }

    /**
     * Returns true of the iterator has not yet returned all of the valid
     * elements in the array.
     *
     * @return True if there is at least one more element in the array.
     */
    @Override
    public boolean hasNext() {
        System.out.println("calling hasNext: " + (current < size));
        return current < size;
    }

    /**
     * Returns the element to which the iterator is currently pointing in the
     * array (as determined by its {@link #current} position).
     *
     * @return The next element in the array.
     */
    @Override
    public E next() {
        E element = (E)elements[current];
        System.out.println("calling next: " + element);
        current++;
        return element;
    }
}
