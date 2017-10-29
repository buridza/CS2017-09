package by.it.sc04_evening_tue_thu.runec.lesson10;
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

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
    public int compareTo(Item o) {
//тут может быть ваш компаратор
//1 если порядок следования в массиве или коллекции this и otherEvent правильный
//0 если объекты равны
//-1 если порядок следования в массиве или коллекции this и otherEvent неправильный
        return -this.cost/this.weight+o.cost/o.weight;


//
    }
}
