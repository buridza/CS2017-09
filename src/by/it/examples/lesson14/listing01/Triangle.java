package by.it.examples.lesson14.listing01;

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape { 
  String style; 
   
  double area() { 
    return width * height / 2; 
  } 
 
  void showStyle() { 
    System.out.println("Triangle is " + style); 
  } 
} 
