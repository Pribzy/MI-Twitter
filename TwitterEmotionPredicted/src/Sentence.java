import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sentence {

    private List<Word> words = new ArrayList<Word>();
    private  WordDatabase wb = WordDatabase.getInstance();

    public Sentence(){
    }

    public void addWord(Word w){
        words.add(w);

    }
    public void addWordsToDataBase(){

        for (Word w:words) {
            wb.addWord(w);
        }
    }

    public void addEmotionToWords(int emotion){

        for (Word w: getWordsWithoutDuplicate()) {

            if(wb.getWords()[w.getId()].getId()!=-1) {

                if (emotion == 1) {
                    wb.getWords()[w.getId()].addPositiveEmotion();
                } else if (emotion == 0) {
                    wb.getWords()[w.getId()].addNegativeEmotion();
                }

            }
        }

    }

    private List<Word> getWordsWithoutDuplicate(){
        List<Word> wordsWithoutDuplicate = new ArrayList<Word>();
        for (Word w: words) {
            boolean exist = false;
            for (Word wwd:wordsWithoutDuplicate) {
                if(w.getId().equals(wwd.getId())){ exist = true;}
            }
            if(!exist){
                wordsWithoutDuplicate.add(w);
            }
        }

        return wordsWithoutDuplicate;
    }

    public int calculateEmotion(){
        int resultEmotion = 0;

        for (Word w: getWordsWithoutDuplicate()) {
            if(wb.getWordById(w.getId()).getId()!=-1){
                resultEmotion = resultEmotion
                        +wb.getWordById(w.getId()).getPositiveCount()
                        -wb.getWordById(w.getId()).getNegativeCount();
            }
        }

        return getEmotion(resultEmotion);
    }

    private int getEmotion(int emotion){




       int resultEmotion = emotion;

        if(resultEmotion>0){
            resultEmotion = 1;
        }
        else if(resultEmotion<0){
            resultEmotion = 0;
        }
        else {
            resultEmotion = generateRandomNumber();
        }
        return resultEmotion;
    }

    private int generateRandomNumber(){
        Random rand = new Random();
        return rand.nextInt(2);
    }


}
