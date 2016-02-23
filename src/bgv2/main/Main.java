package bgv2.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import my.project.gop.main.GameWindow;
import bgv2.gameloop.GameLoop;
import bgv2.managers.MouseManager;
import bgv2.ref.Reference;

public class Main {
		
	public static int width;
	public static int height;
	
	public static void main(String[] args) {
		
		if (Reference.FULLSCREEN) {
			GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
			width = gd.getDisplayMode().getWidth();
			height = gd.getDisplayMode().getHeight();
		}
		else {
			width = Reference.WIDTH;
			height = Reference.HEIGHT;
		}
		
		GameWindow frame = new GameWindow(Reference.NAME, width, height);
		
		if (Reference.FULLSCREEN) {
			frame.setFullScreen(1);
		}

		frame.addMouseListener(new MouseManager());
		frame.addMouseMotionListener(new MouseManager());
		frame.addMouseWheelListener(new MouseManager());		
		
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);

	}
}