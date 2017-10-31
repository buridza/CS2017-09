package by.it.sc04_evening_tue_thu.makarevich.lesson10;

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
        List<Double> result;
        result = new ArrayList<>();
        int i = 0;
        int n=events.length;
        Arrays.sort(events);
        while (i < events.length) {
            double start = events[i];
            double stop = start + workDuration;
            result.add(start);
            while (i < n && events[i] <= stop) {
                i++;
            }
        }
        return result;
    }

}

