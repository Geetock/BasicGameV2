package bgv2.ref;

import java.awt.image.BufferedImage;
import my.project.gop.main.SpriteSheet;
import my.project.gop.main.loadImageFrom;

public class Assets {
	
	private static SpriteSheet bars = new SpriteSheet();

	// BUTTONS
	private static BufferedImage button_heldover;
	private static BufferedImage button_notover;
	
	// MOUSE CURSER
	private static BufferedImage mouse_pressed;
	private static BufferedImage mouse_released;
	
	public static void init() {
		
		bars.setSpriteSheet(loadImageFrom.LoadImageFrom(Assets.class, "res/SleekBars.png"));
		
		button_heldover = bars.getTile(0, 32, 128, 32);
		button_notover = bars.getTile(0, 0, 128, 32);
	}
	
	public static BufferedImage getButton_heldover() {
		return button_heldover;
	}
	
	public static BufferedImage getButton_notover() {
		return button_notover;
	}
	
	public static BufferedImage getMouse_pressed() {
		return mouse_pressed;
	}
	
	public static BufferedImage getMouse_released() {
		return mouse_released;
	}
}
