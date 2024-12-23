import vyatsu.task1.Animal;
import vyatsu.task1.Cat;
import vyatsu.task1.Dog;
import vyatsu.task1.Tiger;
import vyatsu.task2.Ant;
import vyatsu.task2.Butterfly;
import vyatsu.task2.Dragonfly;
import vyatsu.task2.Insects;
import vyatsu.task3.Amphibians;
import vyatsu.task3.Chameleon;
import vyatsu.task3.Frog;
import vyatsu.task3.Triton;

import java.util.Random;
public class Test {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("Бобик", 5),
                new Dog("Шарик", 3),
                new Dog("Спайк", 7),
                new Cat("Ласка", 6),
                new Cat("Мурка", 2),
                new Tiger("Амур", 13),
                new Ant("Рэд", 12),
                new Butterfly("Марианна", 7),
                new Ant("Блэк", 11),
                new Dragonfly("Стрекоза", 28),
                new Frog("Frog", 4, "Jump, Jump"),
                new Triton("Triton", 7, "Regeneration"),
                new Chameleon("Cham", 9, "Swap-Color")

        };


        for (Animal animal : animals) {
            animal.run(400);
            animal.swim(5);
            System.out.println();
        }

        ((Dragonfly) animals[9]).fly(10);
        ((Ant) animals[6]).lifespan();
        ((Butterfly) animals[7]).lifespan();
        ((Ant) animals[8]).lifespan();


        System.out.println("Количество собак: " + Dog.getCountOfDog());
        System.out.println("Количество кошек: " + Cat.getCountOfCat());
        System.out.println("Количество тигров: " + Tiger.getCountOfTiger());
        System.out.println("Количество муравьев: " + Ant.getCountOfAnt());
        System.out.println("Количество бабочек: " + Butterfly.getCountOfButterfly());
        System.out.println("Количество стрекоз: " + Dragonfly.getCountOfDragonfly());
        System.out.println("Количество лягушек: " + Frog.getCountOfFrog());
        System.out.println("Количество тритонов: " + Triton.getCountOfTriton());
        System.out.println("Количество хамелеонов: " + Chameleon.getCountOfChameleon());
        System.out.println("Всего насекомых: " + Insects.getCountOfInsects());
        System.out.println("Всего земноводных: " + Amphibians.getCountOfAmphibians());
        System.out.println("Всего животных: " + Animal.getCountOfAnimal());
        System.out.println("Уникальная способность лягушки: " + ((Amphibians) animals[10]).uniqueness());
        System.out.println("Уникальная способность тритона: " + ((Amphibians) animals[11]).uniqueness());
        System.out.println("Уникальная способность хамелеона: " + ((Amphibians) animals[12]).uniqueness());
        // вывод количества насекомых и амфибианс
    }
}