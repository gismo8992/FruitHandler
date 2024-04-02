import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            Map<String, Integer> wordFrequency = new HashMap<>();
            String longestWord = "";
            int wordCount = 0;

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                wordCount++;

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }

                if (wordFrequency.containsKey(word)) {
                    int count = wordFrequency.get(word);
                    wordFrequency.put(word, count + 1);
                } else {
                    wordFrequency.put(word, 1);
                }
            }

            scanner.close();

            System.out.println("Количество слов в файле: " + wordCount);
            System.out.println("Самое длинное слово в файле: " + longestWord);

            System.out.println("Частота слов:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}