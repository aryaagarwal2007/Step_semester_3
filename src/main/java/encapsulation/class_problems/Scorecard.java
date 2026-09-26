package encapsulation.class_problems;

/**
 * Practice 2: The Quiz Scorecard
 *
 * results is a private array filled one answer at a time. There is no
 * getter that returns it in any form — only getScore(), which counts the
 * corrects internally. totalQuestions is fixed at construction.
 */
public class Scorecard {
    private final boolean[] results;
    private int answeredCount;
    private final int totalQuestions;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.answeredCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answeredCount >= totalQuestions) {
            System.out.println("Rejected: all questions already recorded");
            return;
        }
        results[answeredCount] = correct;
        answeredCount++;
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < answeredCount; i++) {
            if (results[i]) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}
