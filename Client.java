package proj5;

/**
 * Client is basically a simple class which is used as a bridge between the user and the code.
 * It just has two lines of code which makes a book object out of the given source text file.
 * Next, the client object calls a method to call the index from the book class.
 *
 * @author baibhavbarwal
 * @version 25th May, 2022
 */
public class Client
{
    public static void main(String[] args)
    {
        makeIndex("src/proj5/input.txt"); //replace with correct path
    }

    /**
     * Makes an index out of fileName. Gradescope needs this function.
     *
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {
        Index book = new Index();
        book.convert(fileName);

    }
}
