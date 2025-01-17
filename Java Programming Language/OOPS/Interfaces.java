package OOPS;

public class Interfaces {
    public static void main(String[] args) {
        // Queen q = new Queen();
        // q.moves();

        Bear b = new Bear();
        b.eatGrass();
    }   
}

interface chessPlayer {
    void moves();  // by default abstract, public
}

class Queen implements chessPlayer {
    public void moves() {       // needs to be public to match interface
        System.out.println("Moves in all directions");
    }
}

class Rook implements chessPlayer {
    public void moves() {
        System.out.println("Only up down right left");
    }
}


// multiple inheritance:
interface herbivore {
    void eatGrass();
}

interface carnivore {
    void eatFlesh();
}

class Bear implements herbivore, carnivore {
    public void eatGrass() {
        System.out.println("Eats grass");
    }

    public void eatFlesh() {
        System.out.println("Eats flesh");
    }
}