package by.it.examples.lesson13.listing08;

// Return a programmer-defined object.
class Err { 
  String msg; // error message 
  int severity; // code indicating severity of error 
 
  Err(String m, int s) { 
    msg = m; 
    severity  = s; 
  } 
} 
