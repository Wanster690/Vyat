package org.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainClass
{
    public static final int CARS_COUNT = 15;

    public static void main(String[] args)
    {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Race race = new Race(new Road(60), new Tunnel(4), new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        CyclicBarrier startBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!"));
        CyclicBarrier endBarrier = new CyclicBarrier(CARS_COUNT, () -> System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!"));

        Car.setStartBarrier(startBarrier);
        Car.setEndBarrier(endBarrier);

        for (int i = 0; i < cars.length; i++)
        {
            cars[i] = new Car(race, 200  + (int) (Math.random() * 50));
        }

        for (Car car : cars)
        {
            new Thread(car).start();
        }

        try
        {
            endBarrier.await();
        }
        catch (InterruptedException | BrokenBarrierException e)
        {
            throw new RuntimeException(e);
        }

        //Car.showWinners(3);
    }
}

