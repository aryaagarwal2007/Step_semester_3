package encapsulation.class_problems;

/**
 * Practice 4: The Locker Code
 *
 * code is private with no getter at all (write-only). changeCode() only
 * applies the new code if the supplied current code matches; otherwise it
 * rejects the change and leaves code untouched. lockerNumber is final.
 */
public class Locker {
    private String code;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.code = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!code.equals(currentCode)) {
            System.out.println("Change rejected: current code incorrect");
            return false;
        }
        code = newCode;
        System.out.println("Code changed successfully");
        return true;
    }

    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
