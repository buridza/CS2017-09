package by.it.sc02_morning.lozitskaya.lesson08;

public class DogHelper {

    public static void printAllNames(Dog[] dogs){
            System.out.println(dogs[0].getName() + " " + dogs[1].getName() + " " + dogs[2].getName() +
             " " + dogs[3].getName() + " " + dogs[4].getName());
    }

    public static double averageAge(Dog[] dogs){
        double sum=0;
        for(int i=0; i<dogs.length; i++){
            sum+=dogs[i].getAge();
        }
        return sum/dogs.length;
    }
}
