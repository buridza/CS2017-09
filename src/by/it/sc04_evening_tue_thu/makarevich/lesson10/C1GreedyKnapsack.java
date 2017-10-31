package by.it.sc04_evening_tue_thu.makarevich.lesson10;
/*
Соберите рюкзак.

Из файла или из консоли вводятся числа (конкретные цифры - для примера)
1) объем рюкзака 60
2) число возможных предметов 4
3) сам набор предметов
    100 50
    120 30
    100 50
    100 50
Необходимо собрать наиболее дорогой вариант рюкзака для этого объема
Решение приведите в методе calc

Предметы можно резать на кусочки (т.е. алгоритм будет жадным)
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class C1GreedyKnapsack {

    double calc(File source) throws FileNotFoundException {
        Scanner input = new Scanner(source);
        int n = input.nextInt();      //сколько предметов в файле
        int W = input.nextInt();      //какой вес у рюкзака
        Item[] items = new Item[n];   //получим список предметов
        for (int i = 0; i < n; i++) { //создавая каждый конструктором
            items[i] = new Item(input.nextInt(), input.nextInt());
        }
        //покажем предметы
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.printf("Всего предметов: %d. Рюкзак вмещает %d кг.\n", n, W);

        for (int i = 1; i < items.length; i++) {  // сортировка в убывающем порядке
            for (int j = 1; j <= items.length - i; j++) {
                if (items[j].value() > items[j - 1].value()) {
                    Item tmp = items[j - 1];
                    items[j - 1] = items[j];
                    items[j] = tmp;
                }
            }
        }
        double result = 0;
        double valueOfPiece=0;

            for (int i = 0; i < items.length; i++) {
                if (W / items[i].weight >= 1) {
                    W = W - items[i].weight;
                    result = result + items[i].cost;
                }
                else
                    while (W > 0) {
                        valueOfPiece = (W * items[i].cost) / items[i].weight;
                        result = result + valueOfPiece;
                        W = W - (int) ((items[i].weight * valueOfPiece) / items[i].cost);
                    }

                }

            System.out.printf("Удалось собрать рюкзак на сумму %f\n", result);
            return result;
        }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        String root=System.getProperty("user.dir")+"/src/";
        File f=new File(root+"by/it/akhmelev/lesson10/greedyKnapsack.txt");
        double costFinal=new C1GreedyKnapsack().calc(f);
        long finishTime = System.currentTimeMillis();
        System.out.printf("Общая стоимость %f (время %d)",costFinal,finishTime - startTime);
    }
}