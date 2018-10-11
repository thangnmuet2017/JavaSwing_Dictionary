package cmd_dictionary_2;
import java.util.Scanner;

public class Cmd_Dictionary_2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandline commandline = new DictionaryCommandline();

        management.insertFromFile(dictionary); // lay du lieu tu file "dictionaries.txt"

        // bat dau
        System.out.println("1. Tra tu");
        System.out.println("2. Them tu");
        System.out.println("3. Sua doi tu");
        System.out.println("4. Xoa tu");
        System.out.println("5. Luu thay doi");
        System.out.println("6. In ra toan bo cac tu");
        System.out.println("0. Ket thuc");
        System.out.println(">>>>>>>>>>***<<<<<<<<<<");
        int continueProgram = -1;
        boolean saved = false;
        do {
            int option = -1;
            System.out.print("Nhap vao lua chon cua ban: ");
            option = scanner.nextInt();
            scanner.nextLine(); // loai ki tu xuong dong
            switch(option) {
                case 1: // tra tu
                    System.out.print("Nhap tu muon tra : ");
                    String s = scanner.next();
                    Dictionary sub_dictionary = commandline.dictionarySearcher(s, dictionary);
                    commandline.showAllWords(sub_dictionary);
                    break;
                case 2: // them tu
                    management.insertFromCommandline(dictionary);
                    saved = false;
                    break;
                case 3: // sua doi tu
                    management.changeFromCommandline(dictionary);
                    saved = false;
                    break;
                case 4: // xoa tu
                    management.removeWord(dictionary);
                    saved = false;
                    break;
                case 5: // luu thay doi
                    management.dictionaryExportToFile(dictionary);
                    saved = true;
                    System.out.println("Da luu thay doi!");
                    System.out.println("------------------------");
                    break;
                case 6: // in het ra
                    commandline.showAllWords(dictionary);
                    break;
                case 0:
                    continueProgram = 0;
                    break;
                default:
                    System.out.println("Vui long nhap lai!");
                    break;
            }
            if (continueProgram != 0) {
                System.out.print("Ban co muon tiep tuc chuong trinh khong? ");
                System.out.println("(Nhap bat ky so nao khac 0 de tiep tuc)");
                continueProgram = scanner.nextInt();
            }
        } while (continueProgram != 0);
           
        if (!saved) {
            management.dictionaryExportToFile(dictionary);
            // Autosave
        }
    }
    
}
