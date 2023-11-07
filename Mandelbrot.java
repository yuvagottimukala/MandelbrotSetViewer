/**  Mandelbrot.java
    Calculates the Mandelbrot set for a given window
    @Author: LW, AB, YG, MF
*/

import java.util.Arrays;

public class Mandelbrot extends Escape {

    public Mandelbrot(double xMin, double xMax, double yMin, double yMax, int xRes, int yRes, int maxIter) {
        super(xMin,xMax,yMin,yMax,xRes,yRes,maxIter,(obj)->null);

        //compute the escape values
        for (int i = 0; i < yRes+1; i++){
            for (int j = 0; j < xRes+1; j++){
                Complex c = zValues[i][j];
                this.setFz((obj)->(Complex.add(obj.square(),c)));
                escape[i][j] = iterations(new Complex(0.0,0.0), maxIter);
            }
        }
    }
}
