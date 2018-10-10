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
        System.out.println("3. In ra toan bo cac tu");
        System.out.println("0. Ket thuc");
        System.out.println(">>>>>>>>>>***<<<<<<<<<<");
        int continueProgram = -1;
        do {
            int option = -1;
            System.out.print("Nhap vao lua chon cua ban: ");
            option = scanner.nextInt();
            switch(option) {
                case 1: 
                    System.out.print("Nhap tu muon tra : ");
                    String s = scanner.next();
                    Dictionary sub_dictionary = commandline.dictionarySearcher(s, dictionary);
                    commandline.showAllWords(sub_dictionary);
                    break;
                case 2:
                    management.insertFromCommandline(dictionary);
                    break;
                case 3:
                    commandline.showAllWords(dictionary);
                    break;
                case 0:
                    continueProgram = 0;
                    break;
                default:
                    System.out.println("Vui long nhap lai");
                    break;
            }
            if (continueProgram != 0) {
                System.out.print("Ban co muon tiep tuc chuong trinh khong? ");
                System.out.println("(Nhap bat ky so nao khac 0 de tiep tuc)");
                continueProgram = scanner.nextInt();
            }
        } while (continueProgram != 0);

        management.dictionaryExportToFile(dictionary);
    }
    
}
