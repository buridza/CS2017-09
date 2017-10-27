package by.it.sc04_evening_tue_thu.shinkevich.lesson08;


            public class Dog {
                private String name;
                private int age;
                private int weight;
                private double power;

                String getName(){
                    return this.name; }
                void setName(String name) {
                    this.name = name;
                }

                int getAge(){
                    return age; }
                void setAge(int age){
                    this.age=age; }

                int getWeight(){
                    return weight;
                }
                void setWeight(int weight){
                    this.weight=weight;
                }

                double getPower(){
                    return power;
                }
                void setPower(double power){
                    this.power=power;
                }

                public String toString(){
                    return "Кличка: "+name+". "+ "Возраст: "+age;
                }

                boolean win(Dog otherDog){
                    double chancesToWin1=0.2* this.getAge()+0.3*this.getWeight()+0.5*this.getPower();
                    double chancesToWin2=0.2* otherDog.getAge()+0.3*otherDog.getWeight()+0.5*otherDog.getPower();
                    if (chancesToWin1>chancesToWin2)
                        return true;
                    else return false;

        }
}