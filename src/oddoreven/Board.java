package oddoreven;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
	protected int gamNum = 1;
	protected int maxGames = 16;
	protected JLabel header = new JLabel("Game " + gamNum + " of " + maxGames, JLabel.CENTER);
	protected Grid g = new Grid();
	protected ScoreBoard s = new ScoreBoard();
	
	public Grid getGrid() {
		return g;
	}
	
	public ScoreBoard getScoreBoard() {
		return s;
	}
	
	public void reset() {
		g.reset();
		if (gamNum < maxGames)
			gamNum++;
		header.setText("Game " + gamNum + " of " + maxGames);
	}
	
	public Board() {
		header.setPreferredSize(new Dimension(64*9, 15));
		header.setText("Game " + gamNum + " of " + maxGames);
		
		setLayout(new BorderLayout());
		add(header, BorderLayout.NORTH);
		add(g, BorderLayout.CENTER);
		add(s, BorderLayout.SOUTH);
	}
}