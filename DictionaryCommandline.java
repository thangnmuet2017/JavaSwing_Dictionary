import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {

    static Scanner scanner = new Scanner(System.in);

    public void showAllWords(Dictionary dictionary) {
        int size = dictionary.getSize();
        for (int i = 0; i < size; i++) {
            dictionary.showWord(i);
        }
    }

    public Dictionary dictionarySearcher( String s, Dictionary dictionary ) {
        Dictionary newDictionary = new Dictionary();
        int size = dictionary.getSize();
        boolean added = false;
        for(int i = 0; i < size; i++ ) {
            if( dictionary.wordAt(i).equare(s) ) {
                newDictionary.add(dictionary.wordAt(i) );
                added = true;
            }
            else if( added == true ) break;
        }
        return newDictionary;
    }
}
