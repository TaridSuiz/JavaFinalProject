package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
	final int originalTitleSize = 16; // 16x16 title
	final int scale = 3;

	final int tileSize = originalTitleSize * scale; // 48 x 48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixel
	final int screenHeight = tileSize * maxScreenRow; // 576 pixel
	
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;

	// set Player default

	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;

	public GamePanel() {

		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);

	}

	public void startGameThread() {
		gameThread = new Thread(this);

		gameThread.start();
	}

	@Override
	public void run() {

		double drawInterval = 1000000000 / FPS;
		double delta = 0;
		//double nextDrawTime = System.nanoTime() + drawInterval;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer =0;
		int drawCount = 0;
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			
			
			if(delta >=1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if(timer >= 1000000000) {
				System.out.println("FPS : "+drawCount);
				drawCount = 0;
				timer = 0;
			}
			
			
			/*try {
			double remainingTime = nextDrawTime - System.nanoTime();
			remainingTime = remainingTime/1000000;
			
			if(remainingTime<0) {
				remainingTime = 0;
			}
			
			Thread.sleep((long) remainingTime);
			
			nextDrawTime += drawInterval;
			
			}
			catch(InterruptedException e) {
				e.printStackTrace();
				
			}*/
			
		}

	}

	public void update() {

		if (keyH.upP == true) {
			playerY -= playerSpeed;
		} 
		else if (keyH.downP == true) {
			playerY += playerSpeed;
		} 
		else if (keyH.lP == true) {
			playerX -= playerSpeed;
		} 
		else if (keyH.rP == true) {
			playerX += playerSpeed;
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.white);

		g2.fillRect(playerX, playerY, tileSize, tileSize);

		g2.dispose();

	}

}
