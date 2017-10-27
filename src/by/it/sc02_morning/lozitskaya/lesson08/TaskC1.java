package by.it.sc02_morning.lozitskaya.lesson08;

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
        Scanner sc = new Scanner(System.in);
        Dog dog1 = new Dog();
        dog1.setName(sc.next());
        dog1.setAge(sc.nextInt());
        dog1.setWeight(sc.nextInt());
        dog1.setPower(sc.nextDouble());
        Dog dog2 = new Dog();
        dog2.setName(sc.next());
        dog2.setAge(sc.nextInt());
        dog2.setWeight(sc.nextInt());
        dog2.setPower(sc.nextDouble());

        if(dog1.win(dog2)) System.out.println(dog1.getName());
        else System.out.println(dog2.getName());
    }
}
