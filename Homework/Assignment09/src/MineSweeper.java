import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javalib.funworld.WorldScene;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.funworld.World;

interface IWorld {
  int CELL_LENGTH = 30;
  int DEFAULT_SIZE = 15;
}

// represents the minesweeper world
class MinesweeperWorld extends World implements IWorld {
  int rows; // represents the number of columns when creating the game
  int columns; // represents the number of rows when creating the game
  int mines; // represents the number of mines on the game board
  ArrayList<ArrayList<Cell>> cells; // represents the cells on the game board
  Random rand; // random number generator (generates the random bombs)
  
  // automatic initialization (when there is nothing given)
  MinesweeperWorld() {
    this.rows = 16;
    this.columns = 30;
    this.mines = 99;
    this.cells = new ArrayList<ArrayList<Cell>>();
    this.rand = new Random();
    
    int mine2 = this.mines;
    this.initializeCells();
    this.initializeBombs(mine2);
    this.updateNeighbors();
  }
  
  // initializing when given rows, columns, and mines
  MinesweeperWorld(int rows, int columns, int mines) {
    if (rows <= 1 || columns <= 1 || mines <= 0 || rows * columns <= mines) {
      throw new IllegalArgumentException("Invalid grid or number of mines");
    }
    
    this.rows = rows;
    this.columns = columns;
    this.mines = mines;
    this.cells = new ArrayList<ArrayList<Cell>>();
    this.rand = new Random();
    
    this.initializeCells();
    this.initializeBombs(mines);
    this.updateNeighbors();
  }
  
  // after first initialization (helps with testing)
  MinesweeperWorld(int rows, int columns, int mines, ArrayList<ArrayList<Cell>> cells) {
    this.rows = rows;
    this.columns = columns;
    this.mines = mines;
    this.cells = cells;
  }
  
  // constructor for testing pt 2 (takes in a random)
  MinesweeperWorld(int rows, int columns, int mines, Random rand) {
    this.rows = rows;
    this.columns = columns;
    this.mines = mines;
    this.cells = new ArrayList<ArrayList<Cell>>();
    this.rand = rand;
    
    this.initializeCells();
    this.initializeBombs(mines);
    this.updateNeighbors();
  }
  
  // initializes all of the cells necessary
  public void initializeCells() {
    ArrayList<ArrayList<Cell>> newArr = new ArrayList<ArrayList<Cell>>();
    for (int i = 0; i < this.rows; i++) {
      ArrayList<Cell> temp = new ArrayList<Cell>();
      for (int j = 0; j < this.columns; j++) {
        temp.add(new Cell());
      }
      newArr.add(temp);
    }
    this.cells = newArr;
  }
  
  // updates the neighbors of arrayList of the cells 
  public void updateNeighbors() {
    int rows = this.rows;
    int col = this.columns;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < col; j++) {
        Cell currentCell = this.cells.get(i).get(j);
        // upper right corner
        if (i == 0 && j == 0) {
          // adding cell next to this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          // adding cell diagonally right below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j + 1));
        }
        
        // updating neighbors in the top row
        else if (i == 0 && j < col - 1) {
          // adding cell to the right of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          
          // adding cell diagonally right below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j + 1));
          // adding cell diagonally left below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j - 1));
        }
        
        // updating neighbors in the upper right corner
        else if (i == 0 && j == col - 1) {
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          // adding cell diagonally left below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j - 1));
        }
        
        // updating neighbors in the left side
        else if (j == 0 && i != rows - 1) {
          // adding cell to the right of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          
          // adding cell diagonally right below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j + 1));
          // adding cell diagonally right above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j + 1));
        }
        
        // updating neighbors in the right side
        else if (j == col - 1 && i != rows - 1) {
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          
          // adding cell diagonally left below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j - 1));
          // adding cell diagonally left above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j - 1));
        }
        
        // updating the neighbors in the lower left corner
        else if (i == rows - 1 && j == 0) {
          // adding cell to the right of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          // adding cell diagonally right above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j + 1));
        }
        
        // updating the neighbors in the bottom row
        else if (i == rows - 1 && j != col - 1) {
          // adding cell to the right of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          
          // adding cell diagonally right above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j + 1));
          // adding cell diagonally left above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j - 1));
        }
        
        // updating the neighbors in the lower right corner
        else if (i == rows - 1 && j == col - 1) {
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          // adding cell diagonally left above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j - 1));
        }
        
        // updating the neighbors in the middle
        else {
          // adding cell to the right of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j + 1));
          // adding cell to the left of this cell
          currentCell.addNeighbor(this.cells.get(i).get(j - 1));
          
          // adding cell above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j));
          // adding cell below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j));
          
          // adding cell diagonally right above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j + 1));
          // adding cell diagonally left above this cell
          currentCell.addNeighbor(this.cells.get(i - 1).get(j - 1));
          
          // adding cell diagonally right below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j + 1));
          // adding cell diagonally left below this cell
          currentCell.addNeighbor(this.cells.get(i + 1).get(j - 1));
        }
      }
    }
  }
  
  // initializes number of bombs
  public void initializeBombs(int remainingBombs) {
    int bombsLeft = remainingBombs;
    
    while (bombsLeft != 0) {
      Cell temp = this.cells.get(this.rand.nextInt(this.rows)).get(this.rand.nextInt(this.columns));
      if (!temp.isBomb) {
        temp.isBomb = true;
        bombsLeft --;
      }
    }
  }
  
  // counts the number of bombs remaining on the game board
  public int countBombs() {
    int bombs = this.mines;
    
    for (ArrayList<Cell> arr : this.cells) {
      for (Cell c : arr) {
        if (c.isFlag()) {
          bombs --;
        }
      }
    }
    
    return bombs;
  }
  
  // mouse-click handling; right-clicking will plant a flag; left-clicking will open a new cell
  public World onMouseClicked(Posn pos, String button) {
    if (this.validClick(pos)) {
      if (button.equals("LeftButton")) {
        this.cellClicked(pos);
        return this;
      }
      
      else if (button.equals("RightButton")) {
        this.cellFlagged(pos);
        return this;
      }
    }
    return this;
  }
  
  // checks if the click is a valid click on the board
  // validClick
  public boolean validClick(Posn pos) {
    return pos.x < this.columns * CELL_LENGTH && pos.y < this.rows * CELL_LENGTH;
  }
  
  // handles opening a new cell
  void cellClicked(Posn pos) {
    int x = pos.x / CELL_LENGTH;
    int y = pos.y / CELL_LENGTH;
    this.cells.get(y).get(x).floodFill();
  }
  
  // handles flagging/unflagging a bomb
  void cellFlagged(Posn pos) {
    int x = pos.x / CELL_LENGTH;
    int y = pos.y / CELL_LENGTH;
    
    this.cells.get(y).get(x).changeFlag();
  }
  
  // draws out the game board
  public WorldScene makeScene() {
    WorldScene s = new WorldScene(this.columns * CELL_LENGTH, this.rows * CELL_LENGTH);
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.columns; j++) {
        s = this.cells.get(i).get(j).draw(s, i, j);
      }
    }
    
    s = s.placeImageXY(new TextImage("Bombs Left: " + this.countBombs(), 25, Color.BLACK), 
        this.columns * CELL_LENGTH / 2, this.rows * CELL_LENGTH + CELL_LENGTH);
    
    return s;
  }
  
  // ends the world
  public WorldEnd worldEnds() {
    boolean allCellsClicked = true;
    for (int i = 0; i < this.rows; i ++) {
      for (int j = 0; j < this.columns; j ++) {
        if (this.cells.get(i).get(j).explosion()) {
          return this.youLost();
        }
        
        else if (!this.cells.get(i).get(j).clicked && !this.cells.get(i).get(j).isBomb) {
          allCellsClicked = false;
        }
      }
    }
    
    if (allCellsClicked) {
      return this.youWon();
    }
    
    return new WorldEnd(false, this.makeScene());
  }
  
  // end lose screen
  public WorldEnd youLost() {
    WorldScene s = this.makeScene();
    s = s.placeImageXY(
        new RectangleImage(CELL_LENGTH * this.columns, CELL_LENGTH * 2, "solid", Color.WHITE), 
        this.columns * CELL_LENGTH / 2, this.rows * CELL_LENGTH / 2)
        .placeImageXY((new TextImage("YOU LOST", CELL_LENGTH, Color.RED)), 
            this.columns * CELL_LENGTH / 2, this.rows * CELL_LENGTH / 2);
    return new WorldEnd(true, s);
  }
  
  // end win screen
  public WorldEnd youWon() {
    WorldScene s = this.makeScene();
    s = s.placeImageXY(
        new RectangleImage(CELL_LENGTH * this.columns, CELL_LENGTH * 2, "solid", Color.WHITE), 
        this.columns * CELL_LENGTH / 2, this.rows * CELL_LENGTH / 2)
        .placeImageXY((new TextImage("YOU WON", CELL_LENGTH, Color.BLUE)), 
            this.columns * CELL_LENGTH / 2, this.rows * CELL_LENGTH / 2);
    return new WorldEnd(true, s);
  }
  
}






