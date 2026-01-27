package UMLForCircleClass;

public class CircleTest {

    public static void main(String[] args) {

        Circle c1 = new Circle(2.0, "blue");

        Circle c2 = new Circle(2.0);

        Circle c3 = new Circle();

        printCircleDetails("c1", c1);
        printCircleDetails("c2", c2);
        printCircleDetails("c3", c3);
    }

    private static void printCircleDetails(String name, Circle c) {
        System.out.println(name + " details:");
        System.out.println("Radius: " + c.getRadius());
        System.out.println("Area: " + c.getArea());
        System.out.println("Circumference: " + c.getCircumference());
        System.out.println();
    }
}
