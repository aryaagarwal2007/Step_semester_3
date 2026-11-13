package week11.class_problems;

import java.util.HashMap;
import java.util.Map;

// buildLookup: O(n) once | getDepartment: O(1) average | Space: O(n)
// Queries vastly outnumber updates, so paying O(n) once to build a hash map
// beats scanning the whole list (O(n)) on every query.
public class P04_EmployeeIdLookup {
    static Map<String, String> buildLookup(String[][] records) {
        Map<String, String> lookup = new HashMap<>();
        for (String[] rec : records) lookup.put(rec[0], rec[1]);
        return lookup;
    }

    static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        String[][] records = {
            {"E245", "Finance"}, {"E110", "Engineering"},
            {"E390", "Marketing"}, {"E101", "Engineering"}};
        Map<String, String> lookup = buildLookup(records);
        System.out.println(getDepartment(lookup, "E390"));
        System.out.println(getDepartment(lookup, "E999"));
    }
}
