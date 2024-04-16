import tester.Tester;

//represents an item at the grocery store
class Item {
  String name;
  int rating; //must be between 0 and 5, inclusive
  double price; // must be greater than 0
  
 //complete the design of the Item constructor
  Item (String name, int rating, double price) {
    Utils temp = new Utils();
    this.name = name;
    this.rating = temp.checkRange(rating);
    this.price = temp.checkPrice(price);
  }
  
  // replaces an item on the grocery list if given an item with the same name but which has an as good or better rating and a 
  // cheaper price
  public Item replaceItemHelper(Item i){
    if (this.name.equals(i.name) && this.rating <= i.rating && this.price > i.price) {
      return i;
    }
    else {
      return this;
    }
  }
}

// utils class; imposes the restrictions for the constructor for the Item class
class Utils {
  /* Template:
     Fields:
     ...
     Methods:
     this.checkRange(int) ...     -- int
     this.checkPrice(double) ...  -- double
  */
  // checks the range of the rating
  int checkRange(int num) {
    if (num >= 0 && num <= 5) {
      return num;
    }
    else {
      throw new IllegalArgumentException("The rating is not in range");
    }
  }
  
  // checks that the price is greater than 0
  double checkPrice(double num) {
    if (num > 0) {
      return num;
    }
    else {
      throw new IllegalArgumentException("The price must be greater than 0");
    }
  }
}

//represents a list of grocery items
interface ILoItem {
// replaces an item on the grocery list if given an item with the same name but which has an as good or better rating and a 
// cheaper price
ILoItem replaceItem(Item i);

// replaces all items in this list with items in the given list if they match names with the same or higher 
// ratings and lower prices
ILoItem replaceAll(ILoItem replacements);

// helper for replaceAll, for the sake of dynamic dispatch so that we can call this.first and this.rest on the list of replacements
ILoItem replaceAllHelper(ILoItem that);
}

//represents an empty list of grocery items
class MtLoItem implements ILoItem {
// replaces an item on the grocery list if given an item with the same name but which has an as good or better rating and a 
// cheaper price
public ILoItem replaceItem(Item i){
  return this;
}

// replaces all items in this list with items in the given list if they match names with the same or higher 
// ratings and lower prices
public ILoItem replaceAll(ILoItem replacements) {
  return this;
}

// helper for replaceAll, for the sake of dynamic dispatch so that we can call this.first and this.rest on the list of replacements
public ILoItem replaceAllHelper(ILoItem that){
  return that;
}
}

//represents a non-empty list of grocery items
class ConsLoItem implements ILoItem {
Item first;
ILoItem rest;

ConsLoItem(Item first, ILoItem rest) {
  this.first = first;
  this.rest = rest;
}

// replaces an item on the grocery list if given an item with the same name but which has an as good or better rating and a 
// cheaper price
public ILoItem replaceItem(Item i){
  return new ConsLoItem(this.first.replaceItemHelper(i), this.rest.replaceItem(i));
}

// replaces all item on the grocery list if given an item with the same name but which has an as good or better rating and a 
// cheaper price
public ILoItem replaceAll(ILoItem replacements) {
  return replacements.replaceAllHelper(this);
}

// helper for replaceAll, for the sake of dynamic dispatch so that we can call this.first and this.rest on the list of replacements
public ILoItem replaceAllHelper(ILoItem that) {
  return that.replaceItem(this.first).replaceAll(this.rest);
}
}

class ExamplesItems {
  // Items
  Item coffee1 = new Item("coffee", 3, 8.99);
  Item coffee2 = new Item("coffee", 5, 8.50);
  Item granola = new Item("granola", 4, 6.25);
  Item milk1 = new Item("milk", 2, 3.10);
  Item milk2 = new Item("milk", 4, 3.05);
  
  // ILoItems
  ILoItem mt = new MtLoItem();
  ILoItem groceryList = new ConsLoItem(this.granola,
                            new ConsLoItem(this.coffee1, 
                                new ConsLoItem(this.milk1, this.mt)));
  
  ILoItem replacements = new ConsLoItem(this.coffee2, 
                            new ConsLoItem(this.milk2, this.mt)); 
  Item granola2 = new Item("granola", 5, 5.0);
  ILoItem replacements2 = new ConsLoItem(this.coffee2, new ConsLoItem(this.granola2, this.mt));
  
  Item oatmeal = new Item("oatmeal", 5, 2.0);
  ILoItem replacements3 = new ConsLoItem(this.oatmeal, new ConsLoItem(this.milk1, this.mt));
  
  // tests replaceAll method
  boolean testReplaceAll(Tester t) {
    return
      // invoked on an empty list
      t.checkExpect(this.mt.replaceAll(this.replacements), this.mt)
      // replaces only 1 thing in the list, as the other does not fit all criteria 
      && t.checkExpect(this.groceryList.replaceAll(this.replacements), new ConsLoItem(this.granola, 
                                                                                   new ConsLoItem(this.coffee2, 
                                                                                                  new ConsLoItem(this.milk2, this.mt))))
      // there is nothing in the replacements list that fits the criteria to be replaced
      && t.checkExpect(this.groceryList.replaceAll(this.replacements3), this.groceryList)
      // everything in the replacements list fits the criteria to be a replacement
      && t.checkExpect(this.groceryList.replaceAll(this.replacements2), 
                       new ConsLoItem(this.granola2,
                                      new ConsLoItem(this.coffee2,
                                                     new ConsLoItem(this.milk1, this.mt))))
      // the list of replacements is empty
      && t.checkExpect(this.groceryList.replaceAll(this.mt), this.groceryList);
  }
}