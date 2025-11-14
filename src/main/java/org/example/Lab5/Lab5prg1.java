package org.example.Lab5;

class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}


class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat barks");
    }
}


public class Lab5prg1 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.makeSound();

        Cat myCat = new Cat();
        myCat.makeSound();
    }
}
