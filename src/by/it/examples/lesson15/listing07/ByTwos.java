package by.it.examples.lesson15.listing07;

// Implement Series.
class ByTwos implements Series { 
  int start; 
  int val; 
 
  ByTwos() { 
    start = 0; 
    val = 0; 
  }  
 
  public int getNext() { 
    val += 2; 
    return val; 
  } 
 
  public void reset() { 
    val = start; 
  } 
 
  public void setStart(int x) { 
    start = x; 
    val = x; 
  } 
}