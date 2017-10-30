package by.it.sc02_morning.sabitova.lesson08;

public class DogHelper {
    public static void printAllNames(Dog[] dogs){
        for (Dog i: dogs) System.out.print(i.getName()+" ");
    }
    //должен печатать в консоль через пробел имена всех собак
    public static double averageAge(Dog[] dogs){
        double sum=0;
        for (Dog i: dogs) sum+=(double)i.getAge();
        return sum/dogs.length;
    } //должен вычислять средний возраст переданных ему собак
}