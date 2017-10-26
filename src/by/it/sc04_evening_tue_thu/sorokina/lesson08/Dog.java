package by.it.sc04_evening_tue_thu.sorokina.lesson08;

public class Dog {
    private String name;
    private int age;
    private int weight;
    private double power;



 /*   String getName(){
        return name;
    }
    void setName(String name){
        this.name = name;
    }

    int getAge(){
        return age;
    }

    void setAge(int age){
        this.age = age;
    }
*/

     String getName() {
        return name;
    }

     void setName( String name ) {
        this.name = name;
    }

     int getAge() {
        return age;
    }

    void setAge( int age ) {
        this.age = age;
    }


    public String toString() {
        return "Кличка: " + name + ". Возраст: " + age;
    }

    int getWeight() {
        return weight;
    }

    void setWeight( int weight ) {
        this.weight = weight;
    }

    double getPower() {
        return power;
    }

    void setPower( double power ) {
        this.power = power;
    }

//  Шансы на победу = 0.2 * возраст + 0.3 * вес + 0.5 * силу укуса.

   public static boolean win(Dog dog1, Dog dog2){
         double resultDog1 = dog1.getAge()*0.2 + dog1.getWeight()*0.3+dog1.getPower()*0.5;
         double resultDog2 = dog2.getAge()*0.2 + dog2.getWeight()*0.3 + dog2.getPower()*0.5;

        if(resultDog1 > resultDog2)
          return  true;
        else return false;


   }}
