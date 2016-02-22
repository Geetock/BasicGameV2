package bgv2.gamestates;

import java.awt.Graphics2D;

import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateButton;
import bgv2.gamestate.GameStateManager;
import bgv2.main.Main;
import bgv2.managers.MouseManager;

public class MenuState extends GameState{
	
	GameStateButton startGame;
	GameStateButton help;
	GameStateButton exit;
	MouseManager mm;
	

	public MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		
		mm = new MouseManager();
		startGame = new GameStateButton(Main.width / 3, 200, new SpaceShooter(gsm), gsm, "Start Game");
		help = new GameStateButton(Main.width / 3, 300, new SpaceShooter(gsm), gsm, "Help");
		exit = new GameStateButton(Main.width / 3, 400, new ExitState(gsm), gsm, "Exit");
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick();
		startGame.tick();
		help.tick();
		exit.tick();
	}

	@Override
	public void render(Graphics2D g) {
		g.drawString("Main Menu", Main.width / 3, 100);
		
		startGame.render(g);
		help.render(g);
		exit.render(g);
		
		mm.render(g);
		//g.clipRect(0, 0, Main.width, Main.height);
	}

}