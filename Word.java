public class Word {
    private String word_target;
    private String word_explain;

    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }

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

    public boolean compareTo( Word word) {
        int x = this.word_target.compareTo( word.word_target );
        if (x > 0) return true;
        return false;
    }

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
