package by.it.sc04_evening_tue_thu.bukhtik.lesson10;
/*
вспомогательный класс.
событие у аудитории(два поля: начало и конец)

Обратите внимание на метод compareTo
*/
class Item implements Comparable<Item> {
        int cost;
        int weight;

        public int getCost() {
            return cost;
        }

        public void setCost(int start) {
            this.cost = start;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int stop) {
            this.weight = stop;
        }





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
        public int compareTo(Item otherItem) {
            //тут может быть ваш компаратор

            return (otherItem.cost/otherItem.weight - this.cost/this.weight);
        }
    }
