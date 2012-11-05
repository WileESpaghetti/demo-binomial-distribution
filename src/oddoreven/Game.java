package oddoreven;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener{
	protected Board b = new Board();
	protected Penny p = new Penny();
	protected Dice d = new Dice();
	int turn = 0;
	int maxGames = 16;
	int games = 1;
	
	public Penny getPenny() {
		return p;
	}
	
	public void reset() {
		games++;
		turn = 0;
		p.reset();
		b.reset();
	}
	
	public Dice getDice() {
		return d;
	}
	
	protected void turn() {
		turn++;
		long roll = d.roll();
		boolean isEven = roll % 2 == 0;
		
		if (isEven) {
			p.moveLeft();
		} else {
			p.moveRight();
		}
		
		b.getGrid().setOccupied(true, p.getRow(), p.getCol());
		
		if (turn == 4) {
			end();
		}

	}

	protected void end() {
		b.getScoreBoard().upScore(p.getCol());
	}

	public Game() {
		super();
		d.getButton().addActionListener(this);
		add(b);
		//float f = 1.0f;
		//p.setAlignmentX((float ) (64 * 5)); 
	}
	
	public void demo() {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 4; j++) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				turn();
			}
			
			reset();
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Roll!")) {
			if (games < maxGames) {
				if (turn < 4) {
					turn();
				} else {
					reset();
				}
			}
		}
	}
}