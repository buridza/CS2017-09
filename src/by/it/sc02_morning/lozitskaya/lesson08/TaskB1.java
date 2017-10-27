package by.it.sc02_morning.lozitskaya.lesson08;

/*

B. (продолжение задач уровня А).

Создайте новый класс DogHelper и в нем два статических метода
void printAllNames(Dog[] dogs){.....}; //должен печатать в консоль через пробел имена всех собак
double averageAge(Dog[] dogs){.....}; //должен вычислять средний возраст переданных ему собак

В классе TaskB1 и его методе main
    Создайте массив из 5 разных собак. Дайте всем клички и укажите возраст.
    Шарик 1 год, Жучка 2 года, Бобик 3 года, Барбос 4 года, Полкан 5 лет

    Напечатайте их имена с помощью метода printAllNames, ожидается
    Шарик Жучка Бобик Барбос Полкан

    Напечатайте с новой строки их средний возраст,
    рассчитанный через метод averageAge, ожидается:
    3.0

Итого, правильный вывод такой:
Шарик Жучка Бобик Барбос Полкан
3.0

*/

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

public class TaskB1 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Dog dog4 = new Dog();
        Dog dog5 = new Dog();

        Dog[] dogs = {dog1, dog2, dog3, dog4, dog5};

        dog1.setName("Шарик");
        dog1.setAge(1);

        dog2.setName("Жучка");
        dog2.setAge(2);

        dog3.setName("Бобик");
        dog3.setAge(3);

        dog4.setName("Барбос");
        dog4.setAge(4);

        dog5.setName("Полкан");
        dog5.setAge(5);

        DogHelper.printAllNames(dogs);
        System.out.println(DogHelper.averageAge(dogs));
    }
}
