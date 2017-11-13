package by.it.examples.lesson13.listing05;

// Simple types are passed by value.
class Test { 
  /* This method causes no change to the arguments 
     used in the call. */ 
  void noChange(int i, int j) { 
    i = i + j; 
    j = -j; 
  } 
} 
