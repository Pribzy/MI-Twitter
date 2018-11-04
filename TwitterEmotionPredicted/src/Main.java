import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        EmotionPredicterEngine epe = EmotionPredicterEngine.getInstance();

        try {
            epe.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
