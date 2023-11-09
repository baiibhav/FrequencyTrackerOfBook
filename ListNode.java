package proj5;

/**
 * The ListNode class is more data-specific than the LinkedList class.  It
 * details what a single node looks like.  This node has one data field,
 * holding a pointer to a String object.
 *
 * This is the only class where I'll let you use public instance variables.
 *
 * Invariant:
 * "data" represents the value stored in the list node
 * "next" represents the next list node that is connected with the previous list node. If a list node is [1]->[2]->[3]..
 * then the next of [1] is [2]
 *
 * @author baibhavbarwal
 * @version 13th May, 2022
 *
 */
public class ListNode
{
    public Integer data;
    public ListNode next;

    /**
     * the constructor for the ListNode
     * @param newData the data which must be made a listNode of
     */
    public ListNode(Integer newData)
    {
        data = newData;
        next = null;
    }

    /**
     * returns data as a printable string
     * @return the string version of the token inside the ListNode
     */
    public String toString()
    {
        return data.toString();
    }

}