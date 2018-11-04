import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmotionPredicterEngine {

    private SentencesHandler sampleSentencesHandler = new SentencesHandler();
    private SentencesHandler learningSentencesHandler = new SentencesHandler();

    private int learningSentenceNumber = 80000;
    private int sampleSentenceNumber = 20000;



    private List<String> learningSentenceLineList = new ArrayList<String>();
    private List<String> learningEmotionLineList = new ArrayList<String>();
    private List<String> sampleSentenceLineList = new ArrayList<String>();



    private static EmotionPredicterEngine ourInstance = new EmotionPredicterEngine();
    public static EmotionPredicterEngine getInstance() {
        return ourInstance;
    }

    public List<String> getLearningEmotionLineList() {
        return learningEmotionLineList;
    }

    private   void readAllLines() throws IOException {
         // BufferedReader bi = new BufferedReader(new FileReader(new File("D:\\GitHub\\TwitterEmotionPredicted\\src\\input1.txt")));
       BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int i=0;
        for (int j = 0; j <learningSentenceNumber ; j++) {


            line = bi.readLine();
            learningSentenceLineList.add(line);


        }
        for (int j = 0; j <learningSentenceNumber ; j++) {


            line = bi.readLine();
            learningEmotionLineList.add(line);


        }
        for (int j = 0; j <sampleSentenceNumber ; j++) {


            line = bi.readLine();
            sampleSentenceLineList.add(line);


        }

            bi.close();
        }



    private Sentence createSentenceFromString(String sentenceString){
        Sentence resultSentence = new Sentence();
        String[] wordsId;

             wordsId = sentenceString.split("\t");


        for (String WordsIDs : wordsId) {

                int actualWordID = Integer.parseInt(WordsIDs);
                Word createdWord = new Word(actualWordID);

                resultSentence.addWord(createdWord);

        }

        return resultSentence;
    }
    private void readLearningSentences(){

        List<String> learningSentenceList = learningSentenceLineList; //learning sentences
        List<String> learningSentenceEmotions = learningEmotionLineList; //learning sentence's emotion

        for (String sentenceString : learningSentenceList) {
            Sentence createdSentence = new Sentence();
            if(!sentenceString.equals("")) {
                createdSentence = createSentenceFromString(sentenceString);
            }
            else if(sentenceString.equals("")){
                Word nullWord = new Word(0);
                createdSentence.addWord(nullWord);
            }

                learningSentencesHandler.addSentence(createdSentence);

        }

        for (Sentence s:learningSentencesHandler.getSentences()) {
           s.addWordsToDataBase();
        }

        List<Sentence> learningList = learningSentencesHandler.getSentences();

        for (int j = 0; j <learningList.size() ; j++) {

            learningList.get(j).addEmotionToWords(Integer.parseInt(learningSentenceEmotions.get(j)));

        }

    }


    private void readSampleSentences(){

        List<String> sampleSentenceList = sampleSentenceLineList; //learning sentences

        for (String sentenceString : sampleSentenceList) {
            Sentence createdSentence = new Sentence();
            if(!sentenceString.equals("")) {
                createdSentence = createSentenceFromString(sentenceString);
            }
            else if(sentenceString.equals("")){
                Word nullWord = new Word(0);
                createdSentence.addWord(nullWord);
            }
            sampleSentencesHandler.addSentence(createdSentence);
        }
    }

    public void run() throws IOException {

            readAllLines();

            readLearningSentences();
            readSampleSentences();

            sampleSentencesHandler.writeOutSentenceEmotion();




    }
}
