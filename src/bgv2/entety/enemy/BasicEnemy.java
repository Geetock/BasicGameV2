package bgv2.entety.enemy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import bgv2.entety.Entety;
import bgv2.ref.Assets;
import bgv2.ref.Reference;

public class BasicEnemy extends Entety{

	private double x;
	private double y;
	private BufferedImage basicEnemy;
	private int enemyWidth;
	private int enemyHeight;
	
	private double dx;
	private double dy;
	private double rad;
	private double speed;
	
	private int health;
	private int rank;
	
	
	// private boolean ready; don't know yet
	private boolean dead;
	
	private boolean hit;
	private long hitTimer;
	
	private boolean slow;
	
	public BasicEnemy(int rank, double x, double y) {
		this.x = x;
		this.y = y;
		this.rank = rank;
		
		// Sets the correct stats for the enemy based on rank
		switch (rank) {
		case 1:
			basicEnemy = Assets.getBasic_e1();
			health = 2;
			speed = 2;
			enemyWidth = 16;
			enemyHeight = 16;
			break;
		case 2:
			basicEnemy = Assets.getBasic_e2();
			health = 4;
			speed = 2;
			enemyWidth = 24;
			enemyHeight = 24;
			break;
		case 3:
			basicEnemy = Assets.getBasic_e3();
			health = 6;
			speed = 2;
			enemyWidth = 32;
			enemyHeight = 32;
			break;
		default:
			System.out.println("Wrong rank given for BasicEnemy");
			break;
		}
		
		double angle = Math.random() * 360;
		rad = Math.toRadians(angle);
		
		dx = Math.cos(rad) * speed;
		dy = Math.sin(rad) * speed;
		
		// ready = false;
		dead = false;
		
		hit = false;
		hitTimer = 0;
	}
	
	// FUNCTIONS
		public double getX() { return x; }
		public double getY() { return y; }
		
		public int getRank() { return rank; }
		public void setSlow(boolean b) { slow = b; }
		
		public boolean isDead() { return dead; }
		
		public void hit(int dmg) {
			health -= dmg;
			if (health <= 0) {
				dead = true;
			}
			hit = true;
			hitTimer = System.nanoTime();
		}

	@Override
	public void tick() {
		if (slow) {
			x += dx * 0.3;
			y += dy * 0.3;
		}
		else {
			x += dx;
			y += dy;
		}
		
		/* Old code. need to think
		if (!ready) {
			if ( x > r && x < GamePanel.WIDTH - r && y > r && y < GamePanel.HEIGHT - r) {
				ready = true;
			}
		}
		*/
		
		if (x < 0 && dx < 0) dx = -dx;
		if (y < 0 && dy < 0) dy = -dy;
		if (x > Reference.WIDTH - enemyWidth && dx > 0) dx = -dx;
		if (y > Reference.HEIGHT -  2 * enemyHeight && dy > 0) dy = -dy;
		
		if (hit) {
			long elapsed = (System.nanoTime() - hitTimer) / 1000000;
			if (elapsed > 50) {
				hit = false;
				hitTimer = 0;
			}
		}
	}

	@Override
	public void render(Graphics2D g) {

		g.drawImage(basicEnemy, (int) x, (int) y, enemyWidth, enemyHeight, null);
	}

}
