package brickBracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Gameplay extends JPanel implements KeyListener, ActionListener {
	//staring play
	private boolean play = false;
	private int score = 0;
	
	private Timer timer;
	
	private int delay = 2;
	//setting up the position of the scrolling bar and the ball
	
	private int playerX= 310;
	private int playerX1=210;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	
	public Gameplay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		//drawing map
		
		
		
		
		//borders
		g.setColor(Color.green);
		g.fillRect(0, 0, 3, 592);
//		g.fillRect(0, 0, 692, 3);
		g.fillRect(683, 0, 3, 592);
		
		//scores
//		
		g.setColor(Color.black);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString(""+ score, 590,30);
		
		
		
		//the paddle
		g.setColor(Color.yellow);
		g.fillRect(playerX, 545, 100, 8);
		
		//the paddle2
		g.setColor(Color.yellow);
		g.fillRect(playerX1, 5, 100, 8);
		
		//the ball
		g.setColor(Color.green);
		g.fillOval(ballposX, ballposY, 20, 20);
		
		
		
		if(ballposY>570) {
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game over Scores: "+ score, 190,300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230,350);
		}
		
		if(ballposY<-20) {
			play=false;
			ballXdir=0;
			ballYdir=0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game over Scores: "+ score, 190,300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart ", 230,350);
		}
		
		g.dispose();
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		//to move the ball
		if(play) {  //if we we press right or left the play will be true , to detect the ball is touching top left or right 
			
			//intersection with the paddle
			
			if(new Rectangle(ballposX,ballposY, 20,20).intersects(new Rectangle(playerX, 550, 100, 8)))
			{
				ballYdir = - ballYdir;	
			}
			
			if(new Rectangle(ballposX,ballposY, 20,20).intersects(new Rectangle(playerX1, 5, 100, 8)))
			{
				ballYdir = - ballYdir;	
			}
			
			
			
			ballposX+=ballXdir;
			ballposY+=ballYdir;
			if(ballposX<0) {//left
				ballXdir = -ballXdir;
				
			}
//			if(ballposY<0) {//top
//				ballYdir = -ballYdir;
//				
//			}
			if(ballposX>670) {//right
				
				ballXdir = -ballXdir;
			}
			repaint();
			
			
		}
		repaint();  //call paint function again and draw everything again
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getKeyCode()== KeyEvent.VK_LEFT);
		if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(playerX >=600) {
				playerX = 600;
			}
			else{
				moveRight();
			}
			
		}
		
		if(e.getKeyCode()== KeyEvent.VK_D) {
			if(playerX1 >=600) {
				playerX1 = 600;
			}
			else{
				moveRightx1();
			}
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <10) {
				playerX = 10;
			}
			else{
				moveLeft();
			}
				
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			if(playerX1 <10) {
				playerX1 = 10;
			}
			else{
				moveLeftx1();
			}
				
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!play) {
				play=true;
				ballposX=120;
				ballposY=350;
				ballXdir=-1;
				ballYdir=-2;
				playerX=310;
				score=0;
			
				
				repaint();
			}
		}
		
	}
	
	public void moveRight() {
		this.play=true;
		playerX+=20;
		
		
	}
	public void moveLeft() {
		this.play=true;
		playerX-=20;
		
		
	}
	
	public void moveRightx1() {
		this.play=true;
		playerX1+=20;
		
		
	}
	public void moveLeftx1() {
		this.play=true;
		playerX1-=20;
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
