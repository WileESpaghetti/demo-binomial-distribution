package oddoreven;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;

public class GameGUI {
	
	protected JMenu gameMenu;
	
	protected JMenu buildGameMenu() {
		// basic setup
		JMenu game;
		
		// create menu items
		JMenuItem gNew = new JMenuItem("New");
		gNew.setMnemonic('n');
		
		JMenuItem gQuit = new JMenuItem("Quit");
		gNew.setMnemonic('q');
		
		game = new JMenu("Game");
		game.setMnemonic('g');
		
		// add menu items
		game.add(gNew);
		game.add(gQuit);
		
		return game;
	}
	
	public static void main(String [] args) {
		GameGUI gg = new GameGUI();
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame f = new JFrame("Even or Odd");
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar mb = new JMenuBar();
		mb.add(gg.buildGameMenu());
		
		Game gam = new Game();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gam, gam.getDice());
		
		f.getContentPane().add(sp);
		f.setGlassPane(gam.getPenny());
		f.setJMenuBar(mb);

		f.pack();
		f.setVisible(true);
		f.getGlassPane().setVisible(true);
	}
}