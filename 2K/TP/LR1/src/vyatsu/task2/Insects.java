package vyatsu.task2;

import vyatsu.task1.Animal;

public abstract class Insects extends Animal {
    private int lifetime;
    private static int countOfInsects;

    public void setLifetime(int lifetime){
        this.lifetime = lifetime;
    }

    public  Insects(String name, int age){
        super(name, age);
        countOfInsects++;
    }
    public void lifespan(){
        System.out.println("Средняя продолжительность жизни " + super.getName() + ":\n" + lifetime + " месяцев.");}

    public static int getCountOfInsects(){
        return countOfInsects;
    }
}
