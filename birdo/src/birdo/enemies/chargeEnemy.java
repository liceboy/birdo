package birdo.enemies;

import java.awt.Color;
import java.util.ArrayList;

import birdo.utilities.enemy;

public class chargeEnemy extends enemy {

	public chargeEnemy(int x, int y) {
		super(x, y);
		c = Color.GRAY;
		health = 1;
	}

	public void move() {
		if (!isDead) {

			if (x > 800) {
				dx = -3;
				super.move();
				return;
			}

			int deltaX = p.x - x;
			int deltaY = p.y - y;

			double theta = Math.atan((double) deltaY / (double) deltaX);

			this.dx = -1 * (int) (6 * Math.cos(theta));
			this.dy = -1 * (int) (6 * Math.sin(theta));

			super.move();

		}

		if (isDead)
			super.move();
	}

	public void shootFeather() {
		return;
	}

	public void poop() {
		return;
	}

}
