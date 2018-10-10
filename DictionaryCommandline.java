import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {

    static Scanner scanner = new Scanner(System.in);

// ham in ra toan bo tu dien
    public void showAllWords(Dictionary dictionary) {
        int size = dictionary.getSize();
        if( size > 0 ) {
            for (int i = 0; i < size; i++) {
                dictionary.showWord(i);
            }
        }
        else {
            System.out.println("khong co tu nao nhu vay");
        }
        System.out.println("------------------");
    }

//
    public Dictionary dictionarySearcher( String s, Dictionary dictionary ) {
        Dictionary newDictionary = new Dictionary();
        int size = dictionary.getSize();
        for(int i = 0; i < size; i++ ) {
            if( dictionary.wordAt(i).contains( s ) ) {
                newDictionary.add(dictionary.wordAt(i) );
            }
        }
        return newDictionary;
    }
}
