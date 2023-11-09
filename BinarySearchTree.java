package proj5;


/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc.  You'll be adding
 *  code to this class for this hwk.
 *
 * @author Baibhav Barwal
 * @version 22 May, 2022
 *
 *
 * Invariant:
 * root: The starting node of a binary search tree
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;

    public BinarySearchTree() {
        root = null;
    }

    /**
     * inserts recursively.  I include this one so you can
     * make your own trees in your own testing class
     *
     * @param startingNode inserts into subtree rooted at staringNode
     * @param newNode      node to insert
     * @return startingNode with newNode already inserted
     */
    private BSTNode<E> recursiveInsert(BSTNode<E> startingNode, BSTNode<E> newNode) {
        if (startingNode == null) {
            return newNode;
        } else if (((E)startingNode.key).compareTo((E)newNode.key) < 0) {
            startingNode.rlink = recursiveInsert(startingNode.rlink, newNode);
            return startingNode;
        } else {  // startingNode.key bigger than newNode.key, so newNode goes on left
            startingNode.llink = recursiveInsert(startingNode.llink, newNode);
            return startingNode;
        }
    }

    /**
     * inserts recursively. Use this in your JUnit tests to
     * build a starting tree correctly
     *
     * @param newString String to insert
     */
    public void recursiveInsert(E newString) {
        BSTNode<E> newNode = new BSTNode<E>(newString);
        root = recursiveInsert(root, newNode);
    }

    /**
     * return tree as printable string
     *
     * @return tree in string format with form (left subtree) value (right subtree)
     */
    public String toString() {
        return  toString(root);
    }

    /**
     * recursive helper method for toString()
     *
     * @param N root of subtree to make into a string
     * @return string version of tree rooted at N
     */
    private String toString(BSTNode<E> N) {
        String ret = "";
        if (N != null) {
            ret += "(";
            ret += toString(N.llink);
            ret += "  " + N + "  ";
            ret += toString(N.rlink);
            ret += ")";
        }
        return ret;
    }

    /**
     * Inserts the new value to the Binary Search Tree.
     * Contrary to the above insert, this insert uses a iterative for loop to insert value
     * to the Binary Search Tree
     *
     * @param value String value that is supposed to be added onto the Binary Search Tree
     */
    public void insert(E value) {
        BSTNode<E> valueToAdd = new BSTNode<E>(value);
        BSTNode<E> placeToAdd = root;

        if (placeToAdd == null)
        {
            root = valueToAdd;
        }
        else {
            boolean insertionDone = false;
            while (!(insertionDone)) {
                if (((E)placeToAdd.key).compareTo((E)valueToAdd.key) < 0)
                {
                    if (placeToAdd.rlink != null)
                    {
                        placeToAdd = placeToAdd.rlink;
                    } else {
                        placeToAdd.rlink = valueToAdd;
                        insertionDone = true;
                    }
                } else
                {
                    if (placeToAdd.llink != null)
                    {
                        placeToAdd = placeToAdd.llink;
                    } else
                    {
                        placeToAdd.llink = valueToAdd;
                        insertionDone = true;
                    }
                }

            }
        }
    }

    /**
     * Searches for the value in the Binary Search Tree.
     * Returns a boolean if the target has been found.
     * This recursively returns the value
     *
     * @param target The data that must be searched
     * @return true if the value has been found and false otherwise
     */
    public boolean search(E target) {
        return recursiveSearch(root, target);
    }
    /**
     * deletes value from tree.  If value not there, do nothing.
     * @param value  int to delete
     */
    public void delete(E value) {
        root = delete(root, value);
    }

    /**
     * deletes value from tree rooted at subroot
     * @param subroot  root of tree to be deleted from
     * @param value  element to delete
     * @return pointer to tree rooted at subroot that has value removed from it
     */
    private BSTNode<E> delete(BSTNode<E> subroot, E value) {
        if (subroot == null)
        {
            return null;
        }
        else if((subroot.key).compareTo(value) > 0) // this means that the starting node is bigger than target
        {
            subroot.llink = delete(subroot.llink, value);
        }
        else if((subroot.key).compareTo(value) < 0)
        {
            subroot.rlink = delete(subroot.rlink, value);
        }
        else
        {
            if (subroot.isLeaf())
            {
                return null;
            }
            else if(subroot.hasRightChildOnly())
            {
                return subroot.rlink;
            }
            else if(subroot.hasLeftChildOnly())
            {
                return subroot.llink;
            }
            else
            {
                BSTNode<E> inOrderSuccesor = inOrderSuccesor(subroot);
                subroot.key = inOrderSuccesor.key;
                subroot.rlink = delete(subroot.rlink, subroot.key);
            }
        }
        return subroot;
    }

    private BSTNode<E> inOrderSuccesor(BSTNode<E> subroot)
    {
        subroot = subroot.rlink;
        while (subroot.llink != null) {
            subroot = subroot.llink;
        }
        return subroot;
    }

    public E get(E target)
    {
        return (E) recursiveGetElement(target, root);
    }

    private E recursiveGetElement(E target, BSTNode<E> subRoot)
    {
        if (subRoot == null)
        {
            return null;
        }

        else
        {
            if (target.compareTo(subRoot.key) == 0)
            {
                return subRoot.key;
            }
            else if (target.compareTo(subRoot.key) < 0)
            {
                return (E) recursiveGetElement(target, subRoot.llink);
            }
            else
            {
                return (E) recursiveGetElement(target, subRoot.rlink);
            }
        }
    }


    /**
     * private helper function which is used to find the node that is supposed to be searched
     * @param startingNode the parent node from under whose family the targetted node is. Most generally,
     *                     this will be root since we're looking at overall tree
     * @param target the value that is searched in the Tree
     * @return True if the node has been found and false else
     */
    private boolean recursiveSearch(BSTNode<E> startingNode, E target) {

        if (startingNode == null) {

            return false;}
        else {
            if (target.compareTo((E) startingNode.key) == 0)
            {
                return true;
            }
            if (((E)startingNode.key).compareTo(target) > 0) // this means that the starting node is bigger than target
            {
                return recursiveSearch(startingNode.llink, target);
            } else {
                return recursiveSearch(startingNode.rlink, target);
            }
        }
    }


    /**
     * counts the size of the tree using recursion.
     * Branches the tree to left subtree and right sub tree and the basic count of this
     * function is +1.
     * @param startingNode the node in the tree from which the counting must star
     * @return the number of nodes in that tree
     */
    private int sizeR(BSTNode<E> startingNode)
    {
        if (startingNode == null)
        {
            return 0;
        }
        else
        {
            return sizeR(startingNode.llink) + sizeR(startingNode.rlink) + 1;
        }
    }


    /**
     * The number of data items(nodes) in the tree.
     * Uses recursion to count the number of items.
     * @return the integer value which is the number of nodes
     */
    public int size()
    {
        return sizeR(root);
    }
}



// things to do
// 1. write a java docs for link node thing
// 2. write a test for delete
// 3. complete the java docs for bst