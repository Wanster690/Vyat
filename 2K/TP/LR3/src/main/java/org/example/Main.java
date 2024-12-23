package org.example;
public class Main {
    public static void main(String[] args){
        boolean nums = true;
        String[][] fibonacciArray = {
                {"2", "1", "1", "1",},
                {"1", "2", "t", "1",},
                {"1", "2", "1", "e",},
                {"1", "1", "1", "1"},
        };
        try {
            if (check(fibonacciArray));
            else nums = false;

            int sum = getSum(fibonacciArray);

            if (nums){
                System.out.println("Сумма элементов массива: " + sum);
            }
        }catch (MyArraySizeException | MyVowelException | MyArrayDataException | MyNoFibonacciException e){
            e.printStackTrace();
            int sum = 0;
            boolean consonantsPresent = false;
            for(String[] arr : fibonacciArray){
                for (String num : arr){
                    try {
                        sum+=Integer.parseInt(num);
                    }catch (NumberFormatException ex){
                        //System.out.println("Некорректное значение: " + num);
                    }
                    if (hasConsonant(num)){
                        consonantsPresent = true;
                    }
                }
            }
            if (nums && !consonantsPresent){
                System.out.println("Сумма элементов массива: " + sum);
            }
        }
    }
    static  int sum = 0;
    static int v = 0;
    public static boolean check(String[][] array) throws  MyArraySizeException, MyVowelException, MyArrayDataException{
        boolean tmp = true;
        for (int i = 0; i < array.length ; i++) {
            if (array[i].length != 4) throw new MyArraySizeException();
            else {
                for (int j = 0; j < array[i].length ; j++) {
                    if (array[j].length != 4) throw new MyArraySizeException();
                    try {
                        if (!array[i][j].matches("(?ui:[eyuioaуеэоаыяию])"))
                            v=Integer.valueOf(array[i][j]);
                        if (array[i][j].length() > 1) throw new MyArrayDataException(i,j,array[i][j]);
                    }catch (NumberFormatException e){
                        throw new MyArrayDataException(i,j,array[i][j]);
                    }

                }
            }
        }
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                try {
                    sum+=Integer.valueOf(array[i][j]);
                }catch (NumberFormatException e){
                    try {
                        if ((array[i][j].matches("(?ui:[eyuioaуеэоаыяию])") || hasConsonant(array[i][j]))) {
                        if (hasConsonant(array[i][j])){
                        tmp = false;
                        }
                        throw new MyVowelException(i,j,array[i][j]);
                        }
                    }catch (MyVowelException ee) {
                        ee.printStackTrace();
                        tmp = false;
                    }
                }
            }
        }
        return  tmp;

    }
    public static boolean hasConsonant(String str){
        return str.matches(".*[bcdfghjklmnpqrstvwxябвгджхклмнпрстфхцчщш].*");
    }
    public static int getSum(String[][] array)
        throws MyArraySizeException, MyVowelException, MyArrayDataException, MyNoFibonacciException{
        int sum = 0;
        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int number = Integer.parseInt(array[i][j]);

                    if (number > 1000 || !isFibonacci(number)){
                        throw new MyNoFibonacciException(i,j,number);
                    }
                    sum+=number;
            } catch (NumberFormatException e){
                }

        }

        }
        return sum;
    }
    public static boolean isFibonacci(int number){
        int a = 0;
        int b = 1;
        while (b<number){
            int temp = b;
            b = a+b;
            a=temp;
        }
        return  b == number;
    }
}


































