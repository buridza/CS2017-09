package by.it.sc02_morning.davydov.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Даны события events и интервал workDuration работы регистратора.

Реализуйте метод calcStartTimes, так,
чтобы общее число включений регистратора на
указанный период времени (1) было минимальным,
но все события events при этом были зарегистрированы.
Одно и то же событие не может быть зарегистрировано
в двух разных включениях регистратора

Метод возвращает список включений регистратора
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A1VideoRegistrator {

    public static void main(String[] args) {
        A1VideoRegistrator instance = new A1VideoRegistrator();
        double[] events = new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        double workDuration = 1;
        //рассчитаем моменты старта, с длиной сеанса 1
        List<Double> starts = instance.calcStartTimes(events, workDuration);
        //покажем полученные моменты старта
        System.out.println(starts);
    }

    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration) {
        //events - события которые нужно зарегистрировать
        //workDuration время работы видеокамеры после старта
        List<Double> result;
        result = new ArrayList<>();
        /*hint: сортировка Arrays.sort обеспечит скорость алгоритма
                C*(n log n) + C1*n = O(n log n)
                а сортировка пузырьком
                C*(n * n) + C1*n = O(n*n) */
        //комментарии от проверочного решения сохранены для подсказки, но вы можете их удалить.
        //Ваше решение тут
        int i = 0;                              //i - это индекс события events[i]
        Arrays.sort(events);
        int n = events.length;                                    //подготовка к жадному поглощению массива событий
        while (i < events.length) {
            double start = events[i];
            result.add(start);
            double stop = start + workDuration;
            while ((i < n) && (events[i] <= stop)) i++;
            //пока есть незарегистрированные события
            //получим одно событие по левому краю
            //и запомним время старта видеокамеры
            //вычислим момент окончания работы видеокамеры
            //и теперь пропустим все покрываемые
            //за время работы видеокамеры события
            //увеличивая индекс.

        }
        return result;                        //вернем итог
    }

}
