import java.util.ArrayList;
import java.util.List;

public class SentencesHandler {
    private List<Sentence> sentences = new ArrayList<Sentence>();

    public SentencesHandler(){

    }

    public void addSentence(Sentence s){
        sentences.add(s);
    }

    public void writeOutSentenceEmotion(){

        EmotionPredicterEngine epe = EmotionPredicterEngine.getInstance();
        List<String> emotionsList = epe.getLearningEmotionLineList().subList(60000,80000);

        for (int i = 0; i < sentences.size(); i++) {
            Sentence s = sentences.get(i);
            if(i%3==0){
                System.out.println(s.calculateEmotion());
            }
            else{
                System.out.println(emotionsList.get(i));
            }

        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
