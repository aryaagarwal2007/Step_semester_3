package array.assigment_problems;

/**
 * PROBLEM 2: Duplicate Player Pick Checker
 *
 * Nested loops, no Collections. Each name is only compared against names
 * that come after it, so no pair is checked twice.
 */
public class DuplicatePlayerPickChecker {

    static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Kohli", "Rohit"}));
        // Expected: Duplicate Found: Kohli

        System.out.println(findDuplicatePick(new String[]{"Kohli", "Bumrah", "Rohit"}));
        // Expected: No Duplicates Found
    }
}
