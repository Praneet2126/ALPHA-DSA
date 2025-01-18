final class Complex {
    private double re, im;
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    Complex(Complex c) {
        System.out.println("Copy constructor called");
        re = c.re;
        im = c.im;
    }            
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }            

    public void changeVal(Complex c, double a, double b) {
        c.re = a;
        c.im = b;
    }
}
class Practice {
    public static void main(String[] args) {
        Complex c1 = new Complex(10, 15);
        // Complex c2 = new Complex(c1);    
        Complex c3 = c1;    // reference is passed
        Complex c4 = new Complex(c1);
        c1.changeVal(c1, 20, 30);
        System.out.println(c3);
        System.out.println(c4);
    }
}
