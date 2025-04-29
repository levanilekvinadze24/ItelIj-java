
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Pre-defined class, no grading here!!!
 * <p>
 * Modifications are ignored.
 */
public class DisplayColor {



    public static void displayColor(RgbColor8Bit c) {
        JFrame jf = new JFrame("Color test") {

            @Override
            public void paint(Graphics g) {
                super.paint(g);
                g.setColor(new Color(c.getRed(), c.getGreen(), c.getBlue()));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        jf.setLocation(300, 300);
        jf.setSize(400, 350);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) { // here trying out own colors
        RgbColor rgbColor = new RgbColor(2, 3, 0, 0);
        displayColor(rgbColor.toRgbColor8Bit());
    }

}