import java.io.*;
import java.util.*;

public class Main {

    // Function to check if a word is compounded
    public static boolean isCompoundWord(String word, Set<String> wordSet) {
        for (int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            if (wordSet.contains(prefix) && wordSet.contains(suffix)) {
                return true;
            }
        }
        return false;
    }

    // Function to find the longest and second longest compound words
    public static void findLongestCompoundWords(String filename) throws IOException {
        // Read the input file and store words in a set for fast lookup
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        Set<String> wordSet = new HashSet<>();
        List<String> words = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null) {
            words.add(line);
            wordSet.add(line);
        }
        reader.close();

        String longest = "";
        String secondLongest = "";
        
        // Start measuring time
        long startTime = System.currentTimeMillis();

        // Iterate through each word and check if it is a compound word
        for (String word : words) {
            if (isCompoundWord(word, wordSet)) {
                if (word.length() > longest.length()) {
                    secondLongest = longest;
                    longest = word;
                } else if (word.length() > secondLongest.length()) {
                    secondLongest = word;
                }
            }
        }

        // End time measurement
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;

        // Output the results
        System.out.println("Longest Compound Word: " + longest);
        System.out.println("Second Longest Compound Word: " + secondLongest);
        System.out.println("Time taken to process file " + filename + ": " + timeTaken + " milliseconds");
    }

    public static void main(String[] args) {
        try {
            // Example for Input_01.txt and Input_02.txt
            findLongestCompoundWords("Input_01.txt");
            findLongestCompoundWords("Input_02.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
