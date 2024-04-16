import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import javalib.impworld.*;
import javalib.worldimages.Posn;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import tester.Tester;

// testing and examples for light em all up game
class ExamplesLight {
  // world1 (everything is manually inputed)
  LightEmAll world1;
  GamePiece r1c1;
  GamePiece r1c2;
  GamePiece r1c3;
  
  GamePiece r2c1;
  GamePiece r2c2;
  GamePiece r2c3;
  
  GamePiece r3c1;
  GamePiece r3c2;
  GamePiece r3c3;
  ArrayList<GamePiece> r1;
  ArrayList<GamePiece> r2;
  ArrayList<GamePiece> r3;
  ArrayList<ArrayList<GamePiece>> board1;
  
  WorldScene s1;
  
  // world2 (manual generation from class)
  LightEmAll world2;
  WorldScene s2;
  
  void initData() {
    // int row, int col, boolean left, boolean right, 
    // boolean top, boolean bottom, boolean powerStation, boolean powered
    r1c1 = new GamePiece(0, 0, true, false, false, false, true, true);
    r1c2 = new GamePiece(0, 1, true, true, false, true, false, false);
    r1c3 = new GamePiece(0, 2, false, false, true, false, false, false);
    
    r2c1 = new GamePiece(1, 0, true, true, true, true, false, false);
    r2c2 = new GamePiece(1, 1, false, true, false, true, false, false);
    r2c3 = new GamePiece(1, 2, true, false, true, false, false, false);
    
    r3c1 = new GamePiece(2, 0, true, true, false, true, false, false);
    r3c2 = new GamePiece(2, 1, false, false, true, true, false, false);
    r3c3 = new GamePiece(2, 2, true, false, true, true, false, false);
    r1 = new ArrayList<GamePiece>(Arrays.asList(this.r1c1, this.r1c2, this.r1c3));
    r2 = new ArrayList<GamePiece>(Arrays.asList(this.r2c1, this.r2c2, this.r2c3));
    r3 = new ArrayList<GamePiece>(Arrays.asList(this.r3c1, this.r3c2, this.r3c3));
    board1 = new ArrayList<ArrayList<GamePiece>>(Arrays.asList(this.r1, this.r2, this.r3));
    world1 = new LightEmAll(this.board1, 3, 3, 0, 0);
    s1 = new WorldScene(150, 150);
    
    world2 = new LightEmAll();
    s2 = new WorldScene(250, 250);
  }
  
  // testing for GamePiece methods
  // test the rotate method
  void testRotate(Tester t) {
    initData();
    // testing original is correct
    t.checkExpect(this.r1c1.left, true);
    t.checkExpect(this.r1c1.right, false);
    t.checkExpect(this.r1c1.top, false);
    t.checkExpect(this.r1c1.bottom, false);
    // calling the method
    this.r1c1.rotate();
    // checking if everything is changed correctly
    t.checkExpect(this.r1c1.left, false);
    t.checkExpect(this.r1c1.right, false);
    t.checkExpect(this.r1c1.top, true);
    t.checkExpect(this.r1c1.bottom, false);
    // calling the method again
    this.r1c1.rotate();
    // checking if everything is changed correctly
    t.checkExpect(this.r1c1.left, false);
    t.checkExpect(this.r1c1.right, true);
    t.checkExpect(this.r1c1.top, false);
    t.checkExpect(this.r1c1.bottom, false);
    // calling the method again
    this.r1c1.rotate();
    // checking if everything is changed correctly
    t.checkExpect(this.r1c1.left, false);
    t.checkExpect(this.r1c1.right, false);
    t.checkExpect(this.r1c1.top, false);
    t.checkExpect(this.r1c1.bottom, true);
    // calling the method again
    this.r1c1.rotate();
    // checking if everything is changed correctly
    t.checkExpect(this.r1c1.left, true);
    t.checkExpect(this.r1c1.right, false);
    t.checkExpect(this.r1c1.top, false);
    t.checkExpect(this.r1c1.bottom, false);
  }
  
  // test the lightAllNeighbors method
  void testLightAllNeighbors(Tester t) {
    initData();
    // lighting all neighbors when there are no things connected
    // checking the original
    t.checkExpect(this.world1.board, this.board1);
    // calling the method
    this.r1c2.lightAllNeighbors(this.board1);
    // checking things changed accordingly
    t.checkExpect(this.world1.board, this.board1);
    
    // lighting all neighbors when there are things connected
    initData();
    
    // rotate the gamepieces so they're connected
    this.r1c1.rotate();
    this.r1c1.rotate();
    this.r1c1.rotate();
    
    this.r3c1.rotate();
    this.r3c1.rotate();
    this.r3c1.rotate();
    
    this.r3c2.rotate();
    
    this.r2c3.rotate();
    this.r2c3.rotate();
    this.r2c3.rotate();
    
    // checking the original
    t.checkExpect(this.world1.board, this.board1);
    this.r1c1.lightAllNeighbors(this.board1);
    
    ArrayList<ArrayList<GamePiece>> board2 = new ArrayList<ArrayList<GamePiece>>(
        Arrays.asList(
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(0, 0, false, false, false, true, true, true),
                new GamePiece(0, 1, true, true, false, true, false ,false),
                new GamePiece(0, 2, false, false, true, false, false, false))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(1, 0, true, true, true, true, false, true),
                new GamePiece(1, 1, false, true, false, true, false, true),
                new GamePiece(1, 2, true, false, false, true, false, true))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(2, 0, false, true, true, true, false, true),
                new GamePiece(2, 1, true, true, false, false, false, true),
                new GamePiece(2, 2, true, false, true, true, false, true)))));
    
    t.checkExpect(this.world1.board, board2);
  }
  
  // test the tileImage method
  void testDraw(Tester t) {
    initData();
    this.s1.placeImageXY(this.r1c1.tileImage(50, 5, Color.YELLOW, true), 25, 25);
    // printing out a powerstation
    t.checkExpect(this.r1c1.draw(this.s1), this.s1);
    
    initData();
    this.r1c2.powered = true;
    this.s1.placeImageXY(this.r1c2.tileImage(50, 5, Color.YELLOW, false), 25, 25);
    // printing out a lit up wire
    t.checkExpect(this.r1c2.draw(this.s1), this.s1);
    
    initData();
    this.s1.placeImageXY(this.r1c2.tileImage(50, 5, Color.LIGHT_GRAY, false), 25, 25);
    // printing out a regular wire
    t.checkExpect(this.r1c3.draw(this.s1), this.s1);
  }
  
  
  // testing for LightEmAll methods
  // test the initializeBoard method
  void testInitializeBoard(Tester t) {
    initData();
    GamePiece g = new GamePiece(0, 0, false, false, false, false, false, false);
    GamePiece g1 = new GamePiece(0, 1, false, false, false, false, false, false);
    GamePiece g2 = new GamePiece(0, 2, false, false, false, false, false, false);
    GamePiece g3 = new GamePiece(1, 0, false, false, false, false, false, false);
    GamePiece g4 = new GamePiece(1, 1, false, false, false, false, false, false);
    GamePiece g5 = new GamePiece(1, 2, false, false, false, false, false, false);
    GamePiece g6 = new GamePiece(2, 0, false, false, false, false, false, false);
    GamePiece g7 = new GamePiece(2, 1, false, false, false, false, false, false);
    GamePiece g8 = new GamePiece(2, 2, false, false, false, false, false, false);
    
    ArrayList<GamePiece> row1 = new ArrayList<GamePiece>(Arrays.asList(g, g1, g2));
    ArrayList<GamePiece> row2 = new ArrayList<GamePiece>(Arrays.asList(g3, g4, g5));
    ArrayList<GamePiece> row3 = new ArrayList<GamePiece>(Arrays.asList(g6, g7, g8));
    
    ArrayList<ArrayList<GamePiece>> board = 
        new ArrayList<ArrayList<GamePiece>>(Arrays.asList(row1, row2, row3));
    
    t.checkExpect(this.world1.initializeBoard(), board);
  }
  
  // test the modification of the board
  void testModifyBoard(Tester t) {
    initData();
    
    GamePiece x0y0 = new GamePiece(0, 0, false, false, false, true, false, true);
    GamePiece x0y1 = new GamePiece(0, 1, false, false, false, true, false, true);
    GamePiece x0y2 = new GamePiece(0, 2, false, false, false, true, false, true);
    GamePiece x0y3 = new GamePiece(0, 3, false, false, false, true, false, true);
    GamePiece x0y4 = new GamePiece(0, 4, false, false, false, true, false, true);
    
    GamePiece x1y0 = new GamePiece(1, 0, false, false, true, true, false, true);
    GamePiece x1y1 = new GamePiece(1, 1, false, false, true, true, false, true);
    GamePiece x1y2 = new GamePiece(1, 2, false, false, true, true, false, true);
    GamePiece x1y3 = new GamePiece(1, 3, false, false, true, true, false, true);
    GamePiece x1y4 = new GamePiece(1, 4, false, false, true, true, false, true);
    
    GamePiece x2y0 = new GamePiece(2, 0, true, true, true, true, false, true);
    GamePiece x2y1 = new GamePiece(2, 1, true, true, true, true, false, true);
    GamePiece x2y2 = new GamePiece(2, 2, true, true, true, true, true, true);
    GamePiece x2y3 = new GamePiece(2, 3, true, true, true, true, false, true);
    GamePiece x2y4 = new GamePiece(2, 4, true, true, true, true, false, true);

    GamePiece x3y0 = new GamePiece(3, 0, false, false, true, true, false, true);
    GamePiece x3y1 = new GamePiece(3, 1, false, false, true, true, false, true);
    GamePiece x3y2 = new GamePiece(3, 2, false, false, true, true, false, true);
    GamePiece x3y3 = new GamePiece(3, 3, false, false, true, true, false, true);
    GamePiece x3y4 = new GamePiece(3, 4, false, false, true, true, false, true);
    
    GamePiece x4y0 = new GamePiece(4, 0, false, false, true, false, false, true);
    GamePiece x4y1 = new GamePiece(4, 1, false, false, true, false, false, true);
    GamePiece x4y2 = new GamePiece(4, 2, false, false, true, false, false, true);
    GamePiece x4y3 = new GamePiece(4, 3, false, false, true, false, false, true);
    GamePiece x4y4 = new GamePiece(4, 4, true, false, false, false, false, false);
    
    ArrayList<ArrayList<GamePiece>> xyBoard = new ArrayList<ArrayList<GamePiece>>(Arrays.asList(
        new ArrayList<GamePiece>(Arrays.asList(x0y0, x0y1, x0y2, x0y3, x0y4)),
        new ArrayList<GamePiece>(Arrays.asList(x1y0, x1y1, x1y2, x1y3, x1y4)),
        new ArrayList<GamePiece>(Arrays.asList(x2y0, x2y1, x2y2, x2y3, x2y4)),
        new ArrayList<GamePiece>(Arrays.asList(x3y0, x3y1, x3y2, x3y3, x3y4)),
        new ArrayList<GamePiece>(Arrays.asList(x4y0, x4y1, x4y2, x4y3, x4y4))));
    
    LightEmAll xyWorld = new LightEmAll(xyBoard, 5, 5, 2, 2);
    
    t.checkExpect(new LightEmAll(), xyWorld);
    
  }
  
  // test the onMouseClicked method
  void testOnMouseClicked(Tester t) {
    
    // invalid left click (do nothing)
    initData();
    LightEmAll save1 = new LightEmAll(this.board1, 3, 3, 0, 0);
    this.world1.onMouseClicked(new Posn(100000, 100000), "LeftButton");
    t.checkExpect(this.world1, save1);
    
    // not a left click (do nothing)
    initData();
    LightEmAll save2 = new LightEmAll(this.board1, 3, 3, 0, 0);
    this.world1.onMouseClicked(new Posn(20, 20), "RightButton");
    t.checkExpect(this.world1, save2);
    
    // valid left click
    initData();
    
    LightEmAll save3 = new LightEmAll(this.board1, 3, 3, 0, 0);
    save3.board.get(0).get(0).rotate();
    save3.disconnect();
    save3.lightConnected();
    this.world1.onMouseClicked(new Posn(20, 20), "LeftButton");
    t.checkExpect(this.world1, save3);
    
    initData();
    
    LightEmAll save4 = new LightEmAll(this.board1, 3, 3, 0, 0);
    save4.board.get(2).get(0).rotate();
    save4.disconnect();
    save4.lightConnected();
    this.world1.onMouseClicked(new Posn(80, 0), "LeftButton");
    t.checkExpect(this.world1, save4);
  }
  
  // test the lightConnected method
  void testLightConnected(Tester t) {
    initData();
    // lighting when there are no things connected
    this.world1.lightConnected();
    // nothing is connected to the powerstation, so return the same world
    t.checkExpect(this.world1, new LightEmAll(this.board1, 3, 3, 0, 0));
    
    // lighting all neighbors when there are things connected
    initData();
    
    // rotate the gamepieces so they're connected
    this.r1c1.rotate();
    this.r1c1.rotate();
    this.r1c1.rotate();
    
    this.r3c1.rotate();
    this.r3c1.rotate();
    this.r3c1.rotate();
    
    this.r3c2.rotate();
    
    this.r2c3.rotate();
    this.r2c3.rotate();
    this.r2c3.rotate();
    
    this.world1.lightConnected();
    
    ArrayList<ArrayList<GamePiece>> board2 = new ArrayList<ArrayList<GamePiece>>(
        Arrays.asList(
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(0, 0, false, false, false, true, true, true),
                new GamePiece(0, 1, true, true, false, true, false ,false),
                new GamePiece(0, 2, false, false, true, false, false, false))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(1, 0, true, true, true, true, false, true),
                new GamePiece(1, 1, false, true, false, true, false, true),
                new GamePiece(1, 2, true, false, false, true, false, true))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(2, 0, false, true, true, true, false, true),
                new GamePiece(2, 1, true, true, false, false, false, true),
                new GamePiece(2, 2, true, false, true, true, false, true)))));
    
    t.checkExpect(this.world1, new LightEmAll(board2, 3, 3, 0, 0)); 
  }
  
  // test the disconnect method
  void testDisconnect(Tester t) {
    initData();
    
    // lighting up the board so it may be disconnected
    // rotate the gamepieces so they're connected
    this.r1c1.rotate();
    this.r1c1.rotate();
    this.r1c1.rotate();
    
    this.r3c1.rotate();
    this.r3c1.rotate();
    this.r3c1.rotate();
    
    this.r3c2.rotate();
    
    this.r2c3.rotate();
    this.r2c3.rotate();
    this.r2c3.rotate();
    
    this.world1.lightConnected();
    
    ArrayList<ArrayList<GamePiece>> board2 = new ArrayList<ArrayList<GamePiece>>(
        Arrays.asList(
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(0, 0, false, false, false, true, true, true),
                new GamePiece(0, 1, true, true, false, true, false ,false),
                new GamePiece(0, 2, false, false, true, false, false, false))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(1, 0, true, true, true, true, false, true),
                new GamePiece(1, 1, false, true, false, true, false, true),
                new GamePiece(1, 2, true, false, false, true, false, true))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(2, 0, false, true, true, true, false, true),
                new GamePiece(2, 1, true, true, false, false, false, true),
                new GamePiece(2, 2, true, false, true, true, false, true)))));
    
    t.checkExpect(this.world1, new LightEmAll(board2, 3, 3, 0, 0)); 
    
    // disconnecting it
    this.world1.disconnect();
    
    ArrayList<ArrayList<GamePiece>> discResult = new ArrayList<ArrayList<GamePiece>>(
        Arrays.asList(
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(0, 0, false, false, false, true, true, false),
                new GamePiece(0, 1, true, true, false, true, false ,false),
                new GamePiece(0, 2, false, false, true, false, false, false))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(1, 0, true, true, true, true, false, false),
                new GamePiece(1, 1, false, true, false, true, false, false),
                new GamePiece(1, 2, true, false, false, true, false, false))),
            new ArrayList<GamePiece>(Arrays.asList(
                new GamePiece(2, 0, false, true, true, true, false, false),
                new GamePiece(2, 1, true, true, false, false, false, false),
                new GamePiece(2, 2, true, false, true, true, false, false)))));
    
    t.checkExpect(this.world1, new LightEmAll(discResult, 3, 3, 0, 0));
    
    
  }
  
  // test the validClick method
  boolean testValidClick(Tester t) {
    initData();
    return 
        // when the click is invalid
        t.checkExpect(this.world1.validClick(5, 0), false)
        // when the click is valid
        && t.checkExpect(this.world1.validClick(0, 0), true);
  }
  
  // test the onKeyEvent method
  void testOnKeyEvent(Tester t) {
    
    // left key (cannot move more left)
    initData();
    LightEmAll saveL = new LightEmAll(this.board1, 3, 3, 0, 0);
    saveL.disconnect();
    saveL.lightConnected();
    this.world1.onKeyEvent("left");
    
    t.checkExpect(this.world1, saveL);
    
    // right key
    initData();
    LightEmAll saveR = new LightEmAll(this.board1, 3, 3, 0, 0);
    this.r1c1.rotate();
    saveR.disconnect();
    saveR.lightConnected();
    this.world1.onKeyEvent("right");
    
    t.checkExpect(this.world1, saveR);
    
    // up key
    initData();
    LightEmAll saveU = new LightEmAll(this.board1, 3, 3, 0, 0);
    this.r1c1.rotate();
    saveU.disconnect();
    saveU.lightConnected();
    this.world1.onKeyEvent("up");
    
    t.checkExpect(this.world1, saveU);
    
    // down key
    initData();
    LightEmAll saveD = new LightEmAll(this.board1, 3, 3, 0, 0);
    this.r1c1.rotate();
    saveD.disconnect();
    saveD.lightConnected();
    this.world1.onKeyEvent("down");
    
    t.checkExpect(this.world1, saveD);
    
    // none of the arrow keys (just disconnect and reconnect again)
    initData();
    LightEmAll saveN = new LightEmAll(this.board1, 3, 3, 0, 0);
    saveN.disconnect();
    saveN.lightConnected();
    this.world1.onKeyEvent("g");
    
    t.checkExpect(this.world1, saveN);
  }
  
  // test the makeScene method
  void testMakeScene(Tester t) {
    initData();
    
    WorldScene result = new WorldScene(150, 150);
    result = this.r1c1.draw(result);
    result = this.r1c2.draw(result);
    result = this.r1c3.draw(result);
    result = this.r2c1.draw(result);
    result = this.r2c2.draw(result);
    result = this.r2c3.draw(result);
    result = this.r3c1.draw(result);
    result = this.r3c2.draw(result);
    result = this.r3c3.draw(result);
    
    t.checkExpect(this.world1.makeScene(), result);
  }
  
  // test the worldEnds method
  void testWorldEnds(Tester t) {
    initData();
    // when the world has not ended
    t.checkExpect(this.world1.worldEnds(), new WorldEnd(false, this.world1.makeScene()));
    // when the world has ended
    this.world2.onMouseClicked(new Posn(245, 245), "LeftButton");
    t.checkExpect(this.world2.worldEnds(), new WorldEnd(true, this.world2.winScene()));
  }
  
  // test the winScene method
  boolean testWinScene(Tester t) {
    initData();
    WorldScene s = new WorldScene(150, 150);
    s.placeImageXY(new TextImage("YOU WIN!!", 15, Color.CYAN), 75, 75);
    return t.checkExpect(this.world1.winScene(), s);
  }
  
  // test the allLit method
  void testAllLit(Tester t) {
    initData();
    // when all of the pieces are not lit
    t.checkExpect(this.world1.allLit(), false);
    // when all of the pieces are lit
    this.world2.onMouseClicked(new Posn(245, 245), "LeftButton");
    t.checkExpect(this.world2.allLit(), true);
  }
  
  
  // play game here
  // play the gameWorld here
  void testBigBang(Tester t) {
    initData();
    int worldWidth = 500;
    int worldHeight = 500;
    this.world2.bigBang(worldWidth, worldHeight, 1);
  }
   
}













