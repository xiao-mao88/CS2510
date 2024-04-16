import tester.Tester;

// generic interface for a list
interface IList<T> {
  // determines if this list contains the given item
  boolean contains(T t, ICompare<T> comp);
  
  // determines if this list suffices the given IPred
  boolean haveSame(IPred<T> pred);
  
  // counts the number of a certain item in the list
  int countItems(IPred<T> comp);
}

// represents an empty list
class MtList<T> implements IList<T> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.contains(T, ICompare<T>) ...         -- boolean
   * ... this.haveSame(IPred<T>) ...               -- boolean
   * ... this.countItems(IPred<T>) ...             -- int
   * 
   * Methods of Fields:
   * ... 
   */

  // determines if this list contains the given item
  public boolean contains(T t, ICompare<T> comp) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.contains(T, ICompare<T>) ...         -- boolean
     * ... this.haveSame(IPred<T>) ...               -- boolean
     * ... this.countItems(IPred<T>) ...             -- int
     * 
     * Methods of Fields:
     * ... 
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... comp.apply(T, T) ...          -- boolean
     */
    return false;
  }
  
  //determines if this list suffices the given IPred
  public boolean haveSame(IPred<T> pred) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.contains(T, ICompare<T>) ...         -- boolean
     * ... this.haveSame(IPred<T>) ...               -- boolean
     * ... this.countItems(IPred<T>) ...             -- int
     * 
     * Methods of Fields:
     * ... 
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... pred.apply(T) ...          -- boolean
     */
    return false;
  }
  
  // counts the number of a certain item in this list
  public int countItems(IPred<T> pred) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.contains(T, ICompare<T>) ...         -- boolean
     * ... this.haveSame(IPred<T>) ...               -- boolean
     * ... this.countItems(IPred<T>) ...             -- int
     * 
     * Methods of Fields:
     * ... 
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... pred.apply(T) ...          -- boolean
     */
    return 0;
  }
}

// represents a list
class ConsList<T> implements IList<T> {
  T first; // represents the first item in this list
  IList<T> rest; // represents the rest of the items in this list
  
  ConsList(T first, IList<T> rest) {
    this.first = first;
    this.rest = rest;
  }
  
  /* Template:
   * Fields:
   * ... this.first ...         -- T
   * ... this.rest ...          -- T
   * 
   * Methods:
   * ... this.haveSame(IPred<T>) ...       -- boolean
   * ... this.contains(ICompare<T>) ...    -- boolean
   * ... this.countItems(IPred<T>) ...     -- int
   * 
   * Methods of Fields:
   * ... this.rest.haveSame(IPred<T>) ...       -- boolean
   * ... this.rest.contains(ICompare<T>) ...    -- boolean
   * ... this.rest.countItems(IPred<T>) ...     -- int
   */
  
  //determines if this list suffices the given IPred
  public boolean haveSame(IPred<T> pred) {
    /* Template:
     * Fields:
     * ... this.first ...         -- T
     * ... this.rest ...          -- T
     * 
     * Methods:
     * ... this.haveSame(IPred<T>) ...       -- boolean
     * ... this.contains(ICompare<T>) ...    -- boolean
     * ... this.countItems(IPred<T>) ...     -- int
     * 
     * Methods of Fields:
     * ... this.rest.haveSame(IPred<T>) ...       -- boolean
     * ... this.rest.contains(ICompare<T>) ...    -- boolean
     * ... this.rest.countItems(IPred<T>) ...     -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... pred.apply(T) ...       -- boolean
     */
    return pred.apply(this.first) || this.rest.haveSame(pred);
  }
  
  // determines if this list contains the given item
  public boolean contains(T t, ICompare<T> comp) {
    /* Template:
     * Fields:
     * ... this.first ...         -- T
     * ... this.rest ...          -- T
     * 
     * Methods:
     * ... this.haveSame(IPred<T>) ...       -- boolean
     * ... this.contains(ICompare<T>) ...    -- boolean
     * ... this.countItems(IPred<T>) ...     -- int
     * 
     * Methods of Fields:
     * ... this.rest.haveSame(IPred<T>) ...       -- boolean
     * ... this.rest.contains(ICompare<T>) ...    -- boolean
     * ... this.rest.countItems(IPred<T>) ...     -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... comp.apply(T, T) ...       -- boolean
     */
    return comp.apply(this.first, t) || this.rest.contains(t, comp);
  }
  
  // counts the number of a certain item in this list
  public int countItems(IPred<T> pred) {
    /* Template:
     * Fields:
     * ... this.first ...         -- T
     * ... this.rest ...          -- T
     * 
     * Methods:
     * ... this.haveSame(IPred<T>) ...       -- boolean
     * ... this.contains(ICompare<T>) ...    -- boolean
     * ... this.countItems(IPred<T>) ...     -- int
     * 
     * Methods of Fields:
     * ... this.rest.haveSame(IPred<T>) ...       -- boolean
     * ... this.rest.contains(ICompare<T>) ...    -- boolean
     * ... this.rest.countItems(IPred<T>) ...     -- int
     * 
     * Fields of Parameters:
     * ...
     * 
     * Methods of Parameters:
     * ... pred.apply(T) ...       -- boolean
     */
    if (pred.apply(this.first)) {
      return 1 + this.rest.countItems(pred);
    }
    else {
      return this.rest.countItems(pred);
    }
  }
}

// generic predicate interface
interface IPred<T> {
  // applies what is necessary
  boolean apply(T t);
}

// checks if the course has the given student
class HasStudent implements IPred<Course> {
  Student s;
  
  HasStudent(Student s) {
    this.s = s;
  }
  
  /* Template:
   * Fields:
   * ... this.s ...          -- Student
   * 
   * Methods:
   * ... this.apply(Course) ...      -- boolean
   * 
   * Methods of Fields:
   * ... this.s.enroll(Course) ...           -- void
   * ... this.s.classmates(Student) ...      -- boolean
   */
  
  // checks if the course has the student
  public boolean apply(Course t) {
    /* Template:
     * Fields:
     * ... this.s ...          -- Student
     * 
     * Methods:
     * ... this.apply(Course) ...      -- boolean
     * 
     * Methods of Fields:
     * ... this.s.enroll(Course) ...           -- void
     * ... this.s.classmates(Student) ...      -- boolean
     * 
     * Fields of Parameters:
     * ... t.name ...                     -- String
     * ... t.prof ...                     -- Instructor
     * ... t.students ...                 -- IList<Student>
     * 
     * Methods of Parameters:
     * ... t.addStudent(Student) ...      -- void
     */
    return t.students.contains(this.s, new CompareStudent());
  }
}

// generic comparison interface
interface ICompare<T> {
  // compares two items of T
  boolean apply(T t1, T t2);
}

// checks if one student is the same as the other
class CompareStudent implements ICompare<Student> {
  /* Template:
   * Fields:
   * ...
   * 
   * Methods:
   * ... this.apply(Student, Student) ...       -- boolean
   * 
   * Methods of Fields:
   * ...
   */
  // compares two students
  public boolean apply(Student s1, Student s2) {
    /* Template:
     * Fields:
     * ...
     * 
     * Methods:
     * ... this.apply(Student, Student) ...       -- boolean
     * 
     * Methods of Fields:
     * ...
     * 
     * Fields of Parameters:
     * ... s.name ...            -- String
     * ... s.id ...              -- int
     * ... s.courses ...         -- IList<Course>
     * 
     * Methods of Parameters:
     * ... s.enroll ...                  -- void
     * ... s.classmates(Student) ...     -- boolean
     */
    return s1.id == s2.id;
  }
}

// represents a course
class Course {
  String name; // name of the course
  Instructor prof; // professor that teaches this course
  IList<Student> students; // list of students that take this course
  
  // initial constructor of a course
  Course(String name, Instructor prof) {
    this.name = name;
    this.prof = prof;
    this.students = new MtList<Student>();
    this.prof.addCourse(this);
  }
  
  // constructor after students are added
  Course(String name, Instructor prof, IList<Student> students) {
    this.name = name;
    this.prof = prof;
    this.students = students;
  }
  
  /* Template:
   * Fields:
   * ... this.name ...        -- String
   * ... this.prof ...        -- Instructor
   * ... this.students ...    -- IList<Student>
   * 
   * Methods:
   * ... this.addStudent ...     -- void
   * 
   * Methods of Fields:
   * ... this.students.contains(Student, ICompare<Student>) ...      -- boolean
   * ... this.students.countItems(IPred<Student) ...                 -- int
   * ... this.student.hasSame(IPred<Student>) ...                    -- boolean
   */
  
  // adds a student to the list of students for this course
  public void addStudent(Student s) {
    /* Template:
     * Fields:
     * ... this.name ...        -- String
     * ... this.prof ...        -- Instructor
     * ... this.students ...    -- IList<Student>
     * 
     * Methods:
     * ... this.addStudent ...     -- void
     * 
     * Methods of Fields:
     * ... this.students.contains(Student, ICompare<Student>) ...      -- boolean
     * ... this.students.countItems(IPred<Student) ...                 -- int
     * ... this.student.hasSame(IPred<Student>) ...                    -- boolean
     * 
     * Fields of Parameters:
     * ... s.name ...            -- String
     * ... s.id ...              -- int
     * ... s.courses ...         -- IList<Course>
     * 
     * Methods of Parameters:
     * ... s.enroll(Course) ...           -- void
     * ... s.classmates(Student) ...      -- boolean
     */
    this.students = new ConsList<Student>(s, this.students);
  }
}

// represents a professor
class Instructor {
  String name; // name of the professor
  IList<Course> courses; // list of courses the professor teaches
  
  // initial construction of an Instructor
  Instructor(String name) {
    this.name = name;
    this.courses = new MtList<Course>();
  }
  
  // constructor after courses are added
  Instructor(String name, IList<Course> courses) {
    this.name = name; 
    this.courses = courses;
  }
  
  /* Template:
   * Fields:
   * ... this.name ...           -- String
   * ... this.courses ...        -- IList<Course>
   * 
   * Methods:
   * ... this.dejavu(Student) ...        -- boolean
   * 
   * Methods of Fields:
   * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
   * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
   * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
   */
  
  // adds a course to the instructor
  public void addCourse(Course c) {
    /* Template:
     * Fields:
     * ... this.name ...           -- String
     * ... this.courses ...        -- IList<Course>
     * 
     * Methods:
     * ... this.dejavu(Student) ...        -- boolean
     * 
     * Methods of Fields:
     * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
     * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
     * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
     * 
     * Fields of Parameters:
     * ... c.name ...                  -- String
     * ... c.prof ...                  -- int
     * ... c.students ...              -- IList<Student>
     * 
     * Methods of Parameters:
     * ... c.addStudent(Student) ...        -- void
     */
    this.courses = new ConsList<Course>(c, this.courses);
  }
  
  // determines if this instructor has the given student more than once
  public boolean dejavu(Student c) {
    /* Template:
     * Fields:
     * ... this.name ...           -- String
     * ... this.courses ...        -- IList<Course>
     * 
     * Methods:
     * ... this.dejavu(Student) ...        -- boolean
     * 
     * Methods of Fields:
     * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
     * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
     * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
     * 
     * Fields of Parameters:
     * ... c.name ...                  -- String
     * ... c.id ...                    -- int
     * ... c.courses ...               -- IList<Course>
     * 
     * Methods of Parameters:
     * ... c.enroll(Course) ...        -- void
     * ... c.classmates(Student) ...   -- boolean
     */
    return this.courses.countItems(new HasStudent(c)) > 1;
  }
}

// represents a student
class Student {
  String name; // name of the student
  int id; // id of the student
  IList<Course> courses; // list of courses the student takes
  
  // initial constructor of a Student
  Student(String name, int id) {
    this.name = name;
    this.id  = id;
    this.courses = new MtList<Course>();
  }
  
  // constructor for after courses are added
  Student(String name, int id, IList<Course> courses) {
    this.name = name;
    this.id = id;
    this.courses = courses;
  }
  
  /* Template:
   * Fields:
   * ... this.name ...         -- String
   * ... this.id ...           -- int
   * ... this.courses ...      -- IList<Course>
   * 
   * Methods:
   * ... this.enroll(Course) ...           -- void
   * ... this.classmates(Student) ...      -- boolean
   * 
   * Methods of Fields:
   * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
   * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
   * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
   */
  
  // adds a course for a student & then adds that student to the course's list of students
  public void enroll(Course c) {
    /* Template:
     * Fields:
     * ... this.name ...         -- String
     * ... this.id ...           -- int
     * ... this.courses ...      -- IList<Course>
     * 
     * Methods:
     * ... this.enroll(Course) ...           -- void
     * ... this.classmates(Student) ...      -- boolean
     * 
     * Methods of Fields:
     * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
     * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
     * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
     * 
     * Fields of Parameters:
     * ... c.name ...          -- String
     * ... c.prof ...          -- Instructor
     * ... c.students ...      -- IList<Student>
     * 
     * Methods of Parameters:
     * ... c.addStudent(Student) ...       -- void
     */
    this.courses = new ConsList<Course>(c, this.courses);
    c.addStudent(this);
  }
  
  // determines whether this student is classmates with the given student
  public boolean classmates(Student c) {
    /* Template:
     * Fields:
     * ... this.name ...         -- String
     * ... this.id ...           -- int
     * ... this.courses ...      -- IList<Course>
     * 
     * Methods:
     * ... this.enroll(Course) ...           -- void
     * ... this.classmates(Student) ...      -- boolean
     * 
     * Methods of Fields:
     * ... this.courses.contains(Course, ICompare<Course>) ...    -- boolean
     * ... this.courses.haveSame(IPred<Compare>) ...              -- boolean
     * ... this.courses.countItems(IPred<Compare>) ...            -- boolean
     * 
     * Fields of Parameters:
     * ... c.name ...          -- String
     * ... c.id ...            -- int
     * ... c.courses ...       -- IList<Course>
     * 
     * Methods of Parameters:
     * ... c.enroll(Course) ...            -- void
     * ... c.classmates(Student) ...       -- boolean
     */
    return this.courses.haveSame(new HasStudent(c));
  }
}

// examples and testers
class ExamplesRegistrar {
  // examples
  // comparator/predicate 
  ICompare<Student> compStu = new CompareStudent();
  
  // instructors
  Instructor hugh = new Instructor("Hugh");
  Instructor maria = new Instructor("Maria");
  
  // students
  Student jasmine = new Student("Jasmine", 1);
  Student jack = new Student("Jack", 2);
  Student bob = new Student("Bob", 3);
  Student lila = new Student("Lila", 4);
  Student millie = new Student("Millie", 5);
  
  // empty list of students
  IList<Student> emptyS = new MtList<Student>();
  //list of students in geometry
  IList<Student> geomStu = new ConsList<Student>(this.jasmine, 
      new ConsList<Student>(this.bob, emptyS));
  // list of students in algebra
  IList<Student> algStu = new ConsList<Student>(this.bob, 
      new ConsList<Student>(this.jack, emptyS));
  
  // list of students in english 
  IList<Student> engStu = new ConsList<Student>(this.lila, 
      new ConsList<Student>(this.jack, emptyS));
  // list of students in literature
  IList<Student> litStu = new ConsList<Student>(this.jasmine,
      new ConsList<Student>(this.bob, emptyS));
  
  // courses
  // geometry course
  Course geom = new Course("Geometry", this.hugh);
  // algebra course
  Course alg = new Course("Algebra", this.hugh);
  // english course
  Course eng = new Course("English", this.maria);
  // literature course
  Course lit = new Course("Literature", this.maria);
  
  // list of courses (depending on student/instructor)
  // empty list of courses
  IList<Course> emptyc = new MtList<Course>();
  // for instructor hugh
  IList<Course> hughClasses = new ConsList<Course>(this.geom, 
      new ConsList<Course>(this.alg, this.emptyc));
  //for instructor maria
  IList<Course> mariaClasses = new ConsList<Course>(this.eng, 
      new ConsList<Course>(this.lit, this.emptyc));
  // for student jasmine
  IList<Course> jasClasses = new ConsList<Course>(this.geom, 
      new ConsList<Course>(this.lit, this.emptyc));
  // for student jack
  IList<Course> jackClasses = new ConsList<Course>(this.alg, 
      new ConsList<Course>(this.eng, this.emptyc));
  // for student bob
  IList<Course> bobClasses = new ConsList<Course>(this.alg, 
      new ConsList<Course>(this.lit, this.emptyc));
  // for student lila
  IList<Course> lilaClasses = new ConsList<Course>(this.eng, this.emptyc);
  
  
  // initializing data
  void initData() {
    // initializing courses for professors
    hugh.courses = this.hughClasses;
    maria.courses = this.mariaClasses;
    
    // initializing courses for students
    jasmine.courses = this.jasClasses;
    jack.courses = this.jackClasses;
    bob.courses = this.bobClasses;
    lila.courses = this.lilaClasses;
    
    // initializing students in courses
    geom.students = this.geomStu;
    alg.students = this.algStu;
    lit.students = this.litStu;
    eng.students = this.engStu;
  }
  
  // testing main methods
  // test enroll method
  void testEnroll(Tester t) {
    initData();
    // checks jasmine's current courses are correct
    t.checkExpect(this.jasmine.courses, this.jasClasses);
    // enrolls jasmine into algebra
    this.jasmine.enroll(this.alg);
    t.checkExpect(this.jasmine.courses, new ConsList<Course>(this.alg, this.jasClasses));
    // checks bob's current courses are correct
    t.checkExpect(this.bob.courses, this.bobClasses);
    // enrolls bob into english
    this.bob.enroll(this.eng);
    t.checkExpect(this.bob.courses, new ConsList<Course>(this.eng, this.bobClasses));
  }
  
  // test classmates method
  boolean testClassmates(Tester t) {
    initData();
    return
        // the students are not in any of the same classes
        t.checkExpect(this.jasmine.classmates(this.jack), false)
        // the students are in the some of the same classes
        && t.checkExpect(this.jasmine.classmates(this.bob), true);
  }
  
  // test dejavu method
  boolean testDejavu(Tester t) {
    initData();
    return
        // the instructor doesn't have the student
        t.checkExpect(this.maria.dejavu(this.millie), false)
        // the instructor has the student, but not more than once
        && t.checkExpect(this.maria.dejavu(this.jack), false)
        // the instructor has the student more than once
        && t.checkExpect(this.hugh.dejavu(this.bob), true);
  }
  
  // testing helper methods
  // test addStudent method
  void testAddStudent(Tester t) {
    initData();
    // checks algebra has the correct list of students
    t.checkExpect(this.alg.students, this.algStu);
    // adds a student to the algebra course
    this.alg.addStudent(this.jasmine);
    t.checkExpect(this.alg.students, new ConsList<Student>(this.jasmine, this.algStu));
    // checks english has the correct list of students
    t.checkExpect(this.eng.students, this.engStu);
    // adds a student to the english course
    this.eng.addStudent(this.jasmine);
    t.checkExpect(this.eng.students, new ConsList<Student>(this.jasmine, this.engStu));
  }
  
  // test addCourse method
  void testAddCourse(Tester t) {
    initData();
    // checks the instructor has the correct list of courses
    t.checkExpect(this.hugh.courses, this.hughClasses);
    // adds a course to the list of courses
    this.hugh.addCourse(this.eng);
    t.checkExpect(this.hugh.courses, new ConsList<Course>(this.eng, this.hughClasses));
  }
  
  // test contains method
  boolean testContains(Tester t) {
    initData();
    return 
        // the item is not contained in the list
        t.checkExpect(this.algStu.contains(this.jasmine, this.compStu), false)
        // the item is contained in the list
        && t.checkExpect(this.algStu.contains(this.bob, this.compStu), true);
  }
  
  // test haveSame method
  boolean testHaveSame(Tester t) {
    initData();
    return 
        // the student is in one of the courses
        t.checkExpect(this.hughClasses.haveSame(new HasStudent(this.jasmine)), true)
        // the student is in one of the courses
        && t.checkExpect(this.hughClasses.haveSame(new HasStudent(this.millie)), false);
  }
  
  // test countItem method
  boolean testCountItem(Tester t) {
    initData();
    return 
        // item does not appear in the list
        t.checkExpect(this.hughClasses.countItems(new HasStudent(this.millie)), 0)
        // item is in the list once
        && t.checkExpect(this.hughClasses.countItems(new HasStudent(this.jasmine)), 1)
        // item is in the list more than once
        && t.checkExpect(this.hughClasses.countItems(new HasStudent(this.bob)), 2);
  }
  
  // test CompareStudent
  boolean testCompareStudent(Tester t) {
    initData();
    return 
        // two students are the same
        t.checkExpect(new CompareStudent().apply(this.jasmine, this.jasmine), true)
        // two students are not the same
        && t.checkExpect(new CompareStudent().apply(this.jasmine, this.jack), false);
  }
  
  // test HasStudent
  boolean testHasStudent(Tester t) {
    initData();
    return 
        // the student is in the course
        t.checkExpect(new HasStudent(this.jasmine).apply(this.lit), true)
        // the student is not in the course
        && t.checkExpect(new HasStudent(this.millie).apply(this.lit), false);
  }
}









