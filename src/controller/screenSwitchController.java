package controller;

import view.Screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class screenSwitchController implements ActionListener {
	JFrame frame;
	Screen screen;
	public screenSwitchController( JFrame f, Screen s ) {
		frame = f;
		screen = s;
	}

	@Override
	public void actionPerformed( ActionEvent actionEvent ) {
		screen.setMainFrame( frame );
		screen.init();
	}
}
