package classesandobjects.class_problems;

/**
 * M4: Library ID Card Management
 *
 * "duplicate" is a second variable pointing at the SAME object as "ravi" —
 * changing a field through one is visible through the other, and == is true.
 * "separate" is a genuinely new object with equal field values, so == is false.
 */
public class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
