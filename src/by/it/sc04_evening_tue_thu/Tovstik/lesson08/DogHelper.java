package by.it.sc04_evening_tue_thu.Tovstik.lesson08;

public class DogHelper {

    static void printAllNames(Dog[] dogs){
        for (int i = 0; i < dogs.length; i++) {
            if (i<4)
            System.out.print(dogs[i].getName() + " ");
            else
                System.out.print(dogs[i].getName());
        }
    }

    double averageAge(Dog[] dogs){
        int sum = 0;
        for (int i = 0; i < dogs.length; i++) {
        sum = sum + dogs[i].getAge();
        }
        return (double)sum/dogs.length;
    }

}
