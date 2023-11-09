package proj5;

/**
 * This class models the object that will be stored in the Index.
 * It has two key features as described in the invariant below.
 *
 * Invariant:
 *
 * word: this instance variable models the word from the book that has to be updated in the index
 * pageList: this instance variable keeps track of the pages where the word occurs
 *
 * @author baibhavbarwal
 * @version 27th May, 2022
 */
public class indexedWords implements Comparable<indexedWords> {

    private String word;
    private Pages pageList;

    private int MAX_PAGELIST_CAPACITY = 4; // the maximum size a word in the index can hold. Anything above 4 will
                                          // will go to the dictionary class

    public indexedWords(String wordFromBook, int initialPage)
    {
        word = wordFromBook;
        pageList = new Pages(MAX_PAGELIST_CAPACITY);
        pageList.insert(initialPage);
    }

    /**
     * getter method for the word. It returns the word only from the information set which stores the word and the pages
     * the word occur in.
     * @return the string word that has been requested
     */
    public String getWord()
    {
        return word;
    }

    /**
     * This method checks if the provided page number exists in the pageList
     * @param page the page that is supposed to be checked
     * @return true if the page exists in the pageList
     */
    public boolean hasPageNumber(int page)
    {
        return pageList.isDuplicate(page);
    }


    /**
     * Returns the number of pages that exists in the pageList
     * @return the integer number of pages
     */
    public int getPageListSize()
    {
        return pageList.size();
    }

    /**
     * This method is like a simple toString which is used to display the pageList
     * @return the string version of the pageList.
     */
    public String showPageList()
    {
        return pageList.display();
    }

    /**
     * This method adds a new page to the pageList. It works like a setter for updating the pageList
     * @param page the page that is supposed to be added.
     */
    public void updatePage(int page)
    {
        pageList.insert(page);
    }

    @Override
    public int compareTo(indexedWords anotherIndexedWord)
    {

        return (word.toLowerCase()).compareTo((anotherIndexedWord.word).toLowerCase());
    }

    public String toString()
    {

        return word + " " + pageList.display();
    }
}
