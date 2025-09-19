/**Measuring Distance Assignment
 * @author Julia Lee
 * Fall Semester 2025
 * CSCI 1130-51
 **/

 // Import
import javax.swing.*;
import java.awt.*;

public class MeasureDistance extends JFrame {
    // Instance variables for all points and distances
    int x1, y1, x2, y2;  // Line 1 points
    int x3, y3, x4, y4;  // Line 2 points
    double distance1, distance2;  // Distances of the lines
    String input;

    public static void main(String[] args) {
        MeasureDistance frame = new MeasureDistance(); //create the window frame
        frame.setSize(new Dimension(650, 650)); //set the window size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close app when window is close
        frame.setTitle("Line Distance Measurement"); //title of frame
        frame.setVisible(true); //make window visible

        frame.getInputs();
        frame.calculateDistances();
        frame.repaint();
    }

    public void getInputs() {
        // Get input for Line 1
        input = JOptionPane.showInputDialog(this, "Enter x1 for Line 1:");
        x1 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter y1 for Line 1:");
        y1 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter x2 for Line 1:");
        x2 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter y2 for Line 1:");
        y2 = Integer.parseInt(input);

        // Get input for Line 2
        input = JOptionPane.showInputDialog(this, "Enter x3 for Line 2:");
        x3 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter y3 for Line 2:");
        y3 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter x4 for Line 2:");
        x4 = Integer.parseInt(input);
        input = JOptionPane.showInputDialog(this, "Enter y4 for Line 2:");
        y4 = Integer.parseInt(input);
    }

    public void calculateDistances() {
        // Calculate distance for Line 1 using distance formula
        distance1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        
        // Calculate distance for Line 2 using distance formula
        distance2 = Math.sqrt(Math.pow(x4 - x3, 2) + Math.pow(y4 - y3, 2));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw Line 1 in blue
        g2d.setColor(Color.BLUE);
        g2d.drawLine(x1, y1, x2, y2);
        
        // Label Line 1 points
        g2d.drawString("(" + x1 + "," + y1 + ")", x1, y1 - 5);
        g2d.drawString("(" + x2 + "," + y2 + ")", x2, y2 - 5);

        // Draw Line 2 in red
        g2d.setColor(Color.RED);
        g2d.drawLine(x3, y3, x4, y4);
        
        // Label Line 2 points
        g2d.drawString("(" + x3 + "," + y3 + ")", x3, y3 - 5);
        g2d.drawString("(" + x4 + "," + y4 + ")", x4, y4 - 5);

        // Display distances at the bottom
        g2d.setColor(Color.BLACK);
        g2d.drawString("Line 1 distance: " + String.format("%.2f", distance1), 20, 600);
        g2d.drawString("Line 2 distance: " + String.format("%.2f", distance2), 20, 620);

        // Display which line is longer using boolean statement
        boolean line1Longer = distance1 > distance2;
        g2d.drawString("Line 1 is longer than Line 2: " + line1Longer, 20, 640);
    }
}
