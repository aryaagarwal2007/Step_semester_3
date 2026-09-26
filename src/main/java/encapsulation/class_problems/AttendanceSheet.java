package encapsulation.class_problems;

/**
 * Practice 5: The Attendance Sheet
 *
 * names is a private array of present students. There is no method that
 * returns the whole array — only getPresentCount() and isPresent(), both
 * computed by looping the array internally. markPresent() checks for
 * duplicates before adding.
 */
public class AttendanceSheet {
    private final String[] names;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.names = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }
        if (presentCount >= names.length) {
            System.out.println("Attendance sheet full: cannot add " + name);
            return;
        }
        names[presentCount] = name;
        presentCount++;
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("isPresent(Ben): " + sheet.isPresent("Ben"));
        System.out.println("isPresent(Chen): " + sheet.isPresent("Chen"));
    }
}
