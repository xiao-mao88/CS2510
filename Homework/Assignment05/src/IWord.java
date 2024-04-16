import javalib.worldimages.*;   // images, like RectangleImage or OverlayImages
import javalib.funworld.*;      // the abstract World class and the big-bang library
import java.awt.Color;
import java.util.Random;

//utils class; creates 'words'
class Utils {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.createWord(String, Random) ...   -- String
   * 
   * Methods of Fields:
   * ...
   */
  
  // creates a "word"; takes in a random seed (for testing purposes)
  // ACCUMULATOR: continuously adds on a character to a string until that string is of length 6  
  String createWord(String word, Random r) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.createWord(String, Random) ...   -- String
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
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    if (word.length() < 6) {
      char letter = alphabet.charAt(r.nextInt(alphabet.length()));
      return createWord(word + letter, r);
    }
    
    else {
      return word;
    } 
  }
}



// represents a word 
interface IWord {
  // constant(s)
  int DEFAULT_FONT = 15; // represents the font size
  
  // turns this word into an image and places it onto the given worldScene
  WorldScene wordToImage(WorldScene w);
  
  // reduces this word by the string if this word's beginning and the string 
  // are the same and this word is an active word 
  IWord reduceHelper(String str); 
  
  // checks if the given string and this word's word is equal
  boolean isEqual(String str);
  
  // checks if the given string is the same as the beginning of a word
  // given string will always be a single character
  boolean substringEqual(String str);
  
  // changes an InactiveWord to an ActiveWord
  IWord toActive();
  
  // determines whether an IWord is active or inactive
  boolean isActive();
  
  // adds onto the the y-value of the word
  IWord moveHelp();
  
  // determines whether an IWord has reached the bottom
  boolean atBottom();
}

abstract class AWord implements IWord {
  String word; // the word
  int x; // x position of a word
  int y; // y position of a word
  
  /* Template:
   * Fields:
   * ... this.word ...            -- String
   * ... this.x ...               -- int
   * ... this.y ...               -- int
   * 
   * Methods:
   * ... this.isEqual(String) ...            -- boolean
   * ... this.substringEqual(String) ...     -- boolean
   * ... this.toActive() ...                 -- IWord
   * ... this.atBottom() ...                 -- boolean
   * 
   * Methods of Fields:
   * ...
   */
  
  AWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }
  
  // checks if this word's word is equal to the string
  public boolean isEqual(String s) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.isEqual(String) ...            -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return this.word.equals(s);
  }
  
  //checks if the given string is the same as the beginning of a word
  // given string will always be a single character
  public boolean substringEqual(String str) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.isEqual(String) ...            -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return this.word.startsWith(str);
  }
  
  // changes an InactiveWord to an ActiveWord
  public IWord toActive() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.isEqual(String) ...            -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return new ActiveWord(this.word, this.x, this.y);
  }
  
  // checks if this IWord has reached the bottom
  public boolean atBottom() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.isEqual(String) ...            -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return this.y > 500;
  }
}


// represents an active word (word that is being typed by user)
class ActiveWord extends AWord {  
  ActiveWord(String word, int x, int y) {
    super(word, x, y);
  }
  
  /* Template:
   * Fields:
   * ... this.word ...            -- String
   * ... this.x ...               -- int
   * ... this.y ...               -- int
   * 
   * Methods:
   * ... this.wordToImage() ...              -- WorldScene
   * ... this.reduceHelper() ...             -- IWord
   * ... this.isEqual(String) ...            -- boolean
   * ... this.isActive() ...                 -- boolean
   * ... this.substringEqual(String) ...     -- boolean
   * ... this.toActive() ...                 -- IWord
   * ... this.moveHelp() ...                 -- IWord
   * ... this.atBottom() ...                 -- boolean
   * 
   * Methods of Fields:
   * ... 
   */
  
  // turns this word into an image and places it onto the given worldScene
  public WorldScene wordToImage(WorldScene w) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return w.placeImageXY(new TextImage(this.word, DEFAULT_FONT, Color.RED), this.x, this.y);
  }
  
  // reduces this word by the string if this word's beginning and the string 
  // are the same and this word is an active word 
  public IWord reduceHelper(String str) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
  
  // determines whether this word is active or inactive
  public boolean isActive() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return true;
  }
  
  // adds onto the the y-value of the word
  public IWord moveHelp() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return new ActiveWord(this.word, this.x, this.y + 15);
  }
}

// represents an inactive word (word that is not being typed by user)
class InactiveWord extends AWord {
  Random rand; // random seed 1, determines the randomized x positioning (not real random)
  Random rand2; // random seed 2, determines the randomized string
  
  // regular constructor; doesn't actually use randomness in any aspect
  InactiveWord(String word, int x, int y) {
    super(word, x, y);
    this.rand = new Random();
    this.rand2 = new Random();
  }
  
  // random value taken in whose seed value is specified; also creates
  // a completely random word
  InactiveWord(int y, Random r, Random r2) {
    super(new Utils().createWord("",  r2), r.nextInt(350) + 15, y);
    this.rand = r;
    this.rand2 = r2;
  }
  
  // random value taken in whose seen value is not specified (true random)
  InactiveWord(int y) {
    this(y, new Random(), new Random());
  }
  
  /* Template:
   * Fields:
   * ... this.word ...            -- String
   * ... this.x ...               -- int
   * ... this.y ...               -- int
   * 
   * Methods:
   * ... this.wordToImage() ...              -- WorldScene
   * ... this.reduceHelper() ...             -- IWord
   * ... this.isEqual(String) ...            -- boolean
   * ... this.isActive() ...                 -- boolean
   * ... this.substringEqual(String) ...     -- boolean
   * ... this.toActive() ...                 -- IWord
   * ... this.moveHelp() ...                 -- IWord
   * ... this.atBottom() ...                 -- boolean
   * 
   * Methods of Fields:
   * ... 
   */
    
  //turns this word into an image and places it onto the given worldScene
  public WorldScene wordToImage(WorldScene w) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return w.placeImageXY(new TextImage(this.word, DEFAULT_FONT, Color.BLUE), this.x, this.y);
  }
  
  // reduces this word by the string if this word's beginning and the string 
  // are the same and this word is an active word 
  public IWord reduceHelper(String str) {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
  
  // determines whether this IWord is active or inactive
  public boolean isActive() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
  
  // adds onto the the y-value of the word
  public IWord moveHelp() {
    /* Template:
     * Fields:
     * ... this.word ...            -- String
     * ... this.x ...               -- int
     * ... this.y ...               -- int
     * 
     * Methods:
     * ... this.wordToImage() ...              -- WorldScene
     * ... this.reduceHelper() ...             -- IWord
     * ... this.isEqual(String) ...            -- boolean
     * ... this.isActive() ...                 -- boolean
     * ... this.substringEqual(String) ...     -- boolean
     * ... this.toActive() ...                 -- IWord
     * ... this.moveHelp() ...                 -- IWord
     * ... this.atBottom() ...                 -- boolean
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
    return new InactiveWord(this.word, this.x, this.y + 15);
  }
}



