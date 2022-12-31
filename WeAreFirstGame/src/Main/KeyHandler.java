package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
	
	public boolean upP,downP,lP,rP;

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

		if (code == KeyEvent.VK_W) {
			upP = true;
		}

		if (code == KeyEvent.VK_S) {
			downP = true;
		}

		if (code == KeyEvent.VK_A) {
			lP = true;
		}

		if (code == KeyEvent.VK_D) {
			rP = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == KeyEvent.VK_W) {
			upP = false;
		}

		if (code == KeyEvent.VK_S) {
			downP = false;
		}

		if (code == KeyEvent.VK_A) {
			lP = false;
		}

		if (code == KeyEvent.VK_D) {
			rP = false;
		}
		
		

	}

}
