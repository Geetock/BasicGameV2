package bgv2.entety.player;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import bgv2.entety.Entety;
import bgv2.managers.KeyManager;
import bgv2.ref.Assets;
import bgv2.ref.Reference;


public class Player extends Entety {

	// FIELDS
	private int x;
	private int y;
	
	private BufferedImage playerImg;
	
	private int dx;
	private int dy;
	private int speed;
	
	private long firingTimer;
	private long firingDelay;
	
	private boolean isFiring = false;
	private boolean recovering = false;
	private long recoveryTimer;
	
	private int lives;
	private int score;	
	
	public Player(int posX, int posY) {
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
	
	public int getX() { return x; }
	public int getY() { return y; }
	
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
	public void update() {
		
		if (KeyManager.left) {
			dx -= speed;
		}
		if (KeyManager.right) {
			dx += speed;
		}
		if (KeyManager.down) {
			dy += speed;
		}
		if (KeyManager.up) {
			dy -= speed;
		}
		if (KeyManager.firing) {
			isFiring = true;
		}
		else {
			isFiring = false;
		}
		
		x += dx;
		y += dy;
		
		if (x < 0) x = 0;
		if (y < 0) y = 0;
		if (x > Reference.WIDTH - Reference.PLAYER_WIDTH - 1) x = Reference.WIDTH - Reference.PLAYER_WIDTH - 1;
		if (y > Reference.HEIGHT - 80) y = Reference.HEIGHT - 80;
		
		dx = 0;
		dy = 0;
		
		if (isFiring) {			
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
		g.drawImage(playerImg, x, y, Reference.PLAYER_WIDTH, Reference.PLAYER_HEIGHT, null);
	}

}
