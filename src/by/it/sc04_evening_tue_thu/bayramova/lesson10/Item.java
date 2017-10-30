package by.it.sc04_evening_tue_thu.bayramova.lesson10;
/*
вспомогательный класс.
событие у аудитории(два поля: начало и конец)

Обратите внимание на метод compareTo
*/
class Item implements Comparable<Item> {
        int cost;
        int weight;
        double costToWeight;

        Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
            this.costToWeight = (double)cost/weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", weight=" + weight +
                    '}';
        }

    public double getCostToWeight() {
        return this.costToWeight;
    }

    @Override
        public int compareTo(Item o) {
            //тут может быть ваш компаратор
            double p1=this.cost/this.weight;
            double p2=o.cost/o.weight;
            if (p1>p2) return -1;
            else if (p1==p2) return 0;
            else return 1;
        }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }
}
