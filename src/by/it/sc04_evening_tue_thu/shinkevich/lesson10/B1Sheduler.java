package by.it.sc04_evening_tue_thu.shinkevich.lesson10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Даны желаемые интервальные события events в аудитории.
Реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.

Решение приведите в calcStartTimes(events, begin, end):
    events - события которые нужно распределить в аудитории
    в период [begin, end] (включительно).
    Изучите как устроен класс events

Оптимизация проводится по наибольшему числу непересекающихся событий.
Начало и конец событий могут совпадать.
*/

public class B1Sheduler {

    public static void main(String[] args) {
        B1Sheduler instance = new B1Sheduler();
        Event[] events = {  new Event(0, 3),  new Event(0, 1), new Event(1, 2), new Event(3, 5),
                            new Event(1, 3),  new Event(1, 3), new Event(1, 3), new Event(3, 6),
                            new Event(2, 7),  new Event(2, 3), new Event(2, 7), new Event(7, 9),
                            new Event(3, 5),  new Event(2, 4), new Event(2, 3), new Event(3, 7),
                            new Event(4, 5),  new Event(6, 7), new Event(6, 9), new Event(7, 9),
                            new Event(8, 9),  new Event(4, 6), new Event(8, 10), new Event(7, 10)
                          };

        //рассчитаем оптимальное заполнение аудитории
        List<Event> starts = instance.calcStartTimes(events,0,10);
        //покажем рассчитанный график занятий
        System.out.println(starts);
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {
        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<Event> result;
        result = new ArrayList<>();
        //ваше решение.
System.out.println(Arrays.toString(events));
       Arrays.sort(events);
        System.out.println(Arrays.toString(events));




        return result;                        //вернем итог
    }
}
