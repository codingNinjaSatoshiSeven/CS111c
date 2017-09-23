import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class GUITemplate extends JPanel {
	private static  int initSize;
	private static int minLength;
	private static int factor;
	private static boolean isPolygon;

	public GUITemplate() {
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(500,500));
	}
	
	public void paintComponent(Graphics pen) {
		pen.setColor(Color.GRAY);
		super.paintComponent(pen);
		
		// YOUR CODE HERE!
		if (isPolygon == false){
			int initX = (int) (500/2 - initSize/2);
			int initY = (int) (500/2 - initSize/2);
			recursivePaintSquare(pen, minLength, factor, initSize, initX, initY );
		} else {
			int[] x={(int) 500/2-initSize/2, (int) 500/2, (int)500/2+initSize/2};
			double rad_3 = Math.sqrt(3);
			int[] y={ (int) (500/2+ initSize/(2*rad_3)) , (int) (500/2- initSize/rad_3),  (int) (500/2+ initSize/(2*rad_3)) };
			recursivePaintTriangle(pen, minLength,factor,initSize, x, y);
		}
		
	}
	
	// DO YOU NEED A HELPER METHOD?

	private void recursivePaintSquare(Graphics pen, int minLength, int factor, int currentLength, int xloc, int yloc) {
		if (currentLength < minLength) {
			return;
		} else {
			pen.fillRect(xloc, yloc, currentLength, currentLength);
			int newLength = currentLength / factor;
			recursivePaintSquare(pen, minLength, factor, newLength, xloc-newLength/2, yloc-newLength/2); // top left
			recursivePaintSquare(pen, minLength, factor, newLength, xloc-newLength/2, yloc-newLength/2+currentLength); // bottom left
			recursivePaintSquare(pen, minLength, factor, newLength, xloc-newLength/2+currentLength, yloc-newLength/2); // top right
			recursivePaintSquare(pen, minLength, factor, newLength, xloc-newLength/2+currentLength, yloc-newLength/2+currentLength); // bottom right
		}
	}

	private void recursivePaintTriangle(Graphics pen, int minLength, int factor, int currentLength, int[] x, int[] y){
		if (currentLength < minLength) {
			return;
		} else {
			pen.fillPolygon(x,y, 3);
			int newLength = (int) (currentLength/factor); 
			double rad_3 = Math.sqrt(3);
			// left triangle
			int[] newX1 = new int[3], 
						newY1 = new int[3], 
						newX2 = new int[3], 
						newY2 = new int[3], 
						newX3 = new int[3], 
						newY3 = new int[3];
			newX1[0]= (int) (x[0]- newLength/2);
			newX1[1] = x[0];
			newX1[2] = (int) (x[0]+ newLength/2);
			newY1[0] = (int) (y[0]+ newLength/2/rad_3);
			newY1[1] = (int) (y[0] - newLength/rad_3);
			newY1[2] = (int) (y[0]+ newLength/2/rad_3);
			recursivePaintTriangle(pen, minLength, factor, newLength, newX1, newY1);
			// upper triangle
			newX2[0]= (int) (x[1]- newLength/2);
			newX2[1] = x[1];
			newX2[2] = (int) (x[1]+ newLength/2);
			newY2[0] = (int) (y[1]+ newLength/2/rad_3);
			newY2[1] = (int) (y[1] - newLength/rad_3);
			newY2[2] = (int) (y[1]+ newLength/2/rad_3);
			recursivePaintTriangle(pen, minLength, factor, newLength, newX2, newY2);
			// right triangle
			newX3[0]= (int) (x[2]- newLength/2);
			newX3[1] = x[2];
			newX3[2] = (int) (x[2]+ newLength/2);
			newY3[0] = (int) (y[2]+ newLength/2/rad_3);
			newY3[1] = (int) (y[2] - newLength/rad_3);
			newY3[2] = (int) (y[2]+ newLength/2/rad_3);
			recursivePaintTriangle(pen, minLength, factor, newLength, newX3, newY3);
		}
		
	}
	
	
	public static void main(String[] args) {

		initSize = Integer.parseInt(JOptionPane.showInputDialog("in a 500X500 panel, how big do you want the initial Length of the square?"));
		minLength = Integer.parseInt(JOptionPane.showInputDialog("What should be the minimal length of the square?"));
		factor = Integer.parseInt(JOptionPane.showInputDialog("What factor do you want to reduce the square each step?"));
		if (JOptionPane.showConfirmDialog(null, "Do you want to draw in triangle?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		    isPolygon = true;
		} else {
		    isPolygon = false;
		}
		GUITemplate panel = new GUITemplate();
	
		JFrame frame = new JFrame("GUI Program");
		frame.getContentPane().add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}
