// Represents a statue with a lot of information about the statue
class Statue {
  String name; // name of the statue
  String artist; // artist that created the statue
  int year; // the year the statue was created
  double weight; // the weight of the statue in pounds
  boolean whole; // whether or not the statue is whole
  
  Statue(String name, String artist, int year, double weight, boolean whole) {
    this.name = name;
    this.artist = artist;
    this.year = year;
    this.weight = weight;
    this.whole = whole; 
  }
}

// Examples
class ExamplesStatue {
  Statue statueOfLiberty = new Statue("Statue Of Liberty","Bartholdi", 1886, 450000, true);
  Statue venusDeMilo = new Statue("Venus de Milo", "Alexandros of Antioch", -115, 1984.16, false);
  Statue theThinker = new Statue("The Thinker", "Rodin", 1881, 1800, true);
}