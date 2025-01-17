package OOPS;

public class Abstraction {
    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eat();
        // h.walk();

        // Chicken c = new Chicken();
        // c.walk();

        // Animal a = new Animal();    // error 

        // Mustang m = new Mustang();
        // animal -> horse -> mustang
    }
}

abstract class Animal {
    // ctor
    Animal() {
        System.out.println("Animal ctor called");
    }

    void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse ctor called");
    }

    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang ctor called");
    }
}

class Chicken extends Animal {
    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

