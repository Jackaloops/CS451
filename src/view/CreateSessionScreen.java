package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import backend.src2.*;

public class CreateSessionScreen extends Screen {
	private final int portNum = 5000;
	@Override
	public void init() {
		// initiate game
		Checkers game = new Checkers( mainFrame );
		game.start();


		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout( 10, 10 ));
//		contentPane.setPreferredSize( new Dimension( 1000, 800 ));

		// build main component
		JLabel codeLabel = new JLabel( "Your Session Code:" );
		codeLabel.setFont( new Font( codeLabel.getFont().getFontName(), Font.PLAIN, 32 ));
		codeLabel.setAlignmentX( Component.CENTER_ALIGNMENT );

		InetAddress IP = null;
		// get local IP
		try {
			IP= InetAddress.getLocalHost();
		} catch( UnknownHostException e ) {
			e.printStackTrace();
			JOptionPane.showMessageDialog( contentPane, "ERROR: No Network Found");
		}

		JLabel codeDisplay = new JLabel( "IP: " + IP.getHostAddress().toString() + "Port #: " + portNum );
		codeDisplay.setFont( new Font( codeDisplay.getFont().getFontName(), Font.PLAIN, 30 ));
		codeDisplay.setAlignmentX( Component.CENTER_ALIGNMENT );

		JPanel codePane = new JPanel();
		codePane.setLayout( new BoxLayout( codePane, BoxLayout.Y_AXIS ));
		codePane.add( Box.createVerticalGlue());
		codePane.add( codeLabel );
		codePane.add( codeDisplay );
		codePane.add( Box.createVerticalGlue());

		contentPane.add( codePane, BorderLayout.CENTER );

		//build bottom bar
		JLabel waitingLabel = new JLabel( "Waiting for player..." );
		waitingLabel.setAlignmentX( Component.LEFT_ALIGNMENT );

		JButton abandonButton = new JButton( "Abandon" );
		abandonButton.setAlignmentX( Component.RIGHT_ALIGNMENT );
		abandonButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				try {
					game.end();
				} catch( IOException e ) {
					e.printStackTrace();
				}
				game.interrupt();
				Screen temp = new TitleScreen();
				temp.setMainFrame( mainFrame );
				temp.init();
			}
		});

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
