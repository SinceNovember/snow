package com.liu1;

import java.awt.Dimension;
import java.awt.Toolkit;

public class snowmain {
	public static void main(String[] args) {
		snow s=new snow();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		s.setSize(dim);
		s.setVisible(true);
	}

}
