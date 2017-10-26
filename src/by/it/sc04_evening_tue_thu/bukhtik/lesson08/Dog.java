package by.it.sc04_evening_tue_thu.bukhtik.lesson08;

public class Dog {
    private String name;
    private int age;
    private int weight;
    private double power;

    String getName (){
        return name;
    }
    void setName (String name){
        this.name=name;
        }

    int getAge (){
        return age;
    }
    void setAge (int age){
        this.age = age;
    }

    int getWeight (){
        return weight;
    }
    void setWeight (int weight){
        this.weight=weight;
    }

    double getPower (){
        return power;
    }
    void setPower (double power){
        this.power=power;
    }


    public String toString(){
        return  ( name + " " + age + " " + weight + " " + power);


    }

    boolean win(Dog otherDog){
      /*  Шансы на победу = 0.2 * возраст + 0.3 * вес + 0.5 * силу укуса. */
      double a = 0.2 * this.getAge() + 0.3*this.getWeight() + 0.5*this.getPower();
      double b = 0.2 * otherDog.getAge() + 0.3*otherDog.getWeight() + 0.5*otherDog.getPower();

      if (a>b) return true;
      else return false;
    }




}
