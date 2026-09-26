package array.class_problems;

import java.util.Arrays;

/**
 * PROBLEM 5 (Practice): Placement Drive Shortlisting & Ranking Engine
 *
 * Composite score formula (reverse-engineered from the worked example):
 *   composite = cgpa * 10 + codingScore * 0.5
 *
 * Eligibility thresholds:
 *   - CGPA-only quick filter: cgpa >= 7.0
 *   - Combined filter for borderline candidates: cgpa >= 6.5 AND codingScore >= 60
 */
public class PlacementDriveShortlistingRankingEngine {

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
        // Expected: 1. Aisha (102.0) | 2. Rohit (100.5) | 3. Karan (85.0)
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] temp = new Candidate[candidates.length];
        int count = 0;
        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                temp[count++] = c;
            }
        }
        Candidate[] shortlisted = Arrays.copyOf(temp, count);

        Arrays.sort(shortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < shortlisted.length; i++) {
            result.append(i + 1).append(". ")
                  .append(shortlisted[i].name)
                  .append(" (").append(shortlisted[i].getCompositeScore()).append(")");
            if (i < shortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}
