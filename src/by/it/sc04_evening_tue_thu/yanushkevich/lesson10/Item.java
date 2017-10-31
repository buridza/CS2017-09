package by.it.sc04_evening_tue_thu.yanushkevich.lesson10;
/*
вспомогательный класс.
событие у аудитории(два поля: начало и конец)

Обратите внимание на метод compareTo
*/
class Item implements Comparable<Item> {
        int cost;
        int weight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item o) {
            //--сортировка элементов по возрастанию стоимости за кг

         /*   double p1=this.cost/this.weight;
            double p2=o.cost/o.weight;
            if (p1>p2) return -1;
            else if (p1==p2) return 0;
            else return 1;*/

            return (o.cost/o.weight - this.cost/this.weight); //--возвращает отриц.число 0 или полож число
            //--что в итоге компаратором будет преобразовано в -1; 0; 1



        }
    }
