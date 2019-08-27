package view;

import backend.src2.Checkers;
import view.board.squarePane;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Flow;

public class GameScreen extends Screen {
	private final int BOARD_WIDTH = 640;
	private ByteArrayInputStream streamFromChecker;
	private ByteArrayOutputStream streamToChecker;
	Checkers checkers;
	private int user;
	private JPanel boardPane;
	private JLabel turnIndicator;
	private squarePane selectedSq = null;

	public GameScreen( Checkers check, int u ) {
		super();
		checkers = check;
		user = u;
	}

	@Override
	public void init() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout());

		turnIndicator = new JLabel( "White Player's Turn" );
		turnIndicator.setBorder( new EmptyBorder( 5, 5, 5, 5 ));
		turnIndicator.setHorizontalAlignment( SwingConstants.CENTER );
		checkers.setIndicator( turnIndicator );

		contentPane.add( turnIndicator, BorderLayout.NORTH );

		// make board
		boardPane = new JPanel();
		boardPane.setLayout( new BoxLayout( boardPane, BoxLayout.Y_AXIS));
		boardPane.setPreferredSize( new Dimension( BOARD_WIDTH, BOARD_WIDTH ));
		boardPane.setMaximumSize( new Dimension( BOARD_WIDTH, BOARD_WIDTH ));
		boardPane.setBorder( BorderFactory.createLineBorder( Color.red ));

		checkers.setBoardPane( boardPane );

		// populate baord with squares
		for( int i = 0; i < 8; i++ ) {
			JPanel rowPane = new JPanel();
			rowPane.setLayout( new BoxLayout( rowPane, BoxLayout.X_AXIS ));
			for( int j = 0; j < 8; j++ ) {
				squarePane sq = new squarePane( i, j );
				sq.setPreferredSize( new Dimension( BOARD_WIDTH/8, BOARD_WIDTH/8 ));
				sq.setMinimumSize( new Dimension( BOARD_WIDTH/8, BOARD_WIDTH/8 ));
				sq.setSize( new Dimension( BOARD_WIDTH/8, BOARD_WIDTH/8 ));

				Color c;
				//calculates what color this square should be
				if(( i % 2 + j ) % 2 == 0 ) {
					c = Color.WHITE;
				}
				else {
					c = Color.BLACK;
					if( i < 3 ) {
						sq.setState( 2 );
					}
					else if( i > 4 ) {
						sq.setState( 1 );
					}
					sq.addMouseListener(new MouseListener() {
						@Override
						public void mouseClicked( MouseEvent mouseEvent ) {
							squarePane s = ((squarePane)mouseEvent.getSource());
							if( selectedSq == null && (s.getState() == user || s.getState() == user + 2)) {
								s.setBackground( Color.RED );
								selectedSq = s;
							}
							else if( selectedSq != null && s.getState() == 0 ){
								int m = checkers.makeMove( user, selectedSq.row, selectedSq.col, s.row, s.col);
								selectedSq.setBackground( Color.black );
								selectedSq = null;
							}
						}

						@Override
						public void mousePressed( MouseEvent mouseEvent ) {

						}

						@Override
						public void mouseReleased( MouseEvent mouseEvent ) {

						}

						@Override
						public void mouseEntered( MouseEvent mouseEvent ) {

						}

						@Override
						public void mouseExited( MouseEvent mouseEvent ) {

						}
					});
				}
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
//		JPanel sidePane = new JPanel();
//		sidePane.setLayout( new BoxLayout( sidePane, BoxLayout.Y_AXIS ));

//		JButton drawButton = new JButton( "Draw" );
//		drawButton.setAlignmentX( Component.CENTER_ALIGNMENT );
////		drawButton.addActionListener(new ActionListener() {
////			@Override
////			public void actionPerformed( ActionEvent actionEvent ) {
////				System.out.println( "send: 2 1 3 2" );
////				String s = "2 1 3 2\n";
////				checkers.makeMove( user, 5, 0, 4, 1);
////
////			}
////		});
//		JButton forfeitButton = new JButton( "Forfeit" );
//
//		forfeitButton.setAlignmentX( Component.CENTER_ALIGNMENT );
//
//		JLabel redCapture = new JLabel( "Captured Red Pieces: 0");
//		redCapture.setHorizontalAlignment( SwingConstants.CENTER );
//		redCapture.setAlignmentX( Component.CENTER_ALIGNMENT );
//		JLabel blackCapture = new JLabel( "Captured Black Pieces: 0");
//		blackCapture.setHorizontalAlignment( SwingConstants.CENTER );
//		blackCapture.setAlignmentX( Component.CENTER_ALIGNMENT );

//		sidePane.add( drawButton );
//		sidePane.add( forfeitButton );
//		sidePane.add( redCapture );
//		sidePane.add( blackCapture );
//
//		sidePane.setPreferredSize( new Dimension( 360, 360 ));
//		sidePane.setBorder( BorderFactory.createLineBorder( Color.YELLOW ));

//		contentPane.add( sidePane, BorderLayout.EAST );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );

		String playerColor = ( user == 1 ) ? "white" : "black";
		JOptionPane.showMessageDialog( contentPane, "You are the " + playerColor + " player");
	}
}
