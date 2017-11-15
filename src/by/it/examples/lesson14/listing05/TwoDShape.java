package by.it.examples.lesson14.listing05;// Add a constructor to Triangle.
 
// A class for two-dimensional objects. 
class TwoDShape { 
  private double width;  // these are 
  private double height; // now private  
 
  // Accessor methods for width and height. 
  double getWidth() { return width; } 
  double getHeight() { return height; } 
  void setWidth(double w) { width = w; } 
  void setHeight(double h) { height = h; } 
 
  void showDim() { 
    System.out.println("Width and height are " + 
                       width + " and " + height); 
  } 
} 