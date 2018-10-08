import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Testss {
    static Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner scanFile;
        scanFile = new Scanner
                (Paths.get("F:\\Java-Huong doi tuong\\Bai tap Dictionary\\my Dictionary.txt"),
                        "UTF-8");

        ArrayList<Word> listWord = new ArrayList<>();
        Dictionary dictionary = new Dictionary(listWord);
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandline commandline = new DictionaryCommandline();

        management.insertFromFile(dictionary);
        commandline.showAllWords(dictionary);

        System.out.println(dictionary.getSize());

        String s=management.dictionaryLookup("find", dictionary);
        System.out.println(s);
    }
}
