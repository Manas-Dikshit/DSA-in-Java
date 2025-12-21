package org.example.Lab5;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}


class Cat extends animal {
    @Override
    void makeSound() {
        System.out.println("Cat barks");
    }
}


public class Lab5prg1 {
    public static void main(String[] args) {
        animal myAnimal = new animal() {
            @Override
            void makeSound() {

            }
        };
        myAnimal.makeSound();

        Cat myCat = new Cat();
        myCat.makeSound();
    }
}
