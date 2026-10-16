package abstraction.class_problems;

import java.util.Locale;
import java.util.Scanner;

abstract class Plot {
    private final String owner;

    Plot(String owner) { this.owner = owner; }

    String getOwner() { return owner; }

    abstract String getShape();

    abstract double calculateArea();
}

class CirclePlot extends Plot {
    private final double radius;

    CirclePlot(String owner, double radius) { super(owner); this.radius = radius; }

    @Override String getShape() { return "CIRCLE"; }

    @Override double calculateArea() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private final double length, width;

    RectanglePlot(String owner, double length, double width) {
        super(owner); this.length = length; this.width = width;
    }

    @Override String getShape() { return "RECTANGLE"; }

    @Override double calculateArea() { return length * width; }
}

class TrianglePlot extends Plot {
    private final double base, height;

    TrianglePlot(String owner, double base, double height) {
        super(owner); this.base = base; this.height = height;
    }

    @Override String getShape() { return "TRIANGLE"; }

    @Override double calculateArea() { return 0.5 * base * height; }
}

public class GardenPlotAreaReport {

    // Only place that knows concrete shapes; the report loop below never changes.
    static Plot createPlot(String shape, String owner, Scanner sc) {
        switch (shape) {
            case "CIRCLE":    return new CirclePlot(owner, sc.nextDouble());
            case "RECTANGLE": return new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble());
            case "TRIANGLE":  return new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble());
            default: throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Plot[] plots = new Plot[n];
        for (int i = 0; i < n; i++) {
            String shape = sc.next().toUpperCase();
            String owner = sc.next();
            plots[i] = createPlot(shape, owner, sc);
        }

        double total = 0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            total += area;
            System.out.println(String.format(Locale.US, "%s (%s): %.2f", p.getOwner(), p.getShape(), area));
        }
        System.out.println(String.format(Locale.US, "Total Area: %.2f", total));
    }
}
