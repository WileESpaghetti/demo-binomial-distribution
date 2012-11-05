package oddoreven;

import java.awt.*;

import javax.swing.*;

public class Square extends JComponent {
	boolean isStart = false;
	boolean hasPenny = false;
	int length = 64;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(getForeground());
		
		if (hasPenny || isStart) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, length, length);
			g.setColor(getForeground());
		}
		
		if (isStart) {
			g.drawString("Start", 20, 15);
		}
		
		g.drawRect(0, 0, length, length);
	}
	
	public void setOccupied(boolean isOccupied) {
		hasPenny = isOccupied;
		repaint();
	}

	public Square() {
		super();
	}
	
	public Square(boolean startHere) {
		super();
		setPreferredSize(new Dimension(length, length));
		isStart = startHere;
	}
}