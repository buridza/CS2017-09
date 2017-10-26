package by.it.sc04_evening_tue_thu.sorokina.lesson08;

public class DogHelper {


  public static void printAllNames(Dog[] dogs){
        for (int i = 0; i < dogs.length; i++) {
            System.out.print(dogs[i].getName() + " ");
        }
       System.out.println();

    }

   public static double averageAge(Dog[] dogs){
       double sum = 0;
        for (int i = 0; i < dogs.length; i++) {
            sum += dogs[i].getAge();
        }
        return sum/dogs.length;
    }


}
