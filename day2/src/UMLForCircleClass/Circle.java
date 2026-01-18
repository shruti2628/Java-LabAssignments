package UMLForCircleClass;

public class Circle {

    private double radius = 1.0;
    private String color = "red";

    public Circle() {
        // default values already set
    }

    public Circle(double radius) {
        setRadius(radius);
    }

    public Circle(double radius, String color) {
        setRadius(radius);
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException(
                "Radius must be positive"
            );
        }
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
