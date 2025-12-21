package org.example.Lab5;


abstract class animal {
    public void move() {
        System.out.println("The animal moves");
    }

    abstract void makeSound();
}


class Cheetah extends animal {
    @Override
    public void move() {
        System.out.println("The cheetah runs");
    }

    @Override
    void makeSound() {

    }
}

public class Lab5prg4 {
    public static void main(String[] args) {
        animal genericAnimal = new animal() {
            @Override
            void makeSound() {

            }
        };
        Cheetah cheetah = new Cheetah();

        genericAnimal.move();  // Calls the Animal version
        cheetah.move();        // Calls the Cheetah version
    }
}
