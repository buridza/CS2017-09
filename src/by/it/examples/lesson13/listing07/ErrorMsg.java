package by.it.examples.lesson13.listing07;

// Return a String object.
class ErrorMsg { 
  String msgs[] = { 
    "Output Error", 
    "Input Error", 
    "Disk Full", 
    "Index Out-Of-Bounds" 
  }; 
 
  // Return the error message. 
  String getErrorMsg(int i) { 
    if(i >=0 & i < msgs.length) 
      return msgs[i]; 
    else 
      return "Invalid Error Code"; 
  } 
} 
