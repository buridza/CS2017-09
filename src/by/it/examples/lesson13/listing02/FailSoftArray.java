package by.it.examples.lesson13.listing02;

/* This class implements a "fail-soft" array which prevents
   runtime errors. 
 */  
class FailSoftArray {  
  private int a[]; // reference to array 
  private int errval; // value to return if get() fails 
 
  public int length; // length is public 
   
  /* Construct array given its size and the value to 
     return if get() fails. */ 
  public FailSoftArray(int size, int errv) { 
    a = new int[size]; 
    errval = errv; 
    length = size;  
  } 
 
  // Return value at given index. 
  public int get(int index) { 
    if(indexOK(index)) return a[index]; 
    return errval; 
  } 
 
  // Put a value at an index. Return false on failure. 
  public boolean put(int index, int val) { 
    if(indexOK(index)) { 
      a[index] = val; 
      return true; 
    } 
    return false; 
  } 
 
  // Return true if index is within bounds. 
  private boolean indexOK(int index) { 
   if(index >= 0 & index < length) return true; 
   return false; 
  } 
}  
