// Make the instance variables in Book protected. 
package by.it.examples.lesson15.listing05;
 
public class Book { 
  // these are now protected 
  protected String title;  
  protected String author;  
  protected int pubDate; 
 
  public Book(String t, String a, int d) {  
    title = t;  
    author = a;  
    pubDate = d;  
  } 
 
   public void show() {  
    System.out.println(title);  
    System.out.println(author);  
    System.out.println(pubDate);   
    System.out.println(); 
  }  
}