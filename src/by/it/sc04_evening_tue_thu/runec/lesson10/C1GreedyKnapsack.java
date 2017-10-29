package by.it.sc04_evening_tue_thu.runec.lesson10;
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
import java.util.Arrays;
import java.util.Scanner;
//
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
        for (Item item:items) {
            System.out.println(item);
        }
        System.out.printf("Всего предметов: %d. Рюкзак вмещает %d кг.\n",n,W);
        Arrays.sort(items);

       // int cost=items[0].cost;
        //int cost1=items[1].cost;
       // int cost2=items[2].cost*(W-items[0].weight-items[1].weight)/(items[2].weight);
        double result = 0;
        int ves=0;
                for (int i = 0; ; i++) {
                        if((ves+items[i].weight)<W){
                                ves+=items[i].weight;
                                result+=items[i].cost;
                            }
                        else{ result+=items[i].cost/items[i].weight*(W-ves); break;}
                    }





        //тут необходимо реализовать решение задачи
        //итогом является максимально воможная стоимость вещей в рюкзаке
        //вещи можно резать на кусочки (непрерывный рюкзак)

        //реализуйте алгоритм сбора рюкзака
        //будет особенно хорошо, если с собственной сортировкой
        //кроме того, можете описать свой компаратор в классе Item

        //ваше решение.





        System.out.printf("Удалось собрать рюкзак на сумму %f\n",result);
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