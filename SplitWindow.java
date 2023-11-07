
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SplitWindow extends JFrame {
    public SplitWindow() {
        // set the size and title of the window
        Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
        int wid = (int) (ss.getWidth());
        int heit = (int) (ss.getHeight());
        setSize(wid, heit);
        setTitle("MANDELBROT SET VIEWER");

      

        // create the main panel with a BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // create the left panel with a FlowLayout
        
        Component JuliaImage = new JuliaImage();
        Component Mandelbrot = new MandelbrotImage();
        mainPanel.add(JuliaImage, BorderLayout.WEST);

        // create the right panel with a FlowLayout
        
       
        mainPanel.add(Mandelbrot, BorderLayout.EAST);

        // create the bottom panel with a GridLayout
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // create the Generate button and add it to the bottom panel
        JButton generateButton = new JButton("Generate");
        bottomPanel.add(generateButton);

        // create the Restore button and add it to the bottom panel
        JButton restoreButton = new JButton("Restore");
        bottomPanel.add(restoreButton);

        // add the main panel to the frame
        add(mainPanel);

        // set the window to be visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // create an instance of the window
        SplitWindow window = new SplitWindow();

        // set the close operation
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}