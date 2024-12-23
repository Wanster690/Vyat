package org.example;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tunnel extends org.example.Stage
{
    private static final int length = 80;
    private final Semaphore semaphore;
    private final Lock lock;

    public Tunnel(int limit)
    {
        super(length, "Тоннель " + length + " метров");

        semaphore = new Semaphore(limit);
        lock = new ReentrantLock();
    }

    @Override
    public void go(Car car)
    {
        try
        {
            System.out.println(car.getName() + " готовится к этапу(ждет): " + description);

            lock.lock();

            semaphore.acquire();
            System.out.println(car.getName() + " начал этап: " + description);

            lock.unlock();

            Thread.sleep(length / car.getSpeed() * 1000L);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            System.out.println(car.getName() + " закончил этап: " + description);
            semaphore.release();
        }
    }
}
