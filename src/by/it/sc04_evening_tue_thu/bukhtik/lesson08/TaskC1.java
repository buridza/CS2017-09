package by.it.sc04_evening_tue_thu.bukhtik.lesson08;

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
        Scanner sc = new Scanner (System.in);

        Dog dog1 = new Dog ();
        Dog dog2 = new Dog();

        String a1 = sc.nextLine();
        int b1 = sc.nextInt();
        int c1 = sc.nextInt();
        double d1 = sc.nextDouble();
        String a2 = sc.nextLine();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        double d2 = sc.nextDouble();

        dog1.setName(a1);
        dog1.setAge(b1);
        dog1.setWeight(c1);
        dog1.setPower(d1);

        dog2.setName(a2);
        dog2.setAge(b2);
        dog2.setWeight(c2);
        dog2.setPower(d2);


        if (true) {
            dog1.win(dog2);
            System.out.println(dog1.getName());
        }
        else System.out.println(dog2.getName());



    }

}
