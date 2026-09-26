package encapsulation.assigment_problems;

/**
 * Problem 3: The Password Checker
 *
 * The password is stored privately with no getter that returns it anywhere.
 * getStrength() computes a rating from the stored value internally, so the
 * raw text never has to leave the object.
 */
public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int length = password.length();
        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("abcd -> " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("abcdefgh -> " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("abcdefghij -> " + pc3.getStrength());
    }
}
