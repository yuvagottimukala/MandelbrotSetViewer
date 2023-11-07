/**MandelbrotImage.java
 * the basic component of rendering a fractal like the mandelbrot set or a julia set
 * @Author: Lauren Weiland
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class MandelbrotImage extends JPanel {
    //instance variables
    BufferedImage img = null;
    Mandelbrot mandelbrot = null;

    /**
     * The constructor of this image
     */
    public MandelbrotImage(double xMin, double xMax, double yMin, double yMax, int xRes, int yRes, int maxIter) {
        mandelbrot = new Mandelbrot(xMin, xMax, yMin, yMax, xRes, yRes, maxIter);
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int wid = (int) (ss.getWidth() *.95);
        int heit = (int) (ss.getHeight() *.95);
        setPreferredSize(new Dimension((int)(wid/2), 0));
        setBackground(Color.WHITE);
    }

    public MandelbrotImage(){
        mandelbrot = new Mandelbrot(-2.0,2.0,-2.2,2,1000,1000,500);
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int wid = (int) (ss.getWidth() *.95);
        int heit = (int) (ss.getHeight() *.95);
        setPreferredSize(new Dimension((int)(wid/1.9), 0));
        setBackground(Color.white);
    }

    void drawJuliaSet(Graphics2D g){
        int[][] numIters = mandelbrot.getEscape();
        BufferedImage img = new BufferedImage(numIters.length,numIters[0].length, TYPE_INT_RGB);

        for(int i = 0; i < numIters.length; i++){
            for (int j = 0; j < numIters[i].length; j++){
                int c = Color.HSBtoRGB(7*(numIters[j][i] + 0.0f)/(mandelbrot.getMaxIter() + 0.0f) % 1, 1, numIters[j][i] > 0 ? 1 : 0);
                    img.setRGB(i, j, c);
            }
        }
        g.drawImage(img, 0, 0, null);
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
            f.add(new MandelbrotImage(-2.0,2.0,-2.0,2.0,1000,1000,500) , BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
