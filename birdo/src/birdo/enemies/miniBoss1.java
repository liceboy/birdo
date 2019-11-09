package birdo.enemies;

import java.awt.Color;

import birdo.utilities.enemy;
import birdo.utilities.feather;



public class miniBoss1 extends enemy {

	public miniBoss1(int x, int y) {
		super(x, y);
		health = 30;
		score = 1500;
		w = 20;
		h = 20;
	}

	public void shootFeather() {
		if (shootcount <= 0) {
			if (health > 15) {
				customShot("buckShot");
				shootcount = 30;
			}
			if (health <= 15) {
				customShot("tripleShot");
				shootcount = 30;
			}
		}
		shootcount--;
	}

	public void poop() {
		return;
	}

	public void move() {
		if (x < 700)
			customMove("upDown");
		super.move();
	}

}
