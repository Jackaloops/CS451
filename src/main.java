import view.TitleScreen;

import java.io.*;

public class main {
    public static void main( String[] args ) {
        //OutputStream
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        String s = "Testing";
        try {
            outStream.write( s.getBytes());
        } catch( IOException e ) {
            e.printStackTrace();
        }

        ByteArrayInputStream inStream = new ByteArrayInputStream( outStream.toByteArray());
//byte[] -> InputStream
        try {
            System.out.println( new String( inStream.readAllBytes(), "UTF-8"));
        } catch( UnsupportedEncodingException e ) {
            e.printStackTrace();
        }

        System.out.println("Hello World!");

        TitleScreen app = new TitleScreen();
        app.init();
    }
}
