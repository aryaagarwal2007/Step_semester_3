package array.assigment_problems;

import java.util.Arrays;

/**
 * PROBLEM 5: Fantasy League Auto-Draft Ranking Engine
 *
 * Draftability thresholds (chosen to match the worked example):
 *   - Experience-only rule: matchesPlayed >= 10 (qualifies regardless of fitness)
 *   - Combined rule for newer players: matchesPlayed >= 5 AND not injured
 *
 * Ranking is by battingAverage descending (the only performance number a
 * Player carries), which reproduces "1. Rahul | 2. Virat | 3. Dev" exactly:
 * Rahul (55.0) > Virat (48.0) > Dev (20.0). Sameer (matches=3) fails both
 * draft rules and is excluded despite the best average of anyone (60.0).
 */
public class FantasyLeagueAutoDraftRankingEngine {

    public static void main(String[] args) {
        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    static String draftAndRank(Player[] players) {
        Player[] temp = new Player[players.length];
        int count = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                temp[count++] = p;
            }
        }
        Player[] draftable = Arrays.copyOf(temp, count);

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].name);
            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    @Override
    public int compareTo(Player other) {
        // Descending order by batting average (used here as fantasy points)
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}
