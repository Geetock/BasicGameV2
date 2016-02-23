package bgv2.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import bgv2.entety.player.Player;
import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateManager;
import bgv2.ref.Reference;

public class SpaceShooter extends GameState {
	
	Player player = new Player(Reference.WIDTH / 2, Reference.HEIGHT / 2);
	
	public SpaceShooter(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public void tick(double deltaTime) {
	
		player.update();
	}

	@Override
	public void render(Graphics2D g) {
				
		player.render(g);
	}

public void keyTyped(KeyEvent key) {
		
	}
	

}
