package view;

import javax.swing.*;
import java.awt.*;

public abstract class Screen {
	JFrame mainFrame = new JFrame();

	public abstract void init();

	public void setMainFrame( JFrame f ) {
		mainFrame = f;
		f.setPreferredSize( new Dimension( 1000, 800 ));
	}
}
