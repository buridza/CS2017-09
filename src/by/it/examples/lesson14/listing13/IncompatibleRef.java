package by.it.examples.lesson14.listing13;

class IncompatibleRef {
  public static void main(String args[]) { 
    X x = new X(10); 
    X x2;  
    Y y = new Y(5); 
 
    x2 = x; // OK, both of same type 
 
    /* x2 = y; */ // Error, not of same type
  } 
}