package bgv2.ref;

import java.awt.image.BufferedImage;
import my.project.gop.main.SpriteSheet;
import my.project.gop.main.ImageLoader;

public class Assets {
	
	private static SpriteSheet bars = new SpriteSheet();
	private static SpriteSheet entety = new SpriteSheet();
	
	//PLAYER
	private static BufferedImage player;
		
	// ENEMIES
	private static BufferedImage basic_e1;
	private static BufferedImage basic_e2;
	private static BufferedImage basic_e3;
	
	
	// BUTTONS
	private static BufferedImage button_heldover;
	private static BufferedImage button_notover;
	
	// MOUSE CURSER
	private static BufferedImage mouse_pressed;
	private static BufferedImage mouse_released;
	
	public static void init() {
		
		bars.setSpriteSheet(ImageLoader.loadImage("/gui/SleekBars.png"));
		entety.setSpriteSheet(ImageLoader.loadImage("/entety/models.png"));
		
		button_heldover = bars.getTile(0, 32, 128, 32);
		button_notover = bars.getTile(0, 0, 128, 32);
		
		player = entety.getTile(0, 0, 16, 16);
		
		basic_e1 = entety.getTile(0, 16, 16, 16);
		basic_e2 = entety.getTile(16, 16, 16, 16);
		basic_e3 = entety.getTile(32, 16, 16, 16);
	}
	
	public static BufferedImage getPlayer() {
		return player;
	}

	public static BufferedImage getBasic_e1() {
		return basic_e1;
	}
	
	public static BufferedImage getBasic_e2() {
		return basic_e2;
	}
	
	public static BufferedImage getBasic_e3() {
		return basic_e3;
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
