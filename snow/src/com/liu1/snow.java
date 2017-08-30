package com.liu1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;
import java.util.function.IntPredicate;

import javax.swing.JFrame;
import javax.swing.RepaintManager;

public class snow extends JFrame{
	private static final long serialVersionUID = 1L;
	private Dimension screem=Toolkit.getDefaultToolkit().getScreenSize();
	private int[] snowx=new int[screem.height];
	private int[] snowy=new int[screem.width];
	private static final int snow_num=100;
	private static final int snow_speend=40;
	private Font[] snows=new Font[10];
	public snow(){
		initsnow();
		fallsnow();
		setUndecorated(true);
	setBackground(new Color(123, 123, 123,0));
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initsnow(){
		Random rand=new Random();
		for(int i=0;i<snow_num;i++){
			snowx[i]=rand.nextInt(screem.width);
			snowy[i]=rand.nextInt(screem.height);
		}
		for (int i = 0; i < snows.length; i++) {
			snows[i] = new Font("ËÎÌו", Font.PLAIN, 15 + i);
		}
			
	}
	

	public void paint(Graphics g) {
		super.paint(g);

		Color c = g.getColor();
		g.setColor(Color.BLACK);
		for (int i = 0; i < snow_num; i++) {
			g.setFont(snows[i % snows.length]);
			g.drawString("*", snowx[i], snowy[i]);
		}
		g.setColor(c);
	}
	public void fallsnow(){
		new Thread(){
			public void run(){
		while(true)
		{
			repaint();
			for(int i=0;i<snow_num;i++)
			{
				snowy[i]++;
				if(snowy[i]>screem.getHeight())
				{
					snowy[i]=0;
				}
			}
			try{
				Thread.sleep(snow_speend);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
			}
	}.start();
}
}
