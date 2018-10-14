import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner scanner = new Scanner(System.in);
    /*
      phuong thuc tra ve chi so cua mot tu tieng Anh nao do
      trong danh sach cac tu tieng Anh cua dictionary
    */
    static int getWordIndex(Dictionary dict, String search_word) {
        // tim kiem khong phan biet chu hoa hay chu thuong
        int dict_size = dict.getSize();
        int left = 0, right = dict_size - 1;
        // binary search
        while (left <= right) {
            int mid = (left + right)/2;
            String match_word = dict.wordAt(mid).getWord_target();
            int compare = match_word.compareToIgnoreCase(search_word);
            if (compare == 0) {
                return mid;
            }
            else if (compare > 0) {
                right = mid - 1;
            }
            else left = mid + 1;
        }
        // neu nhu khong tim thay word trong dictionary thi tra ve -1
        return -1;
    }

    // phuong thuc lay ve chi so de them 1 word vao dictionary theo thu tu abc
    static int getAddedIndex(Dictionary dict, Word word, int beginIndex, int endIndex) {
        // neu word xep sau tu dung o vi tri endIndex trong tu dien
        if ( !dict.wordAt(endIndex).isGreaterThan(word) ) {
            return endIndex + 1;
        }
        // neu word xep truoc tu dung o vi tri beginIndex trong tu dien
        if ( dict.wordAt(beginIndex).isGreaterThan(word) ) {
            return beginIndex;
        }
        int mid = (beginIndex + endIndex)/2;
        // neu word dung sau dict[mid]
        if ( !dict.wordAt(mid).isGreaterThan(word) ) {
            return getAddedIndex(dict, word, mid + 1, endIndex);
        }
        // neu word dung truoc dict[mid]
        else {
            return getAddedIndex(dict, word, beginIndex, mid - 1);
        }
    }

    /*
        phuong thuc them word tu ban phim
        da cai tien ( them va sap xep theo thu tu abc..)
     */
    public void insertFromCommandline(Dictionary dictionary) {
        System.out.print("Hay nhap tu moi: ");
        String newWord = scanner.nextLine();
        newWord = newWord.trim(); // cat het khoang trang thua
        int matchIndex = getWordIndex(dictionary, newWord);
        if (matchIndex != -1) {
            System.out.println("Trong tu dien da co tu do!");
            return;
        }
        System.out.print("Hay nhap nghia cua tu do: ");
        String meaningWord = scanner.nextLine();
        meaningWord = meaningWord.trim();
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
        File file = new File("dictionaries.txt");
        // file dictionaries.txt da duoc sap xep theo thu tu abc truoc do
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

    // phuong thuc sua 1 tu trong tu dien
    public void changeFromCommandline(Dictionary dictionary) {
        System.out.print("Nhap tu ban muon sua: ");
        String changedWord = scanner.nextLine();
        changedWord = changedWord.trim();
        int matchIndex = getWordIndex(dictionary, changedWord);
        // neu khong tim thay
        if (matchIndex == -1) {
            System.out.println("Tu nay khong co trong danh sach!");
            return;
        }

        String oldTarget = dictionary.wordTargetAt(matchIndex);
        String editedTarget = "";
        int changeTarget = -1, changeExplain = -1;
        System.out.println("Co thay doi tu goc? (Nhap so khac 0 bat ky de thay doi)");
        changeTarget = scanner.nextInt();
        scanner.nextLine(); // doc ki tu enter thua
        if (changeTarget != 0) {
            System.out.print("Nhap vao tu moi: ");
            editedTarget = scanner.nextLine();
            editedTarget = editedTarget.trim();
        }
        System.out.println("Co thay doi tu giai nghia? (Nhap so khac 0 bat ky de thay doi)");
        changeExplain = scanner.nextInt();
        scanner.nextLine(); // doc ki tu enter thua
        if (changeExplain != 0) {
            System.out.print("Nhap vao giai nghia moi: ");
            String editedMeaning = scanner.nextLine();
            editedMeaning = editedMeaning.trim();
            dictionary.wordAt(matchIndex).setWord_explain(editedMeaning);
        }

        // neu ta thay doi tu goc thi sau khi sua phai sap xep lai tu dien
        // con neu khong thay doi tu goc thi chi can set lai giai nghia
        if (changeTarget != 0) {
            String editedMeaning = dictionary.meaningAt(matchIndex);
            // luu thay doi sang mot bien tmp_word
            Word tmp_word = new Word(editedTarget, editedMeaning);
            // xoa tu cu di
            removeByKeyWord(dictionary, oldTarget);
            int addedPos = getAddedIndex(dictionary, tmp_word, 0, dictionary.getSize() - 1);
            // them tmp_word vao tu dien
            dictionary.add(addedPos, tmp_word);
        }
        System.out.println("------------------------");
    }

    // phuong thuc xoa 1 tu trong tu dien
    public void removeWord(Dictionary dictionary) {
        System.out.print("Nhap tu ban muon xoa: ");
        String removedWord = scanner.nextLine();
        removedWord = removedWord.trim();
        int matchIndex = getWordIndex(dictionary, removedWord);
        if (matchIndex == -1) {
            System.out.println("Tu nay khong co trong danh sach!");
            return;
        }
        dictionary.remove(matchIndex);
        System.out.println("Da xoa!");
        System.out.println("------------------------");
    }

    // phuong thuc xoa 1 tu cu the
    public void removeByKeyWord(Dictionary dictionary, String KeyWord) {
        int matchIndex = getWordIndex(dictionary, KeyWord);
        if (matchIndex == -1) {
            return;
        }
        dictionary.remove(matchIndex);
    }
    // tra tu chinh xac (chi cho ra 1 tu duy nhat)
    public String dictionaryLookup(Dictionary dictionary) {
        String Lookup = "";
        System.out.print("Nhap chinh xac tu ban can tra: ");
        Lookup = scanner.nextLine();
        Lookup = Lookup.trim();
        int matchIndex = getWordIndex(dictionary, Lookup);
        if (matchIndex == -1) {
            System.out.println("Khong ton tai tu do!");
            return null;
        }
        return dictionary.meaningAt(matchIndex);
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
