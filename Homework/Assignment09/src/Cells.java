import java.util.ArrayList;
import javalib.funworld.WorldScene;
import java.awt.Color;
import javalib.worldimages.*;

// represents a cell
class Cell implements IWorld {
  ArrayList<Cell> neighbors; // list of this cell's neighbors
  boolean isBomb; // is this cell a bomb?
  boolean flag; // is this cell flagged
  boolean clicked; // has this cell been clicked on?
  
  // initial creation of a cell
  Cell() {
    this.neighbors = new ArrayList<Cell>();
    this.isBomb = false;
    this.flag = false;
    this.clicked = false;
  }
  
  // takes in multiple values to create a cell (makes my life easier for testing)
  Cell(ArrayList<Cell> neighbors, boolean isBomb, boolean flag, boolean clicked) {
    this.neighbors = neighbors;
    this.isBomb = isBomb;
    this.flag = flag;
    this.clicked = clicked;
  }
  
  // adds a cell to this cell's neighbors
  public void addNeighbor(Cell c) {
    this.neighbors.add(c);
  }
  
  // counts the number of bombs in the neighbors
  public int countBombs() {
    int num = 0;
    for (int i = 0; i < this.neighbors.size(); i++) {
      if (this.neighbors.get(i).isBomb) {
        num++;
      }
    }
    
    return num;
  }
  
  // changes the flag boolean of this cell
  public void changeFlag() {
    this.flag = !this.flag;
  }
  
  // flood behavior if there are no neighboring bombs & changes the visibility
  public void floodFill() {
    if (!this.clicked && !this.flag) {
      this.clicked = true;
      
      if (this.countBombs() == 0 && !this.flag && !this.isBomb) {
        for (Cell c : this.neighbors) {
          c.floodFill();
        }
        
      }
    }
  }
  
  // checks if a cell is flagged
  public boolean isFlag() {
    return this.flag;
  }
  
  // checks if an explosion will occur (ie. if the cell is clicked AND is a bomb)
  // this part still isn't working either
  public boolean explosion() {
    return this.clicked && this.isBomb;
  }
  
  // draws out each cell given a worldScene, the row, and column
  public WorldScene draw(WorldScene s, int row, int col) {
    int x = CELL_LENGTH * row + CELL_LENGTH / 2;
    int y = CELL_LENGTH * col + CELL_LENGTH / 2;
    
    // first checks if the cell is flagged
    if (this.flag) {
      return 
          s.placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "solid", Color.GRAY), y, x)
          .placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "outline", Color.BLACK), y, x)
          .placeImageXY(new EquilateralTriangleImage(DEFAULT_SIZE, "solid", Color.YELLOW), y, x);
    }
    
    // then checks if the cell has been clicked
    else if (this.clicked && this.countBombs() != 0 && !this.isBomb) {
      return 
          s.placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "solid", Color.LIGHT_GRAY), 
              y, x)
          .placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "outline", Color.BLACK), y, x)
          .placeImageXY((new TextImage("" + this.countBombs(), DEFAULT_SIZE, 
              this.theColor(this.countBombs()))), y, x);
    }
    
    // then checks if the cell has been clicked
    else if (this.clicked && (this.countBombs() == 0) && !this.isBomb) {
      return 
          s.placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "solid", Color.LIGHT_GRAY),
              y, x)
          .placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "outline", Color.BLACK), y, x);
    }
    
    // if not either, then just print out the default cell
    return 
        s.placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "solid", Color.GRAY), y, x)
        .placeImageXY(new RectangleImage(CELL_LENGTH, CELL_LENGTH, "outline", Color.BLACK), y, x);
  }
  
  // returns the color given the number of bombs (helper method)
  public Color theColor(int bombs) {
    if (bombs == 1) {
      return Color.BLUE;
    }
    
    else if (bombs == 2) {
      return Color.GREEN;
    }
    
    else if (bombs == 3) {
      return Color.RED;
    }
    
    else if (bombs == 4) {
      return Color.MAGENTA;
    }
    
    else if (bombs == 5) {
      return Color.ORANGE;
    }
    
    else if (bombs == 6) {
      return Color.CYAN;
    }
    
    else {
      return Color.BLACK;
    }
  }
}





