import java.util.Scanner;

public class DictionaryCommandline {
    static Scanner scanner = new Scanner(System.in);

    // phuong thuc in ra Menu lua chon
    public void printMenu() {
        System.out.printf("%-35s","1. Tra tu chinh xac");
        System.out.println("2. Tra tu mot cach tuong doi");
        System.out.printf("%-35s", "3. Them tu");
        System.out.println("4. Sua doi tu");
        System.out.printf("%-35s","5. Xoa tu");
        System.out.println("6. Luu thay doi");
        System.out.printf("%-35s","7. In ra toan bo cac tu");
        System.out.println("0. Ket thuc");
        System.out.println("\t\t>>>>>>>>>>>>>>*******<<<<<<<<<<<<<<");
    }

    // ham in ra toan bo tu dien
    public void showAllWords(MyDictionary dictionary) {
        int size = dictionary.getSize();
        if( size > 0 ) {
            System.out.printf("%-8s|%-25s|%s\n", "No", "English", "Vietnamese");
            for (int i = 0; i < size; i++) {
                dictionary.showWord(i);
            }
        }
        else {
            System.out.println("khong co tu nao nhu vay");
        }
        System.out.println("------------------");
    }

    // tra tu mot cach tuong doi
    public MyDictionary dictionarySearcher( MyDictionary dictionary ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap tu muon tra : ");
        String s = scanner.nextLine();
        s = s.trim();
        MyDictionary newDictionary = new MyDictionary();
        int size = dictionary.getSize();
        for(int i = 0; i < size; i++ ) {
            Word iter_word = dictionary.wordAt(i);
            if( iter_word.contains(s) ) {
                newDictionary.add(iter_word);
            }
            else {
                int compare = iter_word.getWord_target().compareToIgnoreCase(s);
                if (compare > 0) break;
            }
        }
        return newDictionary;
    }

    public MyDictionary dictionarySearcher( String s, MyDictionary dictionary ) {
        s = s.trim();
        MyDictionary newDictionary = new MyDictionary();
        int size = dictionary.getSize();
        for(int i = 0; i < size; i++ ) {
            Word iter_word = dictionary.wordAt(i);
            if( iter_word.contains(s) ) {
                newDictionary.add(iter_word);
            }
            else {
                int compare = iter_word.getWord_target().compareToIgnoreCase(s);
                if (compare > 0) break;
            }
        }
        return newDictionary;
    }
}