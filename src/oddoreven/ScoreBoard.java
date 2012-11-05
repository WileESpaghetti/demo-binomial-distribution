package oddoreven;

import java.awt.*;
import java.util.Arrays;

import javax.swing.*;

public class ScoreBoard extends JPanel {
	JLabel [] cols = new JLabel[9];
	int [] wins = new int[9];
	
	public void upScore(int col) {
		int index = col;
		wins[index]++;
		cols[index].setText("" + wins[index]);
	}
	
	public ScoreBoard() {
		//setLayout(new FlowLayout());
		Arrays.fill(wins, 0);
		for (int i = 0; i < 9; i++) {
			cols[i] = new JLabel("" + wins[i], JLabel.CENTER);
			cols[i].setPreferredSize(new Dimension(58, 15));
			add(cols[i]);
		}
	}
}
