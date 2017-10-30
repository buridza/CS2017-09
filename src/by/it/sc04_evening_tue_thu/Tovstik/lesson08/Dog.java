package by.it.sc04_evening_tue_thu.Tovstik.lesson08;

public class Dog {

    private String name;
    private  int age;

    String getName(){
        return this.name;

    }
    void setName(String name) {
        this.name = name;
    }
    int getAge(){
        return age;
    }
    void setAge(int age)  {
        this.age = age;
    }

    public String toString(){
        return "Кличка: " +name + ". Возраст: " + age;
    }
}


