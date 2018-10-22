public class Word {
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

    // phuong thuc kiem tra word_target co dung sau word khong
    public boolean isGreaterThan( Word word) {
        int x = this.word_target.compareToIgnoreCase( word.word_target );
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

    }
}
