import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//3,1415926535897932384626433832795028841971693993751058 // 52


public class Threads{
    static final int SIZE = 60_000_000;
    static final int HALF = SIZE / 2;
    static final int HALFN = SIZE / 2 + 1;


    public void firstMethod()
    {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long start = System.currentTimeMillis();

        for (int i = 0; i <SIZE; i++)
        {
         arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        long end = System.currentTimeMillis();
        System.out.println("Первый элемент массива: " + arr[0]);
        System.out.println("Последний элемент массива: " + arr[SIZE-1]);
        System.out.println("Время выполнения при однопоточности: " + (end - start) + " мс\n");
    }

    public void secondMethod() {
            float[] arr = new float[SIZE];
            float[] firstHalf = new float[HALF];
            float[] secondHalf;
            if (SIZE % 2 != 0){
                 secondHalf = new float[HALFN];
            } else {
                secondHalf = new float[HALF];
            }


        Arrays.fill(arr, 1.0f);

            long start = System.currentTimeMillis();

            System.arraycopy(arr, 0, firstHalf, 0, HALF);

        if (SIZE % 2 != 0)
        {
            System.arraycopy(arr, HALF, secondHalf, 0, HALFN);
        }
        else
        {
            System.arraycopy(arr, HALF, secondHalf, 0, HALF);
        }
            Thread t1 = new Thread(() -> {
                for (int i = 0; i < HALF; i++) {
                    firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(firstHalf, 0, arr, 0, HALF);
            });

            Thread t2 = new Thread(() -> {
                for (int i = HALF; i < SIZE; i++) {
                    secondHalf[i-HALF] = (float) (secondHalf[i-HALF] * Math.sin(0.2f + i / 5) *
                            Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                if (SIZE % 2 != 0) {
                    System.arraycopy(secondHalf, 0, arr, HALF, HALFN);
                } else {
                    System.arraycopy(secondHalf, 0, arr, HALF, HALF);
                }
            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long end = System.currentTimeMillis();


        System.out.println("Первый элемент массива:    " + arr[0]);
        System.out.println("Последний элемент массива: " + arr[SIZE - 1]);
        System.out.println("Время выполнения второго метода: " + (end - start) + " мс\n");
    }

    public void thirdMethod(int tCount) {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);

        while (SIZE % tCount != 0) {
            tCount++;
        }


        float[][] subArr = new float[tCount][];
        List<java.lang.Thread> threads = new ArrayList<>();

        long startT = System.currentTimeMillis();

        int startIndex = 0;
        int endIndex = 0;
        int tSize = 0;

        for (int i = 0; i < tCount; i++) {
            tSize = SIZE / tCount;

            startIndex = endIndex;
            endIndex += tSize;

            final int start = startIndex;
            final int end = endIndex;
            final int arrayIndex = i;

            threads.add(new java.lang.Thread(() -> {
                subArr[arrayIndex] = Arrays.copyOfRange(array, start, end);
                for (int j = start; j < end; j++) {
                    subArr[arrayIndex][j - start] = (float) (subArr[arrayIndex][j - start] * Math.sin(0.2f + j / 5) *
                            Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }

            }));
            threads.get(i).start();
        }

        for (java.lang.Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0; i < tCount; i++) {
            System.arraycopy(subArr[i], 0, array, i * tSize, tSize);
        }

        long endT = System.currentTimeMillis();

        System.out.println("Первый элемент массива:    " + array[0]);
        System.out.println("Последний элемент массива: " + array[SIZE - 1]);
        System.out.println("Время выполнения третьего метода: " + (endT - startT) + " мс");
        System.out.println("Количество потоков: " + tCount);
    }
}

// подправить 2 метод и в 3 методе выводить количество потоков.
