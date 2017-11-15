package by.it.sc04_evening_tue_thu.rumiantsau.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Видеорегистраторы и площадь 2.
Условие то же что и в задаче А.

        По сравнению с задачей A доработайте алгоритм так, чтобы
        1) он оптимально использовал время и память:
            - за стек отвечает элиминация хвостовой рекурсии,
            - за сам массив отрезков - сортировка на месте
            - рекурсионные вызовы должны проводится на основе 3-разбиения

        2) при поиске подходящих отрезков для точки реализуйте метод бинарного поиска,
        помните при реализации, что поиск множественный
        (т.е. отрезков, подходящих для точки, может быть много)

    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/

public class C_QSortOptimized {

    private class Event implements Comparable<Event>{
        int time;
        int type; //-1=off 0=point +1=on

        public Event(int time, int type){
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event otherEvent) {
            int res = this.time - otherEvent.time;
            if (res == 0)
                res = -this.type + otherEvent.type;

            return res;
        }

        public String toString(){
            return "e{" + this.time + ", " + this.type + "}";
        }
    }

    //отрезок
    private class Segment  implements Comparable{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Object o) {
            //подумайте, что должен возвращать компаратор отрезков
            //и нужен ли он вообще.
            return 0;
        }

        @Override
        public String toString() {
            return "("+start +":" + stop +')';
        }

    }

    private int partition(int[] a, int left, int right) {
        int x = a[left];
        int j = left;

        for (int i = left + 1; i <= right; i++){
            if (a[i] < x) {
                j++;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }

        int tmp = a[j];
        a[j] = a[left];
        a[left] = tmp;

        return j;
    }

    private void qSort(int[] a, int left, int right) {
        if (left >= right)
            return;

        // Элиминация хвостовой рекурсии
        while (left < right) {
            int m = partition(a, left, right);
            qSort(a, left, m - 1);
            left = m + 1;
        }
    }

    private void qSort(int[] a){
        qSort(a, 0, a.length - 1);
    }

    int[] getAccessory2(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points = new int[m];
        int[] result = new int[m];

        // сюда сложим события
        Event[] events = new Event[2 * n + m];
        int counterEvents = 0;

        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i] = new Segment(scanner.nextInt(),scanner.nextInt());

            events[counterEvents++] = new Event(segments[i].start, +1);
            events[counterEvents++] = new Event(segments[i].stop, -1);
        }
        System.out.println("segments="+ Arrays.toString(segments));

        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
            events[counterEvents++] = new Event(points[i], 0);
        }
        System.out.println("points="+ Arrays.toString(points));

        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор

        qSort(points);
        System.out.println("Sorted points="+Arrays.toString(points));

        Arrays.sort(events);
        System.out.println("Sorted events="+Arrays.toString(events));

        int pts = 0;
        int camOn = 0;
        for (int i = 0; i < events.length; i++) {
            if (events[i].type == 0) {
                result[pts++] = camOn;
            } else
                camOn = camOn + events[i].type;
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc04_evening_tue_thu/rumiantsau/lesson12/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        System.out.println("result="+ Arrays.toString(result));
    }

}
