package view;

import javax.swing.*;

public class JoinSessionScreen extends Screen {
	@Override
	public void init() {
		JPanel contentPane = new JPanel();


		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}
