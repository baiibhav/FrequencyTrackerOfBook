package proj5;

/**
 * This data structure models the collection of pages.
 * This data structure stores the pages numbers like 7,10,12.
 * This structure relies over other data structure and hence has several operations like insert, display and size.
 *
 * Invariant:
 * pages : pages store the pages in a sequential order it is sent without duplication.
 * pageCapacity : this stores the number of pages that a pageList can hold
 */
public class Pages {
    private ArrayQueue pages; // MAKE IT private
    private int pageCapacity;

    /**
     * Non default constructor for the pageList class
     * @param capacity the number of pages a pageList can hold
     */
    public Pages(int capacity)
    {
        pageCapacity = capacity;
        pages = new ArrayQueue(capacity);
    }

    /**
     * This method checks if the there is capacity in the pageList and if there is a duplicate or not.
     * If the listed case is satisfied, a page is hence inserted to the pageList.
     * @param newPage the new page number that is supposed to be inserted in the pageList
     */
    public void insert(int newPage) {
        if (pages.size() < pageCapacity && !isDuplicate(newPage))
            pages.insert(newPage);
    }

    /**
     * Private helper function to check if the listed page exists or not in the pageList
     * @param newPage the pageNumber to check if it exists in the pageList or not
     * @return true/false if there is a duplicate and not respectively
     */
    public boolean isDuplicate(int newPage)
    {
        boolean duplicateFlag = false;
        for (int index = 0; index < pages.size(); index++)
        {
            if (pages.getIthItem(index) == newPage)
            {
                duplicateFlag = true;
            }
        }
        return duplicateFlag;
    }

    /**
     * Displays the pageList as a string. works as a toString()
     * @return the string version of the pageList
     */
    public String display()
    {
        String toDisplay = "{";
        for (int i = 0; i<pages.size(); i++ )
        {
            if (pages.getIthItem(i) != 0)
            {
                toDisplay = toDisplay + String.valueOf(pages.getIthItem(i)) + ", ";
            }
        }
        String lastCharacter = toDisplay.substring(toDisplay.length()-2, toDisplay.length()-1);
        if (lastCharacter.compareTo(",") == 0)
        {
            return toDisplay.substring(0, toDisplay.length()-2) + "}";
        }
        else
            return toDisplay + "}";
    }

    /**
     * returns the number of pages in the list
     * @return the number of pages in the list
     */
    public int size()
    {
        return pages.size();
    }

    public int getPageAtIndex(int index)
    {
        return pages.getIthItem(index);
    }

}
