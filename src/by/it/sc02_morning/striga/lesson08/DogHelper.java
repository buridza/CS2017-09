package by.it.sc02_morning.striga.lesson08;

public class DogHelper {
    static void printAllNames(Dog[] dogs) {
        for (int i = 0; i < dogs.length; i++) {
            System.out.print(dogs[i].getName() + " ");
        }
        System.out.println();
    }

    static double averageAge(Dog[] dogs){
        double average=0;
        double sum=0;
        for (int i=0; i<dogs.length; i++) {
            sum=sum + dogs[i].getAge();
            average=sum/dogs.length;

        }
return average;
    }
}
