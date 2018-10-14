import java.util.Scanner;

public class Cmd_Dictionary_2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement management = new DictionaryManagement();
        DictionaryCommandline commandline = new DictionaryCommandline();
        management.insertFromFile(dictionary); // lay du lieu tu file "dictionaries.txt"

        // bat dau
        System.out.println("\t\tTu dien Anh - Viet bang CommandLine");
        System.out.println("\t\t--------------*******--------------");
        boolean saved = true;
        String option = "-1";
        do {
            commandline.printMenu();
            System.out.print("Nhap vao lua chon cua ban: ");
            option = scanner.next();
            scanner.nextLine(); // loai ki tu xuong dong
            switch(option) {
                case ( "1" ): // tra tu chinh xac
                    String result = management.dictionaryLookup(dictionary);
                    if (result != null) {
                        System.out.println("Giai nghia: " + result);
                    }
                    System.out.println("------------------");
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ( "2" ) : // tra tu mot cach tuong doi
                    Dictionary sub_dictionary = commandline.dictionarySearcher(dictionary);
                    commandline.showAllWords(sub_dictionary);
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ( "3" ): // them tu
                    management.insertFromCommandline(dictionary);
                    saved = false;
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ( "4" ): // sua doi tu
                    management.changeFromCommandline(dictionary);
                    saved = false;
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ( "5" ): // xoa tu
                    management.removeWord(dictionary);
                    saved = false;
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ( "6" ): // luu thay doi
                    management.dictionaryExportToFile(dictionary);
                    saved = true;
                    System.out.println("Da luu thay doi!");
                    System.out.println("------------------------");
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ("7" ): // in het ra
                    commandline.showAllWords(dictionary);
                    System.out.println("Vui long nhan phim Enter!");
                    scanner.nextLine();
                    break;
                case ("end" ) : // thoat chuong trinh
                    System.out.println("Ket thuc chuong trinh!");
                    if (!saved) {
                        // Autosave
                        management.dictionaryExportToFile(dictionary);
                    }
                    break;
                default: // neu nhap vao khong hop le
                    System.out.println("Vui long nhap lai!");
                    break;
            }

        } while (option != "0");

    }

}