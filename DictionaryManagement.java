import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner scanner = new Scanner(System.in);

/*
    ham them word tu ban phim
    ham nay da cai tien ( them va sap xep theo thu tu abc..)
 */
    public void insertFromCommandline(Dictionary dictionary){
        System.out.print("Hay nhap tu moi: ");
        String newWord = scanner.next();
        System.out.println("Hay nhap nghia cua tu do: ");
        scanner.nextLine();
        String meansWord ="\t" + scanner.nextLine();

        Word word = new Word(newWord, meansWord);
        boolean added = false;
        for (int i = dictionary.getSize(); i>=1 ; i--) {
            if ( word.compareTo( dictionary.wordAt(i-1) ) ) {
                dictionary.add(i, word);
                added = true;
                break;
            }
        }
        if( !added ) dictionary.add(0, word);

        System.out.println("------------------------");
    }



/*
    Cai tien ham them tu file
    them tu dong thoi sap xep theo thu tu abc
 */
    public void insertFromFile(Dictionary dictionary) throws IOException {
        Scanner scanFile = new Scanner(Paths.get("new Dictionary.txt"), "UTF-8");
        while ( scanFile.hasNext() ) {
            String targetWord = scanFile.next();
            String meansWord = scanFile.nextLine();
            Word word = new Word(targetWord, meansWord);

            boolean added = false;
            for (int i = dictionary.getSize(); i>=1 ; i--) {
                if ( word.compareTo( dictionary.wordAt(i-1) ) ) {
                    dictionary.add(i, word);
                    added = true;
                    break;
                }
            }
            if( !added ) dictionary.add(0, word);
        }
    }
    //HAM TIM KIEM
    public String dictionaryLookup(String word ,Dictionary dictionary) {
        int size = dictionary.getSize();
        for (int i = 0; i < size; i++) {
            if( word.equalsIgnoreCase(dictionary.wordTargetAt(i)) ) return dictionary.meansAt(i) ;
        }
        return "    Sorry! khong tim thay tu do";
    }

    // ham xuat du lieu tu dien ra file
    public void dictionaryExportToFile(Dictionary dictionary) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("new Dictionary.txt", "UTF-8");
        for(int i=0; i < dictionary.getSize(); i++) {
            printWriter.println(dictionary.wordTargetAt(i) + dictionary.meansAt(i)   );
        }
        printWriter.close();
    }

}
