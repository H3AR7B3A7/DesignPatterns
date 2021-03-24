package Composition;

import java.awt.*;

public class Composition {
    private static final Point o = new Point(1, 2);
    private static final Point p = new Point(1, 2);
    private static final Point q = new Point(1, 2);
    private static final ColorPoint r = new ColorPoint(1, 2, Color.RED);
    private static final ColorPoint s = new ColorPoint(1, 2, Color.RED);
    private static final ColorPoint t = new ColorPoint(1, 2, Color.RED);


    /**
     * This way both equals methods adhere to contract of being:
     * - Reflexive
     * - Symmetric
     * - Transitive
     * - Consistent
     * - Never equal to null
     *
     * They also follow Liskov's substitution principle saying that:
     * - Any important property of a type should hold for all its subtypes.
     *
     * If we were to use inheritance instead we would violate one or more of these rules.
     */
    public static void main(String[] args) {
        // Reflexive
        System.out.println(o.equals(o));
        System.out.println(r.equals(r));

        // Symmetric
        System.out.println(o.equals(p) + " = " + p.equals(o));
        System.out.println(r.equals(s) + " = " + s.equals(r));

        // Transitive
        System.out.println(o.equals(p) + " = " + p.equals(q) + " = " + o.equals(q));
        System.out.println(r.equals(s) + " = " + s.equals(t) + " = " + r.equals(t));

        // Comparing Point to ColorPoint
        System.out.println(p.equals(s.asPoint()));
        System.out.println(s.asPoint().equals(p));
    }
}

class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Point))
            return false;
        Point point = (Point) o;
        return point.x == x &&
                point.y == y;
    }
}

class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) &&
                cp.color.equals(color);
    }
}