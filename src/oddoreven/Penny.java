package oddoreven;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import sun.java2d.pipe.BufferedBufImgOps;

public class Penny extends JComponent {
	int row = 0;
	int col = 4;
	int dx = 2;
	int dy = 2;
	int dMax = 64;
	final int STARTX = 263;
	final int STARTY = 64;
	int posX = 263;
	int posY = 64;
	BufferedImage buffImg;
	String img = "penny.png";
	 
	 public void reset() {
		row = 0;
		col = 4;
		posX = STARTX;
		posY = STARTY;
		repaint();
	}
	
	public Penny() {
		setPreferredSize(new Dimension(64, 64));
		URL u = getClass().getResource(img);
	    System.out.println(u);
		try {
		    buffImg = ImageIO.read(u);
		} catch (IOException e) {
			System.out.println(u);
		}
	}
	 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.fillOval(posX, posY, 64, 64);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(buffImg, null, posX, posY);
	}

	protected void moveDown() {
		 row++;
		 //posY += dMax;
	 }
	
	public void moveLeft() {
		moveDown();
		col--;
		animateLeft();
		repaint();
		//posX -= dMax;
	}
	
	public void moveRight() {
		moveDown();
		col++;
		animateRight();
		repaint();
		//posX += dMax;
	}
	
	protected void animateDown() {
		for (int i = 0; i < dMax; i += dy) {
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			posY += dy;
			paintComponent(getGraphics());
		}
	}
	
	protected void animateLeft() {
		animateDown();
		for (int i = 0; i < dMax; i += dx) {
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			posX -= dx;
			paintComponent(getGraphics());
		}
	}
	
	protected void animateRight() {
		animateDown();
		for (int i = 0; i < dMax; i += dx) {
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			posX += dx;
			paintComponent(getGraphics());
		}
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
}