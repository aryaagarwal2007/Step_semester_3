package encapsulation.assigment_problems;

/**
 * Problem 4: The Traffic Light
 *
 * color is private with no direct setter; next() is the only way to change
 * it, and it always moves RED -> GREEN -> YELLOW -> RED in that fixed order.
 * id is final, fixed at construction.
 */
public class TrafficLight {
    private String color;
    private final String id;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public String next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
        return color;
    }

    public String getColor() {
        return color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Start: " + t.getColor());
        System.out.println("next(): " + t.next());
        System.out.println("next(): " + t.next());
        System.out.println("next(): " + t.next());
    }
}
