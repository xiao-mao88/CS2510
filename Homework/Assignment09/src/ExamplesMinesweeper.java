import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javalib.funworld.WorldScene;
import javalib.worldimages.EquilateralTriangleImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import tester.Tester;

// all of the testing for the various classes
class ExamplesMinesweeper {
  WorldScene s;
  Random rand1;
  Random rand2;
  Random rand3;
  
  // world1 will be an in-between world
  MinesweeperWorld world1;
  ArrayList<Cell> row1;
  Cell r1c1;
  Cell r1c2;
  Cell r1c3;
  ArrayList<Cell> row2;
  Cell r2c1;
  Cell r2c2;
  Cell r2c3;
  ArrayList<Cell> row3;
  Cell r3c1;
  Cell r3c2;
  Cell r3c3;
  ArrayList<ArrayList<Cell>> grid1;
  
  // word2 will be a new world
  MinesweeperWorld world2;
  ArrayList<ArrayList<Cell>> grid2; // this grid is for when cells are newly initialized
  
  // worlds for random testing
  MinesweeperWorld world3;
  MinesweeperWorld world4;
  
  // initialize data
  void initData() {
    // worldscene
    s = new WorldScene(90, 90);
    rand1 = new Random(10);
    rand2 = new Random(0);
    rand3 = new Random(23);
    
    // arguments of Cell
    // ArrayList<Cell> neighbors, boolean isBomb, boolean flag, boolean clicked
    
    // world 1 stuffs (in-between world)
    r1c1 = new Cell(new ArrayList<Cell>(), false, false, true);
    r1c2 = new Cell(new ArrayList<Cell>(), false, false, true);
    r1c3 = new Cell(new ArrayList<Cell>(), true, false, false);
    
    r2c1 = new Cell(new ArrayList<Cell>(), false, false, true);
    r2c2 = new Cell(new ArrayList<Cell>(), false, false, false);
    r2c3 = new Cell(new ArrayList<Cell>(), false, false, true);
    
    r3c1 = new Cell(new ArrayList<Cell>(), false, false, true);
    r3c2 = new Cell(new ArrayList<Cell>(), false, false, false);
    r3c3 = new Cell(new ArrayList<Cell>(), true, true, false);
    
    r1c1.neighbors = new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r2c1, this.r2c2));
    r1c2.neighbors = new ArrayList<Cell>(Arrays.asList(
        this.r1c1, this.r2c1, this.r1c3, this.r2c2, this.r2c3));
    r1c3.neighbors = new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r2c3, this.r2c2));
    
    r2c1.neighbors = new ArrayList<Cell>(Arrays.asList(
        this.r1c1, this.r1c2, this.r2c2, this.r3c1, this.r3c2));
    r2c2.neighbors = new ArrayList<Cell>(Arrays.asList(
        this.r1c1, this.r1c2, this.r1c3, this.r2c1, this.r2c3, this.r3c1, this.r3c2, this.r3c3));
    r2c3.neighbors = new ArrayList<Cell>(Arrays.asList(
        this.r1c2, this.r1c3, this.r2c2, this.r3c2, this.r3c3));
    
    r3c1.neighbors = new ArrayList<Cell>(Arrays.asList(this.r2c1, this.r2c2, this.r3c2));
    r3c2.neighbors = new ArrayList<Cell>(Arrays.asList(
        this.r2c1, this.r2c2, this.r2c3, this.r3c1, this.r3c3));
    r3c3.neighbors = new ArrayList<Cell>(Arrays.asList(this.r2c2, this.r2c3, this.r3c2));
    
    row1 = new ArrayList<Cell>(Arrays.asList(this.r1c1, this.r1c2, this.r1c3));
    row2 = new ArrayList<Cell>(Arrays.asList(this.r2c1, this.r2c2, this.r2c3));
    row3 = new ArrayList<Cell>(Arrays.asList(this.r3c1, this.r3c2, this.r3c3));
    
    grid1 = new ArrayList<ArrayList<Cell>>(Arrays.asList(this.row1, this.row2, this.row3));
    
    world1 = new MinesweeperWorld(3, 3, 2, this.grid1);
    
    // world 2 stuffs (used to check if construction is correct)
    world2 = new MinesweeperWorld(3, 3, 2, rand1);
    
    world3 = new MinesweeperWorld(4, 4, 10, rand2);
    world4 = new MinesweeperWorld(5, 3, 5, rand3);
    
    // grid with newly initialized cells
    grid2 = new ArrayList<ArrayList<Cell>>(Arrays.asList(
        new ArrayList<Cell>(Arrays.asList(new Cell(), new Cell(), new Cell())),
        new ArrayList<Cell>(Arrays.asList(new Cell(), new Cell(), new Cell())),
        new ArrayList<Cell>(Arrays.asList(new Cell(), new Cell(), new Cell()))));
  }
  
  // testing floodFill method
  void testFloodFill(Tester t) {
    initData();
    
    this.r2c2.floodFill(); // this floods r3c2, the last unclicked cell
    
    t.checkExpect(this.r2c2, new Cell(new ArrayList<Cell>(Arrays.asList(
        this.r1c1, this.r1c2, this.r1c3, this.r2c1, this.r2c3, this.r3c1,
        this.r3c2, this.r3c3)),
        false, false, true));
    
    Cell r3c2Save = this.r3c2;
    
    this.r3c2.floodFill(); // this does not flood, so northing happens
    
    t.checkExpect(this.r3c2, r3c2Save);
  }
  
  // testing validClick method
  void testValidClick(Tester t) {
    initData();
    
    t.checkExpect(this.world1.validClick(new Posn(0, 0)), true);
    t.checkExpect(this.world1.validClick(new Posn(-100, 500)), false);
    t.checkExpect(this.world1.validClick(new Posn(500, -100)), false);
    t.checkExpect(this.world1.validClick(new Posn(30, 30)), true);
  }
  
  // testing explosion method
  void testExplosion(Tester t) {
    initData();
    // when both is a bomb an clicked
    this.r1c1.isBomb = true;
    this.r1c1.clicked = true;
    t.checkExpect(this.r1c1.explosion(), true);
    
    // when not a bomb and not clicked
    this.r1c1.isBomb = false;
    this.r1c1.clicked = false;
    t.checkExpect(this.r1c1.explosion(), false);
    
    // when not a bomb and clicked
    this.r1c1.isBomb = false;
    this.r1c1.clicked = true;
    t.checkExpect(this.r1c1.explosion(), false);
    
    // when a bomb and not clicked
    this.r1c1.isBomb = true;
    this.r1c1.clicked = false;
    t.checkExpect(this.r1c1.explosion(), false);
  }
  
  // test changeFlag method
  void testChangeFlag(Tester t) {
    initData();
    
    this.r1c1.changeFlag();
    this.r3c3.changeFlag();
    
    // unflagged to flagged
    t.checkExpect(this.r1c1, new Cell(this.r1c1.neighbors, false, true, true));
    // flagged to unflagged
    t.checkExpect(this.r3c3, new Cell(this.r3c3.neighbors, true, false, false));
  }
  
  // test youWon method
  void testYouWon(Tester t) {
    initData();
    
    t.checkExpect(this.world1.youWon(), new WorldEnd(true, 
        this.world1.makeScene().placeImageXY(
            new RectangleImage(90, 60, "solid", Color.WHITE), 
            45, 45)
            .placeImageXY((new TextImage("YOU WON", 30, Color.BLUE)), 
                45, 45)));
    
    MinesweeperWorld grid2World = new MinesweeperWorld(3, 3, 2, this.grid2);
    
    t.checkExpect(grid2World.youWon(), new WorldEnd(true, 
        grid2World.makeScene().placeImageXY(
            new RectangleImage(90, 60, "solid", Color.WHITE), 
            45, 45)
            .placeImageXY((new TextImage("YOU WON", 30, Color.BLUE)), 
                45, 45)));
  }
  
  // test youLost method
  void testYouLost(Tester t) {
    initData();
    
    t.checkExpect(this.world1.youLost(), new WorldEnd(true, 
        this.world1.makeScene().placeImageXY(
            new RectangleImage(90, 60, "solid", Color.WHITE), 
            45, 45)
            .placeImageXY((new TextImage("YOU LOST", 30, Color.RED)), 
                45, 45)));
    
    MinesweeperWorld grid2World = new MinesweeperWorld(3, 3, 2, this.grid2);
    
    t.checkExpect(grid2World.youLost(), new WorldEnd(true, 
        grid2World.makeScene().placeImageXY(
            new RectangleImage(90, 60, "solid", Color.WHITE), 
            45, 45)
            .placeImageXY((new TextImage("YOU LOST", 30, Color.RED)), 
                45, 45)));
  }
  
  // void test worldEnds method
  void testWorldEnds(Tester t) {    
    // case where you lose (exploding a mine)
    initData();
    this.r1c1.clicked = true;
    this.r1c1.isBomb = true;
    MinesweeperWorld loseWorld = new MinesweeperWorld(2, 2, 1,
        new ArrayList<ArrayList<Cell>>(Arrays.asList(
            new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r1c1, this.r1c2, this.r1c2)),
            new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r1c2, this.r1c2, this.r1c2)))));
    
    t.checkExpect(loseWorld.worldEnds(), loseWorld.youLost());
    
    // case where you win (all cells are clicked)
    initData();
    this.r1c1.isBomb = false;
    MinesweeperWorld winWorld = new MinesweeperWorld(2, 2, 0,
        new ArrayList<ArrayList<Cell>>(Arrays.asList(
            new ArrayList<Cell>(Arrays.asList(this.r1c1, this.r1c1)),
            new ArrayList<Cell>(Arrays.asList(this.r1c1, this.r1c1)))));
            
    t.checkExpect(winWorld.worldEnds(), winWorld.youWon());
    // case where the world doesn't end
    initData();
    t.checkExpect(this.world1.worldEnds(), new WorldEnd(false, this.world1.makeScene()));
  }
  
  // test cellFlagged method
  void testCellFlagged(Tester t) {
    initData();
    
    MinesweeperWorld w1Save =  new MinesweeperWorld(3, 3, 2, this.grid1);
    
    this.world1.cellFlagged(new Posn(0, 0));
    w1Save.cells.get(0).get(0).changeFlag();
    
    t.checkExpect(this.world1, w1Save);
    
    initData();
    
    MinesweeperWorld grid2World = new MinesweeperWorld(4, 4, 10, this.grid2);
    
    MinesweeperWorld result = new MinesweeperWorld(4, 4, 10, this.grid2);
    
    grid2World.cellFlagged(new Posn(45, 60));
    result.cells.get(1).get(2).changeFlag();
    
    t.checkExpect(grid2World, result);
  }
  
  // test cellClicked method
  void testCellClicked(Tester t) {
    initData();
    
    MinesweeperWorld w1Save =  new MinesweeperWorld(3, 3, 2, this.grid1);
    
    this.world1.cellClicked(new Posn(0, 0));
    w1Save.cells.get(0).get(0).floodFill();
    
    t.checkExpect(this.world1, w1Save);
    
    initData();
    
    MinesweeperWorld grid2World = new MinesweeperWorld(4, 4, 10, this.grid2);
    
    MinesweeperWorld result = new MinesweeperWorld(4, 4, 10, this.grid2);
    
    grid2World.cellClicked(new Posn(45, 60));
    result.cells.get(1).get(2).floodFill();
    
    t.checkExpect(grid2World, result);
    
  }
  
  // test addNeighbor method
  void testAddNeighbor(Tester t) {
    initData();
    // checking that a cell has the correct list of neighbors
    t.checkExpect(this.r1c1.neighbors, 
        new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r2c1, this.r2c2)));
    // adding a neighbor
    this.r1c1.addNeighbor(this.r1c3);
    // checking that the cell has the correct updated list of neighbors
    t.checkExpect(this.r1c1.neighbors, 
        new ArrayList<Cell>(Arrays.asList(this.r1c2, this.r2c1, this.r2c2, this.r1c3)));
  }
  
  // test countBombs method (MinesweeperWorld)
  void testCountBombsMSW(Tester t) {
    initData();
    t.checkExpect(this.world2.countBombs(), 2);
    t.checkExpect(this.world3.countBombs(), 10);
    t.checkExpect(this.world4.countBombs(), 5);
  }
  
  // test countBombs method (Cell)
  void testCountBombsCell(Tester t) {
    initData();
    // no bombs in neighboring cells
    t.checkExpect(this.r1c1.countBombs(), 0);
    // one bomb
    t.checkExpect(this.r1c2.countBombs(), 1);
    // more than one bomb
    t.checkExpect(this.r2c3.countBombs(), 2);
  }
  
  // test draw method
  void testDraw(Tester t) {
    initData();
    
    // drawing a corner piece (0 bombs)
    t.checkExpect(this.r1c1.draw(s, 0, 0), 
        this.s.placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 15, 15)
        .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 15));
    
    // drawing an unclicked piece
    t.checkExpect(this.r2c2.draw(s, 1, 1), 
        this.s
        .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 45)
        .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 45));
    
    // drawing an bomb
    t.checkExpect(this.r1c3.draw(s, 0, 2), 
        this.s.placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 15)
        .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 15));
  }
  
  // testing onMouseClicked method
  void testOnMouseClicked(Tester t) {
    initData();
    
    this.world1.cellClicked(new Posn(30, 30));
    MinesweeperWorld result1 = this.world1;
    
    initData();
    
    // when it's a valid left click
    t.checkExpect(this.world1.onMouseClicked(new Posn(30, 30), "LeftButton"),
        result1);
    
    initData();
    
    // when it's a valid right click
    
    this.world1.cellFlagged(new Posn(30, 30));
    MinesweeperWorld result2 = this.world1;
    
    initData();
    
    t.checkExpect(this.world1.onMouseClicked(new Posn(30, 30), "RightButton"),
        result2);
    
    // else return same scene
    
    initData();
    
    MinesweeperWorld result3 = this.world1;
    
    t.checkExpect(this.world1.onMouseClicked(new Posn(-213, 322), "LeftButton"),
        result3);
    t.checkExpect(this.world1.onMouseClicked(new Posn(-213, 322), "RightButton"),
        result3);
  }
  
  // test illegal argument throw
  void testIllegalArgumentThrow(Tester t) {
    // invalid grid
    t.checkConstructorException(new IllegalArgumentException("Invalid grid or number of mines"),
        "MinesweeperWorld", 0, 4, 1);
    // invalid number of mines
    t.checkConstructorException(new IllegalArgumentException("Invalid grid or number of mines"),
        "MinesweeperWorld", 3, 4, 0);
    // more mines than cells
    t.checkConstructorException(new IllegalArgumentException("Invalid grid or number of mines"),
        "MinesweeperWorld", 3, 4, 50);
  }
  
  // test initializeCells method
  void testInitializeCells(Tester t) {
    initData();
    // checks if the initial version is correct
    t.checkExpect(this.world1.cells, this.grid1);
    // call the function
    this.world1.initializeCells();
    // check if the function has worked correctly
    t.checkExpect(this.world1.cells, this.grid2);
  }
  
  // test updateNeighbors method
  void testUpdateNeighbors(Tester t) {
    initData();
    // checking upper right corner piece
    t.checkExpect(this.world2.cells.get(0).get(0).neighbors.size(), 3);
    // checking upper left corner piece
    t.checkExpect(this.world2.cells.get(0).get(2).neighbors.size(), 3);
    // checking top row piece
    t.checkExpect(this.world2.cells.get(0).get(1).neighbors.size(), 5);
    
    // checking left column piece
    t.checkExpect(this.world2.cells.get(1).get(0).neighbors.size(), 5);
    // checking right column piece
    t.checkExpect(this.world2.cells.get(1).get(2).neighbors.size(), 5);
    // checking middle piece
    t.checkExpect(this.world2.cells.get(1).get(1).neighbors.size(), 8);
    
    // checking lower right corner piece
    t.checkExpect(this.world2.cells.get(2).get(0).neighbors.size(), 3);
    // checking lower left corner piece
    t.checkExpect(this.world2.cells.get(2).get(1).neighbors.size(), 5);
    // checking bottom row piece
    t.checkExpect(this.world2.cells.get(2).get(2).neighbors.size(), 3);
  }
  
  // test initializeBombs method
  // to test this method, you need to check if the correct number of bombs have been initialized
  void testInitializeBombs(Tester t) {
    initData();
    t.checkExpect(this.world2.countBombs(), 2);
  }
  
  // test makeScene method
  boolean testMakeScene(Tester t) {
    initData();
    
    return 
        // making the scene of a newly created game world
        t.checkExpect(this.world2.makeScene(),
            new WorldScene(90,  90)
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 15, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 15)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 15)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 15)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 15, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 15, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 75)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 75)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 75))
        
        // making the scene of an in-between world
        && t.checkExpect(this.world1.makeScene(), 
            s.placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 15, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 15)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 45, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 15)
            .placeImageXY((new TextImage("1", 15, Color.BLUE)), 45, 15)

            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 15)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 15)
                
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 15, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 75, 45)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 45)
            .placeImageXY((new TextImage("2", 15, Color.GREEN)), 75, 45)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.LIGHT_GRAY), 15, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 15, 75)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 45, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 45, 75)
            
            .placeImageXY(new RectangleImage(30, 30, "solid", Color.GRAY), 75, 75)
            .placeImageXY(new RectangleImage(30, 30, "outline", Color.BLACK), 75, 75)
            .placeImageXY(new EquilateralTriangleImage(15, "solid", Color.YELLOW), 75, 75));
  }
  
  // test theColor method
  boolean testTheColor(Tester t) {
    return
        // 1
        t.checkExpect(new Cell().theColor(1), Color.BLUE)
        // 2
        && t.checkExpect(new Cell().theColor(2), Color.GREEN)
        // 3
        && t.checkExpect(new Cell().theColor(3), Color.RED)
        // 4
        && t.checkExpect(new Cell().theColor(4), Color.MAGENTA)
        // 5
        && t.checkExpect(new Cell().theColor(5), Color.ORANGE)
        // 6
        && t.checkExpect(new Cell().theColor(6), Color.CYAN)
        // 7
        && t.checkExpect(new Cell().theColor(7), Color.BLACK);
  }
  
  // play the gameWorld here
  boolean testBigBang(Tester t) {
    initData();
    int worldWidth = 900;
    int worldHeight = 800;
    MinesweeperWorld world = new MinesweeperWorld();
    return world.bigBang(worldWidth, worldHeight, 1);
  }
}