// Represents a soup
interface ISoup {
  
}

// Represents a broth 
class Broth implements ISoup {
  String type; // the type of broth
  
  Broth(String type) {
    this.type = type;
  }
}

// Represents an ingredient
class Ingredient implements ISoup {
  ISoup more; // the other ingredients/broth that make up the soup
  String name; // the name of the ingredient
  
  Ingredient(ISoup more, String name) {
    this.more = more;
    this.name = name;
  }
}

// Examples
class ExamplesSoup {
  ISoup chicken = new Broth("chicken");
  ISoup carrots = new Ingredient(this.chicken, "carrots");
  ISoup celery = new Ingredient(this.carrots, "celery");
  ISoup yummy = new Ingredient(this.celery, "noodles"); 
  
  ISoup vanilla = new Broth("vanilla");
  ISoup horseradish = new Ingredient(this.vanilla, "horseradish");
  ISoup hotDogs = new Ingredient(this.horseradish, "hot dogs");
  ISoup noThankYou = new Ingredient(this.hotDogs, "plum sauce");
  
}