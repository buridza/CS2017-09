package by.it.sc02_morning.lozitskaya.lesson08;

public class Dog {
    String name;
    int age;
    private int weight;
    private double power;

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setAge(int age){
        this.age=age;
    }

    public int getWeight(){
        return weight;
    }

    public double getPower(){
        return power;
    }

    public void setWeight(int weight){
        this.weight=weight;
    }

    public void setPower(double power){
        this.power=power;
    }

    @Override
    public String toString() {
        return "Кличка:" + " " + name + ". " + "Возраст:" + " " + age;
    }

    boolean win(Dog otherDog){
        //Шансы на победу = 0.2 * возраст + 0.3 * вес + 0.5 * силу укуса
        return (0.2*this.age + 0.3*this.weight + 0.5*this.power)>(0.2*otherDog.age + 0.3*otherDog.weight + 0.5*otherDog.power);
    }
}
