// Represents a housing type
interface IHousing{
  
}


// Represents a Hut type housing
class Hut implements IHousing {
  int capacity; // how many people the hut can hold
  int population; // current number of people in the hut
  
  Hut(int capacity, int population) {
    this.capacity = capacity;
    this.population = population;
  }
}

// Represents an Inn type housing
class Inn implements IHousing {
  String name; // the name of the inn
  int capacity; // how many people the inn can hold
  int population; // current number of people in the inn
  int stalls; // number of stalls the inn has
  
  Inn(String name, int capacity, int population, int stalls) {
    this.name = name;
    this.capacity = capacity;
    this.population = population;
    this.stalls = stalls;
  }
}

// Represents a Castle type housing
class Castle implements IHousing {
  String name; // the name of the castle
  String familyName; // the family name
  int population; // current number of people in the castle
  int carriageHouse; // number of carriages the castle can hold
  
  Castle(String name, String familyName, int population, int carriageHouse) {
    this.name = name;
    this.familyName = familyName;
    this.population = population;
    this.carriageHouse = carriageHouse;
  }
}

//Represents a type of transportation
interface ITransportation{

}

// Represents transportation in the form of horse(s)
class Horse implements ITransportation {
  IHousing from; // where the horse is coming from
  IHousing to; // where the horse's going, can go to any hut/castle, can go to an inn with space
  String name; // the name of the horse
  String color; // the color of the horse
  
  Horse(IHousing from, IHousing to, String name, String color) {
    this.from = from;
    this.to = to;
    this.name = name;
    this.color = color;
  }
}

// Represents transportation in the form of carriage
class Carriage implements ITransportation {
  IHousing from; 
  IHousing to; 
  // to & from -> the carriage can only go from inns to castles or vice versa
  int tonnage; // the load a carriage can carry in tons
  
  Carriage(IHousing from, IHousing to, int tonnage) {
    this.from = from;
    this.to = to;
    this.tonnage = tonnage;
  }
}

// Examples
class ExamplesTravel {
  IHousing hovel = new Hut(5, 1);
  IHousing crossroads = new Inn("Inn At The Crossroads", 40, 20, 12);
  IHousing winterfell = new Castle("Winterfell", "Stark", 500, 6);
  
  IHousing littleHut = new Hut(6, 4);
  IHousing sailor = new Inn("Sailor's Inn", 100, 89, 20);
  IHousing wysteria = new Castle("Wysteria", "Howl", 340, 4);
  
  ITransportation horse1 = new Horse(winterfell, hovel, "Pheonix", "brown");
  ITransportation horse2 = new Horse(sailor, crossroads, "Daisy", "tan");
  ITransportation carriage1 = new Carriage(crossroads, winterfell, 50);
  ITransportation carriage2 = new Carriage(wysteria, sailor, 40);
  
}



