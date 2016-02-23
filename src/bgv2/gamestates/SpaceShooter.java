package bgv2.gamestates;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import bgv2.entety.player.Player;
import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateManager;
import bgv2.managers.KeyManager;
import bgv2.ref.Reference;

public class SpaceShooter extends GameState {
	
	private boolean isPaused;
	
	Player player = new Player(Reference.WIDTH / 2, Reference.HEIGHT / 2);
	
	public SpaceShooter(GameStateManager gsm) {
		super(gsm);
		init();
	}

	@Override
	public void init() {
		isPaused = false;
	}

	@Override
	public void tick(double deltaTime) {
		
		// check if back to menu
		if (KeyManager.escape) {
			isPaused = true;
			KeyManager.escape = false;
		}
		
		// bastard code to get back to menu
		if (isPaused) {
			gsm.states.pop();
		}
		
		player.update();
	}

	@Override
	public void render(Graphics2D g) {
				
		player.render(g);
	}

public void keyTyped(KeyEvent key) {
		
	}
	

}
