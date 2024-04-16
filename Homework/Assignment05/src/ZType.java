import java.awt.Color;
import java.util.Random;

import javalib.worldimages.*;
import javalib.funworld.*;

// the game world
interface IWorld {
  // constants; represents the height and width of the gameworld
  int DEFAULT_X = 380;
  int DEFAULT_Y = 500;
}

// represents the game world
class ZTypeWorld extends World implements IWorld {
  ILoWord list;
  int tick;
  
  ZTypeWorld(ILoWord list, int tick) {
    this.list = list;
    this.tick = tick;
  }
  
  /*
   * Template:
   * Fields:
   * ... this.list ...        -- ILoWord
   * ... this.tick ...        -- int
   * 
   * Methods:
   * ... this.onTick() ...              -- ZTypeWorld
   * ... this.onTickForTesting() ...    -- ZTypeWorld
   * ... this.makeScene()               -- WorldScene
   * ... this.onKeyEvent() ...          -- ZTypeWorld
   * ... this.worldEnds() ...           -- WorldEnd
   * ... this.makeAFinalScene() ...     -- WorldScene
   * 
   * Methods of Fields:
   * ... this.list.checkAndReduce(String) ...     --ILoWord
   * ... this.list.reduceHelper(String) ...       -- ILoWord
   * ... this.list.addToEnd(IWord) ...            -- ILoWord
   * ... this.list.filterOutEmpties() ...         -- ILoWord
   * ... this.list.containsActive() ...           -- boolean
   * ... this.list.changeToActive(String) ...     -- ILoWord
   * ... this.list.move() ...                     -- ILoWord
   * ... this.list.reachedBottom() ...            -- boolean
   * ... this.list.draw(WorldScene) ...           -- WorldScene
   */
  
  // my wishlist method(s)
  // on tick method -- adds in words & changes positioning of any prexisting words
  public ZTypeWorld onTick() {
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    if ((this.tick % 3) == 0) {
      ILoWord add = this.list.addToEnd(new InactiveWord(0)); 
      return new ZTypeWorld(add.move(), this.tick + 1);
    }
    else {
      return new ZTypeWorld(this.list.move(), this.tick + 1);
    }
  }
  
  // on tick method for testing -- does the same thing as previous on-tick, but has a random-seed
  public ZTypeWorld onTickForTesting() {
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    if ((this.tick % 3) == 0) {
      ILoWord add = this.list.addToEnd(new InactiveWord(0, new Random(20), new Random(40))); 
      return new ZTypeWorld(add.move(), this.tick + 1);
    }
    return new ZTypeWorld(this.list.move(), this.tick + 1);
  }
  
  // on key method -- when there is an active word in the list of words, it will reduce the word
  // by the key hit, if the character is the same as the beginning; if there is no active word it
  // will change the closest (first) word in the list with the same beginning character as the key
  // hit and reduce it while at the same time turning it into an active word
  public ZTypeWorld onKeyEvent(String key) {
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return new ZTypeWorld(this.list.checkAndReduce(key).filterOutEmpties(), this.tick);
  }
  
  // creates what the game board looks like
  public WorldScene makeScene() {    
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    WorldScene s = new WorldScene(DEFAULT_X, DEFAULT_Y)
        .placeImageXY(new RectangleImage(DEFAULT_X, DEFAULT_Y, "solid", Color.BLACK),
            DEFAULT_X / 2, DEFAULT_Y / 2);
    return this.list.draw(s);
  }
  
  // will check if a word has reached the bottom, and if it has, then the world will end
  public WorldEnd worldEnds() {
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    if (this.list.reachedBottom()) {
      return new WorldEnd(true, this.makeAFinalScene());
    }
    else {
      return new WorldEnd(false, this.makeScene());
    }
  }
  
  // the final scene (when the game is over)
  public WorldScene makeAFinalScene() {
    /*
     * Template:
     * Fields:
     * ... this.list ...        -- ILoWord
     * ... this.tick ...        -- int
     * 
     * Methods:
     * ... this.onTick() ...              -- ZTypeWorld
     * ... this.onTickForTesting() ...    -- ZTypeWorld
     * ... this.makeScene()               -- WorldScene
     * ... this.onKeyEvent() ...          -- ZTypeWorld
     * ... this.worldEnds() ...           -- WorldEnd
     * ... this.makeAFinalScene() ...     -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    WorldScene s = new WorldScene(DEFAULT_X, DEFAULT_Y)
        .placeImageXY(new RectangleImage(DEFAULT_X, DEFAULT_Y, "solid", Color.BLACK),
            DEFAULT_X / 2, DEFAULT_Y / 2)
        .placeImageXY(new TextImage("GAME", 100, Color.white), DEFAULT_X / 2, DEFAULT_Y / 2 - 50)
        .placeImageXY(new TextImage("OVER", 100, Color.white), DEFAULT_X / 2, DEFAULT_Y / 2 + 50);
    return s;
  }
  
}

