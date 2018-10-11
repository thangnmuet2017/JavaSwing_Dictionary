package cmd_dictionary_2;

import java.util.ArrayList;

// class Dictionary
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
    
    // them vao mot vi tri cu the
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

// class Word
class Word {
    private String word_target;
    private String word_explain;
    // constructor
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    public Word() {
        this.word_target = "";
        this.word_explain = "";
    }
    
    // getter & setter
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }
    
    // phuong thuc so sanh 2 Word voi nhau
    public boolean isGreaterThan( Word word) {
        int x = this.word_target.compareTo( word.word_target );
        if (x > 0) return true;
        return false;
    }
    
    // kiem tra xem word_target co chua xau s hay khong
    public boolean contains( String s){
        int sizeS = s.length();
        int sizeW = word_target.length();
        if( sizeS > sizeW) return false;
        else {
            String smallWord = word_target.substring(0, sizeS);
            return smallWord.equalsIgnoreCase(s);
        }
//        try {
//            String smallWord = word_target.substring(0, sizeS);
//            return smallWord.equalsIgnoreCase(s);
//        } catch (Exception e) {
//            return false;
//        }

    }
}