package proj5;

import java.util.Locale;

/**
 * Dictionary is a class which in which a tree is passed and a word along with it. The words is handled accordingly.
 * That behavior is described in the underlying ADT which uses dictionary.
 *
 * @author baibhavbarwal
 * @version 25th May 2022
 *
 * Invariant:
 *
 * dictionary: dictionary is the instance variable which stores all the words that has been used frequently in the text.
 *             It is stored in a binary search tree due to high intensity of searching ot be performed.
 */
public class Dictionary{

    private BinarySearchTree<String> dictionary;

    public Dictionary()
    {
        dictionary = new BinarySearchTree<>();
    }

    /**
     * This is a helper method which returns is the word is present in the dictionary or not.
     * It returns a boolean.
     * @param wordTarget the word that is supposed to be checked in the dictionary
     * @return True if the word exists and false otherwise.
     */
    public boolean exists(String wordTarget)
    {
        String wordFromDict = dictionary.get(wordTarget);
        boolean wordFound = false;
        if (!(wordFromDict == null))
        {
            if (wordFromDict.toLowerCase(Locale.ROOT).equals(wordTarget.toLowerCase())) {
                wordFound = true;
            }
        }
        return wordFound;
    }



    /**
     * Insert is a method which is used to insert the word that has to be added into the dictionary. There are cases which
     * must be satisfied for a word to be added in the index class. Hence this method is only called when all the cases are satisfied. Therefore,
     * it is just a simple insert method.
     * @param word The word that has to be added to the dictioanry.
     */
    public void insert(String word)
    {
        if (!dictionary.search(word)) {
            dictionary.insert(word);
        }
    }

    public String toString()
    {
        if (dictionary.size() == 0)
        {
            return " ";
        }
        String withBracket = dictionary.toString();
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




