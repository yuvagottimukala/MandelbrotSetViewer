/**MandelbrotImage.java
 * the basic component of rendering a fractal like the mandelbrot set or a julia set
 * @Author: Lauren Weiland
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class JuliaImage extends JPanel {
    //instance variables
    BufferedImage img = null;
    Julia julia = null;

    /**
     * The constructor of this image
     */
    public JuliaImage(double real, double imag, double xMin, double xMax, double yMin, double yMax, int xRes, int yRes, int maxIter) {
        julia = new Julia(new Complex(real, imag),xMin,xMax,yMin,yMax,xRes,yRes,maxIter);
        setPreferredSize(new Dimension(xRes,yRes));
        setBackground(Color.white);
    }

    public JuliaImage(){
        julia = new Julia(new Complex(0.0, 0.0), -2.0,4.0,-4.0,2.0,1000,1000,500);
        setPreferredSize(new Dimension(1000,1000));
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int wid = (int) (ss.getWidth() *.95);
        int heit = (int) (ss.getHeight() *.95);
        setPreferredSize(new Dimension((int)(wid/1.9), 0));
        setBackground(Color.WHITE);
        setBackground(Color.white);
    }

    void drawJuliaSet(Graphics2D g){
        int[][] numIters = julia.getEscape();
        BufferedImage img = new BufferedImage(numIters.length,numIters[0].length, TYPE_INT_RGB);

        for(int i = 0; i < numIters.length; i++){
            for (int j = 0; j < numIters[i].length; j++){
                int c = Color.HSBtoRGB(7*(numIters[j][i] + 0.0f)/(julia.getMaxIter() + 0.0f) % 1, 1, numIters[j][i] > 0 ? 1 : 0);

                    img.setRGB(i, j, c);
            }
        }
        g.drawImage(img, 0, 0, null);
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int wid = (int) (ss.getWidth() *.95);
        int heit = (int) (ss.getHeight() *.95);
        setPreferredSize(new Dimension((int)(wid/1.9), 0));
        setBackground(Color.WHITE);
        setBackground(Color.white);
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        drawJuliaSet(g);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setTitle("Julia Set");
            f.setResizable(false);
            
            double re = Double.parseDouble(args[0]);
            double im = Double.parseDouble(args[1]);
            double xMax = Double.parseDouble(args[2]);
            double xMin = Double.parseDouble(args[3]);
            double yMax = Double.parseDouble(args[4]);
            double yMin = Double.parseDouble(args[5]);
            int res = Integer.parseInt(args[6]);
            int maxIter = Integer.parseInt(args[7]);
            f.add(new JuliaImage(re, im, xMax, xMin, yMax, yMin, res,res, maxIter), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
