package bgv2.entety.player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import bgv2.entety.Entety;
import bgv2.managers.KeyManager;
import bgv2.ref.Assets;
import bgv2.ref.Reference;


public class Player extends Entety {

	// FIELDS
	private double x;
	private double y;
	
	private BufferedImage playerImg;
	
	private double dx;
	private double dy;
	private double speed;

	private long firingTimer;
	private long firingDelay;
	
	private boolean recovering = false;
	private long recoveryTimer;
	
	private int lives;
	private int score;	
	
	public Player(double posX, double posY) {
		this.x = posX;
		this.y = posY;
		
		firingTimer = System.nanoTime();
		firingDelay = 200;
		
		recovering = false;
		recoveryTimer = 0;
		
		lives = 3;
		score = 0;
		speed = 5;
		playerImg = Assets.getPlayer();
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	public int getLives() { return lives; }	
	public int getScore() { return score; }
	
	public boolean isDead() { return lives <= 0; }
	public boolean isRecovering() { return recovering; }
	
	public void addScore(int i) { score += i; }
	
	public void gainLife() {
		lives++;
	}
	
	public void loseLife() {
		lives--;
		recovering = true;
		recoveryTimer = System.nanoTime();
	}

	@Override
	public void tick() {
		
		// Normal movement
		if (KeyManager.left) {
			dx = -speed;
		}
		if (KeyManager.right) {
			dx = speed;
		}
		if (KeyManager.down) {
			dy = speed;
		}
		if (KeyManager.up) {
			dy = -speed;
		}
		
		// compensating for diagonal speed;
		if (KeyManager.left && (KeyManager.up || KeyManager.down)) {
			dx =  speed * -0.75;
		}
		if (KeyManager.right && (KeyManager.up || KeyManager.down)) {
			dx = speed * 0.75;
		}
		if (KeyManager.down && (KeyManager.left || KeyManager.right)) {
			dy = speed * 0.75;
		}
		if (KeyManager.up && (KeyManager.left || KeyManager.right)) {
			dy = speed * -0.75;
		}
		
		// sets the speed
		x += dx;
		y += dy;
		
		// check out of bounds
		if (x < 0) x = 0;
		if (y < 0) y = 0;
		if (x > Reference.WIDTH - Reference.PLAYER_WIDTH - 1) x = Reference.WIDTH - Reference.PLAYER_WIDTH - 1;
		if (y > Reference.HEIGHT - 2 * Reference.PLAYER_HEIGHT) y = Reference.HEIGHT - 2 * Reference.PLAYER_HEIGHT;
		
		// reset the speed variables so no continued acceleration
		dx = 0;
		dy = 0;
		
		// check if firing and keep tracks of the delay.
		if (KeyManager.firing) {			
			long elapsed = (System.nanoTime() - firingTimer) / 1000000;
			
			if (elapsed > firingDelay) {
				firingTimer = System.nanoTime();
				
				// TODO add firing code				
			}
		}
		
		// Check if taken damage
		if (recovering) {
			long elapsed = (System.nanoTime() - recoveryTimer) / 1000000;
			if (elapsed > 2000) {
				recovering = false;
				recoveryTimer = 0;
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(playerImg, (int) x, (int) y, Reference.PLAYER_WIDTH, Reference.PLAYER_HEIGHT, null);
	}

}
