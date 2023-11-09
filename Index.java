package proj5;


/**
 * Once a word is decided to in the index, it makes an object of the index.
 * Then that object is handled by the following handle method written below.
 * This index just handles word and nothing more like Integer, Float etc.
 *
 * Invariant:
 *
 * index: index is a instance variable which is used to store the indexedWord. The indexedWord is a data
 * that stores a word and the information about the pages where that word occurs. Therefore, in a nutshell,
 * it stores the entire information about the word and the page it exists in.
 */
public class Index{

    private final static int MIN_LENGTH_FOR_INDEX = 2;
    private final static int MAX_PAGE_LIST_SIZE_FOR_INDEX = 4;

    private BinarySearchTree<indexedWords> index;

    public Index()
    {
        index = new BinarySearchTree<>();
    }


    /**
     * insert is a simple helper method which is used to add the indexedWord into the index.
     * @param toInsert the word that is supposed to be added to the index
     */
    public void insert(indexedWords toInsert)
    {
        index.insert(toInsert);
    }


    /**
     * This method deletes the provided indexedWord from the index.
     * @param toDelete  the word that is suppsoed to be deleted
     */
    public void deleteIndex(indexedWords toDelete)
    {
        index.delete(toDelete);
    }

    /**
     * This method is the heart of this project. It reads each and every word from the text file and checks into the
     * index. If the word exits there and there are still space on the page storage, it adds the page onto the page storage.
     * Otherwise, there are cases which makes the word be updated into the dictionary. As already mentioned above,
     * dicitonary stores the word that has the most occurance. Hence, this method controls everything.
     *
     * @param fileName The name of the file that has to be read and made an index.
     */
    public void convert(String fileName) {
        FileReader file = new FileReader(fileName);
        int pageNumber = 1;
        String word = file.nextToken();
        boolean endOfFile = word == null;


        Dictionary dictWord = new Dictionary();

        while (!endOfFile) // This makes one extra statement execute inside the loop. However, introducing this
        // makes the code understandable
        {
            if (word.length() > MIN_LENGTH_FOR_INDEX && (!dictWord.exists(word))) {
                indexedWords wordForIndex = new indexedWords(word, pageNumber);
                if (index.search(wordForIndex))
                {
                    indexedWords indexFromTree = index.get(wordForIndex);
                    if (!indexFromTree.hasPageNumber(pageNumber))
                    {
                        if (indexFromTree.getPageListSize() < MAX_PAGE_LIST_SIZE_FOR_INDEX)
                        {
                            indexFromTree.updatePage(pageNumber);
                        }
                        else // pageList is full
                        {

                            System.out.println("Deleting '" + indexFromTree.toString() + "' from index");
                            this.deleteIndex(indexFromTree);
                            dictWord.insert(indexFromTree.getWord());
                        }
                    }
                }
                else
                {
                    indexedWords newIndex = new indexedWords(word, pageNumber);
                    this.insert(newIndex);
                }
            }

            word = file.nextToken();
            endOfFile = word == null;

            if (!endOfFile && word.equals("#"))
            {
                pageNumber++;
            }
        }

        System.out.println(this);
        System.out.println(dictWord);
    }


    public String toString()
    {
        if (index.size() == 0)
        {
        return " ";
        }
        String withBracket = index.toString();
        String withoutBracket = "";
        for (int index = 0; index < withBracket.length(); index++) {
            String charAtThatPlace = withBracket.substring(index, index + 1);
            if (!((charAtThatPlace).compareTo("(") == 0 || charAtThatPlace.compareTo(")") == 0)) {
                withoutBracket = withoutBracket + charAtThatPlace;
            }
        }
        withoutBracket = withoutBracket.substring(2);
        String[] inArray = withoutBracket.split("    ");
        String toString = "";
        for (String word : inArray)
        {
            toString = toString + word + "\n";
        }
        return toString;
    }
}
