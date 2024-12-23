import org.example.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Box.showBox;

public class

Main {
    public static void main(String[] args) {
        //1
        Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        swap(intArray, 0, 8);

        //2
        List<Integer> intList = convertToList(intArray);
        System.out.println(intList);

        //3
        Box<Apple> appleBox1 = new Box<>(new Apple(), new Apple(), new Apple(), new Apple());

        Box<Apple> appleBox2 = new Box<>(new Apple(), new Apple(), new Apple());

        Box<Orange> orangeBox1 = new Box<>(new Orange(), new Orange(), new Orange());

        Box<Lemon> lemonBox1 = new Box<>(new Lemon());

        Box<Lemon> lemonBox2 = new Box<>(new Lemon(), new Lemon(), new Lemon(), new Lemon());

        appleBox1.addFruit(1);
        orangeBox1.addFruit(1);
        appleBox2.addFruit(2);


        showBox(appleBox1);
        showBox(appleBox2);
        System.out.println("Масса коробки с яблоками 1 равна массе коробка с яблоками 2 = "
                + appleBox1.compareBoxesWeight(appleBox2));
        showBox(appleBox2);
        showBox(orangeBox1);
        System.out.println("Масса коробки с яблоками 2 равна массе коробки с апельсинами 1 = "
                + appleBox2.compareBoxesWeight(orangeBox1));

        appleBox1.transferFruit(appleBox2);


        lemonBox2.addFruit(1, new Orange());
        lemonBox2.addFruit(3, new Lemon());

        lemonBox2.transferFruit(lemonBox1);

        lemonBox1.transferFruit(lemonBox1);

        orangeBox1.addFruit(2);
        orangeBox1.compareBoxesWeight(lemonBox1);
        appleBox2.transferFruit(appleBox1);
        showBox(appleBox1);
    }

    public static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public static <T> List<T> convertToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}

