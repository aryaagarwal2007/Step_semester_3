package polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice 4: Examination Question Grader
 *
 * Question is an abstract base type; each subclass overrides gradeScore()
 * with its own grading rule (exact match for MCQ/TF, partial keyword
 * matching for Essay). The grader loop calls gradeScore() uniformly.
 */
public class ExaminationQuestionGrader {

    static final Pattern LINE_PATTERN =
            Pattern.compile("^(\\S+)\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+\"([^\"]*)\"\\s+(\\d+)$");

    static abstract class Question {
        protected final String label;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final int points;

        Question(String label, String correctAnswer, String studentAnswer, int points) {
            this.label = label;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double gradeScore();
    }

    static class McqQuestion extends Question {
        McqQuestion(String correctAnswer, String studentAnswer, int points) {
            super("MCQ", correctAnswer, studentAnswer, points);
        }

        double gradeScore() {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
        }
    }

    static class TfQuestion extends Question {
        TfQuestion(String correctAnswer, String studentAnswer, int points) {
            super("TF", correctAnswer, studentAnswer, points);
        }

        double gradeScore() {
            return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0;
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", correctAnswer, studentAnswer, points);
        }

        double gradeScore() {
            String[] keywords = correctAnswer.split(",");
            String studentLower = studentAnswer.toLowerCase();
            int matches = 0;

            for (String keyword : keywords) {
                if (studentLower.contains(keyword.trim().toLowerCase())) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            } else if (matches == 1) {
                return points * 0.50;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (!m.matches()) {
                System.out.println("Could not parse line: " + line);
                continue;
            }
            String type = m.group(1);
            String correctAnswer = m.group(3);
            String studentAnswer = m.group(4);
            int points = Integer.parseInt(m.group(5));

            switch (type) {
                case "MCQ":
                    questions.add(new McqQuestion(correctAnswer, studentAnswer, points));
                    break;
                case "TF":
                    questions.add(new TfQuestion(correctAnswer, studentAnswer, points));
                    break;
                case "ESSAY":
                    questions.add(new EssayQuestion(correctAnswer, studentAnswer, points));
                    break;
                default:
                    System.out.println("Unknown question type: " + type);
            }
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.gradeScore();
            System.out.printf("%s: %.2f%n", q.label, score);
            total += score;
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}
