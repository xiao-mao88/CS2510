import java.util.Comparator;
import tester.Tester;

// represents a binary search tree
abstract class ABST<T> {
  Comparator<T> order; // the comparator that will be used on the BST
  
  ABST(Comparator<T> order) {
    this.order = order;
  }
  
  /* Template:
   * Fields:
   * ... this.order ...        -- Comparator <T>
   * 
   * Methods:
   * ... this.insert(T) ...                       -- ABST<T>
   * ... this.present(T) ...                      -- boolean
   * ... this.getLeftmost() ...                   -- T
   * ... this.getRight() ...                      -- ABST<T>
   * ... this.sameTree(ABST<T> that) ...          -- boolean
   * ... this.sameTreeHelper(Node<T> that) ...    -- boolean
   * ... this.sameData(ABST<T> that) ...          -- boolean
   * ... this.buildList() ...                     -- IList<T>
   * ... this.sameLeaf(Leaf<T>) ...               -- boolean
   * 
   * Methods of Fields:
   * ... this.order.compare(T, T) ...             -- int
   */
  
  // inserts an item into the binary tree
  public abstract ABST<T> insert(T item);
  
  // checks if an item is in the binary tree
  public abstract boolean present(T item);
  
  // returns the leftmost item in the binary tree
  public abstract T getLeftmost();
  
  // returns this binary tree without the leftmost item
  public abstract ABST<T> getRight();
  
  // checks if this binary tree is the same as that binary tree
  public abstract boolean sameTree(ABST<T> that);
  
  // helper for sameTree
  public abstract boolean sameTreeHelper(Node<T> that);
  
  // checks if this binary tree contains the same data as that binary tree
  public abstract boolean sameData(ABST<T> that);
  
  // turns a list into a binary tree that is sorted
  public abstract IList<T> buildList();
  
  // determines whether this leaf is the a the same as that leaf 
  public abstract boolean sameLeaf(Leaf<T> that);
}

// represents an empty or leaf of a binary search tree
class Leaf<T> extends ABST<T> {
  Leaf(Comparator<T> order) {
    super(order);
  }
  
  /* Template:
   * Fields:
   * ... this.order ...        -- Comparator <T>
   * 
   * Methods:
   * ... this.insert(T) ...                       -- ABST<T>
   * ... this.present(T) ...                      -- boolean
   * ... this.getLeftmost() ...                   -- T
   * ... this.getRight() ...                      -- ABST<T>
   * ... this.sameTree(ABST<T> that) ...          -- boolean
   * ... this.sameTreeHelper(Node<T> that) ...    -- boolean
   * ... this.sameData(ABST<T> that) ...          -- boolean
   * ... this.buildList() ...                     -- IList<T>
   * ... this.sameLeaf(Leaf<T>) ...               -- boolean
   * 
   * Methods of Fields:
   * ... this.order.compare(T, T) ...             -- int
   */
  
  // inserts the given item into the correct place
  public ABST<T> insert(T item) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return new Node<T>(this.order, item, new Leaf<T>(this.order), new Leaf<T>(this.order));
  }
  
  // determines if the given item is present in this BST
  public boolean present(T item) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return false;
  }
  
  // since this is a leaf, will throw an exception saying that there is no left most item in 
  // an empty tree
  public T getLeftmost() {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    throw new RuntimeException("No leftmost item of an empty tree"); 
  }
  
  // since this is a leaf, will throw an exception saying that there is no right of an empty tree
  public ABST<T> getRight() {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    throw new RuntimeException("No right of an empty tree");
  }
  
  // is this tree the same as that tree?
  public boolean sameTree(ABST<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ... that.order ...           -- Comparator <T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return that.sameLeaf(this);
  }
  
  // helper for sameTree, helps to test the node
  public boolean sameTreeHelper(Node<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ... that.order ...           -- Comparator <T>
     * ... that.data ...            -- T
     * ... that.left ...            -- ABST<T>
     * ... that.right ...           -- ABST<T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return false;
  }
  
  // determines whether this tree contains the same data as that tree
  public boolean sameData(ABST<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ... that.order ...           -- Comparator <T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return true;
  }
  
  // turns a binary search tree into a sorted list
  public IList<T> buildList() {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ...
     */
    return new MtList<T>();
  }
  
  // is this leaf the same as that leaf
  public boolean sameLeaf(Leaf<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... this.order.compare(T, T) ...             -- int
     * 
     * Fields of Parameters:
     * ... that.order ...           -- Comparator <T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return this.order == that.order;
  }
}

// represents a node of a binary search tree
class Node<T> extends ABST<T> {
  T data; // the value/item in of this node
  ABST<T> left; // the left branch of this node
  ABST<T> right; // the right branch of this node
  
  Node(Comparator<T> order, T data, ABST<T> left, ABST<T> right) {
    super(order);
    this.data = data;
    this.left = left;
    this.right = right;
  }
  
  /* Template:
   * Fields:
   * ... this.order ...        -- Comparator <T>
   * ... this.data ...         -- T
   * ... this.left ...         -- ABST<T>
   * ... this.right ...        -- ABST<T>
   * 
   * Methods:
   * ... this.insert(T) ...                       -- ABST<T>
   * ... this.present(T) ...                      -- boolean
   * ... this.getLeftmost() ...                   -- T
   * ... this.getRight() ...                      -- ABST<T>
   * ... this.sameTree(ABST<T> that) ...          -- boolean
   * ... this.sameTreeHelper(Node<T> that) ...    -- boolean
   * ... this.sameData(ABST<T> that) ...          -- boolean
   * ... this.buildList() ...                     -- IList<T>
   * ... this.sameLeaf(Leaf<T>) ...               -- boolean
   * 
   * Methods of Fields:
   * ... this.order.compare(T, T) ...                  -- int
   * 
   * ... this.left.insert(T) ...                       -- ABST<T>
   * ... this.left.present(T) ...                      -- boolean
   * ... this.left.getLeftmost() ...                   -- T
   * ... this.left.getRight() ...                      -- ABST<T>
   * ... this.left.sameTree(ABST<T> that) ...          -- boolean
   * ... this.left.sameTreeHelper(Node<T> that) ...    -- boolean
   * ... this.left.sameData(ABST<T> that) ...          -- boolean
   * ... this.left.buildList() ...                     -- IList<T>
   * ... this.left.sameLeaf(Leaf<T>) ...               -- boolean
   * 
   * ... this.right.insert(T) ...                      -- ABST<T>
   * ... this.right.present(T) ...                     -- boolean
   * ... this.right.getLeftmost() ...                  -- T
   * ... this.right.getRight() ...                     -- ABST<T>
   * ... this.right.sameTree(ABST<T> that) ...         -- boolean
   * ... this.right.sameTreeHelper(Node<T> that) ...   -- boolean
   * ... this.right.sameData(ABST<T> that) ...         -- boolean
   * ... this.right.buildList() ...                    -- IList<T>
   * ... this.right.sameLeaf(Leaf<T>) ...              -- boolean
   */
  
  // inserts the given item into the correct placement in this BST
  public ABST<T> insert(T item) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
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
    if (this.order.compare(this.data, item) <= 0) {
      return new Node<T>(this.order, this.data, this.left, this.right.insert(item));
    }
    else {
      return new Node<T>(this.order, this.data, this.left.insert(item), this.right);
    }
  }
  
  // checks if the given item is present within this BST
  public boolean present(T item) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
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
    return this.order.compare(this.data, item) == 0 
        || this.left.present(item) 
        || this.right.present(item);
  }
  
  // gets the left most item in a BST
  public T getLeftmost() {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
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
    if (this.left.sameLeaf(new Leaf<T>(this.order))) {
      return this.data;
    }
    else {
      return this.left.getLeftmost();
    }
  }
  
  // returns this BST except for the left most item
  public ABST<T> getRight() { 
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
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
    if (this.left.sameLeaf(new Leaf<T>(this.order))) {
      return this.right;
    }
    else {
      return new Node<T>(this.order, this.data, this.left.getRight(), this.right);
    }
  }
  
  // determines if this tree is the same as that tree
  public boolean sameTree(ABST<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ... that.order ...         -- Comparator<T>
     *  
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return that.sameTreeHelper(this);
  }
  
  // helps to determine if this tree is the same as that tree
  public boolean sameTreeHelper(Node<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ... that.order ...         -- Comparator<T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     *  
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    if (this.order.compare(this.data, that.data) == 0) {
      return that.left.sameTree(this.left) && that.right.sameTree(this.right);
    }
    else {
      return false;
    }
  }
  
  // checks if two trees have the same data (does not need to be in the same order)
  public boolean sameData(ABST<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ... that.order ...         -- Comparator<T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    if (this.order.compare(this.getLeftmost(), that.getLeftmost()) == 0) {
      return this.getRight().sameData(that.getRight());
    }
    else {
      return false;
    }
  } 
  
  // turns this BST into a sorted list
  public IList<T> buildList() {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
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
    return new ConsList<T>(this.getLeftmost(), this.getRight().buildList());
  }
  
  // is this leaf the same as that leaf
  public boolean sameLeaf(Leaf<T> that) {
    /* Template:
     * Fields:
     * ... this.order ...        -- Comparator <T>
     * ... this.data ...         -- T
     * ... this.left ...         -- ABST<T>
     * ... this.right ...        -- ABST<T>
     * 
     * Methods:
     * ... same as before ...
     * 
     * Methods of Fields:
     * ... same as before ...
     * 
     * Fields of Parameters:
     * ... that.order ...         -- Comparator<T>
     * 
     * Methods of Parameters:
     * ... that.insert(T) ...                       -- ABST<T>
     * ... that.present(T) ...                      -- boolean
     * ... that.getLeftmost() ...                   -- T
     * ... that.getRight() ...                      -- ABST<T>
     * ... that.sameTree(ABST<T> that) ...          -- boolean
     * ... that.sameTreeHelper(Node<T> that) ...    -- boolean
     * ... that.sameData(ABST<T> that) ...          -- boolean
     * ... that.buildList() ...                     -- IList<T>
     * ... that.sameLeaf(Leaf<T>) ...               -- boolean
     */
    return false;
  }
}

// represents a book
class Book {
  String title; // title of the book
  String author; // author of the book
  int price; // price of the book
  
  /* 
   * Template:
   * Fields:
   * ... this.title ...        -- String
   * ... this.author ...       -- String
   * ... this.price ...        -- int
   * 
   * Methods:
   * ...
   * 
   * Methods of Fields:
   * ...
   */
  
  Book(String title, String author, int price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }
  
}

// compares books by their title
class BooksByTitle implements Comparator<Book> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.compare(Book, Book) ...      -- int
   * 
   * Methods of Fields:
   * ...
   */
  
  public int compare(Book b1, Book b2) {
    return b1.title.compareTo(b2.title);
  }
  
}

// compares books by their author
class BooksByAuthor implements Comparator<Book> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.compare(Book, Book) ...      -- int
   * 
   * Methods of Fields:
   * ...
   */

  public int compare(Book b1, Book b2) {
    return b1.author.compareTo(b2.author);
  }
  
}

class BooksByPrice implements Comparator<Book> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.compare(Book, Book) ...      -- int
   * 
   * Methods of Fields:
   * ...
   */
  
  public int compare(Book b1, Book b2) {
    return b1.price - b2.price;
  }
}

// represents an interface for a generic list
interface IList<T> {}

// represents an empty list for a generic list
class MtList<T> implements IList<T> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ...
   * 
   * Methods of Fields:
   * ...
   */
}

// represents a list for a generic list
class ConsList<T> implements IList<T> {
  T first; // the first item in the list
  IList<T> rest; // the rest of the list
  /* Template:
   * Fields:
   * ... this.first ...       -- T
   * ... this.rest ...        -- IList<T>
   * 
   * Methods:
   * ...
   * 
   * Methods of Fields:
   * ...
   */
  
  ConsList(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }
} 

class ExamplesABST {
  // comparator for titles of Books
  Comparator<Book> titles = new BooksByTitle();
  
  // comparator for authors of Books
  Comparator<Book> authors = new BooksByAuthor();
  
  // comparator for prices of Books
  Comparator<Book> prices = new BooksByPrice();
  
  // some books
  Book farenheit = new Book("Farenheit 451", "Ray Bradbury", 15);
  Book tiger = new Book("Tiger Mother", "Amy Chua", 20);
  Book animal = new Book("Animal Farm", "George Orwell", 10);
  Book onePiece = new Book("One Piece", "Eiichiro Oda", 13);
  
  // BST of Books using title comparator
  // Leaf of comparing Books using titles
  Leaf<Book> titleLeaf = new Leaf<Book>(this.titles);
  // Nodes of comparing Books using titles
  Node<Book> title1 = new Node<Book>(this.titles, this.animal, this.titleLeaf, this.titleLeaf);
  Node<Book> title2 = new Node<Book>(this.titles, this.tiger, this.titleLeaf, this.titleLeaf);
  // Larger BST
  ABST<Book> title3 = new Node<Book>(this.titles, this.farenheit, this.title1, this.title2);
  //After inserting the one piece book
  ABST<Book> title4 = new Node<Book>(this.titles, this.farenheit, this.title1, 
      new Node<Book>(this.titles, this.tiger, 
          new Node<Book>(this.titles, this.onePiece, this.titleLeaf, this.titleLeaf), 
          this.titleLeaf));
  
  // BST of Books using authors comparator
  // Leaf of comparing Books using authors
  Leaf<Book> authorLeaf = new Leaf<Book>(this.authors);
  // Nodes of comparing books using authors
  Node<Book> author1 = new Node<Book>(this.authors, this.tiger, this.authorLeaf, this.authorLeaf);
  Node<Book> author2 = new Node<Book>(this.authors, this.farenheit, 
      this.authorLeaf, this.authorLeaf);
  // Larger BST
  ABST<Book> author3 = new Node<Book>(this.authors, this.animal, this.author1, this.author2);
  // After inserting the one piece book
  ABST<Book> author4 = new Node<Book>(this.authors, this.animal, 
      new Node<Book>(this.authors, this.tiger, this.authorLeaf, 
          new Node<Book>(this.authors, this.onePiece, this.authorLeaf, this.authorLeaf)), 
      this.author2);
  
  // BST of Books using prices comparator
  // Leaf of comparing Books using prices
  Leaf<Book> priceLeaf = new Leaf<Book>(this.prices);
  // Nodes of comparing books using prices
  Node<Book> price1 = new Node<Book>(this.prices, this.animal, this.priceLeaf, this.priceLeaf);
  Node<Book> price2 = new Node<Book>(this.prices, this.tiger, this.priceLeaf, this.priceLeaf);
  // Larger BST
  ABST<Book> price3 = new Node<Book>(this.prices, this.farenheit, this.price1, this.price2);
  // After inserting the one piece book
  ABST<Book> price4 = new Node<Book>(this.prices, this.farenheit, 
      new Node<Book>(this.prices, this.animal, this.priceLeaf, 
          new Node<Book>(this.prices, this.onePiece, this.priceLeaf, this.priceLeaf)), this.price2);
  
  
  // empty list for books
  IList<Book> empty = new MtList<Book>();
  
  // testing insert method
  boolean testInsert(Tester t) {
    return 
        // inserting into a leaf with title comparator
        t.checkExpect(this.titleLeaf.insert(this.animal), this.title1)
        // inserting into a leaf with author comparator
        && t.checkExpect(this.authorLeaf.insert(this.tiger), this.author1)
        // inserting into a leaf with price comparator
        && t.checkExpect(this.priceLeaf.insert(this.animal), this.price1)
        // inserting into a BST of books using title comparator
        && t.checkExpect(this.title3.insert(this.onePiece), this.title4)
        // inserting into a BST of books using title comparator (duplicate)
        && t.checkExpect(this.title3.insert(this.animal), 
            new Node<Book>(this.titles, this.farenheit,
                new Node<Book>(this.titles, this.animal, this.titleLeaf,
                    new Node<Book>(this.titles, this.animal, this.titleLeaf, 
                        this.titleLeaf)), this.title2))
        // inserting into a BST of books using author comparator
        && t.checkExpect(this.author3.insert(this.onePiece), this.author4)
        // inserting into a BST of books using author comparator (duplicate)
        && t.checkExpect(this.author3.insert(this.animal), 
            new Node<Book>(this.authors, this.animal, this.author1, 
                new Node<Book>(this.authors, this.farenheit, 
                    new Node<Book>(this.authors, this.animal, this.authorLeaf, 
                        this.authorLeaf), this.authorLeaf)))
        // inserting into a BST of books using price comparator
        && t.checkExpect(this.price3.insert(this.onePiece), this.price4)
        // inserting into a BST of books using price comparator (duplicate)
        && t.checkExpect(this.price3.insert(this.animal), 
            new Node<Book>(this.prices, this.farenheit,
                new Node<Book>(this.prices, this.animal, this.priceLeaf,
                    new Node<Book>(this.prices, this.animal, this.priceLeaf, 
                        this.priceLeaf)), this.price2));
  }
  
  // testing present method
  boolean testPresent(Tester t) {
    return 
        // testing whether it is present within a leaf
        t.checkExpect(this.authorLeaf.present(this.animal), false)
        // testing whether it is present in a BST of books using title comparator (not present)
        && t.checkExpect(this.title3.present(this.onePiece), false)
        // testing whether it is present in a BST of books using title comparator (is present)
        && t.checkExpect(this.title3.present(this.animal), true)
        // testing whether it is present in a BST of books using author comparator (not present)
        && t.checkExpect(this.author3.present(this.onePiece), false)
        // testing whether it is present in a BST of books using author comparator (is present)
        && t.checkExpect(this.author3.present(this.animal), true)
        // testing whether it is present in a BST of books using price comparator (not present)
        && t.checkExpect(this.price3.present(this.onePiece), false)
        // testing whether it is present in a BST of books using title comparator (is present)
        && t.checkExpect(this.price3.present(this.animal), true);
  }
  
  // testing getLeftmost method
  boolean testGetLeftMost(Tester t) {
    return 
        // testing on a leaf (should throw an exception)
        t.checkException(new RuntimeException("No leftmost item of an empty tree"), 
            this.authorLeaf, "getLeftmost")
        // getting left most of a BST of books with a single node (title comparator)
        && t.checkExpect(this.title1.getLeftmost(), this.animal)
        // getting left most of a BST of books with a single node (author comparator)
        && t.checkExpect(this.author1.getLeftmost(), this.tiger)
        // getting left most of a BST of books with a single node (price comparator)
        && t.checkExpect(this.price1.getLeftmost(), this.animal)
        // getting left most of a BST of books (title comparator)
        && t.checkExpect(this.title3.getLeftmost(), this.animal)
        // getting left most of a BST of books (author comparator)
        && t.checkExpect(this.author3.getLeftmost(), this.tiger)
        // getting left most of a BST of books (price comparator)
        && t.checkExpect(this.price3.getLeftmost(), this.animal);
  }
  
  // testing getRight method
  boolean testGetRight(Tester t) {
    return 
        // testing on a leaf (should throw an exception)
        t.checkException(new RuntimeException("No right of an empty tree"), 
            this.authorLeaf, "getRight")
        // getting right of a BST of books with a single node (title comparator)
        && t.checkExpect(this.title1.getRight(), this.titleLeaf)
        // getting right of a BST of books with a single node (author comparator)
        && t.checkExpect(this.author1.getRight(), this.authorLeaf)
        // getting right of a BST of books with a single node (price comparator)
        && t.checkExpect(this.price1.getRight(), this.priceLeaf)
        // getting right of a BST of books (title comparator)
        && t.checkExpect(this.title3.getRight(), 
            new Node<Book>(this.titles, this.farenheit, this.titleLeaf, this.title2))
        // getting right of a BST of books (author comparator)
        && t.checkExpect(this.author3.getRight(), 
            new Node<Book>(this.authors, this.animal, this.authorLeaf, this.author2))
        // getting right of a BST of books (price comparator)
        && t.checkExpect(this.price3.getRight(), 
            new Node<Book>(this.prices, this.farenheit, this.priceLeaf, this.price2));
  }
  
  // testing sameTree method
  boolean testSameTree(Tester t) {
    return 
        // two leafs; same comparator
        t.checkExpect(this.titleLeaf.sameTree(new Leaf<Book>(this.titles)), true)
        // two leafs; different comparator
        && t.checkExpect(this.titleLeaf.sameTree(this.authorLeaf), false)
        // two BSTs; same tree; title comparator
        && t.checkExpect(this.title3.sameTree(this.title3), true)
        // two BSTs; same tree; author comparator
        && t.checkExpect(this.author3.sameTree(this.author3), true)
        // two BSTs; same tree; price comparator
        && t.checkExpect(this.price3.sameTree(this.price3), true)
        // two BSTs; same data, but different structure; title comparator
        && t.checkExpect(this.title3.sameTree(
            new Node<Book>(this.titles, this.animal, this.titleLeaf, 
                new Node<Book>(this.titles, this.farenheit, this.titleLeaf, this.title2))), false)
        // two BSTs; same data, but different structure; author comparator
        && t.checkExpect(this.author3.sameTree(
            new Node<Book>(this.authors, this.farenheit, 
                new Node<Book>(this.authors, this.animal, this.author1, this.authorLeaf), 
                this.authorLeaf)), false)
        // two BSTs; same data, but different structure; price comparator
        && t.checkExpect(this.price3.sameTree(
            new Node<Book>(this.prices, this.animal, this.priceLeaf, 
                new Node<Book>(this.prices, this.farenheit, this.priceLeaf, this.price1))), false)
        // two BSTs; different comparators
        && t.checkExpect(this.title1.sameTree(this.author1), false)
        // two BSTs; completely different; title comparator
        && t.checkExpect(this.title1.sameTree(this.title2), false)
        // two BSTs; completely different; author comparator
        && t.checkExpect(this.author1.sameTree(this.author2), false)
        // two BSTs; completely different; price comparator
        && t.checkExpect(this.price1.sameTree(this.price2), false);
  }
  
  // testing sameTreeHelper method
  boolean testSameTreeHelper(Tester t) {
    return 
        // one leaf, one node
        t.checkExpect(this.authorLeaf.sameTreeHelper(this.author1), false)
        // two BSTs; same tree 
        && t.checkExpect(this.author1.sameTreeHelper(this.author1), true)
        // two BSTs; same data, but different structure
        && t.checkExpect(this.author3.sameTreeHelper(
            new Node<Book>(this.authors, this.farenheit, 
                new Node<Book>(this.authors, this.animal, this.author1, this.authorLeaf), 
                this.authorLeaf)), false)
        // two BSTs; different comparators
        && t.checkExpect(this.author1.sameTreeHelper(this.title1), false)
        // two BSTs; completely different
        && t.checkExpect(this.author1.sameTreeHelper(this.author2), false);
  }
  
  // testing sameData method
  boolean testSameData(Tester t) {
    return 
        // two leafs; same comparator
        t.checkExpect(this.authorLeaf.sameData(this.authorLeaf), true)
        // two leafs; different comparator
        && t.checkExpect(this.authorLeaf.sameData(this.titleLeaf), true)
        // two BSTs; completely the same; title comparator
        && t.checkExpect(this.title3.sameData(this.title3), true)
        // two BSTs; completely the same; author comparator
        && t.checkExpect(this.author3.sameData(this.author3), true)
        // two BSTs; completely the same; price comparator
        && t.checkExpect(this.price3.sameData(this.price3), true)
        // two BSTs; same data, but different structures; title comparator
        && t.checkExpect(this.title3.sameData(
            new Node<Book>(this.titles, this.animal, this.titleLeaf, 
                new Node<Book>(this.titles, this.farenheit, this.titleLeaf, this.title2))), true)
        // two BSTs; same data, but different structures; author comparator
        && t.checkExpect(this.author3.sameData(
            new Node<Book>(this.authors, this.farenheit, 
                new Node<Book>(this.authors, this.animal, this.author1, this.authorLeaf), 
                this.authorLeaf)), true)
        // two BSTs; same data, but different structures; price comparator
        && t.checkExpect(this.price3.sameData(
            new Node<Book>(this.prices, this.animal, this.priceLeaf, 
                new Node<Book>(this.prices, this.farenheit, this.priceLeaf, this.price2))), true)
        // two BSTs; completely different
        && t.checkExpect(this.price3.sameData(this.title4), false)
        // two BSTs that have the sameData, but different comparators
        && t.checkExpect(this.price3.sameData(this.title3), true);
  }
  
  // testing buildList method
  boolean testBuildList(Tester t) {
    return 
        // leaf with title comparator
        t.checkExpect(this.titleLeaf.buildList(), this.empty)
        // leaf with author comparator
        && t.checkExpect(this.authorLeaf.buildList(), this.empty)
        // leaf with price comparator
        && t.checkExpect(this.priceLeaf.buildList(), this.empty)
        // single node with title comparator
        && t.checkExpect(this.title1.buildList(), new ConsList<Book>(this.animal, this.empty))
        // single node with author comparator
        && t.checkExpect(this.author1.buildList(), new ConsList<Book>(this.tiger, this.empty))
        // single node with price comparator
        && t.checkExpect(this.price1.buildList(), new ConsList<Book>(this.animal, this.empty))
        // BST with title comparator
        && t.checkExpect(this.title3.buildList(), new ConsList<Book>(this.animal, 
            new ConsList<Book>(this.farenheit, new ConsList<Book>(this.tiger, this.empty))))
        && t.checkExpect(this.title4.buildList(),new ConsList<Book>(this.animal, 
            new ConsList<Book>(this.farenheit, new ConsList<Book>(this.onePiece, 
                new ConsList<Book>(this.tiger, this.empty)))))
        // BST with author comparator
        && t.checkExpect(this.author3.buildList(), new ConsList<Book>(this.tiger, 
            new ConsList<Book>(this.animal, new ConsList<Book>(this.farenheit, this.empty))))
        && t.checkExpect(this.author4.buildList(),new ConsList<Book>(this.tiger, 
            new ConsList<Book>(this.onePiece, new ConsList<Book>(this.animal, 
                new ConsList<Book>(this.farenheit, this.empty)))))
        // BST with price comparator
        && t.checkExpect(this.price3.buildList(),new ConsList<Book>(this.animal, 
            new ConsList<Book>(this.farenheit, new ConsList<Book>(this.tiger, this.empty))))
        && t.checkExpect(this.price4.buildList(),new ConsList<Book>(this.animal, 
            new ConsList<Book>(this.onePiece, new ConsList<Book>(this.farenheit, 
                new ConsList<Book>(this.tiger, this.empty)))));
  }
  
  // testing sameLeaf method
  boolean testSameLeaf(Tester t) {
    return 
        // when the leaves are the same
        t.checkExpect(this.titleLeaf.sameLeaf(new Leaf<Book>(this.titles)), true)
        // when the leaves are different
        && t.checkExpect(this.authorLeaf.sameLeaf(this.titleLeaf), false);
  }
}





