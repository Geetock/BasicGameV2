package bgv2.gamestates;

import java.awt.Graphics2D;

import bgv2.gamestate.GameState;
import bgv2.gamestate.GameStateButton;
import bgv2.gamestate.GameStateManager;
import bgv2.main.Main;
import bgv2.managers.MouseManager;

public class ExitState extends GameState{

	GameStateButton yes;
	GameStateButton no;
	MouseManager mm;
	
	public ExitState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		mm = new MouseManager();
		yes = new GameStateButton(Main.width / 3, 100, "Yes!");
		no = new GameStateButton(Main.width / 3 + 200, 100, "No!");
	}

	@Override
	public void tick(double deltaTime) {
		mm.tick();
		yes.tick();
		no.tick();
		
		if(yes.isHeldOver()){
			if(yes.isPressed()){
				System.exit(1);
			}
		}
		if(no.isHeldOver()){
			if(no.isPressed()){
				gsm.states.push(new MenuState(gsm));
				gsm.states.peek().init();
			}
		}
	}

	@Override
	public void render(Graphics2D g) {
		yes.render(g);
		no.render(g);
		mm.render(g);
		g.clipRect(0, 0, Main.width, Main.height);
	}

}