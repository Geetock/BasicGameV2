package bgv2.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import bgv2.managers.MouseManager;
import bgv2.ref.Assets;

@SuppressWarnings("serial")
public class GameStateButton extends Rectangle{

	private Vector2F pos = new Vector2F();
	private GameState gamestate;
	private GameStateManager gsm;
	private boolean isHeldOver;
	private int width = 192;
	private int height = 64;
	private BufferedImage defaultImage;
	private String buttonMessage;

	public GameStateButton(float xpos, float ypos, GameState gamestate, GameStateManager gsm, String buttonMessage) {
		this.gamestate = gamestate;
		this.gsm = gsm;
		this.pos.xpos = xpos;
		this.pos.ypos = ypos;
		this.buttonMessage = buttonMessage;
		setBounds((int)pos.xpos,(int) pos.ypos, width, height);
		defaultImage = Assets.getButton_notover();
	}

	public GameStateButton(float xpos, float ypos, String buttonMessage) {
		this.pos.xpos = xpos;
		this.pos.ypos = ypos;
		this.buttonMessage = buttonMessage;
		setBounds((int)pos.xpos,(int) pos.ypos, width, height);
		defaultImage = Assets.getButton_notover();
	}
	
	public void tick(){
		setBounds((int)pos.xpos,(int) pos.ypos, width, height);	
		
		if(MouseManager.mouse != null){
			if(getBounds().contains(MouseManager.mouse)){
				isHeldOver = true;
			}else{
				isHeldOver = false;
			}
			
		}
		
		if(isHeldOver){
			if(defaultImage != Assets.getButton_heldover()){
				defaultImage = Assets.getButton_heldover();
			}
		}else{
			if(defaultImage != Assets.getButton_notover()){
				defaultImage = Assets.getButton_notover();
			}
		}
		
		if(gamestate != null){
			if(isHeldOver){
				if(isPressed()){
					gsm.states.push(gamestate);
					gsm.states.peek().init();
					isHeldOver = false;
					MouseManager.pressed = false;
				}
			}
		}
	}
	
	Font font = new Font("Super Mario Bros 3",10,20);
	
	public void render(Graphics2D g){
		
		g.drawImage(defaultImage, (int)pos.xpos, (int)pos.ypos, width, height, null);
		
		g.setColor(Color.WHITE);
		g.setFont(font);
		AffineTransform at = new AffineTransform();
		FontRenderContext frc = new FontRenderContext(at, true, true);
		int tw = (int) font.getStringBounds(buttonMessage, frc).getWidth();
		g.drawString(buttonMessage, pos.xpos + width / 2 - tw / 2, pos.ypos + height / 2 + 8);

	}
	
	public boolean isHeldOver(){
		return isHeldOver;
	}
	
	public boolean isPressed(){
		return MouseManager.pressed;
	}
	
	
}