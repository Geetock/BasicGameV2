package bgv2.managers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	public static boolean left;
	public static boolean right;
	public static boolean up;
	public static boolean down;
	
	public static boolean firing;

	public KeyManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent key) {

		int keyCode = key.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			left = true;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			right = true;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up = true;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down = true;
		}
		if (keyCode == KeyEvent.VK_Z) {
			firing = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent key) {

		int keyCode = key.getKeyCode();
		
		if (keyCode == KeyEvent.VK_LEFT) {
			left = false;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			right = false;
		}
		if (keyCode == KeyEvent.VK_UP) {
			up = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down = false;
		}
		if (keyCode == KeyEvent.VK_Z) {
			firing = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent key) {
		// TODO Auto-generated method stub
		
	}

}
