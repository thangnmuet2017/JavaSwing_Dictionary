import java.util.Scanner;

public class Word {
    private String word_target; // tu tieng anh
    private String word_explain; // giai nghia

    // ham khoi tao
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

    // getter  &  setter
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


    // so sanh mot Word voi mot Word khac
    public boolean isAfter( Word word) {
        int x = this.word_target.compareToIgnoreCase( word.word_target );
        if (x > 0) return true;
        return false;
    }

    public boolean equalsIgnoreCase(Word w) {
        return word_target.equalsIgnoreCase(w.getWord_target());
    }
    // so sanh Word voi String
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
    // ham sua chua Word
    public void repairWord(String newWord_target, String newWord_explain) {
        setWord_explain( newWord_target );
        setWord_explain(newWord_explain);
    }
}
