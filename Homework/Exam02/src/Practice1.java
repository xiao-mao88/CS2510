import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import tester.Tester;

// problem 1
class Problem1 {
  // checks if source contains a sub-sequence of the integers in sequence. The sub-sequence should
  // contain the same numbers as sequence in the same order.
  boolean containsSequence (ArrayList<Integer> source, ArrayList<Integer> sequence) {
    ArrayList<Integer> newArr;
    for (int i = 0; i <= source.size() - sequence.size(); i ++) {
      newArr = new ArrayList<Integer>();
      
      for (int j = 0; j < sequence.size(); j ++) {
        newArr.add(source.get(j + i));
      }
      
      if (sequence.equals(newArr)) {
        return true;
      }
    }
    
    return false;
  }
}

// problem 2
// Design a void method in the class Deque<T> that appends a given Deque<T> to the end of this 
// Deque<T>. The method should append all the items of the given Deque onto the current one 
// and remove the items from that given Deque.
/*class Deque<T> {
  Sentinel<T> header;
  
  Deque() {
    this.header = new Sentinel<T>();
  }
  
  Deque(Sentinel<T> header) {
    this.header = header;
  }
  
  void append(Deque<T> dq) {
    if (!dq.header.next.isSentinel()) {
      this.addToTail(dq.header.next);
      dq.removeFromHead();
      this.append(dq);
    }
    
    // actual solution (pretty simple)
    for (int i = 0; i < size; i ++){
    this.addToTail(dq.removeFromHead);
    }
  }
}

abstract class ANode<T> {
  ANode<T> next;
  ANode<T> prev;
  
  //removes a node
  public abstract T removeValue();
}

class Sentinel<T> extends ANode<T> { 
  Sentinel() {
    this.next = this;
    this.prev = this;
  }
  
  // removes a node
  public T removeValue() {
    throw new RuntimeException("Cannot remove from empty deque");
  }
}

public class Node<T> extends ANode<T> {
  T data;
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
  
  // removes this node
  public T removeValue() {
    next.prev = this.prev;
    prev.next = this.next;
    return this.data;
  }
}*/

// problem 3
// Design an Iterator that is given another Iterator when constructed and iterates over every other
// element produced by the given Iterator.
class Problem3<T> implements Iterator<T>{
  Iterator<T> it;
  
  @Override
  public boolean hasNext() {
    return this.it.hasNext();
  }

  @Override
  public T next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("there are no more items!");
    }
    
    T ans = this.it.next();
    
    if (this.it.hasNext()) {
      this.it.next();
    }
    
    return ans;
  }
  
}

// skips over n elements
class Problem4<T> implements Iterator<T> {
  Iterator<T> source;
  int skips;
  
  Problem4(Iterator<T> source, int skips){
    this.source = source;
    this.skips = skips;
  }
  
  @Override
  public boolean hasNext() {
    // TODO Auto-generated method stub
    return this.source.hasNext();
  }

  @Override
  public T next() {
    if (!this.hasNext()) {
      throw new NoSuchElementException("there are no more items!");
    }
    
    T ans = this.source.next();
    
    for (int i = 1; i < this.skips - 1; i ++) {
      if (this.source.hasNext()) {
        this.source.next();
      }
    }
    // TODO Auto-generated method stub
    return ans;
  }
  
}



class ExamplesProblems {
  // test problem1
  Problem1 prob1 = new Problem1();
  ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
  ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
  ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
  ArrayList<Integer> arr4 = new ArrayList<Integer>(Arrays.asList(3, 4, 5));
  ArrayList<Integer> arr5 = new ArrayList<Integer>(Arrays.asList(2, 1, 3));
  
  boolean testProblem1(Tester t) {
    return 
        // when the sequence is at the start
        t.checkExpect(prob1.containsSequence(this.arr1, this.arr2), true)
        // when the sequence is not within the list
        && t.checkExpect(prob1.containsSequence(this.arr1, this.arr3), false)
        // when the sequence is in the source but not at the start
        && t.checkExpect(prob1.containsSequence(this.arr1, this.arr4), true)
        // when the sequence has the same numbers but is not in the right order
        && t.checkExpect(prob1.containsSequence(this.arr1, this.arr5), false);
  }
  
  // test problem2
  // initializations
  /*Sentinel<String> sen1;
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
  }*/

}





