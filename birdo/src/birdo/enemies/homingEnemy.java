package birdo.enemies;

import java.awt.Color;

import birdo.utilities.enemy;

public class homingEnemy extends enemy{

	public homingEnemy(int x, int y) {
		super(x, y);
		c = new Color(156, 219, 67);
	}
	
	public void move() {
		customMove("stop");
		super.move();
	}

	public void shoot() {
		if (shotCount == 0) {
			customShot("homing");
			shotCount = 100;
		}
		shotCount--;
	}

	public void poop() {
		return;
	}

}