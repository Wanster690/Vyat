import java.util.*;
import static java.util.Collection.*;

public class Translator {
    private Map<String, TreeSet<String>> dictionary;

    public Translator() {
        dictionary = new TreeMap<>();
    }

    public void add(String word, String translation) {
        if (dictionary.containsKey(word)) {
            TreeSet<String> translations = dictionary.get(word);
            translations.add(translation);
        } else {
            TreeSet<String> translations = new TreeSet<>();
            translations.add(translation);
            dictionary.put(word, translations);
        }
    }

    public List<String> get(String word) {
        return new ArrayList<>(dictionary.get(word));
    }

    public void printDictionary() {
        for (String word : dictionary.keySet()) {
            TreeSet<String> translations = dictionary.get(word);
            System.out.print(word + ": ");
            Iterator<String> iterator = translations.iterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next());
                if (iterator.hasNext()) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Translator translator = new Translator();
        translator.add("Custom", "общепринятое");
        translator.add("Custom", "уникальное");
        translator.add("Amazing", "удивительный");
        translator.add("Translation", "перевод");
        translator.add("Take", "брать");
        translator.add("Take", "дубль");
        translator.add("Take", "дубль");
        translator.add("Gusty", "порывистый");
        translator.add("Technology", "технология");
        translator.add("Programing", "программирование");
        translator.printDictionary();
    }
}
