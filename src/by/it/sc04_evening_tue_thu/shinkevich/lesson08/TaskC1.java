package by.it.sc04_evening_tue_thu.shinkevich.lesson08;

/*
Доработайте класс Dog.

1) Добавьте два новых поля с геттерами и сеттерми (!!!!)
private int weight; //вес собаки
private double power; //сила укуса собаки

2) Напишите экземплярный метод в классе Dog
boolean win(Dog otherDog)
    {... тело метода...}
который рассчитывает, кто из двух собак победит эта (this) или та (otherDog).

Расчет должен быть таким.
    Шансы на победу = 0.2 * возраст + 0.3 * вес + 0.5 * силу укуса.

Побеждает та собака, у которой больше шансов на победу.
Если победила эта (this), то метод win возвращает true, иначе false

3) Проверка.
В классе TaskC1 с клавиатуры через Scanner водятся две собаки в формате
кличка возраст вес сила
кличка возраст вес сила
(всего получается 8 чтений разных данных)

Создайте этих собак, определите победителя с помощью созданного
в классе Dog метода boolean win(Dog dog).
Напечатайте кличку победителя.
*/


import java.util.Scanner;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String nameDog1=sc.next();
        int ageDog1=sc.nextInt();
        int weightDog1=sc.nextInt();
        double powerDog1=sc.nextDouble();
        String nameDog2=sc.next();
        int ageDog2=sc.nextInt();
        int weightDog2=sc.nextInt();
        double powerDog2=sc.nextDouble();

        Dog dog1=new Dog();
        dog1.setName(nameDog1);
        dog1.setAge(ageDog1);
        dog1.setWeight(weightDog1);
        dog1.setPower(powerDog1);

        Dog dog2=new Dog();
        dog2.setName(nameDog2);
        dog2.setAge(ageDog2);
        dog2.setWeight(weightDog2);
        dog2.setPower(powerDog2);

        if (dog1.win(dog2))
            System.out.println(dog1.getName());
        else System.out.println(dog2.getName());
    }
}
