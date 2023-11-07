/**  Escape.java
    Calculates the escape time for a given iterative function and window
    @Author: LW, AB, YG, MF
*/

import java.util.Arrays;
import java.util.function.Function;

public abstract class Escape {
    protected int[][] escape;
    protected Complex[][] zValues;
    protected int maxIter = 500;
    protected double threshold = 2.0;
    
    protected Function<Complex,Complex> fz;
    
    /**
     * Constructor
     * @param xMax Max value for Real dimension of c
     * @param yMax Max value for Imaginary dimension of c
     * @param xMin Min value for Real dimension of c
     * @param yMin Min value for Imaginary dimension of C
     * @param xRes X dimension resolution
     * @param yRes Y dimension resolution
     */
    public Escape(double xMin, double xMax, double yMin, double yMax, int xRes, int yRes, int maxIter, Function<Complex,Complex> fz) {
        this.maxIter = maxIter;
        this.fz=fz;
        zValues = new Complex[yRes+1][xRes+1];
        escape = new int[yRes+1][xRes+1];
        
        double deltaX = (xMax - xMin) / xRes;
        double deltaY = (yMax - yMin) / yRes;
        
        for(int i = 0; i < yRes+1; i++){
            for(int j = 0; j < xRes+1; j++){
                zValues[i][j] = new Complex(xMin + (deltaX * j), yMax - (deltaY * i));
            }
        }
    }
    
    protected int iterations(Complex initialGuess, int maxIterations){
        Complex z = initialGuess;
        for (int i = 1; i < maxIterations; i++){
            z = this.fz.apply(z);
            if (z.size() > threshold){
                return i;
            }
        }
        return 0;
    }
    
    protected void setFz(Function<Complex,Complex> fz){
        this.fz = fz;
    }
    
    public int[][] getEscape(){return this.escape;}
    public int getMaxIter(){return this.maxIter;}
    
    /**
     * The toString method
     * @return the printed version of the escape-time set
     */
    @Override
    public String toString(){
        String ans = "The escape sequence:\n";

        for (int i = 0; i < escape.length; i++){
            ans += Arrays.toString(escape[i]) + "\n";
        }
        return ans;
    }
}
