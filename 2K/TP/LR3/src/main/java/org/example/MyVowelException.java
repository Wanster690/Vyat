package org.example;

public class MyVowelException extends RuntimeException {
    public MyVowelException(int rowIndex, int columnIndex, String s){
        super("В ячейке " + (rowIndex+1) + ","+ (columnIndex+1)+" массива " + " - гласная.");
    }
}
