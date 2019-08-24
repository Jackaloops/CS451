package view;

import controller.screenSwitchController;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HowToPlayScreen extends Screen {

	@Override
	public void init() {
		JPanel contentPane = new JPanel();
		contentPane.setLayout( new BorderLayout( 10, 10 ));
		contentPane.setPreferredSize( new Dimension( 1000, 800 ));

		//Heading
		JLabel rulesLabel = new JLabel( "Rules" );
		rulesLabel.setFont( new Font( rulesLabel.getFont().getFontName(), Font.PLAIN, 32 ));
		rulesLabel.setHorizontalAlignment( SwingConstants.CENTER );

		contentPane.add( rulesLabel, BorderLayout.NORTH );

		// Main instruction panel
		JEditorPane instructionsPane = new JEditorPane();
		instructionsPane.setContentType( "text/html" );
		instructionsPane.setText( "<ol><li>Checkers is a two player game. Each player starts with 12 colored discs (of the same color). Typically Checker discs come in sets of black and red.</li><li>A Checker board has 64 squares of alternating colors, 32 light and 32 dark squares.</li><li>Players place their discs (pieces) on the dark squares on their side of the board.</li><li>Black has first play, after turns alternate.</li><li>Moves can only be made on black squares, so the pieces move diagonally. Pieces&nbsp;can only move in a forward direction, toward&nbsp;their opponent.</li><li>If you are moving your disc forward, and not capturing your opponent’s piece in the move, you may&nbsp;only move it forward one square.</li><li>In a capturing move, a piece leaps of the opponents piece in a diagonal line, landing on a dark square on the other side. While you can only capture one piece per jump you can make multiple jumps in a single turn, if the positioning of the pieces allows.</li><li>After a piece is captured, it is removed from the board, and collected by the opponent.</li><li>If you have the ability to jump your opponents pieces, you must. However, in the even there are more than one capture possible from a single square, you may jump whichever piece is preferable.</li><li>Once a piece reaches the first row of their opponents side of the board (conversely, the row farthest from the player who controls the piece), that piece is kinged, or becomes a king, and is crowned with a piece that had been captured by the opponent. King’s stand twice as tall as a single piece.</li><li>Kings can only move diagonally as well, however they can move forward or backward as opposed to single pieces.</li><li>Kings can also jump both forward and backward (diagonally) in the same turn, a multi-direction multi-jump.</li><li>The game is won when the opponent is unable to make a move. This&nbsp;can happen one of two ways: the entirety of a player’s pieces were captured by the opponent, or a player’s pieces are all blocked from moving.</li></ol><a href=\"https://gamerules.com/rules/checkers-board-game/\">Instructions provided by GameRules.com</a>" );
		instructionsPane.addHyperlinkListener( new BrowserOpener());
		instructionsPane.setEditable( false );
		instructionsPane.setPreferredSize( new Dimension( 1000, 800 ));

		JScrollPane scrollPane = new JScrollPane( instructionsPane );
		scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED );

		contentPane.add(scrollPane, BorderLayout.CENTER );

		//Return Button
		JButton backButton = new JButton( "Back" );
		backButton.addActionListener( new screenSwitchController( mainFrame, new TitleScreen()));

		contentPane.add( backButton, BorderLayout.SOUTH );

		mainFrame.setContentPane( contentPane );
		mainFrame.pack();
		mainFrame.setVisible( true );
	}

	class BrowserOpener implements HyperlinkListener {
		@Override
		public void hyperlinkUpdate( HyperlinkEvent event) {
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
				try {
					Desktop.getDesktop().browse(event.getURL().toURI());
				} catch ( IOException ex) {
					JOptionPane.showMessageDialog(null, "Error: Cannot Open Browser");
				} catch ( URISyntaxException e) {
					JOptionPane.showMessageDialog( null, "Error: Invalid URL");
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog( null, "Error: Definition not found");
				}
			}
		}
	}
}
