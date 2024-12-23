package org.example;

public class MyArrayDataException extends  RuntimeException
{
    public MyArrayDataException(int rowIndex, int columnIndex, String s)
    {
        super("В ячейке " + (rowIndex + 1) + "," + (columnIndex + 1) + " массива лежит что-то не то.");
    }
}
