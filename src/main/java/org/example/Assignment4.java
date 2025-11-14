package org.example;

public class Assignment4 {

    static class Counter {
        static int count = 0;
        Counter() {
            count++;
        }
    }

    static class MathUtility {
        static int add(int a, int b) {
            return a + b;
        }
    }

    static class Constants {
        static final double PI = 3.14159;
        static double calculateCircleArea(double radius) {
            return PI * radius * radius;
        }
    }

    static class IDGenerator {
        static int nextID = 1000;
        static int generateID() {
            return nextID++;
        }
    }

    static class ComplexInitializer {
        static int x, y, z;
        static {
            x = 10;
            y = x * 2;
            z = y + x;
        }
    }

    static class Computer {
        class Processor {
            void displayDetails() {
                System.out.println("Processor Brand: Intel, Speed: 3.5GHz");
            }
        }
    }

    static class Car {
        void startEngine() {
            class Engine {
                void run() {
                    System.out.println("Engine is running");
                }
            }
            Engine engine = new Engine();
            engine.run();
        }
    }

    static class Library {
        String libraryName;
        Library(String name) {
            this.libraryName = name;
        }
        class Book {
            String getLibraryName() {
                return libraryName;
            }
        }
    }

    static class MathUtil {
        static class Calculator {
            static int add(int a, int b) {
                return a + b;
            }
        }
    }

    static class House {
        void calculateArea(double length, double width) {
            class Room {
                double getArea() {
                    return length * width;
                }
            }
            Room room = new Room();
            System.out.println("Room area: " + room.getArea());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 1. Counter Example ===");
        new Counter();
        new Counter();
        new Counter();
        System.out.println("Total objects created: " + Counter.count);

        System.out.println("\n 2. MathUtility Example ===");
        System.out.println("Sum: " + MathUtility.add(10, 20));

        System.out.println("\n 3. Constants Example ===");
        System.out.println("Area of circle (r=5): " + Constants.calculateCircleArea(5));

        System.out.println("\n 4. IDGenerator Example ===");
        System.out.println("Generated ID: " + IDGenerator.generateID());
        System.out.println("Next Generated ID: " + IDGenerator.generateID());

        System.out.println("\n 5. ComplexInitializer Example ===");
        System.out.println("x=" + ComplexInitializer.x + ", y=" + ComplexInitializer.y + ", z=" + ComplexInitializer.z);

        System.out.println("\n 6. Computer & Processor Example ===");
        Computer computer = new Computer();
        Computer.Processor processor = computer.new Processor();
        processor.displayDetails();

        System.out.println("\n 7. Car & Engine Example ===");
        Car car = new Car();
        car.startEngine();

        System.out.println("\n 8. Library & Book Example ===");
        Library library = new Library("City Central Library");
        Library.Book book = library.new Book();
        System.out.println("Library name from book: " + book.getLibraryName());

        System.out.println("\n 9. MathUtil & Calculator Example ===");
        System.out.println("Addition: " + MathUtil.Calculator.add(15, 25));

        System.out.println("\n 10. House & Room Example ===");
        House house = new House();
        house.calculateArea(12.5, 10.0);
    }
}

