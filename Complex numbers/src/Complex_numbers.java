import java.util.Scanner;

class Complex {
    double real;
    double imaginary;

    Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static void main() {
        Scanner sc = new Scanner(System.in);
        Complex complex = new Complex(sc.nextDouble(), sc.nextDouble());
    }
}
