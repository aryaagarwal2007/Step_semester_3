package polymorphism.class_problems;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Practice 2: Library Item Due Date Calculator
 *
 * LibraryItem is an abstract base type exposing getBorrowDays(); each
 * subclass fixes its own borrowing period. getDueDate() lives once, in the
 * base class, and reuses whatever the subclass returns for its period.
 */
public class LibraryItemDueDateCalculator {

    static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);
    static final Pattern LINE_PATTERN = Pattern.compile("^(\\S+)\\s+\"(.*)\"$");

    static abstract class LibraryItem {
        protected final String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int getBorrowDays();

        LocalDate getDueDate() {
            return CURRENT_DATE.plusDays(getBorrowDays());
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }

        int getBorrowDays() {
            return 14;
        }
    }

    static class Dvd extends LibraryItem {
        Dvd(String title) {
            super(title);
        }

        int getBorrowDays() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }

        int getBorrowDays() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            Matcher m = LINE_PATTERN.matcher(line);
            if (!m.matches()) {
                System.out.println("Could not parse line: " + line);
                continue;
            }
            String type = m.group(1);
            String title = m.group(2);

            switch (type) {
                case "BOOK":
                    items.add(new Book(title));
                    break;
                case "DVD":
                    items.add(new Dvd(title));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(title));
                    break;
                default:
                    System.out.println("Unknown item type: " + type);
            }
        }

        for (LibraryItem item : items) {
            System.out.println(item.title + ": " + item.getDueDate().format(fmt));
        }
    }
}
