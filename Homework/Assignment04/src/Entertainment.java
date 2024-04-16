import tester.*;

interface IEntertainment {
  // compute the total price of this Entertainment
  double totalPrice();
  
  // computes the minutes of entertainment of this IEntertainment
  int duration();
  
  // produce a String that shows the name and price of this IEntertainment
  String format();
 
  // is this IEntertainment the same as that one?
  boolean sameEntertainment(IEntertainment that);
  
  // some extra helpers
  // is this Magazine the same as that one?
  boolean sameMagazine(Magazine that);
  
  // is this TVSeries the same as that one?
  boolean sameTVSeries(TVSeries that);
  
  // is this Podcast the same as that one?
  boolean samePodcast(Podcast that);
}

abstract class AEntertainment implements IEntertainment {
  String name; // name of the entertainment
  double price; // price of the entertainment (per issue and whatnot)
  int installments; // number of episodes/issues per year
  
  AEntertainment(String name, double price, int installments) {
    this.name = name;
    this.price = price;
    this.installments = installments;
  }
  
  /* Template
     Fields:
     ... this.name ...            -- String
     ... this.price ...           -- double
     ... this.installments ...    -- int
     
     Methods:
     ... this.totalPrice() ...                                -- double
     ... this.duration() ...                                  -- int
     ... this.format() ...                                    -- String
     ... this.sameEntertainment(IEntertainment that) ...      -- boolean
     ... this.sameMagazine(Magazine that) ...                 -- boolean
     ... this.sameTVSeries(TVSeries that) ...                 -- boolean
     ... this.samePodcast(Podcast that) ...                   -- boolean
     
     Methods of Fields:
     ...
   */
  
  // computes the price of a yearly subscription to this entertainment
  public double totalPrice() {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods of Parameters:
    ...
    */
    return this.price * this.installments;
  }
  
  // computes the duration of entertainment for this entertainment
  public int duration() {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods of Parameters:
    ...
    */
    return this.installments * 50;
  }
 
  //produce a String that shows the name and price of this Entertainment
  public String format() {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods of Parameters:
    ...
    */
    return this.name + ", " + this.price + ".";
  }
 
  // is this IEntertainment the same as that IEntertainment; however this is different for 
  // each class and will hence be implemented in each class separately
  public abstract boolean sameEntertainment(IEntertainment that);
  
  // helper methods
  // is this Magazine the same as that Magazine?
  public boolean sameMagazine(Magazine that) {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ... that.name ...            -- String
    ... that.price ...           -- double
    ... that.installments ...    -- int
    ... that.genre ...           -- String
    ... that.pages ...           -- int
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return false;
  }
  
  //is this TVSeries the same as that TVSeries?
  public boolean sameTVSeries(TVSeries that) {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ... that.name ...            -- String
    ... that.price ...           -- double
    ... that.installments ...    -- int
    ... that.corporation ...     -- String
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return false;
  }
  
  //is this Podcast the same as that Podcast?
  public boolean samePodcast(Podcast that) {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods of Fields:
    ...
    
    Fields of Parameters:
    ... that.name ...            -- String
    ... that.price ...           -- double
    ... that.installments ...    -- int
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return false;
  }
  
}

// represents a magazine type entertainment
class Magazine extends AEntertainment {
  String genre; // represents genre of the issue
  int pages; // represents number of pages per issue
    
  Magazine(String name, double price, String genre, int pages, int installments) {
    super(name, price, installments);
    this.genre = genre;
    this.pages = pages;
  }
  
  /* Template:
     Fields:
     ... this.name ...          -- String
     ... this.price ...         -- double
     ... this.installments ...  -- int
     ... this.genre ...         -- String
     ... this.pages ...         -- int
     
     Methods:
     ... this.totalPrice() ...                                -- double
     ... this.duration() ...                                  -- int
     ... this.format() ...                                    -- String
     ... this.sameEntertainment(IEntertainment that) ...      -- boolean
     ... this.sameMagazine(Magazine that) ...                 -- boolean
     ... this.sameTVSeries(TVSeries that) ...                 -- boolean
     ... this.samePodcast(Podcast that) ...                   -- boolean
     
     Methods for Fields:
     ...
   */
    
  // computes the minutes of entertainment of this Magazine, (includes all installments)
  // overrides the duration method in AEntertainment
  public int duration() {
    /* Template:
       Fields:
       ... this.name ...          -- String
       ... this.price ...         -- double
       ... this.installments ...  -- int
       ... this.genre ...         -- String
       ... this.pages ...         -- int
    
       Methods:
       ... this.totalPrice() ...                                -- double
       ... this.duration() ...                                  -- int
       ... this.format() ...                                    -- String
       ... this.sameEntertainment(IEntertainment that) ...      -- boolean
       ... this.sameMagazine(Magazine that) ...                 -- boolean
       ... this.sameTVSeries(TVSeries that) ...                 -- boolean
       ... this.samePodcast(Podcast that) ...                   -- boolean
    
       Methods for Fields:
       ...
    
       Fields of Parameters:
       ...
    
       Methods of Parameters:
       ...
    */
    return this.pages * this.installments * 5;
  }
    
  //is this Magazine the same as that IEntertainment?
  public boolean sameEntertainment(IEntertainment that) {
    /* Template:
       Fields:
       ... this.name ...          -- String
       ... this.price ...         -- double
       ... this.installments ...  -- int
       ... this.genre ...         -- String
       ... this.pages ...         -- int
     
       Methods:
       ... this.totalPrice() ...                                -- double
       ... this.duration() ...                                  -- int
       ... this.format() ...                                    -- String
       ... this.sameEntertainment(IEntertainment that) ...      -- boolean
       ... this.sameMagazine(Magazine that) ...                 -- boolean
       ... this.sameTVSeries(TVSeries that) ...                 -- boolean
       ... this.samePodcast(Podcast that) ...                   -- boolean
    
       Methods for Fields:
       ...
    
       Fields of Parameters:
       ...
    
       Methods of Parameters:
       ... that.totalPrice() ...                                -- double
       ... that.duration() ...                                  -- int
       ... that.format() ...                                    -- String
       ... that.sameEntertainment(IEntertainment that) ...      -- boolean
       ... that.sameMagazine(Magazine that) ...                 -- boolean
       ... that.sameTVSeries(TVSeries that) ...                 -- boolean
       ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return that.sameMagazine(this);
  }
 
  // is this Magazine the same as that Magazine?
  // overrides the method with the same name in the abstract class
  public boolean sameMagazine(Magazine that) {
    /* Template:
       Fields:
       ... this.name ...          -- String
       ... this.price ...         -- double
       ... this.installments ...  -- int
       ... this.genre ...         -- String
       ... this.pages ...         -- int
    
       Methods:
       ... this.totalPrice() ...                                -- double
       ... this.duration() ...                                  -- int
       ... this.format() ...                                    -- String
       ... this.sameEntertainment(IEntertainment that) ...      -- boolean
       ... this.sameMagazine(Magazine that) ...                 -- boolean
       ... this.sameTVSeries(TVSeries that) ...                 -- boolean
       ... this.samePodcast(Podcast that) ...                   -- boolean
    
       Methods for Fields:
       ...
     
       Fields of Parameters:
       ... that.name ...          -- String
       ... that.price ...         -- double
       ... that.installments ...  -- int
       ... that.genre ...         -- String
       ... that.pages ...         -- int
    
       Methods of Parameters:
       ... that.totalPrice() ...                                -- double
       ... that.duration() ...                                  -- int
       ... that.format() ...                                    -- String
       ... that.sameEntertainment(IEntertainment that) ...      -- boolean
       ... that.sameMagazine(Magazine that) ...                 -- boolean
       ... that.sameTVSeries(TVSeries that) ...                 -- boolean
       ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    boolean names = this.name.equals(that.name);
    boolean prices = Math.abs(this.price - that.price) < 0.001;
    boolean installments = this.installments == that.installments;
    boolean genre = this.genre.equals(that.genre);
    boolean pages = this.pages == that.pages;
    return names && prices && installments && genre && pages;
  }
}

// represents a tv series type entertainment
class TVSeries extends AEntertainment {
  String corporation; // represents the corporation that streams this series
    
  TVSeries(String name, double price, int installments, String corporation) {
    super(name, price, installments);
    this.corporation = corporation;
  }
  
  /* Template
     Fields:
     ... this.name ...           -- String
     ... this.price ...          -- double
     ... this.installments ...   -- int
     ... this.corporation ...    -- String
     
     Methods:
     ... this.totalPrice() ...                                -- double
     ... this.duration() ...                                  -- int
     ... this.format() ...                                    -- String
     ... this.sameEntertainment(IEntertainment that) ...      -- boolean
     ... this.sameMagazine(Magazine that) ...                 -- boolean
     ... this.sameTVSeries(TVSeries that) ...                 -- boolean
     ... this.samePodcast(Podcast that) ...                   -- boolean
    
     Methods for Fields:
     ...
  */
    
  // is this TVSeries the same as that IEntertainment?
  public boolean sameEntertainment(IEntertainment that) {
    /* Template
    Fields:
    ... this.name ...           -- String
    ... this.price ...          -- double
    ... this.installments ...   -- int
    ... this.corporation ...    -- String
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
   
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return that.sameTVSeries(this);
  }
  
  // is this TVSeries the same as that TVSeries?
  public boolean sameTVSeries(TVSeries that) {
    /* Template
    Fields:
    ... this.name ...           -- String
    ... this.price ...          -- double
    ... this.installments ...   -- int
    ... this.corporation ...    -- String
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
   
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ... that.name ...           -- String
    ... that.price ...          -- double
    ... that.installments ...   -- int
    ... that.corporation ...    -- String
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    boolean names = this.name.equals(that.name);
    boolean prices = Math.abs(this.price - that.price) < 0.001;
    boolean installments = this.installments == that.installments;
    boolean corporations = this.corporation.equals(that.corporation);
    return names && prices && installments && corporations;
  }
}

// represents a podcast type entertainment
class Podcast extends AEntertainment {    
  Podcast(String name, double price, int installments) {
    super(name, price, installments);
  }
  
  /* Template
     Fields:
     ... this.name ...            -- String
     ... this.price ...           -- double
     ... this.installments ...    -- int
     
     Methods:
     ... this.totalPrice() ...                                -- double
     ... this.duration() ...                                  -- int
     ... this.format() ...                                    -- String
     ... this.sameEntertainment(IEntertainment that) ...      -- boolean
     ... this.sameMagazine(Magazine that) ...                 -- boolean
     ... this.sameTVSeries(TVSeries that) ...                 -- boolean
     ... this.samePodcast(Podcast that) ...                   -- boolean
     
     Methods for Fields:
     ...
   */
    
  // is this Podcast the same as that IEntertainment?
  public boolean sameEntertainment(IEntertainment that) {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    return that.samePodcast(this);
  }
 
  // is this TVSeries the same as that TVSeries?
  public boolean samePodcast(Podcast that) {
    /* Template
    Fields:
    ... this.name ...            -- String
    ... this.price ...           -- double
    ... this.installments ...    -- int
    
    Methods:
    ... this.totalPrice() ...                                -- double
    ... this.duration() ...                                  -- int
    ... this.format() ...                                    -- String
    ... this.sameEntertainment(IEntertainment that) ...      -- boolean
    ... this.sameMagazine(Magazine that) ...                 -- boolean
    ... this.sameTVSeries(TVSeries that) ...                 -- boolean
    ... this.samePodcast(Podcast that) ...                   -- boolean
    
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ... that.name ...            -- String
    ... that.price ...           -- double
    ... that.installments ...    -- int
    
    Methods of Parameters:
    ... that.totalPrice() ...                                -- double
    ... that.duration() ...                                  -- int
    ... that.format() ...                                    -- String
    ... that.sameEntertainment(IEntertainment that) ...      -- boolean
    ... that.sameMagazine(Magazine that) ...                 -- boolean
    ... that.sameTVSeries(TVSeries that) ...                 -- boolean
    ... that.samePodcast(Podcast that) ...                   -- boolean
    */
    boolean names = this.name.equals(that.name);
    boolean prices = Math.abs(this.price - that.price) < 0.001;
    boolean installments = this.installments == that.installments;
    return names && prices && installments;
  }
}

// examples class
class ExamplesEntertainment {
  IEntertainment rollingStone = new Magazine("Rolling Stone", 2.55, "Music", 60, 12);
  IEntertainment houseOfCards = new TVSeries("House of Cards", 5.25, 13, "Netflix");
  IEntertainment serial = new Podcast("Serial", 0.0, 8);
  
  // more example data
  IEntertainment vogue = new Magazine("Vogue", 3.25, "Fashion", 45, 11);
  IEntertainment theGlory = new TVSeries("The Glory", 4.25, 14, "Netflix");
  IEntertainment horrorStories = new Podcast("Horror Stories", 0.1, 150);
  
  // duplicates
  IEntertainment vogue2 = new Magazine("Vogue", 3.25, "Fashion", 45, 11);
  IEntertainment theGlory2 = new TVSeries("The Glory", 4.25, 14, "Netflix");
  IEntertainment horrorStories2 = new Podcast("Horror Stories", 0.1, 150);
    
  // testing total price method
  boolean testTotalPrice(Tester t) {
    return 
        // total price of a magazine series
        t.checkInexact(this.rollingStone.totalPrice(), 2.55 * 12, .0001) 
        && t.checkInexact(this.vogue.totalPrice(), 3.25 * 11, .0001)
        // total price of a tv series
        && t.checkInexact(this.houseOfCards.totalPrice(), 5.25 * 13, .0001)
        && t.checkInexact(this.theGlory.totalPrice(), 4.25 * 14, .0001)
        // total price of a podcast series
        && t.checkInexact(this.serial.totalPrice(), 0.0, .0001)
        && t.checkInexact(this.horrorStories.totalPrice(), 0.1 * 150, .0001);
  }
  
  // testing duration method
  boolean testDuration(Tester t) {
    return 
        // total duration of a magazine series
        t.checkExpect(this.vogue.duration(), 5 * 45 * 11)
        // total duration of a tv series
        && t.checkExpect(this.theGlory.duration(), 14 * 50)
        // total price of a podcast series
        && t.checkExpect(this.horrorStories.duration(), 150 * 50);
  }
  
  // testing format method
  boolean testFormat(Tester t) {
    return 
        // formatting of a magazine series
        t.checkExpect(this.vogue.format(), "Vogue, 3.25.")
        // formatting of a tv series
        && t.checkExpect(this.theGlory.format(), "The Glory, 4.25.")
        // formatting of a podcast series
        && t.checkExpect(this.horrorStories.format(), "Horror Stories, 0.1.");
  }
  
  // testing sameEntertainment method
  boolean testSameEntertainment(Tester t) {
    return 
        // two magazines that are the same
        t.checkExpect(this.vogue.sameEntertainment(this.vogue2), true)
        // two tv series that are the same
        && t.checkExpect(this.theGlory.sameEntertainment(this.theGlory2), true)
        // two podcast series that are the same
        && t.checkExpect(this.horrorStories.sameEntertainment(this.horrorStories2), true)
        
        // same type but different aspects
        // magazines
        // two magazines - name differs
        && t.checkExpect(this.rollingStone.sameEntertainment(this.vogue), false)
        // two magazines - price differs
        && t.checkExpect(this.vogue.sameEntertainment(
            new Magazine("Vogue", 4.25, "Fashion", 45, 11)), false)
        // two magazines - installments differs
        && t.checkExpect(this.vogue.sameEntertainment(
            new Magazine("Vogue", 4.25, "Fashion", 35, 11)), false)
        // two magazines - genre differs
        && t.checkExpect(this.vogue.sameEntertainment(
            new Magazine("Vogue", 4.25, "Jewelry", 45, 11)), false)
        // two magazines - pages differs
        && t.checkExpect(this.vogue.sameEntertainment(
            new Magazine("Vogue", 4.25, "Fashion", 45, 10)), false)
        
        // tv series
        // two tv series - name differs
        && t.checkExpect(this.theGlory.sameEntertainment(this.houseOfCards), false)
        // two tv series - price differs
        && t.checkExpect(this.theGlory.sameEntertainment(
            new TVSeries("The Glory", 5.25, 14, "Netflix")), false)
        // two tv series - installments differs
        && t.checkExpect(this.theGlory.sameEntertainment(
            new TVSeries("The Glory", 5.25, 12, "Netflix")), false)
        // two tv series - corporations differs
        && t.checkExpect(this.theGlory.sameEntertainment(
            new TVSeries("The Glory", 5.25, 14, "HBO Max")), false)
        
        // podcast series
        // two podcast series - name differs
        && t.checkExpect(this.serial.sameEntertainment(this.horrorStories), false)
        // two podcast series - price differs
        && t.checkExpect(this.serial.sameEntertainment(
            new Podcast("Horror Stories", 2.0, 150)), false)
        // two podcast series - installments differs
        && t.checkExpect(this.serial.sameEntertainment(
            new Podcast("Horror Stories", 0.1, 155)), false)
        
        // magazine vs tv - false
        && t.checkExpect(this.vogue.sameEntertainment(this.theGlory), false)
        // tv vs podcast - false
        && t.checkExpect(this.theGlory.sameEntertainment(this.horrorStories), false)
        // podcast vs magazine - false
        && t.checkExpect(this.horrorStories.sameEntertainment(this.vogue), false);
  }
  
  // testing helpers
  // testing sameMagazine
  boolean testSameMagazine(Tester t) {
    return 
        // same magazine
        t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Vogue", 3.25, "Fashion", 45, 11)), true)
        // two magazines - name differs
        && t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Cracker & Barrel", 3.25, "Fashion", 45, 11)), false)
        // two magazines - price differs
        && t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Vogue", 4.25, "Fashion", 45, 11)), false)
        // two magazines - installments differs
        && t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Vogue", 4.25, "Fashion", 35, 11)), false)
        // two magazines - genre differs
        && t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Vogue", 4.25, "Jewelry", 45, 11)), false)
        // two magazines - pages differs
        && t.checkExpect(this.vogue.sameMagazine(
            new Magazine("Vogue", 4.25, "Fashion", 45, 10)), false);
  }
  
  // testing sameTVSeries
  boolean testSameTVSeries(Tester t) {
    return
        // same TV Series
        t.checkExpect(this.theGlory.sameTVSeries(
            new TVSeries("The Glory", 4.25, 14, "Netflix")), true)
        // two tv series - name differs
        && t.checkExpect(this.theGlory.sameTVSeries(
            new TVSeries("One Piece", 4.25, 14, "Netflix")), false)
        // two tv series - price differs
        && t.checkExpect(this.theGlory.sameTVSeries(
            new TVSeries("The Glory", 5.25, 14, "Netflix")), false)
        // two tv series - installments differs
        && t.checkExpect(this.theGlory.sameTVSeries(
            new TVSeries("The Glory", 5.25, 12, "Netflix")), false)
        // two tv series - corporations differs
        && t.checkExpect(this.theGlory.sameTVSeries(
            new TVSeries("The Glory", 5.25, 14, "HBO Max")), false);
  }
  
  // testing samePodcast
  boolean testSamePodcast(Tester t) {
    return
        // same podcast series
        t.checkExpect(this.horrorStories.samePodcast(
            new Podcast("Horror Stories", 0.1, 150)), true)
        // two podcast series - name differs
        && t.checkExpect(this.horrorStories.samePodcast(
            new Podcast("Japanese Learning", 0.1, 150)), false)
        // two podcast series - price differs
        && t.checkExpect(this.serial.samePodcast(
            new Podcast("Horror Stories", 2.0, 150)), false)
        // two podcast series - installments differs
        && t.checkExpect(this.serial.samePodcast(
            new Podcast("Horror Stories", 0.1, 155)), false);
        
  }
  
}

