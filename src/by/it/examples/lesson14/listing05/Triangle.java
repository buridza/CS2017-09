package by.it.examples.lesson14.listing05;

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape { 
  private String style; 
   
  // Constructor 
  Triangle(String s, double w, double h) { 
    setWidth(w); 
    setHeight(h); 
 
    style = s;  
  } 
 
  double area() { 
    return getWidth() * getHeight() / 2;  
  } 
 
  void showStyle() { 
    System.out.println("Triangle is " + style); 
  } 
} 