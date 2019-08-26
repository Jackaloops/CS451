package view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.Flow;

public class GameScreen extends Screen {
	private final int BOARD_WIDTH = 640;

	@Override
	public void init() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout());

		JLabel turnIndicator = new JLabel( "Red Player's Turn" );
		turnIndicator.setBorder( new EmptyBorder( 5, 5, 5, 5 ));
		turnIndicator.setHorizontalAlignment( SwingConstants.CENTER );

		contentPane.add( turnIndicator, BorderLayout.NORTH );

		// make board
		JPanel boardPane = new JPanel();
		boardPane.setLayout( new BoxLayout( boardPane, BoxLayout.Y_AXIS));
		boardPane.setPreferredSize( new Dimension( BOARD_WIDTH, BOARD_WIDTH ));
		boardPane.setMaximumSize( new Dimension( BOARD_WIDTH, BOARD_WIDTH ));
		boardPane.setBorder( BorderFactory.createLineBorder( Color.red ));

		// populate baord with squares
		for( int i = 0; i < 8; i++ ) {
			JPanel rowPane = new JPanel();
			rowPane.setLayout( new BoxLayout( rowPane, BoxLayout.X_AXIS ));
			for( int j = 0; j < 8; j++ ) {
				JPanel sq = new JPanel();
				sq.setPreferredSize( new Dimension( BOARD_WIDTH/8, BOARD_WIDTH/8 ));

				//calculates what color this square should be
				Color c = (( i % 2 + j ) % 2 == 0 ) ?  Color.BLACK :  Color.WHITE;
				sq.setBackground( c );
				rowPane.add( sq );
			}
			boardPane.add( rowPane );
		}
		JPanel boardWrapper = new JPanel();
		boardWrapper.setLayout( new BoxLayout( boardWrapper, BoxLayout.Y_AXIS));
		boardWrapper.add( boardPane );
//		boardWrapper.setMaximumSize( new Dimension( BOARD_WIDTH, BOARD_WIDTH ));
		boardWrapper.setBorder( BorderFactory.createLineBorder( Color.red ));
		contentPane.add( boardWrapper, BorderLayout.CENTER );

		// make sidebar
		JPanel sidePane = new JPanel();
		sidePane.setLayout( new BoxLayout( sidePane, BoxLayout.Y_AXIS ));

		JButton drawButton = new JButton( "Draw" );
		drawButton.setAlignmentX( Component.CENTER_ALIGNMENT );
		JButton forfeitButton = new JButton( "Forfeit" );
		forfeitButton.setAlignmentX( Component.CENTER_ALIGNMENT );

		JLabel redCapture = new JLabel( "Captured Red Pieces: 0");
		redCapture.setHorizontalAlignment( SwingConstants.CENTER );
		redCapture.setAlignmentX( Component.CENTER_ALIGNMENT );
		JLabel blackCapture = new JLabel( "Captured Black Pieces: 0");
		blackCapture.setHorizontalAlignment( SwingConstants.CENTER );
		blackCapture.setAlignmentX( Component.CENTER_ALIGNMENT );

		sidePane.add( drawButton );
		sidePane.add( forfeitButton );
		sidePane.add( redCapture );
		sidePane.add( blackCapture );

		sidePane.setPreferredSize( new Dimension( 360, 360 ));
		sidePane.setBorder( BorderFactory.createLineBorder( Color.YELLOW ));

		contentPane.add( sidePane, BorderLayout.EAST );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}
}
