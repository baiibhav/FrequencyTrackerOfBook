package proj5;


import java.util.Arrays;

/**
 * This is a Queue data structure. It implements the Queue interface which makes the data structure implement few
 * methods such as size, isEmpty, insert. This makes the class more robust and reusable since if we change the
 * underlying structure of the Queue to other data structure, the program will still run until and unless it implements
 * a queue.
 *
 * Queue is a linear structure which follows the basic principle of FIFO which stands for First In First Out.
 *
 * @author baibhavbarwal
 * @version 2nd June, 2022
 *
 * Invariants:
 * rear: rear is a pointer that points to the last element of the queue.
 * count: count is the number of elements present inside the Queue.
 * capacity: capacity is the total number of element that the queue can hold.
 * front: front is the pointer that points to the first element of the queue
 * capacityIncrement: capacityIncrement is the value which is initiated by the user that helps the growth of the size
 *                    in an array. If the capacity of an queue is 5, and when the size reaches 5, the capacity increases
 *                    to 10.
 */
public class ArrayQueue implements Queue{

    private static final int DEFAULT_INCREMENT = 5;
    private static final int DEFAULT_SIZE = 10;

    private int rear;
    private int count;
    private int capacity;
    private int front;
    private int capacityIncrement;

    private int[] itemArray;


    /**
     * Default constructor for the array queue class. Here, the user can't initialize the capacity of the queue.
     */
    public ArrayQueue()
    {
        front = 0; rear = 0; count = 0;
        capacity = DEFAULT_INCREMENT;
        itemArray = new int[capacity];
        capacityIncrement = DEFAULT_INCREMENT;
    }


    /**
     * Non default constructor where the user can decide the capacity of the queue.
     * @param userCapacity the capacity user wishes to start the queue with.
     *
     */
    public ArrayQueue(int userCapacity)
    {
        front = 0; rear = 0; count = 0;
        capacity = userCapacity;
        itemArray = new int[capacity];
        capacityIncrement = DEFAULT_INCREMENT;
    }


    /**
     * the helper method which gives you the size of the queue
     * @return the size of the queue
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * helper that checks if the queue is empty or not
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * insert a new integer to the queue.
     * @param newItem the new integer that is supposed to be added to the array
     */
    @Override
    public void insert(int newItem) {

        if (count == capacity) {
            capacity += capacityIncrement;
            int[] tempArray = new int[capacity];

            if (front == 0) {
                rear = count;
                for (int i = front; i < rear; i++) {
                    tempArray[i] = itemArray[i];
                }
            } else {
                for (int i = 0; i < rear; i++) {
                    tempArray[i] = itemArray[i];
                }
                for (int i = front; i < count; i++) {
                    tempArray[i + capacityIncrement] = itemArray[i];
                }
                front += capacityIncrement;
            }

            itemArray = tempArray;
        }
        itemArray[rear] = newItem;
        rear = (rear + 1) % capacity;
        count ++;
    }

    /**
     * helper function that removes the integer from the queue.
     * @return the integer that has been removed
     */
    public Integer remove()
    {
        if (count == 0)
        {
            return null;
        }

        else
        {
            int tempItem = itemArray[front];
            front = (front+1) % capacity;
            count --;
            return new Integer(tempItem);
        }
    }

    /**
     * returns the item in an array from the provided position
     * @param i the index from where the user wants to retrieve the data from
     * @return
     */
    public int getIthItem(int i)
    {
        return itemArray[i];
    }

    public String toString()
    {
        return Arrays.toString(itemArray);
    }
}
