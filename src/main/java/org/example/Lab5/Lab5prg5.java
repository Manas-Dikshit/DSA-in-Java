package org.example.Lab5;


class shape {
    public double getPerimeter() {
        return 0;
    }

    public double getArea() {
        return 0;
    }
}


class Circle extends shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}


public class Lab5prg5 {
    public static void main(String[] args) {
        Circle c = new Circle(5.0);

        System.out.println("Perimeter of Circle: " + c.getPerimeter());
        System.out.println("Area of Circle: " + c.getArea());
    }
}
