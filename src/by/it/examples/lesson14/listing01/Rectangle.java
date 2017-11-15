package by.it.examples.lesson14.listing01;

// A subclass of TwoDShape for rectangles.
class Rectangle extends TwoDShape { 
  boolean isSquare() { 
    if(width == height) return true; 
    return false; 
  } 
   
  double area() { 
    return width * height; 
  } 
}
