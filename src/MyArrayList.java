import java.util.Arrays;
import java.util.Iterator;

/**
 * Updated to implement the {@link Iterable#iterator()} method, as is required
 * by the fact that the parent {@link MyList} interface now extends
 * {@link Iterable}.
 */
public class MyArrayList<E> implements MyList<E> {
    private Object[] elements;
    private int size;

    public MyArrayList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E stu) {
        if(size == elements.length) {
            elements = Arrays.copyOf(elements, size*2);
        }
        elements[size] = stu;
        size++;
    }

    @Override
    public E get(int index) {
        return (E)elements[index];
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * Returns a {@link MyArrayListIterator} that can iterate over the array
     * elements maintained by this list. Allows this list to work with for
     * each loops.
     *
     * @return An {@link Iterator} capable of iterating over the elements in
     * the list's internal array.
     */
    @Override
    public Iterator<E> iterator() {
        return new MyArrayListIterator<>(elements, size);
    }
}
