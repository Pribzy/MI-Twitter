public class Word {
    private Integer id;
    private Integer positiveCount =0;
    private Integer negativeCount = 0;


    public Word(Integer id){
        this.id=id;
    }

    public void addPositiveEmotion(){
        positiveCount++;
    }
    public void addNegativeEmotion(){
        negativeCount++;
    }

    public Integer getPositiveCount() {
        return positiveCount;
    }

    public Integer getNegativeCount() {
        return negativeCount;
    }

    public Integer getId() {
        return id;
    }
}
