package com.liu;
import java.awt.*;
	public class Main
	{
	public static void main(String[] args)
	{
	MainFrame mf = new MainFrame();

	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

	mf.setSize(dim.width, dim.height);
	mf.setVisible(true);
	}
	}
