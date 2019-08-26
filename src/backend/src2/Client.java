package backend.src2;

import java.net.*;
import java.io.*;

public class Client{
  private Socket socket = null;
  public DataInputStream input = null;
  public DataOutputStream output = null;

  public Client(String address, int port){

    try {
      socket = new Socket(address, port);
      System.out.println("Connected");
      input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
      output = new DataOutputStream(socket.getOutputStream());
    } catch(UnknownHostException e){
      System.out.println(e);
    } catch(IOException e){
      System.out.println(e);
    }
  }

  public boolean send(String str){
    try {
      output.writeUTF(str);
      return true;
    } catch(IOException e){
      System.out.println(e);
      return false;
    }
  }

  public String receive(){
    try {
      String str = input.readUTF();
      return str;
    } catch(IOException e){
      System.out.println(e);
      return "Error";
    }
  }
}
