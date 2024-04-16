import java.awt.Color;
import java.util.Random;

import javalib.funworld.WorldScene;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import tester.Tester;

// tests all of the methods from the various classes
class ExamplesZType {
  //IWord(s) (to be put into ILoWord)
  IWord bounce = new ActiveWord("Bounce", 50, 50);
  IWord fly = new ActiveWord("fly", 60, 40);
  IWord empty = new ActiveWord("", 20, 20);
  IWord a = new ActiveWord("a", 20, 20);
  IWord aptly = new ActiveWord("aptly", 15, 5);
 
  IWord sit = new InactiveWord("Sit", 20, 30);
  IWord still = new InactiveWord("still", 25, 10);
  IWord empty2 = new InactiveWord("", 20, 35);
 
  // IWord(s) using the seeded randomness aspects; 
  // ActiveWord will never really the random word generator, as such the tests reflects that
  IWord iRandom1 = new InactiveWord(30, new Random(4), new Random(15));
  IWord iRandom2 = new InactiveWord(50, new Random(50), new Random(500));
 
  // ILoWord(s) (to be put into ZTYpeWorld)
  ILoWord emptyLo = new MtLoWord();
  ILoWord singleActive = new ConsLoWord(this.bounce, this.emptyLo);
  ILoWord singleInactive = new ConsLoWord(this.sit, this.emptyLo);
 
  ILoWord list = new ConsLoWord(this.still, this.singleActive);
  ILoWord listWEmpty = new ConsLoWord(this.empty2, this.list);
 
  // single letter
  ILoWord singleLetter = new ConsLoWord(this.a, new ConsLoWord(this.still, this.emptyLo));
  
  // there is a random word in the list
  ILoWord randList = new ConsLoWord(this.iRandom1, this.singleActive);
 
  // Examples of ZTypeWorld
  ZTypeWorld emptyW = new ZTypeWorld(this.emptyLo, 0);
  ZTypeWorld first = new ZTypeWorld(this.list, 0);
  ZTypeWorld withEmpty = new ZTypeWorld(this.listWEmpty, 0);
  ZTypeWorld randZ = new ZTypeWorld(this.randList, 0);
 
  
  
  // testers for IWord
  // tests reduceHelper method
  boolean testReduceHelper(Tester t) {
    return
        // an active word whose start matches the string
        t.checkExpect(this.bounce.reduceHelper("B"), new ActiveWord("ounce", 50, 50))
        // an active word whose start does not match the string
        && t.checkExpect(this.bounce.reduceHelper("b"), new ActiveWord("Bounce", 50, 50))
        // an inactive word
        && t.checkExpect(this.sit.reduceHelper("B"), this.sit);
  }
  
  // tests isEqual method
  boolean testIsEqual(Tester t) {
    return 
        // active word, word is equal to string
        t.checkExpect(this.bounce.isEqual("Bounce"), true)
        // active word, word is not equal to string
        && t.checkExpect(this.bounce.isEqual("ounce"), false)
        // inactive word, word is equal to string
        && t.checkExpect(this.still.isEqual("still"), true)
        // inactive word, word is not equal to string
        && t.checkExpect(this.still.isEqual("bleh"), false);
  }
  
  // tests substringEqual method
  boolean testSubstringEqual(Tester t) {
    return 
        // test active word; substring is equal
        t.checkExpect(this.bounce.substringEqual("B"), true)
        // test inactive word; substring is equal
        && t.checkExpect(this.still.substringEqual("s"), true)
        // test active word; substring is not equal
        && t.checkExpect(this.bounce.substringEqual("l"), false)
        // test inactive word; substring is not equal
        && t.checkExpect(this.still.substringEqual("l"), false);
  }
  
  // tests toActive method
  boolean testToActive(Tester t) {
    return 
        // trying on an active word; returns the same active word
        t.checkExpect(this.bounce.toActive(), this.bounce)
        // trying on an inactive word; should be the same except an active word
        && t.checkExpect(this.sit.toActive(), new ActiveWord("Sit", 20, 30));
  }

  // tests isActive method
  boolean testIsActive(Tester t) {
    return 
        // invoking on an active word; returns true
        t.checkExpect(this.bounce.isActive(), true)
        // invoking on an inactive word; returns false
        && t.checkExpect(this.still.isActive(), false);
  }
  
  // tests moveHelp method
  boolean testMoveHelp(Tester t) {
    return 
        // invoking on an active word
        t.checkExpect(this.bounce.moveHelp(), new ActiveWord("Bounce", 50, 65))
        // invoking on an inactive word
        && t.checkExpect(this.still.moveHelp(), new InactiveWord("still", 25, 25));
  }
  
  // tests atBottom method
  boolean testAtBottom(Tester t) {
    return 
        // active word; has not reached the bottom
        t.checkExpect(this.bounce.atBottom(), false)
        // inactive word; has not reached the bottom
        && t.checkExpect(this.still.atBottom(), false)
        // active word; has reached the bottom
        && t.checkExpect(new ActiveWord("jump", 120, 550).atBottom(), true)
        // inactive word; has reached the bottom
        && t.checkExpect(new InactiveWord("jump", 120, 550).atBottom(), true)
        // randomseeded word (inactive); has not reached the bottom
        && t.checkExpect(this.iRandom1.atBottom(), false);
  }
  
  // tests wordToImage method
  boolean testWordToImage(Tester t) {
    WorldScene w = new WorldScene(380, 500);
    return 
        // drawing out an empty active word
        t.checkExpect(this.empty.wordToImage(w), w.placeImageXY(
            new TextImage("", 15, Color.RED), 20, 20))
        // drawing out an empty inactive word
        && t.checkExpect(this.empty.wordToImage(w), w.placeImageXY(
            new TextImage("", 15, Color.BLUE), 20, 35))
        // drawing out an inactive word
        && t.checkExpect(this.bounce.wordToImage(w), w.placeImageXY(
            new TextImage("Bounce", 15, Color.RED), 50, 50))
        // drawing out an active word
        && t.checkExpect(this.sit.wordToImage(w), w.placeImageXY(
            new TextImage("Sit", 15, Color.BLUE), 20, 30))
        // drawing out a randomized word
        && t.checkExpect(this.iRandom1.wordToImage(w), w.placeImageXY(
            new TextImage("nmonto", 15, Color.BLUE), 277, 30))
        && t.checkExpect(this.iRandom2.wordToImage(w), w.placeImageXY(
            new TextImage("xomanp", 15, Color.BLUE), 132, 50));
  }
  
  // tests the creation of a random string of words
  boolean testUtils(Tester t) {
    return 
        // creates a word of length 6
        t.checkExpect(new Utils().createWord("", new Random(4)), "qsnwfp")
        && t.checkExpect(new Utils().createWord("", new Random(50)), "lgtapf")
        // what if there was a word already inputed
        && t.checkExpect(new Utils().createWord("ap", new Random(6)), "aprgsw")
        // what if there was a 6 letter word already inputed
        && t.checkExpect(new Utils().createWord("orange", new Random(4)), "orange");
  }
  
  
  
  // testers for ILoWord
  // tests the checkAndReduce method
  boolean testCheckAndReduce(Tester t) {
    return 
        // an empty list, nothing to do
        t.checkExpect(this.emptyLo, this.emptyLo)
        // there are no active words in the list; an inactive word has been turned active
        // and reduced
        && t.checkExpect(this.singleInactive.checkAndReduce("S"), 
            new ConsLoWord(new ActiveWord("it", 20, 30), this.emptyLo))
        // there are active words, but the string doesn't match any of them
        && t.checkExpect(this.list.checkAndReduce("s"), this.list)
        // there are active words and the string matches one
        && t.checkExpect(this.singleActive.checkAndReduce("B"), 
            new ConsLoWord(new ActiveWord("ounce", 50, 50), this.emptyLo))
        // uppercase vs lowercase, not the same
        && t.checkExpect(this.singleActive.checkAndReduce("b"), this.singleActive)
        // there are empty words contained in the list
        && t.checkExpect(this.listWEmpty.checkAndReduce("r"), this.listWEmpty)
        // the active word is a single letter, which is the same as the string
        && t.checkExpect(this.singleLetter.checkAndReduce("a"), new ConsLoWord(this.empty, 
            new ConsLoWord(this.still, this.emptyLo)));
  }
  
  // tests the reduceHelper method
  boolean testReduceHelperILoWord(Tester t) {
    return 
        // empty list
        t.checkExpect(this.emptyLo.reduceHelper("s"), this.emptyLo)
        // the list already as an active word; string matches
        && t.checkExpect(this.singleActive.reduceHelper("B"), 
            new ConsLoWord(new ActiveWord("ounce", 50, 50), this.emptyLo))
        // the list already has an active word; string does not match
        && t.checkExpect(this.singleActive.reduceHelper("f"), this.singleActive)
        // the list does not have an active word; string does not match
        && t.checkExpect(this.singleInactive.reduceHelper("f"), this.singleInactive)
        // the list does not have an active word; string matches
        && t.checkExpect(this.singleInactive.reduceHelper("S"), this.singleInactive);
  }
  
  // tests the addToEnd method
  boolean testAddToEnd(Tester t) {
    return 
        // invoked on an empty list; add an active IWord
        t.checkExpect(this.emptyLo.addToEnd(this.bounce), this.singleActive)
        // invoked on an empty list; add an inactive IWord
        && t.checkExpect(this.emptyLo.addToEnd(this.sit), this.singleInactive)
        // invoked on non-empty list; add an active IWord
        && t.checkExpect(new ConsLoWord(this.still, this.emptyLo).addToEnd(this.bounce), this.list)
        // invoked on non-empty list; add an inactive IWord
        && t.checkExpect(new ConsLoWord(this.still, this.emptyLo).addToEnd(this.sit), 
            new ConsLoWord(this.still, new ConsLoWord(this.sit, this.emptyLo)));
  }
  
  // tests filterOutEmpties method 
  boolean testFilterOutEmpties(Tester t) {
    return 
        // invoking on an empty list
        t.checkExpect(this.emptyLo.filterOutEmpties(), this.emptyLo)
        // there is only an empty in the lists
        && t.checkExpect(new ConsLoWord(new ActiveWord("", 20, 30), this.emptyLo)
            .filterOutEmpties(), this.emptyLo)
        // there are no empties in the list
        && t.checkExpect(this.list.filterOutEmpties(), this.list)
        // there are empty(s) in the list
        && t.checkExpect(this.listWEmpty.filterOutEmpties(), this.list);
  }
  
  // tests containsActive method
  boolean testContainsActive(Tester t) {
    return 
        // empty list
        t.checkExpect(this.emptyLo.containsActive(), false)
        // list contains an active
        && t.checkExpect(this.list.containsActive(), true)
        // list does not contain an active
        && t.checkExpect(this.singleInactive.containsActive(), false);
  }
  
  // tests changeToActive method
  boolean testChangeToActive(Tester t) {
    return
        // empty list
        t.checkExpect(this.emptyLo.changeToActive("s"), this.emptyLo)
        // the list already as an active word; string matches
        && t.checkExpect(this.singleActive.changeToActive("B"), 
            new ConsLoWord(new ActiveWord("ounce", 50, 50), this.emptyLo))
        // the list already has an active word; string does not match
        && t.checkExpect(this.singleActive.changeToActive("f"), this.singleActive)
        // the list does not have an active word; string does not match
        && t.checkExpect(this.singleInactive.changeToActive("f"), this.singleInactive)
        // the list does not have an active word; string matches
        && t.checkExpect(this.singleInactive.changeToActive("S"), 
            new ConsLoWord(new ActiveWord("it", 20, 30), this.emptyLo));
  }
  
  // tests move method
  boolean testMove(Tester t) {
    return 
        // invoked on empty list
        t.checkExpect(this.emptyLo.move(), this.emptyLo)
        // invoked on non-empty list
        && t.checkExpect(this.list.move(), new ConsLoWord(new InactiveWord("still", 25,25), 
            new ConsLoWord(new ActiveWord("Bounce", 50, 65), this.emptyLo)));
  }
  
  // tests reachedBottom method
  boolean testReachedBottom(Tester t) {
    return 
        // the list is empty; returns false
        t.checkExpect(this.emptyLo.reachedBottom(), false)
        // the list does not have an item that has reached the bottom
        && t.checkExpect(this.list.reachedBottom(), false)
        // the list has an item that has reached the bottom
        && t.checkExpect((new ConsLoWord(new ActiveWord("Bounce", 20, 550), 
            this.emptyLo)).reachedBottom(), true);
  }
  
  // tests the draw method
  boolean testDraw(Tester t) {
    WorldScene s = new WorldScene(500, 500);
    return
        // empty world scene
        t.checkExpect(this.emptyLo.draw(s), s)
        // world scene with words
        && t.checkExpect(this.list.draw(s), 
            new WorldScene(500, 500)
            .placeImageXY(new TextImage("still", 15, Color.BLUE), 25, 10)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50))
        // world scene with words and some empty words
        && t.checkExpect(this.listWEmpty.draw(s), 
            new WorldScene(500,500)
            .placeImageXY(new TextImage("", 15, Color.BLUE), 20, 35)
            .placeImageXY(new TextImage("still", 15, Color.BLUE), 25, 10)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50))
        // world scene with a word that was generated randomly
        && t.checkExpect(this.randList.draw(s), 
            new WorldScene(500,500)
            .placeImageXY(new TextImage("nmonto", 15, Color.BLUE), 277, 30)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50));
  }
 
 
 
 
  // testers for ZTypeWorld
  // tests the makeScene method in ZTypeWorld
  boolean testMakeScene(Tester t) {
    return
        // empty world scene
        t.checkExpect(this.emptyW.makeScene(), new WorldScene(380, 500)
            .placeImageXY(new RectangleImage(380, 500, "solid", Color.BLACK),
                380 / 2, 500 / 2))
        // world scene with words
        && t.checkExpect(this.first.makeScene(), 
            new WorldScene(380, 500)
            .placeImageXY(new RectangleImage(380, 500, "solid", Color.BLACK),
                380 / 2, 500 / 2)
            .placeImageXY(new TextImage("still", 15, Color.BLUE), 25, 10)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50))
        // world scene with words and some empty words
        && t.checkExpect(this.withEmpty.makeScene(), 
            new WorldScene(380, 500)
            .placeImageXY(new RectangleImage(380, 500, "solid", Color.BLACK),
                380 / 2, 500 / 2)
            .placeImageXY(new TextImage("still", 15, Color.BLUE), 25, 10)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50))
        && t.checkExpect(this.randZ.makeScene(),
            new WorldScene(380, 500)
            .placeImageXY(new RectangleImage(380, 500, "solid", Color.BLACK),
                380 / 2, 500 / 2)
            .placeImageXY(new TextImage("nmonto", 15, Color.BLUE), 277, 30)
            .placeImageXY(new TextImage("Bounce", 15, Color.RED), 50, 50));
  }
 
  // tests the ZTypeWorld onTickForTesting method
  boolean testOnTickForTesting(Tester t) {
    return 
        // when the world is empty, and the tick is not a multiple of 3
        t.checkExpect(new ZTypeWorld(this.emptyLo, 2).onTickForTesting(), 
            new ZTypeWorld(this.emptyLo, 3))
        // when the world is empty, and the tick is a multiple of 3
        && t.checkExpect(new ZTypeWorld(this.emptyLo, 3).onTickForTesting(), 
            new ZTypeWorld(new ConsLoWord(new InactiveWord("attlww", 18, 15), this.emptyLo), 4))
        // when the world is not empty, and the tick is a multiple of 3
        && t.checkExpect(this.first.onTickForTesting(), new ZTypeWorld(
            new ConsLoWord(new InactiveWord("still", 25, 25), new ConsLoWord(
                new ActiveWord("Bounce", 50, 65), new ConsLoWord(
                    new InactiveWord("attlww", 18, 15), this.emptyLo))), 1))
        // when the world is not empty, and the tick is not a multiple of 3
        && t.checkExpect(new ZTypeWorld(this.singleActive, 2).onTickForTesting(), 
            new ZTypeWorld(new ConsLoWord(new ActiveWord("Bounce", 50, 65), this.emptyLo), 3));
  }
  
  // tests the onKeyEvent method
  boolean testOnKeyEvent(Tester t) {
    return
        // empty list; stays empty
        t.checkExpect(this.emptyW.onKeyEvent("f"), this.emptyW)
        // inactive list of words, key not equal
        && t.checkExpect(new ZTypeWorld(this.singleInactive, 4).onKeyEvent("l"),
            new ZTypeWorld(this.singleInactive, 4))
        // inactive list of words, a key is equal; a word should turn active and be reduced
        && t.checkExpect(new ZTypeWorld(this.singleInactive, 4).onKeyEvent("S"),
            new ZTypeWorld(new ConsLoWord(new ActiveWord("it", 20, 30), this.emptyLo), 4))
        // active in list, key is not equal
        && t.checkExpect(new ZTypeWorld(this.singleActive, 4).onKeyEvent("l"),
            new ZTypeWorld(this.singleActive, 4))
        // active in list, key is equal
        && t.checkExpect(new ZTypeWorld(this.singleActive, 4).onKeyEvent("B"),
            new ZTypeWorld(new ConsLoWord(new ActiveWord("ounce", 50, 50), this.emptyLo), 4))
        // if there is an empty word within the list, it will be filtered out
        && t.checkExpect(this.withEmpty.onKeyEvent("l"), this.first);
  }
  
  // tests the WorldEnds method
  boolean testWorldEnds(Tester t) {
    return 
        // world is empty
        t.checkExpect(this.emptyW.worldEnds(), new WorldEnd(false, this.emptyW.makeScene()))
        // world does not have a word that has reached the bottom
        && t.checkExpect(this.first.worldEnds(), new WorldEnd(false, this.first.makeScene()))
        // world contains a list that has reached the bottom
        && t.checkExpect(new ZTypeWorld(new ConsLoWord(
            new ActiveWord("flick", 30, 550), this.singleInactive), 4).worldEnds(), 
            new WorldEnd(true, new ZTypeWorld(new ConsLoWord(
                new ActiveWord("flick", 30, 550), this.singleInactive), 4).makeAFinalScene()));
  }
  
  // tests the makeAFinalScene method
  boolean testMakeAFinalScene(Tester t) {
    return 
        // when the finalScene is called
        t.checkExpect(this.first.makeAFinalScene(),
            new WorldScene(380, 500)
            .placeImageXY(new RectangleImage(380, 500, "solid", Color.BLACK),
                380 / 2, 500 / 2)
            .placeImageXY(new TextImage("GAME", 100, Color.white), 380 / 2, 500 / 2 - 50)
            .placeImageXY(new TextImage("OVER", 100, Color.white), 380 / 2, 500 / 2 + 50));
  }
  
  // play the gameWorld here
  boolean testBigBang(Tester t) {
    ZTypeWorld world = new ZTypeWorld(this.emptyLo, 0);
    int worldWidth = 380;
    int worldHeight = 500;
    double tickRate = 0.5;
    return world.bigBang(worldWidth, worldHeight, tickRate);
  }
}