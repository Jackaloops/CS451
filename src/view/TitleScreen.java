package view;

import javax.swing.*;
import java.awt.*;

public class TitleScreen {
    JFrame mainFrame = new JFrame();

    public TitleScreen () {

    }

    public void init() {
        mainFrame.setTitle( "Checkers" );

        //create elements
        JLabel title = new JLabel( "Checkers" );
        title.setFont( new Font( title.getFont().getFontName(), Font.PLAIN, 42 ));
        title.setForeground( Color.BLACK );
        title.setBorder( BorderFactory.createLineBorder( Color.RED ));
        title.setPreferredSize( new Dimension( 300, 100 ) );

        JButton createSessionButton = new JButton( "Create Session" );
        JButton joinSessionButton = new JButton( "Join Session " );
        JButton howToButton = new JButton( "How To Play" );
        JButton quitButton = new JButton( "Quit" );

        //make layout
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout( new BoxLayout( titlePanel, BoxLayout.Y_AXIS ));
//        title.setAlignmentX( Component.CENTER_ALIGNMENT );
        titlePanel.add( title );
        titlePanel.add( createSessionButton );
        titlePanel.add( joinSessionButton );
        titlePanel.add( howToButton );
        titlePanel.add( quitButton );
        titlePanel.setMinimumSize( new Dimension( 200, 200 ) );
        titlePanel.setBorder( BorderFactory.createLineBorder( Color.YELLOW ));

        // setup layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout( new BoxLayout( contentPane, BoxLayout.X_AXIS ));
        contentPane.add( Box.createHorizontalGlue());
        contentPane.add( titlePanel );
        contentPane.add( Box.createHorizontalGlue());
        contentPane.setBorder( BorderFactory.createLineBorder( Color.CYAN ));

        mainFrame.setContentPane( contentPane );
        mainFrame.pack();
        mainFrame.setVisible( true );
    }
}
