package by.it.examples.lesson15.listing10;

// Implement Series.
class ByThrees implements Series { 
  int start; 
  int val; 
 
  ByThrees() { 
    start = 0; 
    val = 0; 
  } 
 
  public int getNext() { 
    val += 3; 
    return val; 
  } 
 
  public void reset() { 
    start = 0; 
    val = 0; 
  } 
 
  public void setStart(int x) { 
    start = x; 
    val = x; 
  } 
}