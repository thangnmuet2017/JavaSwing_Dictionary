import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandline commandline = new DictionaryCommandline();

        management.insertFromFile(dictionary); // lay du lieu tu file "new Dictionary"

        // bat dau
        System.out.println(">>>>>>>* My Dictionary *<<<<<<<<<");
        System.out.println("1. tra tu dien\t|2. them tu moi\n" +
                           "3. in tu dien \t|4. sua mot tu \n" +
                           "5. xoa mot tu \t|end. ket thuc");
        System.out.println("----------------------------------");
        while (true) {
            System.out.print  ("lua chon cua ban la: ");
            String chose = scanner.next();
            if (chose.equalsIgnoreCase("1")) { // tra tu dien
                System.out.print("Nhap tu muon tra : ");
                String s = scanner.next();
                commandline.searchWord(s, dictionary);

            } else if (chose.equals("2")) { // them tu
                management.insertFromCommandline(dictionary);
            } else if (chose.equals("3")) {  // in ra toan bo
                commandline.showAllWords(dictionary);
            } else if (chose.equals("4")) { // sua nghia mot tu
                management.repairOneWord( dictionary);
            } else if (chose.equals("5")) { // xoa mot tu
                management.removeOneWord(dictionary);
            }
            else if (chose.equalsIgnoreCase("end")) break;

            else if (chose.equalsIgnoreCase("add")) {
                management.insertFromOtherFile(dictionary);
            }

            else continue;

        }

        management.dictionaryExportToFile(dictionary); // dong file "new Dictionary"
    }
}
