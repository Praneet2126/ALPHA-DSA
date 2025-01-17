package OOPS;

public class SuperKeyword {
    public static void main(String[] args) {
        Horse h = new Horse();
        Animal a = new Animal();
        System.out.println(h.color + a.color);
    }   
}

class Animal {
    String color;
    Animal() {
        System.out.println("Animal ctor called...");
    }
}

class Horse extends Animal {
    Horse() {
        super();        // java puts this by default.
        System.out.println("Horse ctor called...");
        super.color = "brown";      // changes the parent class attribute
    }
}
