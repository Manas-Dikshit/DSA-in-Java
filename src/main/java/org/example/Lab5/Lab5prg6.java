package org.example.Lab5;

// Base Class: Employee
class Employee {
    protected String name;
    protected String address;
    protected double salary;
    protected String jobTitle;

    Employee(String name, String address, double salary, String jobTitle) {
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.jobTitle = jobTitle;
    }

    public double calculateBonus() {
        return salary * 0.05; // Default 5% bonus
    }

    public String generatePerformanceReport() {
        return jobTitle + " " + name + " has given a satisfactory performance.";
    }

    public void manageProject() {
        System.out.println(jobTitle + " " + name + " is helping in the project.");
    }
}

// Manager class (Subclass of Employee)
class Manager extends Employee {

    Manager(String name, String address, double salary) {
        super(name, address, salary, "Manager");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.20; // Manager gets 20% bonus
    }

    @Override
    public String generatePerformanceReport() {
        return "Manager " + name + " has shown excellent leadership.";
    }

    @Override
    public void manageProject() {
        System.out.println("Manager " + name + " is handling the complete project.");
    }
}

// Developer class (Subclass of Employee)
class Developer extends Employee {

    Developer(String name, String address, double salary) {
        super(name, address, salary, "Developer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.10; // Developer gets 10% bonus
    }

    @Override
    public String generatePerformanceReport() {
        return "Developer " + name + " is writing good quality code.";
    }

    @Override
    public void manageProject() {
        System.out.println("Developer " + name + " is working on technical tasks.");
    }
}

// Programmer class (Subclass of Employee)
class Programmer extends Employee {

    Programmer(String name, String address, double salary) {
        super(name, address, salary, "Programmer");
    }

    @Override
    public double calculateBonus() {
        return salary * 0.08; // Programmer gets 8% bonus
    }

    @Override
    public String generatePerformanceReport() {
        return "Programmer " + name + " is delivering efficient coding work.";
    }

    @Override
    public void manageProject() {
        System.out.println("Programmer " + name + " is writing modules for the project.");
    }
}

// Main class to run the program
public class Lab5prg6 {
    public static void main(String[] args) {

        Manager m = new Manager("Amit", "Delhi", 90000);
        Developer d = new Developer("Rohit", "Mumbai", 80000);
        Programmer p = new Programmer("Sana", "Bangalore", 70000);

        System.out.println(m.generatePerformanceReport());
        System.out.println("Bonus : Rs " + m.calculateBonus());
        m.manageProject();

        System.out.println();

        System.out.println(d.generatePerformanceReport());
        System.out.println("Bonus : Rs " + d.calculateBonus());
        d.manageProject();

        System.out.println();

        System.out.println(p.generatePerformanceReport());
        System.out.println("Bonus : Rs " + p.calculateBonus());
        p.manageProject();
    }
}
