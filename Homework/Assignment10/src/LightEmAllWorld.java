import java.util.ArrayList;
import javalib.impworld.*;
import java.awt.Color;
import javalib.worldimages.*;

// interface for light em all
interface ILightEmAll {
  int SIZE = 50;
  int WIREW = 5;
  Color UNPOWERED = Color.LIGHT_GRAY;
  Color POWERED = Color.YELLOW;
  
  Color TEXT = Color.CYAN;
  int DEFAULT_TEXT = 15;
  
  int DEFAULT_WIDTH = 5;
  int DEFAULT_HEIGHT = 5;
}

// lightemAll world
class LightEmAll extends World implements ILightEmAll {
  ArrayList<ArrayList<GamePiece>> board; // a list of columns of GamePieces, (column-major order)
  ArrayList<GamePiece> nodes; // a list of all nodes
  ArrayList<Edge> mst; // a list of edges of the minimum spanning tree
  int width; // width of the board
  int height; // height of the board
  // the current location of the power station,
  // as well as its effective radius
  int powerRow;
  int powerCol;
  int radius;
  
  // constructor that creates everything from nothing given
  LightEmAll() {
    this.width = DEFAULT_WIDTH;
    this.height = DEFAULT_HEIGHT;
    this.powerRow = DEFAULT_HEIGHT / 2;
    this.powerCol = DEFAULT_WIDTH / 2;
    this.board = this.initializeBoard();
    this.modifyBoard();
    this.lightConnected();
  }
  
  // only takes in the width and height
  LightEmAll(int width, int height) {
    this.width = width;
    this.height = height;
    this.powerRow = height / 2;
    this.powerCol = width / 2;
    this.board = this.initializeBoard();
    this.modifyBoard();
  }
  
  // takes in everything necessary for testing purposes of Part 1
  LightEmAll(ArrayList<ArrayList<GamePiece>> board, int width, int height, 
      int powerRow, int powerCol) {
    this.board = board;
    this.width = width;
    this.height = height; 
    this.powerRow = powerRow;
    this.powerCol = powerCol;
  }
  
  // initialize the board
  public ArrayList<ArrayList<GamePiece>> initializeBoard() {
    ArrayList<ArrayList<GamePiece>> newBoard = new ArrayList<ArrayList<GamePiece>>();
    for (int i = 0; i < this.height; i ++) {
      ArrayList<GamePiece> row = new ArrayList<GamePiece>();
      for (int j = 0; j < this.width; j ++) {
        GamePiece newG = new GamePiece(i, j, false, false, false, false, false, false);
        row.add(newG);
      }
      newBoard.add(row);
    }
    return newBoard;
  }
  
  // modifies the first completed board for manual generation
  public void modifyBoard() {
    for (int i = 0; i < this.height; i ++) {
      for (int j = 0; j < this.width; j ++) {
        
        // changing top row
        if (i == 0) {
          this.board.get(i).get(j).bottom = true;
        }
        
        // changing the one line in the middle
        else if (i == this.height / 2) {
          this.board.get(i).get(j).left = true;
          this.board.get(i).get(j).right = true;
          this.board.get(i).get(j).top = true;
          this.board.get(i).get(j).bottom = true;
        }
        
        // changing last tile so that you don't automatically win when after first initialization
        else if (i == this.height - 1 && j == this.width - 1) {
          this.board.get(i).get(j).left = true;
        }
        
        // changing the bottom row
        else if (i == this.height - 1) {
          this.board.get(i).get(j).top = true;
        }
        
        // changing left/right side
        else if (j == 0 || j == this.width - 1) {
          this.board.get(i).get(j).top = true; 
          this.board.get(i).get(j).bottom = true;
        }
        
        // all of the other pieces
        else {
          this.board.get(i).get(j).top = true;
          this.board.get(i).get(j).bottom = true;
        }
      }
    }
  }
  
  // handles the clicking to rotate of the GamePiece
  public void onMouseClicked(Posn pos, String button) {
    int x = pos.x / SIZE;
    int y = pos.y / SIZE;
    if (button.equals("LeftButton") && this.validClick(x, y)) {
      this.board.get(y).get(x).rotate();
      this.disconnect();
      this.lightConnected();
    }
  }
  
  // turns on all connected pieces, starting from the powerStation
  public void lightConnected() {
    GamePiece ps = this.board.get(this.powerRow).get(this.powerCol);
    ps.powerStation = true;
    ps.powered = true;
    ps.lightAllNeighbors(this.board);
  }
  
  // disconnects everything
  public void disconnect() {
    for (ArrayList<GamePiece> row : this.board) {
      for (GamePiece col : row) {
        col.powered = false;
      }
    }
  }
  
  // checks if this click is a valid click on the board
  public boolean validClick(int x, int y) {
    return x >= 0 && y >= 0 && x < this.width && y < this.height;
  }
  
  // handles the movement of the powerStation (onkey)
  public void onKeyEvent(String key) {
    this.board.get(this.powerRow).get(this.powerCol).powerStation = false;
    GamePiece currPow = this.board.get(this.powerRow).get(this.powerCol);
    
    if (key.equals("left") && this.powerCol > 0) {
      GamePiece l = this.board.get(this.powerRow).get(this.powerCol - 1);
      if (currPow.left && l.right) {
        this.powerCol --;
      }
    }
    
    else if (key.equals("right") && this.powerCol < this.width - 1) {
      GamePiece r = this.board.get(this.powerRow).get(this.powerCol + 1);
      if (currPow.right && r.left) {
        this.powerCol ++;
      }
    }
    
    else if (key.equals("up") && this.powerRow > 0) {
      GamePiece t = this.board.get(this.powerRow - 1).get(this.powerCol);
      if (currPow.top && t.bottom) {
        this.powerRow --;
      }
    }
    
    else if (key.equals("down") && this.powerRow < this.height - 1) {
      GamePiece b = this.board.get(this.powerRow + 1).get(this.powerCol);
      if (currPow.bottom && b.top) {
        this.powerRow ++;
      }
    }
    this.disconnect();
    this.lightConnected();
  }
  
  // makes the game board
  public WorldScene makeScene() {
    WorldScene s = new WorldScene(this.width * SIZE, this.height * SIZE);
    
    for (ArrayList<GamePiece> arrG : this.board) {
      for (GamePiece g : arrG) {
        s = g.draw(s);
      }
    }
    
    return s;
  }
  
  // ends the world
  public WorldEnd worldEnds() {
    if (this.allLit()) {
      return new WorldEnd(true, this.winScene());
    }
    
    return new WorldEnd(false, this.makeScene());
  }
  
  // the end win scene
  public WorldScene winScene() {
    WorldScene s = new WorldScene(this.width * SIZE, this.height * SIZE);
    s.placeImageXY(new TextImage("YOU WIN!!", DEFAULT_TEXT, TEXT), 
        this.width * SIZE / 2, this.height * SIZE / 2);
    return s;
  }
  
  // checks if all the pieces on the board are lit
  public boolean allLit() {
    for (ArrayList<GamePiece> row : this.board) {
      for (GamePiece col : row) {
        if (!col.powered) {
          return false;
        }
      }
    }
    
    return true;
  }
  
  // unused for now, but I want to keep this monstrosity of a piece of code
  /*// changes the game board after each move the user does
  // BFS: handles rotation after mouse-clicking & powerStation movement
  public void changeLight(GamePiece from, ArrayList<ArrayList<GamePiece>> board) {
    Queue<GamePiece> worklist = new LinkedList<GamePiece>();
    Deque<GamePiece> visited = new ArrayDeque<GamePiece>();
    worklist.add(from);
    while (!worklist.isEmpty()) {
      GamePiece next = worklist.remove();
      if (!visited.contains(next)) {
        ArrayList<GamePiece> neighbors = next.neighbor(board);
        worklist.addAll(neighbors);
        for (int i = 0; i < neighbors.size(); i ++) {
          if (next.connectedLit(neighbors.get(i))) {
            neighbors.get(i).powered = true;
          }
          else if (!visited.contains(neighbors.get(i))) {
            neighbors.get(i).powered = false;
          }
        }
      }
      
      visited.addFirst(next);
    }
  }*/
}






