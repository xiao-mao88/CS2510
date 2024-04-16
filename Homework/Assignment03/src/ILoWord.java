import java.awt.Color;
import javalib.worldimages.*;
import javalib.funworld.*;
import javalib.worldcanvas.WorldCanvas;
import tester.Tester;


//represents a list of words
interface ILoWord {
  ILoWord sort(); // sorts this list of words
  
  boolean isSorted(); // checks if this list of words is sorted
  
  ILoWord interleave(ILoWord that); // merges this list and that list alternating
  
  ILoWord merge(ILoWord that); // merges this sorted list with that sorted list sorted
  
  ILoWord checkAndReduce(String str); // reduces any active word in this list that 
  // has the same start as the string
  
  ILoWord addToEnd(IWord word); // adds a word to the end of this list of words
  
  ILoWord filterOutEmpties(); // filters out empty strings from this list of words
  
  WorldScene draw(WorldScene w); // draws this list of words into a world scene
  
  // helper methods
  ILoWord insert(IWord w); // helper for sort method; inserts this word into this list
  
  boolean isSortedHelper(boolean s, IWord w); // helper for isSorted method
  
  ILoWord mergeHelper(IWord w, ILoWord that); // helper for merge method
}


//represents an empty list of words
class MtLoWord implements ILoWord {
  /*  TEMPLATE 
  Fields:
  ...
  Methods:
  ... this.sort() ...                          -- ILoWord 
  ... this.isSorted() ...                      -- boolean
  ... this.interleave(ILoWord) ...             -- ILoWord
  ... this.merge(ILoWord) ...                  -- ILoWord
  ... this.checkAndReduce(String) ...          -- ILoWord
  ... this.addToEnd(IWord) ...                 -- ILoWord
  ... this.filterOutEmpties() ...              -- ILoWord
  ... this.draw(WorldScene) ...                -- WorldScene
  ... this.isSortedHelper(boolean, IWord) ...  -- boolean
  ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
  Methods for Fields:
  ...
  */
  
  // sorts this list of words
  public ILoWord sort() {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return this;
  }
  
  // checks if this list of words is sorted
  public boolean isSorted() {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return true;
  }
  
  // merges this list and that list alternating
  public ILoWord interleave(ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... that.sort() ...                      -- ILoWord 
    ... that.isSorted() ...                  -- boolean
    ... that.interleave(ILoWord) ...         -- ILoWord
    ... that.merge(ILoWord) ...              -- ILoWord
    ... that.checkAndReduce(String) ...      -- ILoWord
    ... that.addToEnd(IWord) ...             -- ILoWord
    ... that.filterOutEmpties() ...          -- ILoWord
    ... that.draw(WorldScene) ...            -- WorldScene
    */
    return that;
  }
  
  // merges this sorted list with that sorted list sorted
  public ILoWord merge(ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... that.sort() ...                          -- ILoWord 
    ... that.isSorted() ...                      -- boolean
    ... that.interleave(ILoWord) ...             -- ILoWord
    ... that.merge(ILoWord) ...                  -- ILoWord
    ... that.checkAndReduce(String) ...          -- ILoWord
    ... that.addToEnd(IWord) ...                 -- ILoWord
    ... that.filterOutEmpties() ...              -- ILoWord
    ... that.draw(WorldScene) ...                -- WorldScene
    ... that.isSortedHelper(boolean, IWord) ...  -- boolean
    ... that.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    */
    return that;
  }
  
  // reduces any active word in this list that has the same start as the string
  public ILoWord checkAndReduce(String str) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return new MtLoWord();
  }
  
  // adds an IWord to the end of this list
  public ILoWord addToEnd(IWord word) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... word.compareWords(IWord) ...       -- boolean
    ... word.compareHelper(String) ...     -- boolean
    ... word.isEqual(String) ...           -- boolean
    ... word.reduceHelper(String) ...      -- IWord
    ... word.wordToImage(WorldScene) ...   -- WorldScene
    */
    return new ConsLoWord(word, new MtLoWord());
  }

  // filters out any words with empty strings in this list
  public ILoWord filterOutEmpties() {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return new MtLoWord();
  }
    
  // draws the WorldScene by converting this list of words into images
  public WorldScene draw(WorldScene w) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return w;
  }
  
  // helper functions
  // inserts the given word into this sorted list of words 
  public ILoWord insert(IWord w) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... word.compareWords(IWord) ...       -- boolean
    ... word.compareHelper(String) ...     -- boolean
    ... word.isEqual(String) ...           -- boolean
    ... word.reduceHelper(String) ...      -- IWord
    ... word.wordToImage(WorldScene) ...   -- WorldScene
    */
    return new ConsLoWord(w, this);
  }
  
  // helper for isSorted method, determines if this list of words is sorted or not
  // ACCUMULATOR: Contains the boolean value of whether the list is sorted or not
  public boolean isSortedHelper(boolean s, IWord w) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... word.compareWords(IWord) ...       -- boolean
    ... word.compareHelper(String) ...     -- boolean
    ... word.isEqual(String) ...           -- boolean
    ... word.reduceHelper(String) ...      -- IWord
    ... word.wordToImage(WorldScene) ...   -- WorldScene
    */
    return s;
  }
  
  // Helps to merge this list and that
  public ILoWord mergeHelper(IWord w, ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ...
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... w.compareWords(IWord) ...       -- boolean
    ... w.compareHelper(String) ...     -- boolean
    ... w.isEqual(String) ...           -- boolean
    ... w.reduceHelper(String) ...      -- IWord
    ... w.wordToImage(WorldScene) ...   -- WorldScene
    
    ... that.sort() ...                          -- ILoWord 
    ... that.isSorted() ...                      -- boolean
    ... that.interleave(ILoWord) ...             -- ILoWord
    ... that.merge(ILoWord) ...                  -- ILoWord
    ... that.checkAndReduce(String) ...          -- ILoWord
    ... that.addToEnd(IWord) ...                 -- ILoWord
    ... that.filterOutEmpties() ...              -- ILoWord
    ... that.draw(WorldScene) ...                -- WorldScene
    ... that.isSortedHelper(boolean, IWord) ...  -- boolean
    ... that.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    */
    return new ConsLoWord(w, that);
  }
}


// represents a list of words
class ConsLoWord implements ILoWord {
  IWord first;
  ILoWord rest;

  ConsLoWord(IWord first, ILoWord rest) {
    this.first = first;
    this.rest = rest;
  }
  
  /*  TEMPLATE 
  Fields:
  ... this.first ...        -- IWord
  ... this.rest  ...        -- ILoWord
  Methods:
  ... this.sort() ...                          -- ILoWord 
  ... this.isSorted() ...                      -- boolean
  ... this.interleave(ILoWord) ...             -- ILoWord
  ... this.merge(ILoWord) ...                  -- ILoWord
  ... this.checkAndReduce(String) ...          -- ILoWord
  ... this.addToEnd(IWord) ...                 -- ILoWord
  ... this.filterOutEmpties() ...              -- ILoWord
  ... this.draw(WorldScene) ...                -- WorldScene
  ... this.isSortedHelper(boolean, IWord) ...  -- boolean
  ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
  Methods for Fields:
  ... this.first.compareWords(IWord) ...       -- boolean
  ... this.first.compareHelper(String) ...     -- boolean
  ... this.first.isEqual(String) ...           -- boolean
  ... this.first.reduceHelper(String) ...      -- IWord
  ... this.first.wordToImage(WorldScene) ...   -- WorldScene
  
  ... this.rest.sort() ...                          -- ILoWord 
  ... this.rest.isSorted() ...                      -- boolean
  ... this.rest.interleave(ILoWord) ...             -- ILoWord
  ... this.rest.merge(ILoWord) ...                  -- ILoWord
  ... this.rest.checkAndReduce(String) ...          -- ILoWord
  ... this.rest.addToEnd(IWord) ...                 -- ILoWord
  ... this.rest.filterOutEmpties() ...              -- ILoWord
  ... this.rest.draw(WorldScene) ...                -- WorldScene
  ... this.rest.isSortedHelper(boolean, IWord) ...  -- boolean
  ... this.rest.mergeHelper(IWord, ILoWord) ...     -- ILoWord
  */
    
  // sorts this list of words
  public ILoWord sort() {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ...
    */
    return this.rest.sort().insert(this.first);
  }
    
  // checks if this list of words is sorted
  public boolean isSorted() {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ...
    */
    return this.isSortedHelper(true, this.first);
  }
   
  // merges this list and that list alternating
  public ILoWord interleave(ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... that.sort() ...                          -- ILoWord 
    ... that.isSorted() ...                      -- boolean
    ... that.interleave(ILoWord) ...             -- ILoWord
    ... that.merge(ILoWord) ...                  -- ILoWord
    ... that.checkAndReduce(String) ...          -- ILoWord
    ... that.addToEnd(IWord) ...                 -- ILoWord
    ... that.filterOutEmpties() ...              -- ILoWord
    ... that.draw(WorldScene) ...                -- WorldScene
    ... that.isSortedHelper(boolean, IWord) ...  -- boolean
    ... that.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    */
    return new ConsLoWord(this.first, that.interleave(this.rest));  
  }
    
  // merges this sorted list and that sorted list into a sorted list
  public ILoWord merge(ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... that.sort() ...                          -- ILoWord 
    ... that.isSorted() ...                      -- boolean
    ... that.interleave(ILoWord) ...             -- ILoWord
    ... that.merge(ILoWord) ...                  -- ILoWord
    ... that.checkAndReduce(String) ...          -- ILoWord
    ... that.addToEnd(IWord) ...                 -- ILoWord
    ... that.filterOutEmpties() ...              -- ILoWord
    ... that.draw(WorldScene) ...                -- WorldScene
    ... that.isSortedHelper(boolean, IWord) ...  -- boolean
    ... that.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    */
    return that.mergeHelper(this.first, this.rest);
  }
    
  // reduces any active word in this list that has the same start as the string
  public ILoWord checkAndReduce(String str) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... 
    */
    return new ConsLoWord(this.first.reduceHelper(str), this.rest.checkAndReduce(str));
  }
  
  // adds an IWord to the end of this list
  public ILoWord addToEnd(IWord word) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... word.first.compareWords(IWord) ...       -- boolean
    ... word.first.compareHelper(String) ...     -- boolean
    ... word.first.isEqual(String) ...           -- boolean
    ... word.first.reduceHelper(String) ...      -- IWord
    ... word.first.wordToImage(WorldScene) ...   -- WorldScene
    */
    return new ConsLoWord(this.first, this.rest.addToEnd(word));
  }
  
  // filters out any words with an empty string in this list
  public ILoWord filterOutEmpties() {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ...
    */
    if (this.first.isEqual("")) {
      return this.rest.filterOutEmpties();
    }
    else {
      return new ConsLoWord(this.first, this.rest.filterOutEmpties());
    }
  }
  
  // draws the WorldScene by converting this list of words into images
  public WorldScene draw(WorldScene w) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
    */
    return this.rest.draw(this.first.wordToImage(w));
  }
  
  // various helper methods
  // inserts the given word into this sorted list of words
  public ILoWord insert(IWord w) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... w.first.compareWords(IWord) ...       -- boolean
    ... w.first.compareHelper(String) ...     -- boolean
    ... w.first.isEqual(String) ...           -- boolean
    ... w.first.reduceHelper(String) ...      -- IWord
    ... w.first.wordToImage(WorldScene) ...   -- WorldScene
    */
    if (w.compareWords(this.first)) {
      return new ConsLoWord(w, this);
    } 
    
    else {
      return new ConsLoWord(this.first, this.rest.insert(w));
    }
  }
  
  // helper for isSorted method, determines if this list of words is sorted
  // ACCUMULATOR: contains the boolean value of whether this list is sorted or not
  public boolean isSortedHelper(boolean s, IWord w) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... w.first.compareWords(IWord) ...       -- boolean
    ... w.first.compareHelper(String) ...     -- boolean
    ... w.first.isEqual(String) ...           -- boolean
    ... w.first.reduceHelper(String) ...      -- IWord
    ... w.first.wordToImage(WorldScene) ...   -- WorldScene
    */
    if (w.compareWords(this.first)) {
      return this.rest.isSortedHelper(true, this.first);
    }
    else {
      return false;
    }
  }
    
  // helper for merge method
  public ILoWord mergeHelper(IWord w, ILoWord that) {
    /*  TEMPLATE 
    Fields:
    ... this.first ...        -- IWord
    ... this.rest  ...        -- ILoWord
    Methods:
    ... this.sort() ...                          -- ILoWord 
    ... this.isSorted() ...                      -- boolean
    ... this.interleave(ILoWord) ...             -- ILoWord
    ... this.merge(ILoWord) ...                  -- ILoWord
    ... this.checkAndReduce(String) ...          -- ILoWord
    ... this.addToEnd(IWord) ...                 -- ILoWord
    ... this.filterOutEmpties() ...              -- ILoWord
    ... this.draw(WorldScene) ...                -- WorldScene
    ... this.isSortedHelper(boolean, IWord) ...  -- boolean
    ... this.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    Methods for Fields:
    ... same as before ...
    Fields of Parameters
    ...
    Methods on Parameters:
    ... w.first.compareWords(IWord) ...       -- boolean
    ... w.first.compareHelper(String) ...     -- boolean
    ... w.first.isEqual(String) ...           -- boolean
    ... w.first.reduceHelper(String) ...      -- IWord
    ... w.first.wordToImage(WorldScene) ...   -- WorldScene
    
    ... that.sort() ...                          -- ILoWord 
    ... that.isSorted() ...                      -- boolean
    ... that.interleave(ILoWord) ...             -- ILoWord
    ... that.merge(ILoWord) ...                  -- ILoWord
    ... that.checkAndReduce(String) ...          -- ILoWord
    ... that.addToEnd(IWord) ...                 -- ILoWord
    ... that.filterOutEmpties() ...              -- ILoWord
    ... that.draw(WorldScene) ...                -- WorldScene
    ... that.isSortedHelper(boolean, IWord) ...  -- boolean
    ... that.mergeHelper(IWord, ILoWord) ...     -- ILoWord
    */
    if (w.compareWords(this.first)) {
      return new ConsLoWord(w, that.merge(this));
    }
    
    else {
      ILoWord list = new ConsLoWord(w, that);
      return new ConsLoWord(this.first, list.merge(this.rest));
    }
  }

}



// represents a word in the ZType game
interface IWord {  
  boolean compareWords(IWord w); // compares this IWord's word and that IWord's word
  
  boolean compareHelper(String s); // helps to compare the word of this IWord and the String
  
  boolean isEqual(String s); // checks if this word's word is equal to the String
  
  IWord reduceHelper(String str); // reduces this word by the string if this word's beginning and 
  // the string are the same and this word is an active word 
  
  
  
  WorldScene wordToImage(WorldScene w); // returns the word as an image
}

// represents an active word in the ZType game
class ActiveWord implements IWord {
  String word;
  int x;
  int y;

  ActiveWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }
  
  /* Template
  Fields: 
  ... this.word ...        -- String
  ... this.x    ...        -- int
  ... this.y    ...        -- int
  Methods:
  ... this.compareWords(IWord) ...       -- boolean
  ... this.compareHelper(String) ...     -- boolean
  ... this.isEqual(String) ...           -- boolean
  ... this.reduceHelper(String) ...      -- IWord
  ... this.wordToImage(WorldScene) ...   -- WorldScene
  Methods for Fields:
  ...   
   */
    
  // compares this IWord's word and that IWord's word
  public boolean compareWords(IWord w) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... w.compareWords(IWord) ...       -- boolean
    ... w.compareHelper(String) ...     -- boolean
    ... w.isEqual(String) ...           -- boolean
    ... w.reduceHelper(String) ...      -- IWord
    ... w.wordToImage(WorldScene) ...   -- WorldScene
     */
    return w.compareHelper(this.word);
  }
    
  // compares this IWord's word and the String
  public boolean compareHelper(String s) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    return s.toLowerCase().compareTo(this.word.toLowerCase()) <= 0;
  }
   
  // checks if this word's word is equal to the string
  public boolean isEqual(String s) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
     */
    return this.word.equals(s);
  }
    
  // reduces this word by the string if this word's beginning and the 
  // string are the same and this word is an active word 
  public IWord reduceHelper(String str) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    int length = this.word.length();
    if (length > 1 && this.word.substring(0, 1).equals(str)) {
      return new ActiveWord(this.word.substring(1, length), this.x, this.y);
    }
    else if (length == 1 && this.word.substring(0, 1).equals(str)) {
      return new ActiveWord("", this.x, this.y);
    }
    else {
      return this;
    }
  }
  
  // returns the word as an image in a WorldScene  
  public WorldScene wordToImage(WorldScene w) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ...
     */
    return w.placeImageXY(new TextImage(this.word, 15, Color.BLUE), this.x, this.y);
  }
}

// represents an inactive word in the ZType game
class InactiveWord implements IWord {
  String word;
  int x;
  int y;
  
  InactiveWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }
  
  /* Template
  Fields: 
  ... this.word ...        -- String
  ... this.x    ...        -- int
  ... this.y    ...        -- int
  Methods:
  ... this.compareWords(IWord) ...       -- boolean
  ... this.compareHelper(String) ...     -- boolean
  ... this.isEqual(String) ...           -- boolean
  ... this.reduceHelper(String) ...      -- IWord
  ... this.wordToImage(WorldScene) ...   -- WorldScene
  Methods for Fields:
  ...   
   */
    
  // compares this IWord's word and that IWord's word
  public boolean compareWords(IWord w) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... w.compareWords(IWord) ...       -- boolean
    ... w.compareHelper(String) ...     -- boolean
    ... w.isEqual(String) ...           -- boolean
    ... w.reduceHelper(String) ...      -- IWord
    ... w.wordToImage(WorldScene) ...   -- WorldScene
     */
    return w.compareHelper(this.word);
  }
  
  // helps to compare the word of this IWord and the String 
  public boolean compareHelper(String s) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    return s.toLowerCase().compareTo(this.word.toLowerCase()) <= 0;
  }
    
  // checks if this word's word is equal to the string
  public boolean isEqual(String s) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    return this.word.equals(s);
  }
  
  // reduces this word by the string if this word's beginning and the 
  // string are the same and this word is an active word 
  public IWord reduceHelper(String str) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    return this;
  }
    
  // returns the word as an image in a WorldScene
  public WorldScene wordToImage(WorldScene w) {
    /* Template
    Fields: 
    ... this.word ...        -- String
    ... this.x    ...        -- int
    ... this.y    ...        -- int
    Methods:
    ... this.compareWords(IWord) ...       -- boolean
    ... this.compareHelper(String) ...     -- boolean
    ... this.isEqual(String) ...           -- boolean
    ... this.reduceHelper(String) ...      -- IWord
    ... this.wordToImage(WorldScene) ...   -- WorldScene
    Methods for Fields:
    ...   
    Fields of Parameters:
    ...
    Methods on Parameters:
    ... 
     */
    return w.placeImageXY(new TextImage(this.word, 15, Color.RED), this.x, this.y);
  }
}



// all examples and tests for ILoWord
class ExamplesWordLists {
  // examples of IWord
  IWord bounce = new ActiveWord("Bounce", 50, 50);
  IWord fly = new ActiveWord("fly", 60, 40);
  IWord empty = new ActiveWord("", 20, 20);
  IWord a = new ActiveWord("a", 20, 20);
  IWord aptly = new ActiveWord("aptly", 15, 5);
  
  IWord sit = new InactiveWord("Sit", 20, 30);
  IWord still = new InactiveWord("still", 25, 10);
  IWord empty2 = new InactiveWord("", 20, 35);
  
  // examples of ILoWord
  ILoWord emptyLo = new MtLoWord();
  ILoWord singleActive = new ConsLoWord(bounce, emptyLo);
  ILoWord singleInactive = new ConsLoWord(sit, emptyLo);
  
  // sorted list
  ILoWord sorted = new ConsLoWord(this.fly, this.singleInactive);
  ILoWord sorted2 = new ConsLoWord(this.bounce, this.sorted);
  ILoWord sorted4 = new ConsLoWord(this.bounce, this.singleActive);
  // sorted list with duplicated
  ILoWord sorted3 = new ConsLoWord(this.bounce, new ConsLoWord(this.fly, this.sorted));
  // unsorted list
  ILoWord unsorted = new ConsLoWord(fly, new ConsLoWord(this.bounce, this.singleInactive));
  // unsorted list with duplicates
  ILoWord unsorted2 = new ConsLoWord(this.fly, this.unsorted);
  // unsorted list with empty "" entry
  ILoWord unsorted3 = new ConsLoWord(this.empty, this.unsorted);
  
  // merge sorted and sorted2
  ILoWord merge = new ConsLoWord(this.fly, new ConsLoWord(this.sit, this.singleInactive));
  ILoWord merge1 = new ConsLoWord(bounce, new ConsLoWord(fly, merge));
  
  // merge sorted and sorted4
  ILoWord m1 = new ConsLoWord(this.fly, singleInactive);
  ILoWord m = new ConsLoWord(this.bounce, new ConsLoWord(this.bounce, this.m1));
  
  // the aftermath of interleave method when two lists are the same length
  ILoWord sorted2InterleavePt1 = new ConsLoWord(this.sit, this.singleInactive);
  ILoWord sorted2InterleavePt2 = new ConsLoWord(this.fly, 
      new ConsLoWord(this.fly, this.sorted2InterleavePt1));
  ILoWord sorted2InterleavePt3 = new ConsLoWord(this.bounce, 
      new ConsLoWord(this.bounce, this.sorted2InterleavePt2));
  
  // the aftermath of interleave method when this list is longer
  ILoWord thisLonger = new ConsLoWord(this.sit, this.sorted);
  ILoWord thisLonger2 = new ConsLoWord(this.bounce, this.thisLonger);
  
  // list with only empties in it
  ILoWord empties = new ConsLoWord(this.empty, new ConsLoWord(this.empty2, this.emptyLo));
  // list with more than one empty in it
  ILoWord listWEmpty = new ConsLoWord(this.bounce, this.empties);
  
  // list that contains single letter word
  ILoWord singleLetter = new ConsLoWord(this.aptly, 
      new ConsLoWord(this.sit, new ConsLoWord(a, new MtLoWord())));
  // same list above after checkAndReduce method
  IWord ptly = new ActiveWord("ptly", 15, 5);
  ILoWord singleCheck = new ConsLoWord(this.ptly, 
      new ConsLoWord(this.sit, new ConsLoWord(this.empty, new MtLoWord())));
  
  // list with only inactive words
  ILoWord inactive = new ConsLoWord(still, singleInactive);
  
  // tester for sort method
  boolean testSort(Tester t) {
    return 
        // sort an already sorted list
        t.checkExpect(this.sorted2.sort(), sorted2)
        // sort an unsorted list
        && t.checkExpect(this.unsorted.sort(), this.sorted2)
        // sort an empty list
        && t.checkExpect(this.emptyLo.sort(), this.emptyLo)
        // sort an unsorted list with two or more entries that are the same
        && t.checkExpect(this.unsorted2.sort(), this.sorted3)
        // sort an unsorted list containing an empty
        && t.checkExpect(this.unsorted3.sort(), new ConsLoWord(empty, sorted2));
  }
  
  // tester for isSorted method
  boolean testIsSorted(Tester t) {
    return 
        // check if a sorted list is sorted or not
        t.checkExpect(this.sorted2.isSorted(), true)
        // check if an unsorted list is sorted or not
        && t.checkExpect(this.unsorted3.isSorted(), false)
        // check if an empty list is sorted or not (always yes)
        && t.checkExpect(this.emptyLo.isSorted(), true)
        // check if a single word is sorted or not (always yes)
        && t.checkExpect(this.singleActive.isSorted(), true);
  }
    
  // tester for interleave method
  boolean testInterleave(Tester t) {
    return 
        // two empty lists
        t.checkExpect(this.emptyLo.interleave(emptyLo), new MtLoWord())
        // two lists are the same length
        && t.checkExpect(this.sorted2.interleave(this.sorted2), sorted2InterleavePt3)
        // when this list is longer
        && t.checkExpect(this.sorted2.interleave(this.singleInactive), this.thisLonger2)
        // when that list is longer
        && t.checkExpect(this.singleInactive.interleave(this.sorted2),
                         new ConsLoWord(sit, sorted2))
        // invoked by empty on non-empty
        && t.checkExpect(this.emptyLo.interleave(this.sorted2), this.sorted2)
        // invoked by non-empty on empty
        && t.checkExpect(this.sorted2.interleave(emptyLo), this.sorted2);
  }
    
  // tester for merge method
  boolean testMerge(Tester t) {
    return
        // merging two lists of different length together (this is shorter)
        t.checkExpect(this.sorted.merge(this.sorted2), this.merge1)
        // merging two lists of different length together (this is longer)
        && t.checkExpect(this.sorted2.merge(this.sorted), this.merge1)
        // merging two empty lists
        && t.checkExpect(this.emptyLo.merge(this.emptyLo), this.emptyLo)
        // merging an empty list to a nonempty list
        && t.checkExpect(this.sorted.merge(this.emptyLo), this.sorted)
        // merging a nonempty list to an empty list
        && t.checkExpect(this.emptyLo.merge(this.sorted), this.sorted)
        // merging two lists of the same length (also have duplicates)
        && t.checkExpect(this.sorted.merge(this.sorted4), this.m)
        && t.checkExpect(this.sorted4.merge(this.sorted), this.m)
        // merging with empties
        && t.checkExpect(this.empties.merge(this.singleActive), 
            new ConsLoWord(this.empty, new ConsLoWord(this.empty2, this.singleActive)))
        // merging two lists exactly the same
        && t.checkExpect(this.empties.merge(this.empties), 
            new ConsLoWord(empty, new ConsLoWord(empty2, empties)));
  }
    
  // tester for checkAndReduce method
  boolean testCheckAndReduce(Tester t) {
    return 
        // an empty list, nothing to do
        t.checkExpect(this.emptyLo, this.emptyLo)
        // there are no active words in the list; returns the list
        && t.checkExpect(this.sorted2InterleavePt1.checkAndReduce("s"), this.sorted2InterleavePt1)
        // there are active words, but the string doesn't match any of them
        && t.checkExpect(this.sorted3.checkAndReduce("s"), this.sorted3)
        // there are active words and the string matches some; uppercase, same
        && t.checkExpect(this.sorted2.checkAndReduce("B"), 
            new ConsLoWord(new ActiveWord("ounce", 50, 50), this.sorted))
        // uppercase vs lowercase, not the same
        && t.checkExpect(this.sorted2.checkAndReduce("b"), this.sorted2)
        // uppercase vs lowercase, not the same
        && t.checkExpect(this.sorted2.checkAndReduce("F"), this.sorted2)
        // there are empty words contained in the list
        && t.checkExpect(this.unsorted3.checkAndReduce("r"), this.unsorted3)
        // the active word is a single letter, which is the same as the string
        && t.checkExpect(this.singleLetter.checkAndReduce("a"), this.singleCheck)
        // the inactive word in the list matches the single letter
        && t.checkExpect(this.inactive.checkAndReduce("s"), this.inactive);
  }
    
  // tester for AddToEnd method
  boolean testAddToEnd(Tester t) {
    return
        // adding a word to an empty list
        t.checkExpect(this.emptyLo.addToEnd(this.bounce), this.singleActive)
        // adding a value to the end of a nonempty list
        && t.checkExpect(this.singleActive.addToEnd(this.still), 
            new ConsLoWord(bounce, new ConsLoWord(still, emptyLo)));
  }
   
  // tester for filterOutEmpties method
  boolean testFilterOutEmpties(Tester t) {
    return
        // a list without any empties
        t.checkExpect(this.sorted.filterOutEmpties(), this.sorted)
        // a list with only empties in it
        && t.checkExpect(this.empties.filterOutEmpties(), new MtLoWord())
        // a list with one empty in it
        && t.checkExpect(this.unsorted3.filterOutEmpties(), this.unsorted)
        // a list with more than one empty
        && t.checkExpect(this.listWEmpty.filterOutEmpties(), this.singleActive)
        // an empty list
        && t.checkExpect(this.emptyLo.filterOutEmpties(), this.emptyLo);
  }
  
  
  // testers for various helper methods
  // tester for insert method
  boolean testInsert(Tester t) {
    return 
        // invoked by empty list
        t.checkExpect(this.emptyLo.insert(this.bounce), singleActive)
        // the word is before this.first
        && t.checkExpect(this.singleInactive.insert(this.fly), this.sorted)
        // the word is after this.first
        && t.checkExpect(this.singleActive.insert(this.fly), 
            new ConsLoWord(this.bounce, new ConsLoWord(this.fly, this.emptyLo)));
  }
  
  // tester for isSortedHelper method
  boolean testisSortedHelper(Tester t) {
    return 
        // empty list, the boolean says true, should return true
        t.checkExpect(this.emptyLo.isSortedHelper(true, this.bounce), true)
        // empty list, the boolean says false, should return false
        && t.checkExpect(this.emptyLo.isSortedHelper(false, this.bounce), false)
        // the list is sorted, the boolean says false; should return false
        && t.checkExpect(this.sorted3.isSortedHelper(false, this.still), false)
        // the list is unsorted, the boolean says false; should return false
        && t.checkExpect(this.unsorted2.isSortedHelper(false, this.bounce), false)
        // the list is sorted, the boolean says true & IWord in correct order; should return true
        && t.checkExpect(this.sorted3.isSortedHelper(true, this.bounce), true)
        // the list is sorted, the boolean says true & IWord isn't correct order; return false
        && t.checkExpect(this.sorted3.isSortedHelper(true, this.sit), false)
        // the list is unsorted, the boolean says true; should return false
        && t.checkExpect(this.unsorted3.isSortedHelper(true, this.bounce), false);
  } 
  
  // tester for mergeHelper
  boolean testMergeHelper(Tester t) {
    return 
        // different length lists IWord is behind other stuff
        t.checkExpect(this.empties.mergeHelper(this.bounce, this.sorted2),
            new ConsLoWord(this.empty, new ConsLoWord(this.empty2, new ConsLoWord(this.bounce,
                new ConsLoWord(this.bounce, new ConsLoWord(this.fly, this.singleInactive))))))
        // same length lists IWord is behind of other stuff
        && t.checkExpect(this.empties.mergeHelper(this.bounce, this.sorted),
            new ConsLoWord(this.empty, new ConsLoWord(this.empty2, new ConsLoWord(this.bounce,
                new ConsLoWord(this.fly, this.singleInactive)))))
        // invoking this method on empty list with an empty list
        && t.checkExpect(this.emptyLo.mergeHelper(empty, this.emptyLo),
            new ConsLoWord(this.empty, this.emptyLo))
        // invoking this method on non-empty list with an empty list
        && t.checkExpect(this.empties.mergeHelper(empty, this.emptyLo),
            new ConsLoWord(this.empty, empties))
        // invoking this method on empty list with non-empty list
        && t.checkExpect(this.emptyLo.mergeHelper(empty, 
            new ConsLoWord(this.empty2, this.emptyLo)), empties);
        
  }
  
  // tester for compareWords method
  boolean testCompareWords(Tester t) {
    return
        // active word and inactive word-active is before
        t.checkExpect(this.bounce.compareWords(this.still), true)
        // active word and inactive word-inactive is before
        && t.checkExpect(this.fly.compareWords(this.empty2), false)
        // inactive word and active word-active is before
        && t.checkExpect(this.still.compareWords(this.bounce), false)
        // inactive word and active word-inactive is before
        && t.checkExpect(this.empty2.compareWords(this.fly), true)
        // active word and active word-first is before
        && t.checkExpect(this.bounce.compareWords(this.fly), true)
        // active word and active word-second is before
        && t.checkExpect(this.fly.compareWords(this.bounce), false)
        // inactive word and inactive word-first is before
        && t.checkExpect(this.sit.compareWords(this.still), true)
        // inactive word and inactive word-second is before
        && t.checkExpect(this.still.compareWords(this.sit), false)
        // active and active word--they are the same word
        && t.checkExpect(this.bounce.compareWords(this.bounce), true)
        // inactive and inactive word--they are the same word
        && t.checkExpect(this.still.compareWords(this.still), true)
        // active and inactive word--they are the same word
        && t.checkExpect(this.empty.compareWords(this.empty2), true);
  }
  
  // tester for compareHelper method
  boolean testCompareHelper(Tester t) {
    return
        // active word with string that is the same
        t.checkExpect(this.bounce.compareHelper("Bounce"), true)
        // inactive word with string that is the same
        && t.checkExpect(this.still.compareHelper("Still"), true)
        // active word with string that is after
        && t.checkExpect(this.bounce.compareHelper("still"), false)
        // inactive word with string that is after
        && t.checkExpect(this.still.compareHelper("z"), false)
        // active word with string that before
        && t.checkExpect(this.bounce.compareHelper(""), true)
        // inactive word with string that is before
        && t.checkExpect(this.still.compareHelper("bounce"), true);
  }
    
  // tester for isEqual method
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
  
  // tester for reduceHelper method
  boolean testReduceHelper(Tester t) {
    return
        // an active word whose start matches the string
        t.checkExpect(this.bounce.reduceHelper("B"), new ActiveWord("ounce", 50, 50))
        // an active word whose start does not match the string
        && t.checkExpect(this.bounce.reduceHelper("b"), new ActiveWord("Bounce", 50, 50))
        // an inactive word
        && t.checkExpect(this.sit.reduceHelper("B"), this.sit);
  }
    
  // tester for wordToImage method
  boolean testWordToImage(Tester t) {
    WorldScene w = new WorldScene(500, 500);
    return 
        // turns an active empty word into an image
        t.checkExpect(this.empty.wordToImage(w), 
            w.placeImageXY(new TextImage("", 15, Color.BLUE), 20, 20))
        // turns an inactive empty word into an image
        && t.checkExpect(this.empty2.wordToImage(w), 
            w.placeImageXY(new TextImage("", 15, Color.RED), 20, 35))
        // turns an active word into an image
        && t.checkExpect(this.bounce.wordToImage(w),
            w.placeImageXY(new TextImage("Bounce", 15, Color.BLUE), 50, 50))
        // turns an inactive word into an image
        && t.checkExpect(this.sit.wordToImage(w), 
            w.placeImageXY(new TextImage("Sit", 15, Color.RED), 20, 30));
  }
     
  
  // testers for drawing stuff
  // tester for draw method
  boolean testDraw(Tester t) {
    WorldScene s = new WorldScene(500, 500);
    return
        // empty world scene
        t.checkExpect(this.emptyLo.draw(s), s)
        // world scene with words
        && t.checkExpect(this.sorted.draw(s), 
            new WorldScene(500, 500)
            .placeImageXY(new TextImage("fly", 15, Color.BLUE), 60, 40)
            .placeImageXY(new TextImage("Sit", 15, Color.RED), 20, 30))
        // world scene with words and some empty words
        && t.checkExpect(this.listWEmpty.draw(s), 
            new WorldScene(500,500)
            .placeImageXY(new TextImage("Bounce", 15, Color.BLUE), 50, 50));
  }
 
 
  // to run the actual draw method
  boolean testDrawWords(Tester t) {
    WorldCanvas c1 = new WorldCanvas(500, 500);
    WorldScene s1 = new WorldScene(500, 500)
        .placeImageXY(new RectangleImage(500, 500, "solid", Color.BLACK), 250, 250);
    return c1.drawScene(sorted3.draw(s1)) && c1.show();
  }

}