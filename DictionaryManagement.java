import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;
import java.util.Scanner;

public class DictionaryManagement {
    Scanner scanner = new Scanner(System.in);

    /*
        ham them word tu ban phim
        ham nay da cai tien ( them va sap xep theo thu tu abc..)
     */
    public void insertFromCommandline(Dictionary dictionary) {
        System.out.print("Hay nhap tu moi: ");
        String newWord = scanner.nextLine();
        if (dictionaryLookup(newWord, dictionary) != -1 ) {
            System.out.println("tu nay da co trong tu dien roi");
            System.out.println("-----------------------------");
            return;
        }
        System.out.print("Hay nhap nghia cua tu do: ");
        String meansWord = scanner.nextLine();

        Word word = new Word(newWord, meansWord);
        boolean added = false;
        for (int i = dictionary.getSize(); i >= 1; i--) {
            if (word.isAfter(dictionary.wordAt(i - 1))) {
                dictionary.add(i, word);
                added = true;
                break;
            }
        }
        if (!added) dictionary.add(0, word);

        System.out.println("------------------------");
    }


    /*
        Cai tien ham them tu file
        them tu dong thoi sap xep theo thu tu abc
     */
    public void insertFromFile(Dictionary dictionary) throws IOException {
        Scanner scanFile = new Scanner(Paths.get("new Dictionary.txt"), "UTF-8");
        while (scanFile.hasNext()) {
            String tmpStr;
            tmpStr = scanFile.nextLine();
            String[] tmpArrStr = tmpStr.split("\t", 2);
            String targetWord = tmpArrStr[0];
            String meansWord;
            if (tmpArrStr.length > 1) {
                meansWord = tmpArrStr[1];
            } else {
                meansWord = "";
            }
            Word word = new Word(targetWord, meansWord);

            boolean added = false;
            for (int i = dictionary.getSize(); i >= 1; i--) {
                if (word.isAfter(dictionary.wordAt(i - 1))) {
                    dictionary.add(i, word);
                    added = true;
                    break;
                }
            }
            if (!added) dictionary.add(0, word);
        }
    }

    //HAM TIM KIEM tra ve vi tri cua tu trong Dictionary
    public int dictionaryLookup(String word, Dictionary dictionary) {
        int size = dictionary.getSize();
        int left = 0;
        int right = size - 1;
        Word w = new Word(word, "no explain");

        while (left <= right) {
            int mid = (left + right) / 2;
            if (w.equalsIgnoreCase(dictionary.wordAt(mid) ) )
                return mid;
            else if (w.isAfter(dictionary.wordAt(mid)))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;

    }

    // ham xuat du lieu tu dien ra file
    public void dictionaryExportToFile(Dictionary dictionary) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("new Dictionary.txt", "UTF-8");
        for (int i = 0; i < dictionary.getSize(); i++) {
            printWriter.println(dictionary.wordTargetAt(i) + "\t" + dictionary.wordExpainsAt(i));
        }
        printWriter.close();
    }

    // ham sua sua nghia cu tu
    public void repairOneWord(Dictionary dictionary) {
        System.out.print("nhap tu can sua nghia: ");
        String word = scanner.nextLine();
        int i = dictionaryLookup(word, dictionary);
        if (i >= 0) {
            System.out.println("Nghia cu cua tu do la: " + dictionary.wordExpainsAt(i));
            System.out.print("Hay nhap nghia moi   : ");
            String newMeans = scanner.nextLine();
            dictionary.wordAt(i).setWord_explain(newMeans);
            System.out.println("da thay doi");
            System.out.println("-----------------------");
        }
    }

    // ham xoa mot Word
    public void removeOneWord(Dictionary dictionary) {
        System.out.print("Nhap tu muon xoa : ");
        String word = scanner.nextLine();
        int index = dictionaryLookup(word, dictionary);
        if (index >= 0) {
            dictionary.remove(index);
            System.out.println("da xoa");
        } else System.out.println("tu do khong co trong tu dien");
        System.out.println("-------------------");
    }



// ham cong don hai tu dien voi nhau
    public void insertFromOtherFile(Dictionary dictionary) throws IOException {
        System.out.print("nhap ten file : ");
        String nameFile = scanner.nextLine();
        try {
            Scanner scanFile = new Scanner(Paths.get(nameFile + ".txt"), "UTF-8");
            while (scanFile.hasNext()) {
                String tmpStr;
                tmpStr = scanFile.nextLine();
                String[] tmpArrStr = tmpStr.split("\t");
                String targetWord = tmpArrStr[0];
                String meansWord;
                if (tmpArrStr.length > 1) {
                    meansWord = tmpArrStr[1];
                } else {
                    meansWord = "";
                }
                Word word = new Word(targetWord, meansWord);

                boolean added = false;
                for (int i = dictionary.getSize(); i >= 1; i--) {
                    if (word.isAfter(dictionary.wordAt(i - 1))) {
                        if( ! word.equalsIgnoreCase(dictionary.wordAt(i)))
                            dictionary.add(i, word);
                        added = true;
                        break;
                    }
                }
                if (!added) dictionary.add(0, word);
            }
            System.out.println("them thanh cong");

        } catch (Exception e) {
            System.out.println("them that bai");
        }
        System.out.println("------------------");
    }
}
