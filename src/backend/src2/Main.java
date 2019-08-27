//package backend.src2;
//import java.net.*;
//import java.io.*;
//
//public class Main {
//
//  private static Checkers game;
//
//  public static void main(String args[]){
//
//    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//    game = new Checkers();
//    try {
//      String str = in.readLine();
//      if(str.equals("1")){
//        System.out.println("start");
//        game.startGame(5000);
//      } else {
//        System.out.println("join");
//        game.joinGame("73.42.174.147", 5000);
//    //    game.joinGame("192.168.1.152", 5000);
//      }
//    } catch(IOException e){
//      System.out.println(e);
//    }
//  }
//}
