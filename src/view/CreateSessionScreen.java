package view;

import javax.swing.*;
import java.awt.*;

public class CreateSessionScreen extends Screen {

	@Override
	public void init() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout( 10, 10 ));
//		contentPane.setPreferredSize( new Dimension( 1000, 800 ));

		// build main component
		JLabel codeLabel = new JLabel( "Your Session Code:" );
		codeLabel.setFont( new Font( codeLabel.getFont().getFontName(), Font.PLAIN, 32 ));
		codeLabel.setAlignmentX( Component.CENTER_ALIGNMENT );

		JLabel codeDisplay = new JLabel("****");
		codeDisplay.setFont( new Font( codeDisplay.getFont().getFontName(), Font.PLAIN, 30 ));
		codeDisplay.setAlignmentX( Component.CENTER_ALIGNMENT );

		JPanel codePane = new JPanel();
		codePane.setLayout( new BoxLayout( codePane, BoxLayout.Y_AXIS ));

		codePane.add( codeLabel );
		codePane.add( codeDisplay );

		contentPane.add( codePane, BorderLayout.CENTER );

		//build bottom bar
		JLabel waitingLabel = new JLabel( "Waiting for player..." );
		waitingLabel.setAlignmentX( Component.LEFT_ALIGNMENT );

		JButton abandonButton = new JButton( "Abandon" );
		abandonButton.setAlignmentX( Component.RIGHT_ALIGNMENT );

		JPanel bottomPane = new JPanel();
		bottomPane.setLayout( new BorderLayout());
		bottomPane.add( waitingLabel, BorderLayout.WEST );
		bottomPane.add( abandonButton, BorderLayout.EAST );

		contentPane.add( bottomPane, BorderLayout.SOUTH );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}
