package OOPS;

public class ComplexNumbers {
    public static void main(String[] args) {
        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(2, -5);

        Complex.add(c1, c2).printComplex();
        Complex.sub(c1, c2).printComplex();
        Complex.mul(c1, c2).printComplex();
    }
}

class Complex {
    int real;
    int img;

    public Complex(int r, int i) {
        real = r;
        img = i;
    }

    public static Complex add(Complex a, Complex b) {
        return new Complex(a.real+b.real, a.img+b.img);
    }

    
    public static Complex sub(Complex a, Complex b) {
        return new Complex(a.real-b.real, a.img-b.img);
    }
    
    public static Complex mul(Complex a, Complex b) {
        return new Complex(((a.real*b.real)-(a.img*b.img)),((a.real*b.img)+(a.img*b.real)));
    }
    
    public void printComplex() {
        if(real == 0 && img != 0) {
            System.out.println(img + "i");
        } else if(img == 0 && real != 0) {
            System.out.println(real);
        } else {
            System.out.println(real+"+"+"("+img+"i)");  
        }
    } 
}



