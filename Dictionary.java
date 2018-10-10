import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> listDictionary;
    private int size = 0;


    public Dictionary() {
        ArrayList<Word> list = new ArrayList<>();
        this.listDictionary = list;
    }

    public int getSize() {
        return size;
    }

    // ham them mot tu moi vao tu dien
    public void add( Word word) {
        listDictionary.add(word);
        size ++;
    }

    public void add(int index, Word word) {
        listDictionary.add(index, word);
        size ++;
    }

    public String wordTargetAt(int index) {
        return listDictionary.get(index).getWord_target();
    }

    public String meansAt(int index) {
        return listDictionary.get(index).getWord_explain();
    }

    public Word wordAt(int index) {
        return listDictionary.get(index);
    }


    // ham in ra thong tin cua mot word
    public void showWord(int index) {
        String wordTarget = listDictionary.get(index).getWord_target();
        String wordMeans = listDictionary.get(index).getWord_explain();
        System.out.printf("%6d |%12s |  %s \n", index +1, wordTarget, wordMeans);

    }
}
