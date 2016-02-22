package bgv2.gameloop;


import my.project.gop.main.IDGameLoop;
import bgv2.gamestate.GameStateManager;
import bgv2.ref.Assets;

@SuppressWarnings("serial")
public class GameLoop extends IDGameLoop {
	
	GameStateManager gsm;

	public GameLoop(int width, int height) {
		super(width, height);
				
	}
	
	@Override
	public void init() {

		Assets.init();
		
		gsm = new GameStateManager();
		gsm.init();
		
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
		gsm.tick(deltaTime);

	}
	
	
	@Override
	public void render() {
		super.render();
		
		gsm.render(graphics2D);
		
		clear();
	}
	
	
	@Override
	public void clear() {
		super.clear();
	}

}