import java.util.function.BiFunction;
import java.util.function.Function;
import tester.Tester;

interface IArith {
  // accepts a visitor into an IArith
  <R> R accept(IArithVisitor<R> visitor);
}

class Const implements IArith {
  double num;
  
  Const(double num) {
    this.num = num;
  }
  
  /* Template:
   * Fields:
   * ... this.num ...     -- double
   * 
   * Methods:
   * ... this.accept(IArithVisitor<R>) ...    -- R
   * 
   * Methods of Fields:
   * ...
   */
  
  // accepts a visitor into a const
  public <R> R accept(IArithVisitor<R> visitor) {
    /* Template:
     * Fields:
     * ... this.num ...     -- double
     * 
     * Methods:
     * ... this.accept(IArithVisitor<R>) ...    -- R
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... visitor.visit(Const) ...             -- R
     * ... visitor.visit(UnaryFormula) ...      -- R
     * ... visitor.visit(BinaryFormula) ...     -- R
     */
    return visitor.visit(this);
  }
}

class UnaryFormula implements IArith {
  Function<Double, Double> func;
  String name;
  IArith child;
  
  UnaryFormula(Function<Double, Double> func, String name, IArith child) {
    this.func = func;
    this.name = name;
    this.child = child;
  }
  
  /* Template:
   * Fields:
   * ... this.func ...     -- Function<Double, Double>
   * ... this.name ...     -- String
   * ... this.child ...    -- IArith
   * 
   * Methods:
   * ... this.accept(IArithVisitor<R>) ...    -- R
   * 
   * Methods of Fields:
   * ...
   */

  // accepts a visitor into a UnaryFormula
  public <R> R accept(IArithVisitor<R> visitor) {
    /* Template:
     * Fields:
     * ... this.func ...     -- Function<Double, Double>
     * ... this.name ...     -- String
     * ... this.child ...    -- IArith
     * 
     * Methods:
     * ... this.accept(IArithVisitor<R>) ...    -- R
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... visitor.visit(Const) ...             -- R
     * ... visitor.visit(UnaryFormula) ...      -- R
     * ... visitor.visit(BinaryFormula) ...     -- R
     */
    return visitor.visit(this);
  }
}

class BinaryFormula implements IArith {
  BiFunction <Double, Double, Double> func;
  String name;
  IArith left;
  IArith right;
  
  BinaryFormula(BiFunction <Double, Double, Double> func, String name, IArith left, IArith right) {
    this.func = func;
    this.name = name;
    this.left = left;
    this.right = right;
  }
  
  /* Template:
   * Fields:
   * ... this.func ...     -- Function<Double, Double, Double>
   * ... this.name ...     -- String
   * ... this.left ...     -- IArith
   * ... this.right ...    -- IArith
   * 
   * Methods:
   * ... this.accept(IArithVisitor<R>) ...    -- R
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
  
  // accepts a visitor into a BinaryFormula
  public <R> R accept(IArithVisitor<R> visitor) {
    /* Template:
     * Fields:
     * ... this.func ...     -- Function<Double, Double, Double>
     * ... this.name ...     -- String
     * ... this.left ...     -- IArith
     * ... this.right ...    -- IArith
     * 
     * Methods:
     * ... this.accept(IArithVisitor<R>) ...    -- R
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... visitor.visit(Const) ...             -- R
     * ... visitor.visit(UnaryFormula) ...      -- R
     * ... visitor.visit(BinaryFormula) ...     -- R
     */
    return visitor.visit(this);
  }
}

//unary formulas
//negation
class Neg implements Function<Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // turns a number into its negative
  public Double apply(Double t) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double) ...    -- Double
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
    return - t; 
  }
}

//squaring
class Sqr implements Function<Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // squares a number
  public Double apply(Double t) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double) ...    -- Double
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
    return t * t;
  }
}

// binary formulas
// addition
class Plus implements BiFunction<Double, Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // adds two numbers together
  public Double apply(Double t, Double u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double Double) ...    -- Double
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
    return t + u;
  }
}

// subtraction
class Sub implements BiFunction<Double, Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // subtracts the first number by the second number
  public Double apply(Double t, Double u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double Double) ...    -- Double
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
    return t - u;
  }
}

// multiplication
class Mul implements BiFunction<Double, Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // multiplies the two numbers together
  public Double apply(Double t, Double u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double Double) ...    -- Double
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
    return t * u;
  }
}

// division
class Div implements BiFunction<Double, Double, Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Double Double) ...    -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // divides the first number by the second number
  public Double apply(Double t, Double u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Double Double) ...    -- Double
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
    return t / u;
  }
}

// visits the various IArith classes
interface IArithVisitor<R> {
  // visits a Const
  R visit(Const c);
  
  // visits a UnaryFormula
  R visit(UnaryFormula u);
  
  // visits a BinaryFormula
  R visit(BinaryFormula b);
}

// evaluates the value within an IArith
class EvalVisitor implements IArithVisitor<Double> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.visit(Const) ...           -- Double 
   * ... this.visit(UnaryFormula) ...    -- Double
   * ... this.visit(BinaryFormula) ...   -- Double
   * 
   * Methods of Fields:
   * ...
   */
  
  // evaluates the value within a Const
  public Double visit(Const c) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Double 
     * ... this.visit(UnaryFormula) ...    -- Double
     * ... this.visit(BinaryFormula) ...   -- Double
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... c.num ...            -- Double
     * 
     * Methods of Parameters:
     * ... c.accept(IArithVisitor<R>) ...      -- R
     */
    return c.num;
  }
  
  // evaluates the value within a UnaryFormula
  public Double visit(UnaryFormula u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Double 
     * ... this.visit(UnaryFormula) ...    -- Double
     * ... this.visit(BinaryFormula) ...   -- Double
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...                 -- Function<Double, Double>
     * ... u.name ...                 -- String
     * ... u.child ...                -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...      -- R
     */
    return u.func.apply(u.child.accept(this));
  }
  
  // evaluates the value within a BinaryFormula
  public Double visit(BinaryFormula b) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Double 
     * ... this.visit(UnaryFormula) ...    -- Double
     * ... this.visit(BinaryFormula) ...   -- Double
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... b.func ...                 -- Function<Double, Double, Double>
     * ... b.name ...                 -- String
     * ... b.left ...                 -- IArith
     * ... b.right ...                -- IArith
     * 
     * Methods of Parameters:
     * ... b.accept(IArithVisitor<R>) ...      -- R
     */
    return b.func.apply(b.left.accept(this), b.right.accept(this));
  }
}

// prints out a fully parenthesized expression using Racket notation
class PrintVisitor implements IArithVisitor<String> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.visit(Const) ...           -- String 
   * ... this.visit(UnaryFormula) ...    -- String
   * ... this.visit(BinaryFormula) ...   -- String
   * 
   * Methods of Fields:
   * ...
   */
  
  // prints out a Const
  public String visit(Const c) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- String 
     * ... this.visit(UnaryFormula) ...    -- String
     * ... this.visit(BinaryFormula) ...   -- String
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... c.num ...           -- double
     * 
     * Methods of Parameters:
     * ... c.accept(IArithVisitor<R>) ...    -- R
     */
    return Double.toString(c.num);
  }

  // prints out a UnaryFormula
  public String visit(UnaryFormula u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- String 
     * ... this.visit(UnaryFormula) ...    -- String
     * ... this.visit(BinaryFormula) ...   -- String
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double>
     * ... u.name ...            -- String
     * ... u.child ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return "(" + u.name + " " + u.child.accept(this) + ")";
  }
  
  // prints out a BinaryFormula
  public String visit(BinaryFormula b) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- String 
     * ... this.visit(UnaryFormula) ...    -- String
     * ... this.visit(BinaryFormula) ...   -- String
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double, Double>
     * ... u.name ...            -- String
     * ... u.left ...            -- IArith
     * ... u.right ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return "(" + b.name + " " + b.left.accept(this) + " " + b.right.accept(this) + ")";
  }
}

// produces an IArith where all the left and right elements in a BinaryFormula is flipped
class MirrorVisitor implements IArithVisitor<IArith> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.visit(Const) ...           -- IArith 
   * ... this.visit(UnaryFormula) ...    -- IArith
   * ... this.visit(BinaryFormula) ...   -- IArith
   * 
   * Methods of Fields:
   * ...
   */
  
  // returns just the regular Const
  public IArith visit(Const c) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- IArith 
     * ... this.visit(UnaryFormula) ...    -- IArith
     * ... this.visit(BinaryFormula) ...   -- IArith
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... c.num ...           -- double
     * 
     * Methods of Parameters:
     * ... c.accept(IArithVisitor<R>) ...    -- R
     */
    return c;
  }

  // returns the UnaryFormula (but with any subsequent BinaryFormulas mirrored)
  public IArith visit(UnaryFormula u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- IArith 
     * ... this.visit(UnaryFormula) ...    -- IArith
     * ... this.visit(BinaryFormula) ...   -- IArith
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double>
     * ... u.name ...            -- String
     * ... u.child ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return new UnaryFormula(u.func, u.name, u.child.accept(this));
  }
  
  // returns a BinaryFormula with the left and right branches flipped
  public IArith visit(BinaryFormula b) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- IArith 
     * ... this.visit(UnaryFormula) ...    -- IArith
     * ... this.visit(BinaryFormula) ...   -- IArith
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double, Double>
     * ... u.name ...            -- String
     * ... u.left ...            -- IArith
     * ... u.right ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return new BinaryFormula(b.func, b.name, b.right.accept(this), b.left.accept(this));
  }
  
}

// determines if every constant within the tree is even
class AllEvenVisitor implements IArithVisitor<Boolean> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.visit(Const) ...           -- String 
   * ... this.visit(UnaryFormula) ...    -- String
   * ... this.visit(BinaryFormula) ...   -- String
   * 
   * Methods of Fields:
   * ...
   */
  
  // determines if a Const is even or odd
  public Boolean visit(Const c) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Boolean 
     * ... this.visit(UnaryFormula) ...    -- Boolean
     * ... this.visit(BinaryFormula) ...   -- Boolean
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... c.num ...           -- double
     * 
     * Methods of Parameters:
     * ... c.accept(IArithVisitor<R>) ...    -- R
     */
    return c.num % 2 == 0;
  }
  
  //continues to go down the tree to determines if the Consts within it are all even
  public Boolean visit(UnaryFormula u) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Boolean 
     * ... this.visit(UnaryFormula) ...    -- Boolean
     * ... this.visit(BinaryFormula) ...   -- Boolean
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double>
     * ... u.name ...            -- String
     * ... u.child ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return u.child.accept(this);
  }

  // continues to go down the tree to determines if the Consts within it are all even
  public Boolean visit(BinaryFormula b) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.visit(Const) ...           -- Boolean 
     * ... this.visit(UnaryFormula) ...    -- Boolean
     * ... this.visit(BinaryFormula) ...   -- Boolean
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... u.func ...            -- Function<Double, Double, Double>
     * ... u.name ...            -- String
     * ... u.left ...            -- IArith
     * ... u.right ...           -- IArith
     * 
     * Methods of Parameters:
     * ... u.accept(IArithVisitor<R>) ...        -- R
     */
    return b.left.accept(this) && b.right.accept(this);
  }
  
}

// examples and tests
class ExamplesVisitors {
  // only constant
  IArith c1 = new Const(2.0);
  IArith c2 = new Const(3.0);
  IArith c3 = new Const(1.2);
  
  // with unary
  IArith u1 = new UnaryFormula(new Neg(), "neg", this.c1);
  IArith u2 = new UnaryFormula(new Sqr(), "sqr", this.c2);
  
  // with binary (only constants)
  IArith b1 = new BinaryFormula(new Plus(), "plus", this.c1, this.c2);
  IArith b2 = new BinaryFormula(new Sub(), "sub", this.c2, this.c1);
  
  // with binary (has unaries as well)
  IArith b5 = new BinaryFormula(new Plus(), "plus", this.u1, this.c2);
  IArith b6 = new BinaryFormula(new Sub(), "sub", this.c2, this.u1);
  
  // larger nested examples
  IArith combo1 = new UnaryFormula(new Sqr(), "sqr", this.b1);
  IArith combo2 = new BinaryFormula(new Mul(), "mul", this.b1, this.u2);
  
  // tests accept
  boolean testAccept(Tester t) {
    return 
        // invoking on Const, using EvalVisitor
        t.checkExpect(this.c1.accept(new EvalVisitor()), 2.0)
        // invoking on Const, using PrintVisitor
        && t.checkExpect(this.c1.accept(new PrintVisitor()), "2.0")
        // invoking on Const, using MirrorVisitor
        && t.checkExpect(this.c1.accept(new MirrorVisitor()), this.c1)
        // invoking on Const, using AllEvenVisitor
        && t.checkExpect(this.c1.accept(new AllEvenVisitor()), true)
        // invoking on UnaryFormula, using EvalVisitor
        && t.checkExpect(this.u1.accept(new EvalVisitor()), -2.0)
        // invoking on UnaryFormula, using PrintVisitor
        && t.checkExpect(this.u1.accept(new PrintVisitor()), "(neg 2.0)")
        // invoking on UnaryFormula, using MirrorVisitor
        && t.checkExpect(this.u1.accept(new MirrorVisitor()), this.u1)
        // invoking on UnaryFormula, using AllEvenVisitor
        && t.checkExpect(this.u1.accept(new AllEvenVisitor()), true)
        // invoking on BinaryFormula, using EvalVisitor
        && t.checkExpect(this.b5.accept(new EvalVisitor()), 1.0)
        // invoking on BinaryFormula, using PrintVisitor
        && t.checkExpect(this.b1.accept(new PrintVisitor()), "(plus 2.0 3.0)")
        // invoking on BinaryFormula, using MirrorVisitor
        && t.checkExpect(this.b5.accept(new MirrorVisitor()), 
            new BinaryFormula(new Plus(), "plus", this.c2, this.u1))
        // invoking on BinaryFormula, using AllEvenVisitor
        && t.checkExpect(this.b1.accept(new AllEvenVisitor()), false);
  }
  
  // tests the apply
  boolean testApply(Tester t) {
    return 
        // testing on Neg
        t.checkInexact(new Neg().apply(2.0), -2.0, 0.0001)
        // testing on Sqr
        && t.checkInexact(new Sqr().apply(3.5), 12.25, 0.0001)
        // testing on Plus
        && t.checkInexact(new Plus().apply(3.5, 2.3), 5.8, 0.0001)
        // testing on Sub
        && t.checkInexact(new Sub().apply(3.5, 2.3), 1.2, 0.0001)
        // testing on Mul
        && t.checkInexact(new Mul().apply(3.5, 2.3), 8.05, 0.0001)
        // testing on Div
        && t.checkInexact(new Div().apply(3.5, 2.3), 1.5217, 0.0001);
  }
  
  // tests the EvalVisitor
  boolean testEvalVisitor(Tester t) {
    return 
        // testing on a Const
        t.checkInexact(new EvalVisitor().visit(new Const(2.0)), 2.0, 0.0001)
        // testing on Neg
        && t.checkInexact(new EvalVisitor().visit(new UnaryFormula(new Neg(), "neg", this.c1)),
            -2.0, 0.0001)
        // testing on Sqr
        && t.checkInexact(new EvalVisitor().visit(new UnaryFormula(new Sqr(), "sqr", this.c1)),
            4.0, 0.0001)
        // testing on Plus
        && t.checkInexact(new EvalVisitor().visit(
            new BinaryFormula(new Plus(), "plus", this.c3, this.u1)), -0.8, 0.0001)
        // testing on Sub
        && t.checkInexact(new EvalVisitor().visit(
            new BinaryFormula(new Sub(), "sub", this.c3, this.u1)), 3.2, 0.0001)
        // testing on Mul
        && t.checkInexact(new EvalVisitor().visit(
            new BinaryFormula(new Mul(), "mul", this.c3, this.u1)), -2.4, 0.0001)
        // testing on Div
        && t.checkInexact(new EvalVisitor().visit(
            new BinaryFormula(new Div(), "div", this.c3, this.u1)), -0.6, 0.0001)
        // testing on more complex IArith(s)
        && t.checkInexact(new EvalVisitor().visit(
            new BinaryFormula(new Sub(), "sub", this.b1, this.b5)), 4.0, 0.0001);
  }
  
  // tests the PrintVisitor
  boolean testPrintVisitor(Tester t) {
    return 
        // testing on Const
        t.checkExpect(new PrintVisitor().visit(new Const(2.0)), "2.0")
        // testing on Neg (UnaryFormula)
        && t.checkExpect(new PrintVisitor().visit(new UnaryFormula(new Neg(), "neg", this.c1)),
            "(neg 2.0)")
        // testing on Sqr (UnaryFormula)
        && t.checkExpect(new PrintVisitor().visit(new UnaryFormula(new Sqr(), "sqr", this.c1)),
            "(sqr 2.0)")
        // testing on Plus (BinaryFormula)
        && t.checkExpect(new PrintVisitor().visit(
            new BinaryFormula(new Plus(), "plus", this.c1, this.c2)), "(plus 2.0 3.0)")
        // testing on Sub (BinaryFormula)
        && t.checkExpect(new PrintVisitor().visit(
            new BinaryFormula(new Sub(), "sub", this.c1, this.c2)), "(sub 2.0 3.0)")
        // testing on Mul (BinaryFormula)
        && t.checkExpect(new PrintVisitor().visit(
            new BinaryFormula(new Mul(), "mul", this.c1, this.c2)), "(mul 2.0 3.0)")
        // testing on Div (BinaryFormula)
        && t.checkExpect(new PrintVisitor().visit(
            new BinaryFormula(new Div(), "div", this.c1, this.c2)), "(div 2.0 3.0)")
        // testing on more complex IArith(s)
        && t.checkExpect(new PrintVisitor().visit(
            new BinaryFormula(new Div(), "div", this.b2, this.u1)), 
            "(div (sub 3.0 2.0) (neg 2.0))");
  }
  
  // tests the MirrorVisitor
  boolean testMirrorVisitor(Tester t) {
    return 
        // testing on a Const
        t.checkExpect(new MirrorVisitor().visit(new Const (2.0)), this.c1)
        // testing on a UnaryFormula
        && t.checkExpect(new MirrorVisitor().visit(new UnaryFormula(new Neg(), "neg", this.c1)), 
            this.u1)
        // testing on a BinaryFormula
        && t.checkExpect(new MirrorVisitor().visit(new BinaryFormula
            (new Sub(), "sub", this.u1, this.c2)), this.b6)
        // testing on a more complex IArith
        && t.checkExpect(new MirrorVisitor().visit(new BinaryFormula
            (new Mul(), "mul", this.u2, new BinaryFormula(
                new Plus(), "plus", this.c2, this.c1))), this.combo2);
  }
  
  // tests the AllEvenVisitor
  boolean testAllEvenVisitor(Tester t) {
    return 
        // Const is even
        t.checkExpect(new AllEvenVisitor().visit(new Const(2.0)), true)
        // Const is odd
        && t.checkExpect(new AllEvenVisitor().visit(new Const(3.0)), false)
        // UnaryFormula; all even 
        && t.checkExpect(new AllEvenVisitor().visit(new UnaryFormula(new Neg(), "neg", this.c1)),
            true)
        // UnaryFormula; contains odd
        && t.checkExpect(new AllEvenVisitor().visit(new UnaryFormula(new Neg(), "neg", this.c2)),
            false)
        // BinaryFormula; all even
        && t.checkExpect(new AllEvenVisitor().visit(
            new BinaryFormula(new Plus(), "plus", this.c1, this.u1)), true)
        // BinaryFormula;; contains odd
        && t.checkExpect(new AllEvenVisitor().visit(
            new BinaryFormula(new Plus(), "plus", this.c2, this.u1)), false);
  }
  
  
}