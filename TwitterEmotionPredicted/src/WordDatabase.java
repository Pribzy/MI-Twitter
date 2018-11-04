import java.util.ArrayList;
import java.util.List;

public class WordDatabase {
    private List<Word> words = new ArrayList<Word>();
    private Word[] wordsArray = new Word[1000000];
    private Word nullWord = new Word(-1);

    private static WordDatabase ourInstance = new WordDatabase();
    public static WordDatabase getInstance() {
        return ourInstance;
    }

    private WordDatabase() {
        for (int i = 0; i <1000000 ; i++) {
            wordsArray[i]=nullWord;
        }
    }


    public void removeDuplicates(){

    }






    //Array
    public void addWord(Word w){
        if(wordsArray[w.getId()]==nullWord) {
            wordsArray[w.getId()] = w;
        }
    }

    public Word getWordById(int id){
        return wordsArray[id];
    }

    public Word[] getWords() {
        return wordsArray;
    }
}
