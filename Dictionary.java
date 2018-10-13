import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> listDictionary;
    private int size = 0;

    // khoi tao khong tham so
    public Dictionary() {
        ArrayList<Word> list = new ArrayList<>();
        this.listDictionary = list;
    }

    public int getSize() {
        return size;
    }

    public void updateSize() {
        this.size = listDictionary.size();
    }

    // ham them mot tu moi vao cuoi tu dien
    public void add( Word word) {
        listDictionary.add(word);
        updateSize();
    }

    // them mot tu vao vi tri index
    public void add(int index, Word word) {
        listDictionary.add(index, word);
        updateSize();
    }

    // ham tra ve tu tieng anh o vi tri index trong Dictionary
    public String wordTargetAt(int index) {
        return listDictionary.get(index).getWord_target();
    }

    // ham tra ve nghia cua tu
    public String wordExpainsAt(int index) {
        return listDictionary.get(index).getWord_explain();
    }

    // ham tra ve Word trong danh sach
    public Word wordAt(int index) {
        return listDictionary.get(index);
    }


    // ham in ra thong tin cua mot word
    public void showWord(int index) {
        String wordTarget = listDictionary.get(index).getWord_target();
        String wordMeans = listDictionary.get(index).getWord_explain();
        System.out.printf("%6d |%-12s |  %s \n", index +1, wordTarget, wordMeans);

    }

    // ham xoa mot tu trong danh sach
    public void remove(int index) {
        listDictionary.remove(index);
        updateSize();
    }
}
