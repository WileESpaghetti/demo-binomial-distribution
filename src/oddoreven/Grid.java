package oddoreven;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class Grid extends JPanel {
	protected Square [][] squares = new Square[5][9];
	
	public void reset() {
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 9; col++) {
				squares[row][col].setOccupied(false);
			}
		}
	}
	
	public void setOccupied(boolean hasPenny, int row, int col) {
		System.out.println("Penny at " + row + "," + col);
		squares[row][col].setOccupied(hasPenny);
	}
	
	public Grid() {
		super();
		setPreferredSize(new Dimension(65*9, 65*5));
		setLayout(new GridLayout(5, 9, -1, -1));
		for (int row = 0; row < 5; row++) {
			 for (int col = 0; col < 9; col++) {
				 if (row == 0 && col == 4)
					 squares[row][col] = new Square(true);
				 else
					 squares[row][col] = new Square();
				 
				 add(squares[row][col]);
			 }
		}
	}
}