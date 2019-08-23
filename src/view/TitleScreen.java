package view;

import controller.screenSwitchController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreen extends Screen {

    @Override
    public void init() {
        mainFrame.setTitle( "Checkers" );

        //create elements
        JLabel title = new JLabel( "Checkers" );
        title.setFont( new Font( title.getFont().getFontName(), Font.PLAIN, 42 ));
        title.setForeground( Color.BLACK );
        title.setAlignmentX( Component.CENTER_ALIGNMENT );

        //buttons creation
        JButton createSessionButton = makeButton( "Create Session" );

        JButton joinSessionButton = makeButton( "Join Session" );

        JButton howToButton = makeButton( "How To Play" );
        howToButton.addActionListener( new screenSwitchController( mainFrame, new HowToPlayScreen()));

        JButton quitButton = makeButton( "Quit" );
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent actionEvent ) {
                System.exit(0 );
            }
        });


        //make layout
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout( new BoxLayout( titlePanel, BoxLayout.Y_AXIS ));
//        title.setAlignmentX( Component.CENTER_ALIGNMENT );
        titlePanel.add( title );
        titlePanel.add( Box.createRigidArea( new Dimension( 0, 50 )));
        titlePanel.add( createSessionButton );
        titlePanel.add( Box.createRigidArea( new Dimension( 0, 10 )));
        titlePanel.add( joinSessionButton );
        titlePanel.add( Box.createRigidArea( new Dimension( 0, 10 )));
        titlePanel.add( howToButton );
        titlePanel.add( Box.createRigidArea( new Dimension( 0, 10 )));
        titlePanel.add( quitButton );
        titlePanel.setMinimumSize( new Dimension( 200, 200 ));
//        titlePanel.setBorder( BorderFactory.createLineBorder( Color.YELLOW ));

        // setup layout
        JPanel contentPane = new JPanel();
        contentPane.setPreferredSize( new Dimension( 1000, 800 ));
        contentPane.setLayout( new BoxLayout( contentPane, BoxLayout.X_AXIS ));
        contentPane.add( Box.createHorizontalGlue());
        contentPane.add( titlePanel );
        contentPane.add( Box.createHorizontalGlue());
//        contentPane.setBorder( BorderFactory.createLineBorder( Color.CYAN ));

        mainFrame.setContentPane( contentPane );
        mainFrame.pack();
        mainFrame.setVisible( true );
    }

    private JButton makeButton( String text ) {
        JButton button = new JButton( text );
        button.setAlignmentX( Component.CENTER_ALIGNMENT );

        return button;
    }
}
