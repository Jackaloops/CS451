package backend.src2;

import java.net.*;
import java.io.*;

public class Server
{
    private Socket socket = null;
    private ServerSocket server = null;
    public DataInputStream input = null;
    public DataOutputStream output  = null;

    public Server(int port){

      try {
        server = new ServerSocket(port);
        System.out.println("Server Started and waiting for a Client");
        socket = server.accept();
        System.out.println("Client accepted");
        input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        output = new DataOutputStream(socket.getOutputStream());

      } catch (IOException e){
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
