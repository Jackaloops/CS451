package view;

import controller.screenSwitchController;

import javax.swing.*;
import java.awt.*;

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

		JTextField codeInput = new JTextField(20);
		codeInput.setFont( new Font( codeInput.getFont().getFontName(), Font.PLAIN, 30 ));
		codeInput.setMaximumSize( new Dimension( 500, codeInput.getPreferredSize().height));
		codeInput.setHorizontalAlignment( SwingConstants.CENTER );
		codeInput.setAlignmentX( Component.CENTER_ALIGNMENT );

		JButton joinButton = new JButton( "Join" );
		joinButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		joinButton.addActionListener( new screenSwitchController( mainFrame, new GameScreen()));

		JPanel codePane = new JPanel();
		codePane.setLayout( new BoxLayout( codePane, BoxLayout.Y_AXIS ));

		codePane.add( Box.createVerticalGlue());
		codePane.add( codeLabel );
		codePane.add( Box.createRigidArea( new Dimension( 0, 20 )));
		codePane.add( codeInput );
		codePane.add( Box.createRigidArea( new Dimension( 0, 20 )));
		codePane.add( joinButton );
		codePane.add( Box.createVerticalGlue());

		contentPane.add( codePane, BorderLayout.CENTER );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}
