package org.example.Lab5;


class Shape {
    double getArea() {
        return 0;
    }
}


class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double getArea() {
        return width * height;
    }
}


public class Lab5prg3 {
    public static void main(String[] args) {
        Shape shape = new Shape();
        System.out.println("Shape area: " + shape.getArea());

        Rectangle rect = new Rectangle(15, 20);
        System.out.println("Rectangle area: " + rect.getArea());
    }
}
