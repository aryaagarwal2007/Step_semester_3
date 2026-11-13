package week11.class_problems;

import java.util.HashSet;
import java.util.Set;

// Chosen (HashSet): Time O(n) average | Space O(n)
// Alternative: sort the IDs, then compare neighbours -> Time O(n log n), Space O(1) extra
// (if sorting in place). Less memory, but slower. Nested loops: O(n^2) time, O(1) space.
public class P03_TransactionDuplicateCheck {
    static boolean hasDuplicate(String[] ids) {
        Set<String> seen = new HashSet<>();
        for (String id : ids) {
            if (!seen.add(id)) return true; // add() is false if already present
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(new String[]{"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"}));
        System.out.println(hasDuplicate(new String[]{"TXN2001", "TXN2002", "TXN2003"}));
    }
}
