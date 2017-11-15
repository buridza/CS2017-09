package by.it.examples.lesson14.listing03;

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape { 
  String style; 
   
  double area() { 
    /* return width * height / 2; */  // Error! can't access
    return 0;
  } 
 
  void showStyle() { 
    System.out.println("Triangle is " + style); 
  } 
}
