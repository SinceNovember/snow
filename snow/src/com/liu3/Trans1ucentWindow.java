package com.liu3;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
import java.awt.*;
 
public class Trans1ucentWindow extends JFrame {
    public Trans1ucentWindow() {
        super("Simple Translucency Demo");
 
        setSize(300, 200);
 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
 
        getRootPane().setDoubleBuffered(false);
        setOpacity(0.5f);
 
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 
                if (ge.getDefaultScreenDevice().isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
                    new Trans1ucentWindow();
                }
            }
        });
    }
}