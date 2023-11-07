/**  Julia.java
    Calculates the julia set of a given region and c
    @Author: LW, AB, YG, MF
*/

import java.util.Arrays;

public class Julia extends Escape {
    private Complex c;

    public Julia(Complex c, double xMin, double xMax, double yMin, double yMax, int xRes, int yRes, int maxIter){
        super(xMin,xMax,yMin,yMax,xRes,yRes,maxIter,(obj)->(Complex.add(obj.square(),c)));
        
        //set our C value
        this.c = c;

        //compute the escape values
        for (int i = 0; i < yRes+1; i++){
            for (int j = 0; j < xRes+1; j++){
                escape[i][j] = iterations(zValues[i][j], maxIter);
            }
        }
    }
}
