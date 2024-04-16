import tester.*;

// represents a cake recipe
class CakeRecipe {
  double sugar; // weight of the sugar in the recipe
  double flour; // weight of the sugar in the recipe
  double eggs; // weight of the sugar in the recipe
  double butter; // weight of the sugar in the recipe
  double milk; // weight of the sugar in the recipe
  boolean areVolumes; // indicates whether the items are in weight or volumes
  
  // everything constructor
  CakeRecipe(double flour, double sugar, double eggs, double butter, double milk) {    
    Utils temp = new Utils();
    
    this.flour = temp.checkRecipe(flour, sugar, 
        "Weight of flour and sugar are not the same");
    this.sugar = sugar;
    this.eggs = temp.checkRecipe(eggs, butter, 
        "Weight of eggs and butter are not the same");
    this.butter = butter;
    this.milk = temp.checkRecipe(milk, flour - eggs, 
        "Weight of eggs plus milk are not the same as weight of flour");
  }
  
  // 3 ingredient constructor
  CakeRecipe(double flour, double eggs, double milk) {
    Utils temp = new Utils();
    this.flour = temp.checkRecipe(flour, flour, "");
    this.sugar = flour;
    this.eggs = temp.checkRecipe(eggs, eggs, "");
    this.butter = eggs;
    this.milk = temp.checkRecipe(milk, flour - eggs, 
        "Weight of eggs plus milk are not the same as weight of flour");
  }
  
  // volume constructor
  CakeRecipe(double flour, double eggs, double milk, boolean areVolumes) {
    Utils temp = new Utils();
    this.areVolumes = areVolumes;
    if (areVolumes) {
      this.flour = temp.checkRecipe(flour * 4.25, flour * 4.25, null);
      this.eggs = temp.checkRecipe(eggs * 1.75, eggs * 1.75, null);
      this.milk = temp.checkRecipe(milk * 8, this.flour - this.eggs, 
          "Weight of eggs plus milk are not the same as weight of flour");
      this.sugar = 4.25 * flour;
      this.butter = 1.75 * eggs;
    }
    else {
      this.flour = temp.checkRecipe(flour, flour, null);
      this.eggs = temp.checkRecipe(eggs, eggs, null);
      this.milk = temp.checkRecipe(milk, this.flour - this.eggs, 
          "Weight of eggs plus milk are not the same as weight of flour");
      this.sugar = flour;
      this.butter = eggs;
    }
  }
  
  /* Template
  Fields:
  ... this.flour ...       -- double
  ... this.sugar ...       -- double
  ... this.eggs ...        -- double
  ... this.butter ...      -- double
  ... this.milk ...        -- double
  ... this.areVolumes ...  -- boolean
  
  Methods:
  ... this.sameRecipe(CakeRecipe) ...  -- boolean
  
  Methods for Fields:
  ...
  */
  
  // checks if two CakeRecipes are the same
  public boolean sameRecipe(CakeRecipe other) {
    /* Template
    Fields:
    ... this.flour ...       -- double
    ... this.sugar ...       -- double
    ... this.eggs ...        -- double
    ... this.butter ...      -- double
    ... this.milk ...        -- double
    ... this.areVolumes ...  -- boolean
    
    Methods:
    ... this.sameRecipe ...  -- boolean
    
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ... other.flour ...       -- double
    ... other.sugar ...       -- double
    ... other.eggs ...        -- double
    ... other.butter ...      -- double
    ... other.milk ...        -- double
    ... other.areVolumes ...  -- boolean
    
    Methods of Parameters:
    ... this.sameRecipe ...  -- boolean
    */
    boolean theFlour = Math.abs(this.flour - other.flour) < 0.001;
    boolean theEggs = Math.abs(this.eggs - other.eggs) < 0.001;
    boolean theMilk = Math.abs(this.milk - other.milk) < 0.001;
    return theFlour && theEggs && theMilk;
  }
}

// checks if the recipe is perfect
class Utils {
  /* Template
     Fields:
     ...
     
     Methods:
     ... this.checkRecipe ...     -- double
     
     Methods for Fields:
     ...
   */
  
  double checkRecipe(double num, double num2, String msg) {
    /* Template
    Fields:
    ...
    
    Methods:
    ... this.checkRecipe(double double String) ...     -- boolean
    
    Methods for Fields:
    ...
    
    Fields of Parameters:
    ...
    
    Methods for Parameters:
    ...
    */
    if ((Math.abs(num - num2) < 0.001) && num > 0) {
      return num;
    }
    else if (num <= 0) {
      throw new IllegalArgumentException("Weight(s) is not in range");
    }
    else {
      throw new IllegalArgumentException("Not a perfect recipe: " + msg);
    }
  }
}


// examples and testers for the cake class(es)
class ExamplesCakes {
  // Examples:
  CakeRecipe fullCake1 = new CakeRecipe(6.5, 6.5, 4.5, 4.5, 2.0);
  CakeRecipe fullCake2 = new CakeRecipe(17.0, 17.0, 3.5, 3.5, 13.5);
  CakeRecipe fullCake3 = new CakeRecipe(17.0, 17.0, 3.5, 3.5, 13.5);
  CakeRecipe fullCake4 = new CakeRecipe(18.0, 18.0, 3.5, 3.5, 14.5);
  CakeRecipe fullCake5 = new CakeRecipe(17.0, 17.0, 4.5, 4.5, 12.5);
  
  // for the 3 ingredient constructor
  CakeRecipe threeCake1 = new CakeRecipe(6.0, 4.0, 2.0);
  CakeRecipe threeCake2 = new CakeRecipe(17.0, 3.5, 13.5);
  CakeRecipe threeCake3 = new CakeRecipe(17.0, 3.5, 13.5);
  CakeRecipe threeCake4 = new CakeRecipe(18.0, 3.5, 14.5);
  CakeRecipe threeCake5 = new CakeRecipe(17.0, 4.5, 12.5);
  
  // for the volumes constructor
  CakeRecipe volCake1 = new CakeRecipe(1.0, 1.0, 0.3125, true);
  CakeRecipe volCake2 = new CakeRecipe(4.0, 2.0, 1.6875, true);
  CakeRecipe volCake3 = new CakeRecipe(4.0, 2.0, 1.6875, true);
  CakeRecipe volCake4 = new CakeRecipe(4.0, 3.0, 1.46875, true);
  
  // what if the volume boolean flag is false?
  CakeRecipe volCake5 = new CakeRecipe(17.0, 4.5, 12.5, false);
  
  // test constructor throw errors
  boolean testCakerRecipeConstructorErrors(Tester t) {
    return 
        // when weight of sugar and flour aren't the same
        t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of flour and sugar are not the same"),
        "CakeRecipe", 5.0, 4.0, 3.0, 3.0, 2.0)
        // when weight of butter and eggs aren't the same
        && t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of eggs and butter are not the same"),
        "CakeRecipe", 5.0, 5.0, 3.0, 1.0, 2.0)
        // when weight of milk plus eggs are not the same as weight of flour
        && t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of eggs plus milk are not the same as weight of flour"),
        "CakeRecipe", 5.0, 5.0, 3.0, 3.0, 1.0)
        // weight is not in range
        && t.checkConstructorException(new IllegalArgumentException(
        "Weight(s) is not in range"),
        "CakeRecipe", -1.0, 5.0, 3.0, 3.0, 1.0)
        
        // three ingredient constructor throw
        // when weight of milk plus eggs are not the same as weight of flour
        && t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of eggs plus milk are not the same as weight of flour"),
        "CakeRecipe", 5.0, 3.0, 1.0)
        // weight is not in range
        && t.checkConstructorException(new IllegalArgumentException(
        "Weight(s) is not in range"),
        "CakeRecipe", -1.0, 5.0, 3.0)
        
        // volume contructor throw
        // when weight of milk plus eggs are not the same as weight of flour
        && t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of eggs plus milk are not the same as weight of flour"),
        "CakeRecipe", 5.0, 3.0, 1.0, true)
        // they are not volumes; weight of milk pluc eggs are not the same as weight of flour
        && t.checkConstructorException(new IllegalArgumentException(
        "Not a perfect recipe: Weight of eggs plus milk are not the same as weight of flour"),
        "CakeRecipe", 5.0, 3.0, 1.0, false)
        // when a weight is not in range
        && t.checkConstructorException(new IllegalArgumentException("Weight(s) is not in range"),
        "CakeRecipe", 0.0, 3.0, 1.0, true);
  }
  
  // test throw utils
  boolean testUtils(Tester t) {
    return 
        // weight isn't in range
        t.checkException(new IllegalArgumentException("Weight(s) is not in range"), 
            new Utils(), 
            "checkRecipe", 0.0, 5.0, "Weight(s) is not in range")
        // when the items are not the same weight
        && t.checkException(new IllegalArgumentException(
            "Not a perfect recipe: Weight of flour and sugar are not the same"),
            new Utils(), 
            "checkRecipe", 6.0, 5.0, 
            "Weight of flour and sugar are not the same");
  }
  
  // test sameRecipe method
  boolean testSameRecipe(Tester t) {
    return 
        // full constructor
        // the recipes are the same
        t.checkExpect(this.fullCake2.sameRecipe(this.fullCake3), true)
        // flour/sugar is different
        && t.checkExpect(this.fullCake2.sameRecipe(this.fullCake4), false)
        // eggs/butter are different
        && t.checkExpect(this.fullCake2.sameRecipe(this.fullCake5), false)
        
        // volume constructor
        // the recipes are the same
        && t.checkExpect(this.volCake2.sameRecipe(this.volCake3), true)
        // flour/sugar is different
        && t.checkExpect(this.volCake2.sameRecipe(this.volCake1), false)
        // eggs/butter are different
        && t.checkExpect(this.volCake2.sameRecipe(this.volCake4), false)
        
        
        // three ingredient constructor
        // the recipes are the same
        && t.checkExpect(this.threeCake2.sameRecipe(this.threeCake3), true)
        // the flour/sugar is different
        && t.checkExpect(this.threeCake2.sameRecipe(this.threeCake4), false)
        // the eggs/butter are different
        && t.checkExpect(this.threeCake2.sameRecipe(this.threeCake5), false)
        
        // different constructors
        // full + three ingredient - same
        && t.checkExpect(this.fullCake2.sameRecipe(this.threeCake3), true)
        // full + three ingredient - different
        && t.checkExpect(this.fullCake2.sameRecipe(this.threeCake1), false)
        // full + vol - same
        && t.checkExpect(this.fullCake2.sameRecipe(this.volCake3), true)
        // full + vol - different
        && t.checkExpect(this.fullCake2.sameRecipe(this.volCake1), false)
        // vol + three ingredient - same
        && t.checkExpect(this.volCake2.sameRecipe(this.fullCake3), true)
        // vol + three ingredient - different
        && t.checkExpect(this.volCake2.sameRecipe(this.fullCake1), false);
  }
}


