/**TestJulia.java
 * Test the
 */

public class TestJulia {
    public static void main(String [] args){
        Complex c = new Complex(Double.parseDouble(args[0]),Double.parseDouble(args[1]));
        Julia theSet = new Julia(c,-2.0,2.0,-2.0,2.0,500,500, 500);
        int a = 1;
        int b = 2;
        int d = 4;
        System.out.println(((a + 0.0f) + (b + 0.0f)) / (d + 0.0f));
    }

}
