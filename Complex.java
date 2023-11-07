/** Represents a Complex number in standard form */
public class Complex {
    
    private double real;
    private double imaginary;

    /** Default constructor
     * @param r The real number modifier
     * @param i The imaginary number modifier
     */
    public Complex(double r, double i){
        real = r;
        imaginary = i;
    }

    /** Getter for real number modifier */
    public double real(){
        return real;
    }

    /** Getter for imaginary aspect modifier */
    public double imaginary(){
        return imaginary;
    }

    /** Calculates the modulus of the Complex number
     * @return the Modulus
     */
    public double size(){
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginary,2));
    }

    /** Finds the sum of two complex numbers
     * @param a The first complex number
     * @param b The second complex number
     * @return The sum of the two numbers
     */
    public static Complex add(Complex a, Complex b){
        double rR = a.real() + b.real();
        double rI = a.imaginary() + b.imaginary();
        return new Complex(rR, rI);
    }

    /**
     * Adds a complex number to the current number
     * @param a The complex number to add
     */
    public void add(Complex a){
        real += a.real();
        imaginary += a.imaginary();
    }

    /**
     * Calculates the square of the current Complex number
     * @return The square of the Complex number
     */
    public Complex square(){
        double rR = Math.pow(real(), 2) - Math.pow(imaginary(), 2);
        double rI = 2*real()*imaginary();
        return new Complex(rR, rI);
    }

    /**
     * Creates a String representation of the Complex number
     * @return The String representing the number
     */
    public String toString(){
        String s = real + " + " + imaginary + "i";
        return s;
    }
}