package by.it.sc02_morning.menchytsky.lesson10;
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

        int getWeight (){
            return weight;
        }

        int getCost(){
            return cost;
        }



        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Item otherItem) {
            int result=0;
            if((this.cost/this.weight)>(otherItem.cost/otherItem.weight)) result = -1;
            if ((this.cost/this.weight)==(otherItem.cost/otherItem.weight)) result = 0;
            if ((this.cost/this.weight)<(otherItem.cost/otherItem.weight)) result = 1;
            //тут может быть ваш компаратор


            return result;
        }
    }
