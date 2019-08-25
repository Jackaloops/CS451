import java.io.*;
public class Checkers {

  private int[][] board;
  private Server server = null;
  private Client client = null;
  private int[][] dir = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

  public void initBoard(){
    board = new int[8][8];
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++){
        if(i < 3)
          board[i][j] = 2 * ((i+j)%2);
        else if(i < 5)
          board[i][j] = 0;
        else
          board[i][j] = (i+j) % 2;
      }
  }
  public void printBoard(){
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        System.out.print(board[i][j] + ((j < 7) ? " " : "\n"));
  }

  public int toi(String str){
    return Integer.parseInt(str);
  }

  public int l1Dist(int x1, int y1, int x2, int y2){
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }

  public boolean checkCapture(int user){
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++){
        int p = board[i][j];
        if(p != 0 && (p % 2) == (user % 2)){
          for(int k = 0; k < 4; k++){
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            int xx = x + dir[k][0];
            int yy = y + dir[k][1];
            if(user == 1 && p == 1 && x > i) continue;
            if(user == 2 && p == 2 && x < i) continue;
            if(0 <= xx && xx < 8 && 0 <= yy && yy < 8){
              if(board[xx][yy] != 0 || board[x][y] == 0) continue;
              if((user == 1 && (board[x][y]%2) == 0) || (user == 2 && (board[x][y]%2) == 1))
                return true;
            }
          }
        }
      }
      return false;
  }

  public int makeMove(int user, int x1, int y1, int x2, int y2){
    System.out.println("Making move (" + x1 + "," + y1 + ") -> (" + x2 + "," + y2 + ")");

    if(!(0 <= x1 && x1 < 8 && 0 <= y1 && y1 < 8 && 0 <= x2 && x2 < 8 && 0 <= y2 && y2 < 8)){
      System.out.println("error - 1");
      return 0;
    }
    if(board[x1][y1] == 0 || (user % 2) != (board[x1][y1] % 2)){
      System.out.println("error - 2");
      return 0;
    }
    int d1 = Math.abs(x1 - x2);
    int d2 = Math.abs(y1 - y2);
    if(d1 != d2){
      System.out.println("error - 3");
      return 0;
    }
    int move;
    int p = board[x1][y1];
    if(d1 == 1){
      if((p == 1 && x2 >= x1) || (p == 2 && x2 <= x1) || board[x2][y2] != 0){
        System.out.println("error - 3");
        return 0;
      }
      else {
        if(checkCapture(user)){
          System.out.println("You gotta make a capture since you can.");
          return 0;
        }
        board[x1][y1] = 0;
        board[x2][y2] = p;
        move = 1;
      }
    } else if(d1 == 2){
      if((p == 1 && x2 >= x1) || (p == 2 && x2 <= x1) || board[x2][y2] != 0) {
        System.out.println("error - 5");
        return 0;
      } else {
        int m = board[(x1+x2)/2][(y1+y2)/2];
        if(p%2 == m%2){
          System.out.println("error - 6");
          return 0;
        }
        else {
          board[x1][y1] = 0;
          board[(x1+x2)/2][(y1+y2)/2] = 0;
          board[x2][y2] = p;
          move = 2;
        }
      }
    } else {
      System.out.println("error - 7");
      return 0;
    }
    if(user == 1 && x2 == 0)
      board[x2][y2] = 3;
    if(user == 2 && x2 == 7)
      board[x2][y2] = 4;
    return move;
  }

  public String boardToStr(int[][] board){
    String res = "";
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        res += board[i][j];
    return res;
  }
  public int[][] strToBoard(String str){
    int[][] board = new int[8][8];
    for(int i = 0; i < str.length(); i++)
      board[i/8][i%8] = toi(str.charAt(i) + "");
    return board;
  }

  public int checkWin(int[][] b){
    int s1 = 0, s2 = 0;
    for(int i = 0; i < 8; i++)
      for(int j = 0; j < 8; j++)
        if(b[i][j] % 2 == 1)
          s1++;
        else if(b[i][j] == 2 || b[i][j] == 4)
          s2++;
    if(s1 == 0)
      return 2;
    if(s2 == 0)
      return 1;
    return 0;
  }

  public void startGame(int port){
    initBoard();
    server = new Server(port);
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while(true){
      printBoard();
      int move = 0;
      while(move == 0){
        try {
          String line = in.readLine();
          String[] a = line.split(" ");
          move = makeMove(1, toi(a[0]), toi(a[1]), toi(a[2]), toi(a[3]));
        } catch(IOException e){
          System.out.println(e);
        }
      }
      if(checkWin(board) == 1){
        System.out.println("You won!!!");
        server.send("I won");
        break;
      }
      if(move == 2 && checkCapture(1)) // If a piece is captured and more can be captured, continue playing
        continue;
      server.send(boardToStr(board));
      String str = server.receive();
      if(str.equals("forfeit")){
        System.out.println("You won!!!");
        break;
      } else if(str.equals("I won")){
        System.out.println("You lost!!!");
        break;
      } else {
        board = strToBoard(str);
      }
    }
  }

  public void joinGame(String address, int port){
    client = new Client(address, port);
    initBoard();
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    while(true){

      String str = client.receive();
      if(str.equals("forfeit")){
        System.out.println("You won!!!");
        break;
      } else if(str.equals("I won")){
        System.out.println("You lost!!!");
        break;
      } else {
        board = strToBoard(str);
      }

      printBoard();
      while(true){
        int move = 0;
        while(move == 0){
          try {
            String line = in.readLine();
            String[] a = line.split(" ");
            if(a.length != 4){
              System.out.println("4 integers please. Thanks.");
              continue;
            }
            move = makeMove(2, toi(a[0]), toi(a[1]), toi(a[2]), toi(a[3]));
          } catch(IOException e){
            System.out.println(e);
          }
        }
        if(checkWin(board) == 2){
          System.out.println("You won!!!");
          client.send("I won");
          break;
        }
        if(move == 2 && checkCapture(2))
          continue;
        break;
      }
      client.send(boardToStr(board));
    }
  }

  public Checkers(){

  }
}
