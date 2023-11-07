/**FractalImage.java
 * the basic component of rendering a fractal like the mandelbrot set or a julia set
 * @Author: Lauren Weiland
 */

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class FractalImage extends JPanel {
    //instance variables
    BufferedImage img = null;
    Julia juliaSet = null;

    /**
     * The constructor of this image
     */
    public FractalImage() {
        juliaSet = new Julia(new Complex(0.01,0.7), -2.0,2.0,-2.0,2.0,1000,1000,500);
        setPreferredSize(new Dimension(1000,1000));
        setBackground(Color.white);
    }

    void drawJuliaSet(Graphics2D g){
        int[][] numIters = juliaSet.getEscape();
        BufferedImage img = new BufferedImage(numIters.length,numIters[0].length, TYPE_INT_RGB);

        for(int i = 0; i < numIters.length; i++){
            for (int j = 0; j < numIters[i].length; j++){
                    int c = Color.HSBtoRGB((juliaSet.getMaxIter() + 0.0f) /(numIters[j][i] + 0.0f) % 1, 1, numIters[j][i] > 0 ? 1 : 0);
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
            f.add(new FractalImage(), BorderLayout.CENTER);
            f.pack();
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        });
    }
}
