package view.board;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class squarePane extends JPanel {
	private ImageIcon piece = null;
	private int pieceState = 0;
	public int row, col;

	public squarePane( int r, int c ) {
		row = r;
		col = c;
	}

	public void setState( int s ) {
		pieceState = s;

		super.removeAll();
		Image temp = null;
		switch( s ) {
			case 0:
				piece = null;
				break;
			case 1:
				try {
					temp = ImageIO.read( ClassLoader.getSystemResourceAsStream( "images/white.png" ) );
				} catch( IOException e ) {
					e.printStackTrace();
				}
				break;
			case 2:
//				System.out.println("asdfasdfasfd");
				try {
					temp = ImageIO.read( ClassLoader.getSystemResourceAsStream( "images/black.png" ) );
				} catch( IOException e ) {
					e.printStackTrace();
					System.out.println("sdjklll");
				}
				break;
			case 3:
				try {
					temp = ImageIO.read( ClassLoader.getSystemResourceAsStream( "images/whiteKing.png" ) );
				} catch( IOException e ) {
					e.printStackTrace();
					System.out.println("sdjklll");
				}
				break;
			case 4:
				try {
					temp = ImageIO.read( ClassLoader.getSystemResourceAsStream( "images/blackKing.png" ) );
				} catch( IOException e ) {
					e.printStackTrace();
					System.out.println("sdjklll");
				}
				break;
		}
		if( temp != null ) {
//			System.out.println("asdf");
			ImageIcon imgIcon = new ImageIcon( temp );
			Image pieceImg = imgIcon.getImage();
			JLabel  pieceIcon = new JLabel( new ImageIcon(pieceImg.getScaledInstance( 80, 80,  java.awt.Image.SCALE_SMOOTH)));
			pieceIcon.setBounds( 0, 0, 80, 80);
			super.add( pieceIcon );
		}

	}

	public int getState() {
		return pieceState;
	}
}
