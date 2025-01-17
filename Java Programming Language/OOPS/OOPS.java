package OOPS;
public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("red");
        System.out.println(p1.getColor());
    }
}

class Pen {
    private String color;
    int tip;

    String getColor() {
        return this.color;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

