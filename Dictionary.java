import java.util.ArrayList;

public class Dictionary {

    private ArrayList<Word> listDictionary;
    private int size = 0;

    // constructor
    public Dictionary() {
        ArrayList<Word> list = new ArrayList<>();
        this.listDictionary = list;
    }

    // lay ra kich thuoc
    public int getSize() {
        return size;
    }

    // them mot tu moi vao tu dien
    public void add( Word word) {
        listDictionary.add(word);
        size++;
    }

    // them vao o mot vi tri cu the
    public void add(int index, Word word) {
        listDictionary.add(index, word);
        size++;
    }

    // xoa tu o mot vi tri cu the
    public void remove(int index) {
        listDictionary.remove(index);
        size--;
    }
    // lay ra tu can giai nghia o vi tri index
    public String wordTargetAt(int index) {
        return listDictionary.get(index).getWord_target();
    }

    // lay ra giai nghia o vi tri index
    public String meaningAt(int index) {
        return listDictionary.get(index).getWord_explain();
    }

    // tra ve Word o vi tri index
    public Word wordAt(int index) {
        return listDictionary.get(index);
    }

    // ham in ra thong tin cua mot word
    public void showWord(int index) {
        String wordTarget = listDictionary.get(index).getWord_target();
        String wordMeaning = listDictionary.get(index).getWord_explain();
        System.out.printf("%-8d|%-25s|%s\n", index +1, wordTarget, wordMeaning);

    }
}


