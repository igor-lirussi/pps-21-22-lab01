package lab01.tdd;

/**
 * Represent a select Strategy to be applied to determine which is the next element to chose in a CircularList
 *
 * NOTE: this is a SINGLE METHOD INTERFACE, so if a method gets this as a parameter or returns it:
 * I can pass a LAMBDA instead of a class that implements this interface!
 * see SimpleFactory class
 */
public interface SelectStrategy {

    /**
     * Determines if the element satisfies the strategy
     * @param element the element to be checked
     * @return true if the element satisfies the strategy, false otherwise
     */
    boolean apply(final int element);
}
