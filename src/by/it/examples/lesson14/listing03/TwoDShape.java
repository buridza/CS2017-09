package by.it.examples.lesson14.listing03;// Private members are not inherited.
 
// This example will not compile. 
 
// A class for two-dimensional objects. 
class TwoDShape { 
  private double width;  // these are 
  private double height; // now private  
 
  void showDim() { 
    System.out.println("Width and height are " + 
                       width + " and " + height); 
  } 
} 
