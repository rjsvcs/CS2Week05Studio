/**
 * Demonstrates using the {@link MyList} interface inside of a for each loop.
 * This is possible because {@link MyList} extends the {@link Iterable}
 * interface, and {@link MyArrayList} implements it and provides a working
 * {@link java.util.Iterator}.
 */
public class Main {
    /**
     * Makes a list, adds a few strings to it, and then uses a for each loop to
     * print them out.
     *
     * @param args Ignored.
     */
    public static void main(String[] args) {
        MyList<String> strings = new MyArrayList<>(5);
        strings.add("abc");
        strings.add("def");
        strings.add("Buttercup");

        // for each uses the Iterable interface to get an Iterator from the
        // list, and then uses the Iterator's hasNext() and next() methods
        // to control iteration.
        for(String string : strings) {
            // the next() method is called and the value returned is assigned
            // to the string variable before each iteration
            System.out.println(string);
        }
    }
}
