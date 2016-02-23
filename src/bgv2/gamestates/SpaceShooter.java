package bgv2.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;

import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateManager;

public class SpaceShooter extends GameState {
	
	private int x = 0;
	
	public SpaceShooter(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void tick(double deltaTime) {
		x++;
	}

	@Override
	public void render(Graphics2D g) {
		g.drawString("Hello world!", 200 + x, 200);
		
		g.setColor(Color.WHITE);
		g.fillRect(150, 150, 16, 16);
	}

}
