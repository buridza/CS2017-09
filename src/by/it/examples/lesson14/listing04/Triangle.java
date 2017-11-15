package by.it.examples.lesson14.listing04;

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape { 
  String style; 
   
  double area() { 
    return getWidth() * getHeight() / 2;  
  } 
 
  void showStyle() { 
    System.out.println("Triangle is " + style); 
  } 
} 