import tester.Tester;
import java.util.function.Predicate;

// abstract class that represents a nods
abstract class ANode<T> {
  ANode<T> next; // the next node
  ANode<T> prev; // the previous node
  
  // counts the number of nodes
  public abstract int size(int count);
  
  // adds a node
  public void addValue(T value) {
    new Node<T>(value, this.next, this);
  }
  
  // removes a node
  public abstract T removeValue();
  
  // finds the first node that satisfies the predicate
  public abstract ANode<T> findHelp(Predicate<T> pred);
  
}

// represents a sentinel of type T
class Sentinel<T> extends ANode<T> {
  Sentinel() {
    this.next = this;
    this.prev = this;
  }
  
  // counts the number of nodes
  // Accumulator: accumulates the number of nodes 
  public int size(int count) {
    if (count > 0 || this == this.next) {
      return count;
    }
    else {
      return this.next.size(count);
    }
  }
  
  // removes a node
  public T removeValue() {
    throw new RuntimeException("Cannot remove from empty deque");
  }
  
  // finds the first node that satisfies the predicate
  public ANode<T> findHelp(Predicate<T> pred) {
    return this;
  }
}

// represents a node of type T
class Node<T> extends ANode<T> {
  T data; // represents the value in the node
  
  Node(T data) {
    this.next = null;
    this.prev = null;
    this.data = data;
  }
  
  Node(T data, ANode<T> next, ANode<T> prev) {
    if (prev == null || next == null) {
      throw new IllegalArgumentException("The previous or next node is null");
    }
    else {    
      this.data = data;
      this.next = next;
      this.prev = prev;
      prev.next = this;
      next.prev = this;
    }
  }
  
  // counts the number of nodes
  // Accumulator: accumulates the number of nodes 
  public int size(int count) {
    return this.next.size(count + 1);
  }
  
  // removes this node
  public T removeValue() {
    next.prev = this.prev;
    prev.next = this.next;
    return this.data;
  }
  
  // finds the first node that satisfies the predicate
  public ANode<T> findHelp(Predicate<T> pred) {
    if (pred.test(this.data)) {
      return this;
    }
    else {
      return this.next.findHelp(pred);
    }
  }
}

// represents a deque of type T
class Deque<T> {
  Sentinel<T> header; // the header of the deque
  
  Deque() {
    this.header = new Sentinel<T>();
  }
  
  Deque(Sentinel<T> header) {
    this.header = header;
  }
  
  // returns the size of this deque
  public int size() {
    return this.header.size(0);
  }
  
  // adds a node to the head of this deque
  public void addAtHead(T value) {
    this.header.addValue(value);
  }
  
  // adds a node to the tail of this deque
  public void addAtTail(T value) {
    this.header.prev.addValue(value);
  }
  
  // removes the first node from this deque and returns what was removed
  public T removeFromHead() {
    return this.header.next.removeValue();
  }
  
  // removes the last node from this deque and returns what was removed
  public T removeFromTail() {
    return this.header.prev.removeValue();
  }
  
  // finds the first node that satisfies the predicate
  public ANode<T> find(Predicate<T> pred) {
    return this.header.next.findHelp(pred);
  }
}

// checks if the string is equal to "bobby"
class IsBob implements Predicate<String> {
  @Override
  public boolean test(String str) {
    return str.equals("bobby");
  }
}

// checks if the string's length is 3
class LengthIsThree implements Predicate<String> {
  @Override
  public boolean test(String str) {
    return str.length() == 3;
  }
}

// checks if the number is even
class IsEven implements Predicate<Integer> {
  public boolean test(Integer num) {
    return num % 2 == 0;
  }
}

class ExamplesDeque {
  // initializations
  Sentinel<String> sen1;
  Sentinel<String> sen2;
  Sentinel<Integer> sen3;
  Sentinel<String> sen4;
  
  Node<String> abc;
  Node<String> bcd;
  Node<String> cde;
  Node<String> def;
  
  Node<Integer> one;
  Node<Integer> two;
  Node<Integer> three;
  Node<Integer> four;
  
  Node<String> mia;
  Node<String> lila;
  Node<String> bob; 
  Node<String> bob2;
  
  Deque<String> deque1;
  Deque<String> deque2;
  Deque<Integer> deque3;
  Deque<String> deque4;
  
  Node<String> millie;
  String mil = "millie";
  
  // initializes the data
  void initData() {
    // deque1
    sen1 = new Sentinel<String>();
    deque1 = new Deque<String>(this.sen1);
    
    // deque2
    sen2 = new Sentinel<String>();
    abc = new Node<String>("abc", this.sen2, this.sen2);
    bcd = new Node<String>("bcd", this.sen2, this.abc);
    cde = new Node<String>("cde", this.sen2, this.bcd);
    def = new Node<String>("def", this.sen2, this.cde);
    deque2 = new Deque<String>(this.sen2);
    
    // deque3
    sen3 = new Sentinel<Integer>();
    one = new Node<Integer>(1, this.sen3, this.sen3);
    two = new Node<Integer>(2, this.sen3, this.one);
    three = new Node<Integer>(3, this.sen3, this.two);
    four = new Node<Integer>(4, this.sen3, this.three);
    deque3 = new Deque<Integer>(this.sen3);
    
    // deque4
    sen4 = new Sentinel<String>();
    mia = new Node<String>("mia", this.sen4, this.sen4);
    lila = new Node<String>("lila", this.sen4, this.mia);
    bob = new Node<String>("bobby", this.sen4, this.lila);
    bob2 = new Node<String>("bobby", this.sen4, this.bob);
    deque4 = new Deque<String>(this.sen4);
  }
  
  // checking the illegal argument exception
  void testIllegelArgument(Tester t) {
    t.checkConstructorException(new IllegalArgumentException("The previous or next node is null"),
        "Node", "lila", null, new Sentinel<String>());
    t.checkConstructorException(new IllegalArgumentException("The previous or next node is null"),
        "Node", "lila", new Sentinel<String>(), null);
  }
  
  // main method tests
  // tests the size method
  void testSize(Tester t) {
    initData();
    // checks the size of an empty deque
    t.checkExpect(this.deque1.size(), 0);
    // checks the size of a non-empty deque
    t.checkExpect(this.deque4.size(), 4);
    // checks the size of a deque after another node has been added
    millie = new Node<String>("millie", this.sen4, this.bob2);
    t.checkExpect(this.deque4.size(), 5);
    
    // checks size method for a Sentinel
    // empty
    t.checkExpect(this.sen1.size(0), 0);
    // has nodes
    t.checkExpect(this.sen2.size(0), 4);
    // when the accumulator already has a value (would never happen when actually running though)
    t.checkExpect(this.sen2.size(3), 3);
    
    // checks size method for a Node
    // counting from the beginning
    t.checkExpect(this.abc.size(0), 4);
    // counting from the middle
    t.checkExpect(this.def.size(0), 1);
  }
  
  // tests the addAtHead method
  void testAddAtHead(Tester t) {
    initData();
    // adds to an empty deque
    t.checkExpect(this.deque1.header, this.sen1);
    t.checkExpect(this.deque1.header.next, this.sen1);
    this.deque1.addAtHead(this.mil);
    t.checkExpect(this.deque1.header.next, new Node<String>("millie", this.sen1, this.sen1));
    // adds to a nonempty deque
    t.checkExpect(this.deque2.header, this.sen2);
    t.checkExpect(this.deque2.header.next, this.abc);
    this.deque2.addAtHead("aaa");
    t.checkExpect(this.deque2.header.next, new Node<String>("aaa", this.abc, this.sen2));
    
    t.checkExpect(this.deque3.header, this.sen3);
    t.checkExpect(this.deque3.header.next, this.one);
    this.deque3.addAtHead(0);
    t.checkExpect(this.deque3.header.next, new Node<Integer>(0, this.one, this.sen3));
  }
  
  // tests the addAtTail method
  void testAddAtTail(Tester t) {
    initData();
    // adds to an empty deque
    t.checkExpect(this.deque1.header, this.sen1);
    t.checkExpect(this.deque1.header.prev, this.sen1);
    this.deque1.addAtTail(this.mil);
    t.checkExpect(this.deque1.header.prev, new Node<String>("millie", this.sen1, this.sen1));
    // adds to a nonempty deque
    t.checkExpect(this.deque2.header, this.sen2);
    t.checkExpect(this.deque2.header.prev, this.def);
    this.deque2.addAtTail("aaa");
    t.checkExpect(this.deque2.header.prev, new Node<String>("aaa", this.sen2, this.def));
    
    t.checkExpect(this.deque3.header, this.sen3);
    t.checkExpect(this.deque3.header.prev, this.four);
    this.deque3.addAtTail(5);
    t.checkExpect(this.deque3.header.prev, new Node<Integer>(5, this.sen3, this.four));
  }
  
  // tests the removeFromHead method
  void testRemoveFromHead(Tester t) {
    initData();
    // removes from an empty deque (should throw runtime exception)
    t.checkException(new RuntimeException("Cannot remove from empty deque"), 
        this.deque1, "removeFromHead");
    // removes from a nonempty deque
    t.checkExpect(this.deque2.header.next, this.abc);
    t.checkExpect(this.deque2.removeFromHead(), "abc");
    // checking linkages
    t.checkExpect(this.deque2.header.next, this.bcd);
    t.checkExpect(this.bcd.prev, this.sen2);
    t.checkExpect(this.deque2.header.prev, this.def);
    
    t.checkExpect(this.deque3.header.next, this.one);
    t.checkExpect(this.deque3.removeFromHead(), 1);
    // checking linkages
    t.checkExpect(this.deque3.header.next, this.two);
    t.checkExpect(this.two.prev, this.sen3);
    t.checkExpect(this.deque3.header.prev, this.four);
    
    t.checkExpect(this.deque4.header.next, this.mia);
    t.checkExpect(this.deque4.removeFromHead(), "mia");
    // checking linkages
    t.checkExpect(this.deque4.header.next, this.lila);
    t.checkExpect(this.lila.prev, this.sen4);
    t.checkExpect(this.deque4.header.prev, this.bob2);
  }
  
  // tests the removeFromTail method
  void testRemoveFromTail(Tester t) {
    initData();
    // removes from an empty deque (should throw runtime exception)
    t.checkException(new RuntimeException("Cannot remove from empty deque"), 
        this.deque1, "removeFromTail");
    // removes from a nonempty deque
    t.checkExpect(this.deque2.header.prev, this.def);
    t.checkExpect(this.deque2.removeFromTail(), "def");
    // checking linkages
    t.checkExpect(this.deque2.header.next, this.abc);
    t.checkExpect(this.cde.next, this.sen2);
    t.checkExpect(this.deque2.header.prev, this.cde);
    
    t.checkExpect(this.deque3.header.prev, this.four);
    t.checkExpect(this.deque3.removeFromTail(), 4);
    // checking linkages
    t.checkExpect(this.deque3.header.next, this.one);
    t.checkExpect(this.three.next, this.sen3);
    t.checkExpect(this.deque3.header.prev, this.three);
    
    t.checkExpect(this.deque4.header.prev, this.bob2);
    t.checkExpect(this.deque4.removeFromTail(), "bobby");
    // checking linkages
    t.checkExpect(this.deque4.header.next, this.mia);
    t.checkExpect(this.bob.next, this.sen4);
    t.checkExpect(this.deque4.header.prev, this.bob);
  }
  
  // tests the find method
  void testFind(Tester t) {
    initData();
    // using IsBob predicate
    // empty deque
    t.checkExpect(this.deque1.header, this.sen1);
    t.checkExpect(this.deque1.find(new IsBob()), this.sen1);
    // nonempty deque; item is not in the deque
    t.checkExpect(this.deque2.header, this.sen2);
    t.checkExpect(this.deque2.find(new IsBob()), this.sen2);
    // nonempty deque; item is in the deque/repeated
    t.checkExpect(this.deque4.header, this.sen4);
    t.checkExpect(this.deque4.find(new IsBob()), this.bob);
    
    // using IsEven predicate
    t.checkExpect(this.deque3.header, this.sen3);
    t.checkExpect(this.deque3.find(new IsEven()), this.two);
    
    // using LengthIsThree predicate
    // empty deque
    t.checkExpect(this.deque1.header, this.sen1);
    t.checkExpect(this.deque1.find(new IsBob()), this.sen1);
    // nonempty deque; item is in the deque/repeated
    t.checkExpect(this.deque2.header, this.sen2);
    t.checkExpect(this.deque2.find(new LengthIsThree()), this.abc);
    // nonempty deque; item is not in the deque
    t.checkExpect(this.deque4.header, this.sen4);
    this.deque4.removeFromHead();
    t.checkExpect(this.deque4.find(new LengthIsThree()), this.sen4);
  }
  
  
  // helper tests
  // tests the addValue method
  void testAddValue(Tester t) {
    initData();
    // adding value to sentinel
    t.checkExpect(this.sen1.next, this.sen1);
    this.sen1.addValue(this.mil);
    t.checkExpect(this.sen1.next, new Node<String>(this.mil, this.sen1, this.sen1));
    // adding value to node
    t.checkExpect(this.mia.next, this.lila);
    this.mia.addValue(this.mil);
    t.checkExpect(this.mia.next, new Node<String>(this.mil, this.lila, this.mia));
  }
  
  // tests the removeValue method
  void testRemoveValue(Tester t) {
    initData();
    // removing value from sentinel (should throw exception)
    t.checkException(new RuntimeException("Cannot remove from empty deque"), 
        this.sen1, "removeValue");
    // removing a node
    this.abc.removeValue();
    t.checkExpect(this.bcd.prev, this.sen2);
    t.checkExpect(this.sen2.next, this.bcd);
    
  }
  
  // tests the findHelp method
  void testFindHelp(Tester t) {
    initData();
    // findHelp on sentinel
    t.checkExpect(this.sen1.findHelp(new IsBob()), this.sen1);
    // findHelp on Node
    t.checkExpect(this.abc.findHelp(new IsBob()), this.sen2);
    t.checkExpect(this.lila.findHelp(new IsBob()), this.bob);
  }
  
  // tests the test method in IsBob
  boolean testIsBob(Tester t) {
    return 
        // when predicate is true
        t.checkExpect(new IsBob().test("mia"), false)
        // when predicate is false
        && t.checkExpect(new IsBob().test("bobby"), true);
  }
  
  // tests the test method in LengthIsThree
  boolean testLengthIsThree(Tester t) {
    return 
        // when predicate is false
        t.checkExpect(new LengthIsThree().test("mia"), true)
        // when predicate is true
        && t.checkExpect(new LengthIsThree().test("bobby"), false);
  }
  
  // tests the test method in LengthIsThree
  boolean testIsEven(Tester t) {
    return 
        // when predicate is true
        t.checkExpect(new IsEven().test(2), true)
        // when predicate is false
        && t.checkExpect(new IsEven().test(5), false);
  }
}





