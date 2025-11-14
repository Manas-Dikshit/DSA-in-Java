package org.example.Lab5;


class Vehicle {
    void drive() {
        System.out.println("Vehicle is being driven");
    }
}


class Car extends Vehicle {
    @Override
    void drive() {
        System.out.println("Repairing a car");
    }
}


public class Lab5prg2 {
    public static void main(String[] args) {
        Vehicle myVehicle = new Vehicle();
        myVehicle.drive();

        Car myCar = new Car();
        myCar.drive();
    }
}
