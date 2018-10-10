import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Testss {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandline commandline = new DictionaryCommandline();

        management.insertFromFile(dictionary); // lay du lieu tu file "new Dictionary"

        // bat dau
        System.out.println("Tra tu : 1 \n" +
                "Them tu : 2\n" +
                "In ra toan bo : 3\n" +
                "ket thuc : end\n" +
                ">>>>>>>>>***<<<<<<<<");
        while (true) {
            System.out.print("lua chon cua ban la: ");
            String chose = scanner.next();
            if (chose.equalsIgnoreCase("1")) {
                System.out.print("Nhap tu muon tra : ");
                String s = scanner.next();
                Dictionary dictionary1 = commandline.dictionarySearcher(s, dictionary);
                commandline.showAllWords(dictionary1);

            } else if (chose.equals("2")) {
                management.insertFromCommandline(dictionary);
            } else if (chose.equals("3")) {
                commandline.showAllWords(dictionary);
            } else if (chose.equalsIgnoreCase("end")) break;

            else continue;

        }

        management.dictionaryExportToFile(dictionary);
    }
}
