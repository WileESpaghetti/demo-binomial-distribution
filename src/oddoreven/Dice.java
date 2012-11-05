package oddoreven;

import java.awt.*;
import javax.swing.*;

public class Dice extends JPanel {
	JLabel num = new JLabel("1");
	JButton roller = new JButton("Roll!");

	public long roll() {
		long roll = Math.round(Math.random() * 5);
		animateRoll(roll);
		return  roll;
	}
	
	protected void animateRoll(long roll) {
		//num.setIcon(new ImageIcon("roll.gif"));
		/*try {
		for (int i = 0; i < 16; i++) {
			long a = Math.round(Math.random() * 5) + 1;
			num.setText("" + a);
		}*/
		num.setText("" + (roll + 1));
	}
	
	public JButton getButton() {
		return roller;
	}
	
	public Dice() {
		roller.setName("roll");
		add(roller);
		add(num);
	}
}