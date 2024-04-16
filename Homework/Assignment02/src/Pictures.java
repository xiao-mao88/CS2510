import tester.*;


// represents a picture of a shape/shapes
interface IPicture {
  int comboDepth(); // finds the depth of a picture
  
  int countShapes(); // counts how many shapes are in the picture
 
  int getWidth(); // finds the width of the picture
 
  IPicture mirror(); // mirrors a picture horizontally
 
  String pictureRecipe(int depth); // tells how a picture was put together
  
  // helper method
  String theName(); // gets the name of a picture
}


// represents a single shape
class Shape implements IPicture {
  
  String kind; // the type of shape
  int size; // the size of the shape
 
  Shape(String kind, int size) {
    this.kind = kind;
    this.size = size;
  }
  
  /*
  // ** TEMPLATE **
  // FIELDS
  ... this.kind ...       -- String
  ... this.size ...       -- int
  // METHODS
  ... this.comboDepth() ...             -- int
  ... this.countShapes() ...            -- int
  ... this.getWidth() ...               -- int
  ... this.mirror() ...                 -- IPicture
  ... this.pictureRecipe(int depth) ... -- String
  ... this.theName() ...                -- String
  */
 
  // finds the depth of a picture/number of operations that has been done
  public int comboDepth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    
    return 0;
  }
  
  // counts the number of shapes in the picture
  public int countShapes() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return 1;
  }
  
  // gives the width of the image
  public int getWidth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.size;
  }
  
  // flips the image horizontally
  public IPicture mirror() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this;
  }
  
  // the way the picture was made
  public String pictureRecipe(int depth) {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.kind;
  }
 
  // the name of the shape
  public String theName() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.kind ...       -- String
    ... this.size ...       -- int
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IPicture
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.kind;
  }
}


// represents a shape/shapes that have had an operation done to it/them
class Combo implements IPicture {
  String name;
  IOperation operation;
 
  Combo(String name, IOperation operation) {
    this.name = name;
    this.operation = operation;
  }
 
  /*
  // ** TEMPLATE **
  // FIELDS
  ... this.name ...       -- String
  ... this.operation ...  -- IOperation
  // METHODS
  ... this.comboDepth() ...             -- int
  ... this.countShapes() ...            -- int
  ... this.getWidth() ...               -- int
  ... this.mirror() ...                 -- IPicture
  ... this.pictureRecipe(int depth) ... -- String
  ... this.theName() ...                -- String
  */
  
  // however many operations that the combo has nested within it
  public int comboDepth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.operation.comboDepth();
  }
 
  // counts the number of shapes in a picture
  public int countShapes() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.operation.countShapes();
  }

  // gives the width of a picture
  public int getWidth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.operation.getWidth();
  }

  // returns a picture that has been flipped horizontally
  public IPicture mirror() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return new Combo(this.name, this.operation.mirror());
  }
  
  // returns how this picture was made
  public String pictureRecipe(int depth) {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    if (depth <= 0) {
      return this.name;
    }
    
    else {
      return this.operation.pictureRecipe(depth - 1); 
    }
  }
  
  // returns the name of this picture
  public String theName() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.name ...       -- String
    ... this.operation ...  -- IOperation
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    ... this.theName() ...                -- String
    */
    return this.name;
  }
}

// represents the operations that can be done to a picture
interface IOperation {
  int comboDepth(); // finds the depth of a picture
  
  int countShapes(); // counts how many shapes are in the picture
  
  int getWidth(); // finds the width of the picture
  
  IOperation mirror(); // mirrors a picture horizontally
  
  String pictureRecipe(int depth); // tells how a picture was put together
}

// makes a picture twice as big as the original
class Scale implements IOperation {
  IPicture picture;
  
  Scale(IPicture picture) {
    this.picture = picture;
  }
  
  /*
  // ** TEMPLATE **
  // FIELDS
  ... this.picture ...       -- IPicture
   // METHODS
  ... this.comboDepth() ...             -- int
  ... this.countShapes() ...            -- int
  ... this.getWidth() ...               -- int
  ... this.mirror() ...                 -- IOperation
  ... this.pictureRecipe(int depth) ... -- String
  */
  
  // returns the depth of the picture
  public int comboDepth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.picture ...       -- IPicture
    
    // Methods of fields
    ... this.picture.comboDepth(); ...   -- int
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return 1 + this.picture.comboDepth();
  }
  
  // counts the number of shapes
  public int countShapes() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.picture ...       -- IPicture
   
    // Methods of Fields
    ... this.picture.countShapes() ...   -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return this.picture.countShapes();
  }
  
  // gets the width of the picture
  public int getWidth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.picture ...       -- IPicture
    
    // Methods of Fields
    ... this.picture.getWidth() ...   -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return 2 * this.picture.getWidth();
  }
  
  // flips the picture horizontally
  public IOperation mirror() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.picture ...       -- IPicture
    
    // Methods of Fields
    ... this.picture.mirror() ...    -- IOperation
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return new Scale(this.picture.mirror());
  }
  
  // how the picture was made depending on its depth
  public String pictureRecipe(int depth) {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.picture ...       -- IPicture
   
    // Methods of Fields
    ... this.picture.theName() ...                -- String
    ... this.picture.pictureRecipe(int depth) ... -- String
    
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (depth <= 0) {
      return "scale(" + this.picture.theName() + ")";
    }
  
    return "scale(" + this.picture.pictureRecipe(depth) + ")";
  }
}
  
// places one picture on top of the other
class Overlay implements IOperation {
  IPicture topPicture;
  IPicture bottomPicture;
  
  Overlay(IPicture topPicture, IPicture bottomPicture) {
    this.topPicture = topPicture;
    this.bottomPicture = bottomPicture;
  }
  
  /*
  // ** TEMPLATE **
  // FIELDS
  ... this.topPicture ...       -- IPicture
  ... this.bottomPicture ...    -- IPicture
  // METHODS
  ... this.comboDepth() ...             -- int
  ... this.countShapes() ...            -- int
  ... this.getWidth() ...               -- int
  ... this.mirror() ...                 -- IOperation
  ... this.pictureRecipe(int depth) ... -- String
  */
  
  // finds the depth of this picture/number of operations that has been done
  public int comboDepth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.topPicture ...       -- IPicture
    ... this.bottomPicture ...    -- IPicture
    
    // Methods of Fields
    ... this.topPicture.comboDepth() ...     -- int
    ... this.BottomPicture.comboDepth() ...  -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (this.topPicture.comboDepth() > this.bottomPicture.comboDepth()) {
      return 1 + this.topPicture.comboDepth();
    }
    
    else {
      return 1 + this.bottomPicture.comboDepth(); 
    }
  }
  
  // the number of shapes that make up this picture
  public int countShapes() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.topPicture ...       -- IPicture
    ... this.bottomPicture ...    -- IPicture
    
    // Methods of Fields
    ... this.topPicture.countShapes() ...     -- IPicture
    ... this.bottomPicture.countShapes() ...  -- IPicture
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return this.topPicture.countShapes() + this.bottomPicture.countShapes();
  }
  
  // finds the width of this picture
  public int getWidth() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.topPicture ...       -- IPicture
    ... this.bottomPicture ...    -- IPicture
    
    // Methods of Fields
    ... this.topPicture.getWidth() ...      -- int
    ... this.bottomPicture.getWidth() ...   -- int
  
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (this.topPicture.getWidth() > this.bottomPicture.getWidth()) {
      return this.topPicture.getWidth();
    }
    
    else {
      return this.bottomPicture.getWidth(); 
    }
  }
  
  // flips this picture horizontally 
  public IOperation mirror() {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.topPicture ...       -- IPicture
    ... this.bottomPicture ...    -- IPicture
     
    // Methods of Fields
    ... this.topPicture.mirror() ...      -- IPicture
    ... this.bottomPicture.mirror() ...   -- IPicture
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return new Overlay(this.topPicture.mirror(), this.bottomPicture.mirror());
  }
  
  // how this picture was made
  public String pictureRecipe(int depth) {
    /*
    // ** TEMPLATE **
    // FIELDS
    ... this.topPicture ...       -- IPicture
    ... this.bottomPicture ...    -- IPicture
   
    // Methods of Fields
    ... this.topPicture.pictureRecipe() ...    -- String
    ... this.bottomPicture.pictureRecipe() ... -- String
   
    // METHODS
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (depth <= 0) {
      return ("overlay(" + this.topPicture.theName() + ", " + this.bottomPicture.theName() + ")");
    }
    else {
      return "overlay(" + this.topPicture.pictureRecipe(depth) + ", "
          + this.bottomPicture.pictureRecipe(depth) + ")";
    }
  }
}

// places one picture beside the other
class Beside implements IOperation {
  IPicture picture1;
  IPicture picture2;
  
  Beside(IPicture rightPicture, IPicture leftPicture) {
    this.picture1 = rightPicture;
    this.picture2 = leftPicture;
  }
  
  /*
  // ** TEMPLATE **
  // FIELDS
  ... this.picture1 ...       -- IPicture
  ... this.picture2 ...       -- IPicture
  // METHODS
  ... this.comboDepth() ...             -- int
  ... this.countShapes() ...            -- int
  ... this.getWidth() ...               -- int
  ... this.mirror() ...                 -- IPicture
  ... this.pictureRecipe(int depth) ... -- String
  ... this.theName() ...                -- String
  */
  
  // finds the depth of this picture/number of operations that has been done
  public int comboDepth() {
    /*
    // ** TEMPLATE **
    returnType methodName(){
    ... this.picture1 ...       -- IPicture
    ... this.picture2 ...       -- IPicture
    
    // Methods of Fields
    ... this.picture1.comboDepth() ...   -- int
    ... this.picture2.comboDepth() ...   -- int
  
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (this.picture1.comboDepth() > this.picture2.comboDepth()) {
      return 1 + this.picture1.comboDepth();
    }
    
    else {
      return 1 + this.picture2.comboDepth(); 
    } 
  }
  
  // finds the number of shapes that make up this picture
  public int countShapes() {
    /*
    // ** TEMPLATE **
    returnType methodName(){
    ... this.picture1 ...       -- IPicture
    ... this.picture2 ...       -- IPicture
    
    // Methods of Fields
    ... this.picture1.countShapes() ...   -- int
    ... this.picture1.countShapes() ...   -- int
    
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return this.picture1.countShapes() + this.picture2.countShapes();
  }
  
  // gets the width of this picture
  public int getWidth() {
    /*
    // ** TEMPLATE **
    returnType methodName(){
    ... this.picture1 ...       -- IPicture
    ... this.picture2 ...       -- IPicture
   
    // Methods of Fields
    ... this.picture1.getWidth() ...   -- int
    ... this.picture2.getWidth() ...   -- int
  
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return this.picture1.getWidth() + this.picture2.getWidth();
  }
  
  // flips this image horizontally
  public IOperation mirror() {
    /*
    // ** TEMPLATE **
    returnType methodName(){
    ... this.picture1 ...       -- IPicture
    ... this.picture2 ...       -- IPicture
   
    // Methods of Fields
    ... this.picture1.mirror() ...   -- IPicture
    ... this.picture2.mirror() ...   -- IPicture
  
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    return new Beside(this.picture2.mirror(), this.picture1.mirror());
  }
  
  // tells how this picture was made
  public String pictureRecipe(int depth) {
    /*
    // ** TEMPLATE **
    returnType methodName(){
    ... this.picture1 ...       -- IPicture
    ... this.picture2 ...       -- IPicture
   
    // Methods of Fields
    ... this.picture1.pictureRecipe() ...   -- String
    ... this.picture2.pictureRecipe() ...   -- String
  
    ... this.comboDepth() ...             -- int
    ... this.countShapes() ...            -- int
    ... this.getWidth() ...               -- int
    ... this.mirror() ...                 -- IOperation
    ... this.pictureRecipe(int depth) ... -- String
    */
    if (depth <= 0) {
      return "beside(" + this.picture1.theName() + ", "
                       + this.picture2.theName() + ")";
    }
    return "beside(" + this.picture1.pictureRecipe(depth) + ", "
                     + this.picture2.pictureRecipe(depth) + ")";
  }
}


// Examples of the various classes, and testing the different methods
class ExamplesPicture {
  // required examples
  IPicture circle = new Shape("circle", 20);
  IPicture square = new Shape("square", 30);
  IPicture bigCircle = new Combo("big circle", new Scale(this.circle));
  IPicture squareOnCircle = new Combo("square on circle", new Overlay(this.square, this.bigCircle));
  IOperation beside1 = new Beside(this.squareOnCircle, this.squareOnCircle);
  IPicture doubledSquareOnCircle = new Combo("doubled square on circle", this.beside1);
 
  // extra examples
  IPicture circle1 = new Shape("circle", 60);
  IPicture square1 = new Shape("square", 50);
  
  // extra scales
  IPicture bigSquare = new Combo("big square", new Scale(this.square1));
  IPicture bigCombo = new Combo("big combo", new Scale(this.squareOnCircle));
 
  // extra overlays
  IOperation overlay1 = new Overlay(this.circle1, this.square1);
  IPicture circleOnTopSquare = new Combo("circle on top square", this.overlay1);
 
  IOperation overlay2 = new Overlay(this.bigSquare, this.circle1);
  IPicture bSOnCircle = new Combo("big square on circle", this.overlay2);
 
  // extra besides
  IOperation beside2 = new Beside(this.circle1, this.bigSquare);
  IPicture bSAndCircle = new Combo("big square and circle", this.beside2);
 
  IOperation beside3 = new Beside(this.circle, this.square);
  IOperation flip1 = new Beside(this.square, this.circle);
  IPicture circleSquare = new Combo("circle square", this.beside3);
 
  IOperation beside5 = new Beside(this.bigSquare, this.circle);
  IPicture bigSquareCircle = new Combo("big square circle", this.beside5);
 
  IOperation beside6 = new Beside(this.circleSquare, this.circle);
  IPicture twoBeside = new Combo("two beside", this.beside6);
 
  // flipping twoBeside
  IPicture flipCircleSquare = new Combo("circle square", this.flip1);
  IOperation beside7 = new Beside(this.circle, this.flipCircleSquare);
  IPicture flipTwoBeside = new Combo("two beside", beside7);
 
 
  // testers
  // tester for method comboDepth();
  boolean testComboDepth(Tester t) {
    return
          // finds the depth of a single shape
          t.checkExpect(this.circle.comboDepth(), 0)
         
       // finds the depth of a Combo with one layer
       && t.checkExpect(this.bigCircle.comboDepth(), 1)
      
       // finds the depth of a more complex Combo, but still symmetrical
       && t.checkExpect(this.doubledSquareOnCircle.comboDepth(), 3)
      
       // finds the depth of a Combo in which the two pictures creating the Beside have
       // different depths, returning the greater one of the two
       && t.checkExpect(this.bigSquareCircle.comboDepth(), 2)
      
       // finds the depth of a Combo in which the two pictures creating the Overlay have
       // different depths, returning the greater one of the two
       && t.checkExpect(this.bSOnCircle.comboDepth(), 2);
  }
 
  // tester for method countShapes();
  boolean testCountShapes(Tester t) {
    return
          // finds the number of shapes when there is only a single shape
          t.checkExpect(this.circle.countShapes(), 1)
         
       // finds the number of shapes when there is a single shape scaled
       && t.checkExpect(this.bigCircle.countShapes(), 1)
      
       // finds the number of shapes when all operations have been used
       && t.checkExpect(this.doubledSquareOnCircle.countShapes(), 4);
  }
 
  // tester for method getWidth();
  boolean testGetWidth(Tester t) {
    return
          // finds the width of a single shape
          t.checkExpect(this.circle.getWidth(), 20)
         
       // finds the width when there is a larger picture under a smaller one
       && t.checkExpect(this.squareOnCircle.getWidth(), 40)
      
       // finds the width when there is a larger picture on top a smaller one
       && t.checkExpect(this.circleOnTopSquare.getWidth(), 60)
      
       // finds the width when two pictures are put beside each other
       && t.checkExpect(this.doubledSquareOnCircle.getWidth(), 80);
  }
 
  // tester for method mirror();
  boolean testerMirror(Tester t) {
    return
          // mirrors a single circle
          t.checkExpect(this.circle.mirror(), this.circle)
         
       // mirrors a picture when beside is being used
       && t.checkExpect(this.circleSquare.mirror(), new Combo("circle square", this.flip1))
      
       // mirrors a picture when overlay/scale is being used
       && t.checkExpect(this.bigCircle.mirror(), this.bigCircle)
         
       // mirrors a picture when overlay/scale is being used
       && t.checkExpect(this.bSOnCircle.mirror(), this.bSOnCircle)
   
       // mirrors a picture when there is more than one beside operation
       && t.checkExpect(this.twoBeside.mirror(), this.flipTwoBeside);
  }
 
  // tester for method pictureRecipe(int depth);
  boolean testerPictureRecipe(Tester t) {
    return
          // finds the recipe for a single shape when the depth is 0
          t.checkExpect(this.circle.pictureRecipe(0), "circle")
      
       // finds the recipe for a single shape when the depth > 0
       && t.checkExpect(this.circle.pictureRecipe(3), "circle")
       
       // finds the recipe for a combo when the depth is greater than its actual depth
       && t.checkExpect(this.bigCircle.pictureRecipe(4), "scale(circle)")
      
       // finds the recipe for a combo when the depth is 0
       && t.checkExpect(this.doubledSquareOnCircle.pictureRecipe(0),
                        "doubled square on circle")
      
       // finds the recipe for a combo when the depth > 0
       && t.checkExpect(this.squareOnCircle.pictureRecipe(1),
                        "overlay(square, big circle)")
      
       // finds the recipe for a combo when the beside operation is used
       // and the depth > 0
       && t.checkExpect(this.doubledSquareOnCircle.pictureRecipe(1),
                        "beside(square on circle, square on circle)")
      
       // finds the recipe for a combo when there are multiple operations
       // and beside is being used
       && t.checkExpect(this.doubledSquareOnCircle.pictureRecipe(2),
              "beside(overlay(square, big circle), overlay(square, big circle))")
      
       // finds the recipe when scale is used, but the depth is greater than what
       // the picture actually has
       && t.checkExpect(this.bigCircle.pictureRecipe(2), "scale(circle)")
      
       // finds the recipe when scale is used
       && t.checkExpect(this.bigCircle.pictureRecipe(1), "scale(circle)")
      
       // finds the recipe when overlay is used
       && t.checkExpect(this.squareOnCircle.pictureRecipe(2),
                        "overlay(square, scale(circle))");
  }
  
  // tester for theName();
  boolean testerTheName(Tester t) {
    // finds the name of a shape
    return t.checkExpect(this.circle.theName(), "circle");
  }
}



