package proj5;

/**
 * This is a queue interface. Any queue that is added onto to this project or if in any case the queue's underlying data
 * structure is changed from array to linkedlist, the program will still use this interface. This ensures the following method
 * exits. These methods are the required methods for this project to run, hence in any extreme cases the project will
 * never fail.
 *
 * @author baibhavbarwal
 * @version 2nd June, 2022
 */
public interface Queue {

    /**
     * The size of the queue.
     * @return the integer size of the queue
     */
    public int size();

    /**
     * returns if the queue is empty or not.
     * @return true if the queue is empty
     */
    public boolean isEmpty();

    /**
     * inserts a new integer to the queue.
     * @param element the integer that is supposed to be added onto the queue.
     */
    public void insert(int element);
}
