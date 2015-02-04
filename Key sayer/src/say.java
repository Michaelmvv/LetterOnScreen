import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class say implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Press Something");

	public void Go() {

		frame.add(panel);
		panel.add(label);
		label.setFont(new Font("Serif", Font.PLAIN, 100));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.addKeyListener(this);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new say().Go();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		label.setText(arg0.getKeyChar() + "");
		System.out.println();
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			try {
				Runtime.getRuntime().exec("say -v Zarvox " + arg0.getKeyChar());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
