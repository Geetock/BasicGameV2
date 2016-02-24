package bgv2.gamestates;

import java.awt.Color;
import java.awt.Graphics2D;

import bgv2.entety.enemy.BasicEnemy;
import bgv2.entety.player.Player;
import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateManager;
import bgv2.managers.KeyManager;
import bgv2.ref.Reference;

public class SpaceShooter extends GameState {
	
	private boolean isPaused;
	
	Player player = new Player(Reference.WIDTH / 2, Reference.HEIGHT / 2);
	BasicEnemy e1 = new BasicEnemy(1, Reference.WIDTH / 5, 200);
	BasicEnemy e2 = new BasicEnemy(2, Reference.WIDTH / 4, 200);
	BasicEnemy e3 = new BasicEnemy(3, Reference.WIDTH / 3, 200);
	
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
		
		player.tick();
		e1.tick();
		e2.tick();
		e3.tick();
	}

	@Override
	public void render(Graphics2D g) {
				
		g.setColor(new Color(50, 0, 170));
		g.fillRect(0, 0, Reference.WIDTH, Reference.HEIGHT);
		
		player.render(g);
		e1.render(g);
		e2.render(g);
		e3.render(g);
	}

	

}
