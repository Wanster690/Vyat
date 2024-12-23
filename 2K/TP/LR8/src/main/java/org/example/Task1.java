package org.example;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "apple", "banana", "kiwi", "banana", "kiwi", "kiwi", "apple", "яблоко" , "яблоко" , "яблоко", "Яблоко" , "Яблоко" , "Яблоко" , "Яблоко"};

        List<String> mostFrequentWords = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().equals(
                        Arrays.stream(words)
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                .values().stream()
                                .max(Long::compare).orElse(0L)))
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Наиболее часто встречающиеся слова: " + mostFrequentWords);
    }
}