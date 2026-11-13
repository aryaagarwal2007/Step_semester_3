package week11.class_problems;

// Time: O(log n) per lookup | Space: O(1)
// Binary search suits a sorted catalog that is queried far more than it is updated:
// no extra structure to maintain, and each query costs only O(log n).
public class P01_LibraryCatalogLookup {
    static String findBook(String[][] catalog, String targetIsbn) {
        int lo = 0, hi = catalog.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid][1];
            if (cmp < 0) lo = mid + 1; else hi = mid - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[][] catalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}};
        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
