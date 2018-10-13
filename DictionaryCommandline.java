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
        } else {
            System.out.println("khong co tu nao nhu vay");
        }
        System.out.println("------------------");
    }

//  ham tra ve mot danh sachh ma co nhung ky tu dau bang (String s)
    public Dictionary dictionarySearcher( String s, Dictionary dictionary ) {
        Dictionary newDictionary = new Dictionary();
        int size = dictionary.getSize();
        int added = 0;
        for(int i = 0; i < size; i++ ) {
            if( dictionary.wordAt(i).contains( s ) ) {
                newDictionary.add(dictionary.wordAt(i) );
                if( ! dictionary.wordAt(i+1).contains( s ) )
                    break;
            }
        }
        return newDictionary;
    }

    // ham tim kiem va in ra man hinh
    public void searchWord(String word, Dictionary dictionary ) {
        DictionaryManagement management = new DictionaryManagement();
        int i = management.dictionaryLookup(word, dictionary);
        if ( i >= 0) {
            System.out.printf("--->KQ: %-12s |  %s \n",
                    dictionary.wordTargetAt(i), dictionary.wordExpainsAt(i));
        } else {
            Dictionary newDictionary = dictionarySearcher(word, dictionary); // tao ra mot tu dien con co nhung ky tu dau giong nhau
            showAllWords(newDictionary); // in toan bo tu dien con do
        }
    }
}
