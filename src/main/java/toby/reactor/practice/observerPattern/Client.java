package toby.reactor.practice.observerPattern;

public class Client {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView);
        scoreRecord.attach(minMaxView);

        for (int index = 1; index <= 5; index++) {

            int score = index * 10;

            System.out.println("================");
            System.out.println("Adding " + score);
            System.out.println("================\n");

            scoreRecord.addScore(score);
        }
    }
}