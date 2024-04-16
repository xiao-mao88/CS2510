import javalib.funworld.*;      // the abstract World class and the big-bang library

//represents a list of words
interface ILoWord {  
  // reduces any active word in this list that has the same start as the string
  // if there are no active word(s) in this list, then will scan through the
  // list of inactive words
  ILoWord checkAndReduce(String str); 
  
  // helper for checkAndReduce() method
  ILoWord reduceHelper(String str);
  
  // adds a word to the end of this list of words
  ILoWord addToEnd(IWord word);
  
  // filters out empty strings from this list of words
  ILoWord filterOutEmpties();
  
  // checks if a list contains an activeWord
  boolean containsActive();
  
  // changes one word in a list of inactive words into an active word
  // if its beginning matches the given string
  ILoWord changeToActive(String str);
  
  // moves all of the words within a list
  ILoWord move();
  
  // checks if there is a word that has reached the bottom
  boolean reachedBottom();
  
  //draws out this list onto a WorldScene
  WorldScene draw(WorldScene w);
}

// represents an empty word
class MtLoWord implements ILoWord {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.checkAndReduce(String) ...     --ILoWord
   * ... this.reduceHelper(String) ...       -- ILoWord
   * ... this.addToEnd(IWord) ...            -- ILoWord
   * ... this.filterOutEmpties() ...         -- ILoWord
   * ... this.containsActive() ...           -- boolean
   * ... this.changeToActive(String) ...     -- ILoWord
   * ... this.move() ...                     -- ILoWord
   * ... this.reachedBottom() ...            -- boolean
   * ... this.draw(WorldScene) ...           -- WorldScene
   * 
   * Methods of Fields:
   * ...
   */
  
  //reduces any active word in this list that has the same start as the string
  // if there are no active word(s) in this list, then will scan through the
  // list of inactive words
  public ILoWord checkAndReduce(String str) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return this;
  }
  
  // helper for checkAndReduce() method
  public ILoWord reduceHelper(String str) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return this;
  }
  
  // adds a word to the end of this list of words
  public ILoWord addToEnd(IWord word) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... word.word ...              -- String
     * ... word.x ...                 -- int
     * ... word.y ...                 -- int
     * 
     * Methods of Parameters:
     * ... word.wordToImage() ...            -- WorldScene
     * ... word.reduceHelper(String) ...     -- IWord
     * ... word.isEqual(String) ...          -- boolean
     * ... word.substringEqual(String) ...   -- boolean
     * ... word.toActive() ...               -- IWord
     * ... word.isActive() ...               -- boolean
     * ... word.moveHelp() ...               -- IWord
     * ... word.atBottom() ...               -- boolean
     */
    return new ConsLoWord(word, new MtLoWord());
  }
  
  // filters out empty strings from this list of words
  public ILoWord filterOutEmpties() {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return this;
  }
  
  // checks if a ILoWord contains any active word
  public boolean containsActive() {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return false;
  }
  
  // changes one word in a list of inactive words into an active word
  // if its beginning matches the given string
  public ILoWord changeToActive(String str) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return this;
  }
  
  // moves all of the words in a list
  public ILoWord move() {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return this;
  }
  
  // checks if there is a word that has reached the bottom
  public boolean reachedBottom() {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return false;
  }
  
  //draws out this list onto a WorldScene
  public WorldScene draw(WorldScene w) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     --ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return w;
  }
}

// represents a word in the list of words
class ConsLoWord implements ILoWord {
  IWord first;
  ILoWord rest;
  
  ConsLoWord(IWord first, ILoWord rest) {
    this.first = first;
    this.rest = rest;
  }
  
  /* Template:
   * Fields:
   * ... this.first ...       -- IWord
   * ... this.rest ...        -- ILoWord
   * 
   * Methods:
   * ... this.checkAndReduce(String) ...     -- ILoWord
   * ... this.reduceHelper(String) ...       -- ILoWord
   * ... this.addToEnd(IWord) ...            -- ILoWord
   * ... this.filterOutEmpties() ...         -- ILoWord
   * ... this.containsActive() ...           -- boolean
   * ... this.changeToActive(String) ...     -- ILoWord
   * ... this.move() ...                     -- ILoWord
   * ... this.reachedBottom() ...            -- boolean
   * ... this.draw(WorldScene) ...           -- WorldScene
   * 
   * Methods of Fields:
   * ... this.first.wordToImage(WorldScene) ...     -- WorldScene
   * ... this.first.reduceHelper(String) ...        -- IWord
   * ... this.first.isEqual(String) ...             -- boolean
   * ... this.first.substringEqual(String) ...      -- boolean
   * ... this.first.toActive() ...                  -- IWord
   * ... this.first.isActive() ...                  -- boolean
   * ... this.first.moveHelp() ...                  -- IWord
   * ... this.first.atBottom() ...                  -- boolean
   * 
   * ... this.rest.checkAndReduce(String) ...     --ILoWord
   * ... this.rest.reduceHelper(String) ...       -- ILoWord
   * ... this.rest.addToEnd(IWord) ...            -- ILoWord
   * ... this.rest.filterOutEmpties() ...         -- ILoWord
   * ... this.rest.containsActive() ...           -- boolean
   * ... this.rest.changeToActive(String) ...     -- ILoWord
   * ... this.rest.move() ...                     -- ILoWord
   * ... this.rest.reachedBottom() ...            -- boolean
   * ... this.rest.draw(WorldScene) ...           -- WorldScene
   */
  
  // reduces any active word in this list that has the same start as the string
  // if there are no active word(s) in this list, then will scan through the
  // list of inactive words
  public ILoWord checkAndReduce(String str) {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    if (this.containsActive()) {
      return this.reduceHelper(str);
    }
    else {
      return this.changeToActive(str);
    }
  }
  
  // helper for the checkAndReduce
  public ILoWord reduceHelper(String str) {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    return new ConsLoWord(this.first.reduceHelper(str), this.rest.reduceHelper(str));
  }
  
  //adds a word to the end of this list of words
  public ILoWord addToEnd(IWord word) {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ... word.word ...               -- String
     * ... word.x ...                  -- int
     * ... word.y ...                  -- int
     * 
     * Methods of Parameters:
     * ... word.wordToImage(WorldScene) ...     -- WorldScene
     * ... word.reduceHelper(String) ...        -- IWord
     * ... word.isEqual(String) ...             -- boolean
     * ... word.substringEqual(String) ...      -- boolean
     * ... word.toActive() ...                  -- IWord
     * ... word.isActive() ...                  -- boolean
     * ... word.moveHelp() ...                  -- IWord
     * ... word.atBottom() ...                  -- boolean
     */
    return new ConsLoWord(this.first, this.rest.addToEnd(word));
  }
  
  // filters out empty strings from this list of words
  public ILoWord filterOutEmpties() {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    if (this.first.isEqual("")) {
      return this.rest.filterOutEmpties();
    }
    else {
      return new ConsLoWord(this.first, this.rest.filterOutEmpties());
    }
  }
  
  // checks if a list contains an active word
  public boolean containsActive() {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    return this.first.isActive() || this.rest.containsActive();
  }
  
  // changes one word in a list of inactive words into an active word
  // if its beginning matches the given string
  public ILoWord changeToActive(String str) {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    if (this.first.substringEqual(str)) {
      return new ConsLoWord(this.first.toActive(), this.rest).checkAndReduce(str);
    }
    else {
      return new ConsLoWord(this.first, this.rest.changeToActive(str));
    }
  }
  
  // moves all of the words in a list
  public ILoWord move() {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    return new ConsLoWord(this.first.moveHelp(), this.rest.move());
  }
  
  //checks if there is a word that has reached the bottom
  public boolean reachedBottom() {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    if (this.first.atBottom()) {
      return true;
    }
    else {
      return this.rest.reachedBottom();
    }
  }
  
  // draws out this list onto a WorldScene
  public WorldScene draw(WorldScene w) {
    /* Template:
     * Fields:
     * ... this.first ...       -- IWord
     * ... this.rest ...        -- ILoWord
     * 
     * Methods:
     * ... this.checkAndReduce(String) ...     -- ILoWord
     * ... this.reduceHelper(String) ...       -- ILoWord
     * ... this.addToEnd(IWord) ...            -- ILoWord
     * ... this.filterOutEmpties() ...         -- ILoWord
     * ... this.containsActive() ...           -- boolean
     * ... this.changeToActive(String) ...     -- ILoWord
     * ... this.move() ...                     -- ILoWord
     * ... this.reachedBottom() ...            -- boolean
     * ... this.draw(WorldScene) ...           -- WorldScene
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
    return this.rest.draw(this.first.wordToImage(w));
  }
}

