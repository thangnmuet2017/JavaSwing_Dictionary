import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner scanner = new Scanner(System.in);


    // ham doc du lieu tu ban phim
    public void insertFromCommandline(Dictionary dictionary){
        System.out.print("Hay nhap tu moi: ");
        String newWord = scanner.next();
        System.out.println("Hay nhap nghia cua tu do: ");
        scanner.nextLine();
        String meansWord = scanner.nextLine();

        Word word = new Word(newWord, meansWord);
        dictionary.add( word );

        System.out.println("------------------------");
    }

    //ham doc du lieu tu file
    public void insertFromFile(Dictionary dictionary) throws IOException {
        Scanner scanFile = new Scanner(Paths.get("F:\\Java-Huong doi tuong\\Bai tap Dictionary\\my Dictionary.txt"),
                "UTF-8");
        while ( scanFile.hasNextLine()) {
            String targetWord = scanFile.next();
            String meansWord = scanFile.nextLine();
            Word word = new Word(targetWord, meansWord);
            dictionary.add(word);
        }
    }

    //HAM TIM KIEM
    public String dictionaryLookup(String word ,Dictionary dictionary) {
        int size = dictionary.getSize();
        for (int i = 0; i < size; i++) {
            if( word.equalsIgnoreCase(dictionary.wordAt(i)) ) return dictionary.meansAt(i) ;
        }
        return "    Sorry! khong tim thay tu do";
    }

}
