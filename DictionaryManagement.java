package cmd_dictionary_2;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner scanner = new Scanner(System.in);
     // phuong thuc lay ve chi so de them word vao dictionary theo thu tu abc
    static int getAddedIndex(Dictionary dict, Word word, int beginIndex, int endIndex) {
        // neu word xep sau tu dung o vi tri endIndex trong tu dien
        if ( !dict.wordAt(endIndex).compareTo(word) ) { 
             return endIndex + 1;
        }
        // neu word xep truoc tu dung o vi tri beginIndex trong tu dien
        if ( dict.wordAt(beginIndex).compareTo(word) ) {
             return beginIndex;
        }
        int mid = (beginIndex + endIndex)/2;
        // neu word dung sau dict[mid]
        if ( !dict.wordAt(mid).compareTo(word) ) {
             return getAddedIndex(dict, word, mid + 1, endIndex);
        }
        // neu word dung truoc dict[mid]
        else {
            return getAddedIndex(dict, word, beginIndex, mid - 1);
        }
    }


/*
    ham them word tu ban phim
    ham nay da cai tien ( them va sap xep theo thu tu abc..)
 */
    public void insertFromCommandline(Dictionary dictionary) {
        System.out.print("Hay nhap tu moi: ");
        String newWord = scanner.next();
        System.out.print("Hay nhap nghia cua tu do: ");
        scanner.nextLine(); 
        String meaningWord = scanner.nextLine();

        Word word = new Word(newWord, meaningWord);
        int dict_size = dictionary.getSize();
        int addedIndex = getAddedIndex(dictionary, word, 0, dict_size - 1);
        dictionary.add(addedIndex, word);
        System.out.println("------------------------");
    }

/*
    Cai tien ham them tu file
    them tu dong thoi sap xep theo thu tu abc
 */
    public void insertFromFile(Dictionary dictionary) {
        // tao ra doi tuong file
        File file = new File("dictionaries.txt");
        try( Scanner scanner = new Scanner(file) ) {
            String target = "";
            String explain = "";
            while (scanner.hasNext()){
                String curLine = scanner.nextLine(); // lay ra dong hien tai
                // sau do tao mang String ngan cach boi dau tab
                String[] splitted = curLine.split("\t"); 
                target = splitted[0].trim();
                explain = splitted[1].trim();
                Word newWord = new Word(target, explain);
                dictionary.add(newWord);
            }
        } catch (Exception e) {
        }
    }
    
    // tra tu tuyet doi (chi cho ra 1 tu duy nhat)
    public String dictionaryLookup(String word ,Dictionary dictionary) {
        int size = dictionary.getSize();
        // sua thanh binary search
        for (int i = 0; i < size; i++) {
            if( word.equalsIgnoreCase(dictionary.wordTargetAt(i)) ) {
                return dictionary.meaningAt(i) ;
            }
        }
        return "Khong tim thay tu do!";
    }
    
    // ghi vao file
    public void dictionaryExportToFile(Dictionary dictionary) {
        File file = new File("dictionaries.txt");
        int list_size = dictionary.getSize();
            try (PrintWriter pw = new PrintWriter(file)) {
                for (int i = 0; i < list_size; i++) {
                    pw.print( dictionary.wordTargetAt(i) + "\t" );
                    pw.println( dictionary.meaningAt(i) );
                }
            } catch (Exception e) {
            }
       
    }
}

