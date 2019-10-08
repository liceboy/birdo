package birdo.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import birdo.utilities.*;
import birdo.enemies.*;

public class main extends JPanel implements ActionListener {

	private static final long serialVersionUID = 7278894226467689035L;
	private Timer timer;
	private final int DELAY = 10;
	public String state;

	public title title;
	public levelSelect levelSelect;
	public woods woods;
	public city city;
	public beach beach;
	public sky sky;

	public main() {
		addKeyListener(new KAdapter());
		addMouseListener(new MAdapter());

		setFocusable(true);
		setBackground(Color.WHITE);

		setFont(new Font("Arial", 1, 16));

		timer = new Timer(DELAY, this);
		timer.start();

		state = "title";
		title = new title();
		levelSelect = new levelSelect();
		woods = new woods();
		beach = new beach();
		city = new city();
		sky = new sky();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);

		Toolkit.getDefaultToolkit().sync();
	}

	private void doDrawing(Graphics g) {

		if (state == "title")
			title.draw(g);

		if (state == "levelSelect")
			levelSelect.draw(g);

		if (state == "woods")
			woods.draw(g);

		if (state == "city")
			city.draw(g);

		if (state == "beach")
			beach.draw(g);

		if (state == "sky")
			sky.draw(g);
	}

	public void actionPerformed(ActionEvent e) {
		if (state == "woods")
			woods.move();
		if (state == "city")
			city.move();
		if (state == "beach")
			beach.move();
		if (state == "sky")
			sky.move();

		repaint();
	}

	private class KAdapter extends KeyAdapter {

		private KAdapter() {
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (state == "title") {
				if (key == KeyEvent.VK_SPACE)
					state = "levelSelect";
			}

			if (woods.state == "GameOver") { // if gameover, new hotkeys, resets game state
				if (key == KeyEvent.VK_F1) {
					state = "woods";
					woods = new woods();
				}
				if (key == KeyEvent.VK_F2) {
					woods = new woods();
					state = "title";
				}
				woods.state = " ";
			}

			if (city.state == "GameOver") {
				if (key == KeyEvent.VK_F1) {
					city = new city();
					state = "city";
				}
				if (key == KeyEvent.VK_F2) {
					city = new city();
					state = "title";
				}
				city.state = " ";
			}

			if (beach.state == "GameOver") {
				if (key == KeyEvent.VK_F1) {
					beach = new beach();
					state = "beach";
				}
				if (key == KeyEvent.VK_F2) {
					beach = new beach();
					state = "title";
				}
				beach.state = " ";
			}

			if (sky.state == "GameOver") {
				if (key == KeyEvent.VK_F1) {
					sky = new sky();
					state = "sky";
				}
				if (key == KeyEvent.VK_F2) {
					sky = new sky();
					state = "title";
				}
				sky.state = " ";
			}

			if (state == "levelSelect") {
				if (key == KeyEvent.VK_ESCAPE)
					state = "title";
				if (key == KeyEvent.VK_1)
					state = "woods";
				if (key == KeyEvent.VK_2)
					state = "city";
				if (key == KeyEvent.VK_3)
					state = "beach";
				if (key == KeyEvent.VK_4)
					state = "sky";
			}

			if (state == "woods") {
				if (key == KeyEvent.VK_UP)
					woods.player.dy = -4;
				if (key == KeyEvent.VK_LEFT)
					woods.player.dx = -4;
				if (key == KeyEvent.VK_DOWN)
					woods.player.dy = 4;
				if (key == KeyEvent.VK_RIGHT)
					woods.player.dx = 4;
				if (key == KeyEvent.VK_ESCAPE) {
					state = "levelSelect";
					woods = new woods();
				}
			}

			if (state == "city") {
				if (key == KeyEvent.VK_UP)
					city.player.dy = -4;
				if (key == KeyEvent.VK_LEFT)
					city.player.dx = -4;
				if (key == KeyEvent.VK_DOWN)
					city.player.dy = 4;
				if (key == KeyEvent.VK_RIGHT)
					city.player.dx = 4;
				if (key == KeyEvent.VK_ESCAPE) {
					state = "levelSelect";
					city = new city();
				}
			}

			if (state == "beach") {
				if (key == KeyEvent.VK_UP)
					beach.player.dy = -4;
				if (key == KeyEvent.VK_LEFT)
					beach.player.dx = -4;
				if (key == KeyEvent.VK_DOWN)
					beach.player.dy = 4;
				if (key == KeyEvent.VK_RIGHT)
					beach.player.dx = 4;
				if (key == KeyEvent.VK_ESCAPE) {
					state = "levelSelect";
					beach = new beach();
				}
			}

			if (state == "sky") {
				if (key == KeyEvent.VK_UP)
					sky.player.dy = -4;
				if (key == KeyEvent.VK_LEFT)
					sky.player.dx = -4;
				if (key == KeyEvent.VK_DOWN)
					sky.player.dy = 4;
				if (key == KeyEvent.VK_RIGHT)
					sky.player.dx = 4;
				if (key == KeyEvent.VK_ESCAPE) {
					state = "levelSelect";
					sky = new sky();
				}
			}

		}

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (state == "woods") {
				if (key == KeyEvent.VK_UP && woods.player.dy != 2)
					woods.player.dy = 0;
				if (key == KeyEvent.VK_LEFT && woods.player.dx != 2)
					woods.player.dx = 0;
				if (key == KeyEvent.VK_DOWN && woods.player.dy != -2)
					woods.player.dy = 0;
				if (key == KeyEvent.VK_RIGHT && woods.player.dx != -2)
					woods.player.dx = 0;
				if (key == KeyEvent.VK_SPACE) {
					woods.player.poop();
				}
			}

			if (state == "city") {
				if (key == KeyEvent.VK_UP && city.player.dy != 2)
					city.player.dy = 0;
				if (key == KeyEvent.VK_LEFT && city.player.dx != 2)
					city.player.dx = 0;
				if (key == KeyEvent.VK_DOWN && city.player.dy != -2)
					city.player.dy = 0;
				if (key == KeyEvent.VK_RIGHT && city.player.dx != -2)
					city.player.dx = 0;
				if (key == KeyEvent.VK_SPACE) {
					city.player.poop();
				}

			}

			if (state == "beach") {
				if (key == KeyEvent.VK_UP && beach.player.dy != 2)
					beach.player.dy = 0;
				if (key == KeyEvent.VK_LEFT && beach.player.dx != 2)
					beach.player.dx = 0;
				if (key == KeyEvent.VK_DOWN && beach.player.dy != -2)
					beach.player.dy = 0;
				if (key == KeyEvent.VK_RIGHT && beach.player.dx != -2)
					beach.player.dx = 0;
				if (key == KeyEvent.VK_SPACE) {
					beach.player.poop();
				}
			}

			if (state == "sky") {
				if (key == KeyEvent.VK_UP && sky.player.dy != 2)
					sky.player.dy = 0;
				if (key == KeyEvent.VK_LEFT && sky.player.dx != 2)
					sky.player.dx = 0;
				if (key == KeyEvent.VK_DOWN && sky.player.dy != -2)
					sky.player.dy = 0;
				if (key == KeyEvent.VK_RIGHT && sky.player.dx != -2)
					sky.player.dx = 0;
				if (key == KeyEvent.VK_SPACE) {
					sky.player.poop();
				}

			}
		}
	}

	private class MAdapter extends MouseAdapter {

		private MAdapter() {
		}

		public void mousePressed(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			Rectangle mr = new Rectangle(mx, my, 1, 1);
		}

		public void mouseReleased(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();

			Rectangle mr = new Rectangle(mx, my, 1, 1);
		}
	}
}