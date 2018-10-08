public class DictionaryCommandline {

    public void showAllWords(Dictionary dictionary) {
        int size = dictionary.getSize();
        for (int i = 0; i < size; i++) {
            dictionary.showWord(i);
        }
    }
}
