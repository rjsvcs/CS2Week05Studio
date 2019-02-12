/**
 * Now extends {@link Iterable}, which requires implementing class to
 * implement the {@link Iterable#iterator()} method to return a working
 * {@link java.util.Iterator}.
 *
 * @param <E> The type of element to be stored in the list.
 */
public interface MyList<E> extends Iterable<E> {
    // needed for ratings problem
    void add(E element);
    E get(int index);
    int size();
    // Iterator<E> iterator();
}
