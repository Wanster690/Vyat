package org.example;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "apple", "grape", "banana", "pear", "orange", "kiwi", "kiwi", "kiwi", "kiwi", "kiwi", "mango"};
        //  List<String> uniqueWords = new ArrayList<>(new HashSet<>(Arrays.asList(words)));
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("Количество повторений каждого слова: " + wordCount);
    }
}
