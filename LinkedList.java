package proj5;


/**
 *  This class models the entire linked list which is a chain of different ListNode.
 *
 *  Invariants:
 *  length: the total number of elements present in the linked list
 *  firstNode: the element at the start of the linked list. it is represented as a ListNode object.
 *
 * @author baibhavbarwal
 * @version 13th May, 2022
 */
public class LinkedList {
    private int length;
    private ListNode firstNode;

    /**
     * Default Constructor for LinkedList class which has length and firstNode as the parameter.
     * Here Length is the size of the linked list as it grows
     * firstNode stores the information of the first element in the linked list
     */
    public LinkedList() {
        length = 0;
        firstNode = null;
    }

    /**
     * getter for the current length of the linked list
     *
     * @return the length of the linked list
     */
    public int getLength() {
        return length;
    }

    /**
     * private helper function to increment the length
     */
    private void incrementLength() {
        length++;
    }

    /**
     * private helper function to get the first node
     */
    private ListNode getFirstNode() {
        return firstNode;
    }

    /**
     * private helper function to set the first Node to the given ListNode
     */
    private void setFirstNode(ListNode newNode) {
        firstNode = newNode;
    }


    /**
     * this method is used to add a new element to the start of the Linked List
     *
     * @param data the data that is supposed to be added to the start of the linked list
     */
    public void insertAtHead(Integer data) {
        ListNode newNode = new ListNode(data);
        if (getLength() != 0) {
            newNode.next = firstNode;
        }
        setFirstNode(newNode);
        incrementLength();
    }

 }