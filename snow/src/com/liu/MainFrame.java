package com.liu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int SNOW_NUM = 100;
	public static final int SPEED = 20;

	private int[] xs = new int[scrSize.width];
	private int[] ys = new int[scrSize.height];
	private Font[] snows = new Font[10];

	public MainFrame() {
		initSnow();
		fallSnow();

		setUndecorated(true);
		setBackground(new Color(0, 0, 0,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initSnow() {
		Random rd = new Random();
		for (int i = 0; i < SNOW_NUM; i++) {
			xs[i] = rd.nextInt(scrSize.width);
			ys[i] = rd.nextInt(scrSize.height);
		}
		for (int i = 0; i < snows.length; i++) {
			snows[i] = new Font("ËÎÌו", Font.PLAIN, 15 + i);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		Color c = g.getColor();
		g.setColor(Color.WHITE);
		for (int i = 0; i < SNOW_NUM; i++) {
			g.setFont(snows[i % snows.length]);
			g.drawString("*", xs[i], ys[i]);
		}
		g.setColor(c);
	}

	public void fallSnow() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					for (int i = 0; i < SNOW_NUM; i++) {
						ys[i]++;
						if (ys[i] > scrSize.height) {
							ys[i] = 0;
						}
					}
					try {
						Thread.sleep(SPEED);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					repaint();
				}
			}
		}.start();
	}
}