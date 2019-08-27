package view;

import backend.src2.Checkers;
import controller.screenSwitchController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinSessionScreen extends Screen {
	@Override
	public void init() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout( 10, 10 ));
//		contentPane.setPreferredSize( new Dimension( 1000, 800 ));

		// build main component
		JLabel codeLabel = new JLabel( "Enter Session Code:" );
		codeLabel.setFont( new Font( codeLabel.getFont().getFontName(), Font.PLAIN, 32 ));
		codeLabel.setAlignmentX( Component.CENTER_ALIGNMENT );

		JTextField IPInput = new JTextField(20);
		IPInput.setFont( new Font( IPInput.getFont().getFontName(), Font.PLAIN, 30 ));
		IPInput.setMaximumSize( new Dimension( 500, IPInput.getPreferredSize().height));
		IPInput.setHorizontalAlignment( SwingConstants.CENTER );
		IPInput.setAlignmentX( Component.CENTER_ALIGNMENT );

		JTextField portInput = new JTextField(20);
		portInput.setFont( new Font( portInput.getFont().getFontName(), Font.PLAIN, 30 ));
		portInput.setMaximumSize( new Dimension( 500, portInput.getPreferredSize().height));
		portInput.setHorizontalAlignment( SwingConstants.CENTER );
		portInput.setAlignmentX( Component.CENTER_ALIGNMENT );

		JButton joinButton = new JButton( "Join" );
		joinButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		joinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				Checkers game = new Checkers( mainFrame, IPInput.getText(), Integer.parseInt( portInput.getText()));
				game.start();

//				Screen gameScreen = new GameScreen();
//				gameScreen.setMainFrame( mainFrame );
//				gameScreen.init();
			}
		});

		JPanel codePane = new JPanel();
		codePane.setLayout( new BoxLayout( codePane, BoxLayout.Y_AXIS ));

		codePane.add( Box.createVerticalGlue());
		codePane.add( codeLabel );
		codePane.add( Box.createRigidArea( new Dimension( 0, 20 )));
		codePane.add( IPInput );
		codePane.add( Box.createRigidArea( new Dimension( 0, 20 )));
		codePane.add( portInput );
		codePane.add( Box.createRigidArea( new Dimension( 0, 20 )));
		codePane.add( joinButton );
		codePane.add( Box.createVerticalGlue());

		contentPane.add( codePane, BorderLayout.CENTER );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}
