import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import tester.Tester;

class Huffman {
  ArrayList<String> letters; // the alphabet to be encoded
  ArrayList<Integer> freq; // the frequency to encode the alphabet at
  ArrayList<ANode> forest; // list of the alphabet + frequencies
  
  // initially constructed with no forest
  Huffman(ArrayList<String> letters, ArrayList<Integer> freq) {
    if (letters.size() != freq.size() || letters.size() <= 1) {
      throw new IllegalArgumentException(
          "Lists are of different lengths or your alphabet is too short");
    }
    
    this.letters = letters;
    this.freq = freq;
    this.forest = this.createNodes();
    Collections.sort(this.forest, new CompareNodes());
    this.oneTree();
  }
  
  // after there is a forest
  Huffman(ArrayList<String> letters, ArrayList<Integer> freq, ArrayList<ANode> forest) {
    this.letters = letters;
    this.freq = freq; 
    this.forest = forest;
  }
  
  // turns the arraylist of letters and arraylist of frequencies into an arraylist of leafs
  public ArrayList<ANode> createNodes() {
    ArrayList<ANode> arr = new ArrayList<ANode>();
    for (int i = 0; i < this.letters.size(); i++) {
      arr.add(new Leaf(this.letters.get(i), this.freq.get(i)));
    }
    return arr;
  }
  
  // turns the forest into oneTree
  public void oneTree() {
    ArrayList<ANode> arr = this.forest; 
    ANode tempNode;
    
    while (arr.size() > 1) {
      tempNode = new Node(
          arr.get(0).addLetter(arr.get(1)),
          arr.get(0).addData(arr.get(1)),
          arr.get(0),
          arr.get(1));
      arr.remove(0);
      arr.remove(0);
      arr.add(tempNode);
      Collections.sort(arr, new CompareNodes());
    }
  }
  
  // encodes a string from this alphabet
  public ArrayList<Boolean> encode(String str) {
    ArrayList<Boolean> temp = new ArrayList<Boolean>();
    ANode node = this.forest.get(0);
    for (int i = 0; i < str.length(); i++) {
      temp = (node.encodeCharacter(str.substring(i, i + 1), temp));
    }
    return temp;
  }
  
  // decodes a given an arrayList of booleans
  public String decode(ArrayList<Boolean> code) {
    ANode key = this.forest.get(0);
    if (code.size() < 1) {
      return "";
    }
    return key.decodeHelper("", code, key);
  }
}

// compares the value within two nodes to determine order
class CompareNodes implements Comparator<ANode> {
  
  // checks which node is greater than the other
  public int compare(ANode o1, ANode o2) {
    return o1.data - o2.data;
  }

}

// ANode
abstract class ANode {
  String letter; // represents all the letters that have been encoded until this node
  int data; // the combined frequencies up until this node
  
  ANode(String letter, int data) {
    this.letter = letter;
    this.data = data;
  }
  
  // adds this nodes letter to that nodes letter and returns the string
  public String addLetter(ANode node) {
    return this.letter + node.letter;
  }
  
  // adds this nodes data to that nodes data and returns the integer
  public int addData(ANode node) {
    return this.data + node.data;
  }
  
  // encodes a character
  abstract ArrayList<Boolean> encodeCharacter(String let, ArrayList<Boolean> b);
  
  // checks if a letter is contained in the letter(s) of the node
  public boolean contains(String let) {
    return this.letter.indexOf(let) > -1;
  }
  
  // decodes from an arrayList of Booleans using the key
  abstract String decodeHelper(String decoded, ArrayList<Boolean> b, ANode key);
}

// a leaf that contains a letter and its frequency
class Leaf extends ANode {
  Leaf(String letter, int freq) {
    super(letter, freq);
  }
  
  // encodes a single character
  // ACCUMULATOR: the encoded arrayList of booleans is accumulated and returned
  public ArrayList<Boolean> encodeCharacter(String let, ArrayList<Boolean> b) {
    return b;
  }
  
  // helps decode a code with an arrayList of booleans and a key
  // ACCUMULATOR: the String decoded is repeatedly accumulated
  public String decodeHelper(String decoded, ArrayList<Boolean> b, ANode key) {
    if (b.size() > 0) {
      return key.decodeHelper(decoded + this.letter, b, key);
    }
    else {
      return decoded + this.letter;
    }
  }
}

// represents a node
class Node extends ANode {
  ANode left; // the left Anode
  ANode right; // the right ANode
  
  Node(String letter, int data, ANode left, ANode right) {
    super(letter, data);
    this.left = left;
    this.right = right;
  }
  
  // encodes a single character
  public ArrayList<Boolean> encodeCharacter(String let, ArrayList<Boolean> b) {
    if (this.left.contains(let)) {
      b.add(false);
      return this.left.encodeCharacter(let, b);
    }
    else if (this.right.contains(let)) {
      b.add(true);
      return this.right.encodeCharacter(let, b);
    }
    else {
      throw new IllegalArgumentException(
          "Tried to encode " + let + " but that is not part of the language.");
    }
  }
  
  // decodes from an arrayList of Booleans using the key
  public String decodeHelper(String decoded, ArrayList<Boolean> b, ANode key) {
    if (b.size() < 1) {
      return decoded + "?";
    }
    
    else if (b.get(0)) {
      b.remove(0);
      return this.right.decodeHelper(decoded, b, key);
    }
    
    else {
      b.remove(0);
      return this.left.decodeHelper(decoded, b, key);
    }
  }
}

// examples class
class ExamplesHuffman {
  // initializing some examples for a shorter alphabet
  ArrayList<String> let1;
  ArrayList<Integer> freq1;
  ANode h1Leaf1;
  ANode h1Leaf2;
  ANode h1Node1;
  
  Huffman huff1;
  
  // initializing some examples for a longer alphabet
  ArrayList<String> let2;
  ArrayList<Integer> freq2;
  ANode h2Leaf1;
  ANode h2Leaf2;
  ANode h2Leaf3;
  ANode h2Node1;
  ANode h2Node2;
  
  Huffman huff2;
  
  // initializes the data
  public void initData() {
    // for huff1
    let1 = new ArrayList<String>();
    let1.add("a");
    let1.add("b");
    freq1 = new ArrayList<Integer>();
    freq1.add(2);
    freq1.add(3);
    
    huff1 = new Huffman(this.let1, this.freq1);
    
    // nodes of huff1
    h1Leaf1 = new Leaf("a", 2);
    h1Leaf2 = new Leaf("b", 3);
    h1Node1 = new Node("ab", 5, this.h1Leaf1, this.h1Leaf2);
    
    // for huff2
    let2 = new ArrayList<String>();
    let2.add("a");
    let2.add("d");
    let2.add("b");
    
    freq2 = new ArrayList<Integer>();
    freq2.add(1);
    freq2.add(2);
    freq2.add(2);
    
    huff2 = new Huffman(this.let2, this.freq2);
    
    // nodes of huff2
    h2Leaf1 = new Leaf("a", 1);
    h2Leaf2 = new Leaf("d", 2);
    h2Leaf3 = new Leaf("b", 2);
    
    h2Node1 = new Node("ad", 3, this.h2Leaf1, this.h2Leaf2);
    h2Node2 = new Node("bad", 5, this.h2Leaf3, this.h2Node1);
  }
  
  // testing main stuff
  // tests constructor construction
  boolean testConstructor(Tester t) {
    initData();
    return 
        // checking the constructor throw when the alphabet is too short
        t.checkConstructorException(new IllegalArgumentException(
            "Lists are of different lengths or your alphabet is too short"), 
            "Huffman", new ArrayList<String>(Arrays.asList("a")),
            new ArrayList<Integer>(Arrays.asList(5)))
        // checking the constructor throw when the frequencies/letters are two different lengths
        && t.checkConstructorException(new IllegalArgumentException(
            "Lists are of different lengths or your alphabet is too short"), 
            "Huffman", new ArrayList<String>(Arrays.asList("a", "b")),
            new ArrayList<Integer>(Arrays.asList(5, 6, 7)))
        // checking the letters is as expected
        && t.checkExpect(this.huff1.letters, this.let1)
        // checking the frequencies is as expected
        && t.checkExpect(this.huff1.freq, this.freq1)
        // checking the creation of a forest is correct
        && t.checkExpect(this.huff1.forest, new ArrayList<ANode>(Arrays.asList(new Node("ab", 5,
            new Leaf("a", 2), new Leaf("b", 3)))));
  }
  
  // test encode method
  boolean testEncode(Tester t) {
    initData();
    return 
        // encoding with a character that is not in the alphabet (first letter)
        t.checkException(new IllegalArgumentException(
            "Tried to encode w but that is not part of the language."),
            this.huff1, "encode", "wab")
        // encoding with a character that is not in the alphabet (later letter)
        && t.checkException(new IllegalArgumentException(
            "Tried to encode w but that is not part of the language."),
            this.huff1, "encode", "abw")
        // encode a single character
        && t.checkExpect(this.huff1.encode("a"), new ArrayList<Boolean>(Arrays.asList(false)))
        // encode more than one character
        && t.checkExpect(this.huff1.encode("ab"), 
            new ArrayList<Boolean>(Arrays.asList(false, true)))
        // encode from a longer huffman
        && t.checkExpect(this.huff2.encode("abdd"), 
            new ArrayList<Boolean>(Arrays.asList(true, false, false, true, true, true, true)));
  }
  
  // test decode method
  boolean testDecode(Tester t) {
    initData();
    return 
        // decoding when the list of booleans is empty
        t.checkExpect(this.huff1.decode(new ArrayList<Boolean>()), "")
        // decoding a list of booleans that is the perfect length (shorter list)
        && t.checkExpect(this.huff1.decode(new ArrayList<Boolean>(Arrays.asList(false))), "a")
        // deciding a list of booleans that is not the perfect length (shorter list)
        && t.checkExpect(this.huff2.decode(new ArrayList<Boolean>(Arrays.asList(true))), "?")
        // decoding a list of booleans that is the perfect length (longer list)
        && t.checkExpect(this.huff1.decode(
            new ArrayList<Boolean>(Arrays.asList(true, false, true, false))), 
            "baba")
        // deciding a list of booleans that is not the perfect length (longer list)
        && t.checkExpect(this.huff2.decode(
            new ArrayList<Boolean>(Arrays.asList(true, false, false, true))), 
            "ab?");
  }
  
  // testing helper methods
  // test createNodes method
  boolean testCreateNodes(Tester t) {
    initData();
    return
        t.checkExpect(this.huff1.createNodes(), 
            new ArrayList<ANode>(Arrays.asList(this.h1Leaf1, this.h1Leaf2)))
        && t.checkExpect(this.huff2.createNodes(), 
            new ArrayList<ANode>(Arrays.asList(this.h2Leaf1, this.h2Leaf2, this.h2Leaf3)));
  }
  
  // test oneTree method
  // to check this method, you only really need to check if it is created correctly from the 
  // constructor
  void testOneTree(Tester t) {
    initData();
    t.checkExpect(this.huff1.forest, new ArrayList<ANode>(Arrays.asList(this.h1Node1)));
    t.checkExpect(this.huff2.forest, new ArrayList<ANode>(Arrays.asList(this.h2Node2)));
  }
  
  // test addLetter method
  boolean testAddLetter(Tester t) {
    return 
        // adding the letters of two leafs
        t.checkExpect(this.h1Leaf1.addLetter(this.h1Leaf2), "ab")
        // adding the letters of two nodes
        && t.checkExpect(this.h1Node1.addLetter(this.h2Node1), "abad")
        // adding the letters of a leaf and a node
        && t.checkExpect(this.h1Node1.addLetter(this.h1Leaf1), "aba");
  }
  
  // test addData method
  boolean testAddData(Tester t) {
    return 
        // adding the letters of two leafs
        t.checkExpect(this.h1Leaf1.addData(this.h1Leaf2), 5)
        // adding the letters of two nodes
        && t.checkExpect(this.h1Node1.addData(this.h2Node1), 8)
        // adding the letters of a leaf and a node
        && t.checkExpect(this.h1Node1.addData(this.h1Leaf1), 7);
  }
  
  // test encodeCharacter method
  boolean testEncodeCharacter(Tester t) {
    initData();
    return 
        // encode a single character that is not in the alphabet
        t.checkException(new IllegalArgumentException(
            "Tried to encode w but that is not part of the language."),
            this.h2Node2, "encodeCharacter", "w", new ArrayList<Boolean>())
        // encode a single character that is in the alphabet
        && t.checkExpect(this.h2Node2.encodeCharacter("a", 
            new ArrayList<Boolean>(Arrays.asList(false))), 
            new ArrayList<Boolean>(Arrays.asList(false, true, false)));
  }
  
  // test contains method
  boolean testcontains(Tester t) {
    initData();
    return 
        // testing on empty string
        t.checkExpect(this.h2Node2.contains(""), true)
        // when the letter is contained
        && t.checkExpect(this.h2Node2.contains("b"), true)
        // when the letter is not contained
        && t.checkExpect(this.h2Node2.contains("w"), false);
  }
  
  // test decodeHelper method
  boolean testDecodeHelper(Tester t) {
    initData();
    return
        // when the list of booleans is perfect length coupled with the key
        t.checkExpect(this.h2Node2.decodeHelper(
            "a", new ArrayList<Boolean>(Arrays.asList(false, true, false)), this.h2Node2), 
            "aba")
        // when the list of booleans is too short coupled with the key
        && t.checkExpect(this.h2Node2.decodeHelper(
            "a", new ArrayList<Boolean>(Arrays.asList(false, true)), this.h2Node2), 
            "ab?");
  }
  
  // tests comparator
  boolean testCompareNodes(Tester t) {
    initData();
    return 
        // first node has larger value
        t.checkExpect(new CompareNodes().compare(this.h1Leaf1, this.h1Leaf2), -1)
        // second node has larger value
        && t.checkExpect(new CompareNodes().compare(this.h1Leaf2, this.h1Leaf1), 1);
  }  
}















