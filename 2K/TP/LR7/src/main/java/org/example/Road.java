package org.example;

public class Road extends Stage
{
    public Road(int length)
    {
        super(length, "Дорога " + length + " метров");
    }

    @Override
    public void go(Car car)
    {
        try
        {
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length / car.getSpeed() * 1000L);

            System.out.println(car.getName() + " закончил этап: " + description);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
