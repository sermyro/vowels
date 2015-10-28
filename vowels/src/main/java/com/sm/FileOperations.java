package com.sm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    public static List<String> readWords(String fileName) {
        List<String> words = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            
            while (line != null) {
                String[] parts = line.split("[^a-zA-Z0-9\\-\'\\_]");
                for (String w : parts) {
                    if(w.matches("^[a-zA-Z0-9\\-'\\_]{1,}$")) {
                        words.add(w.toLowerCase());
                    }
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static void writeToFile(List<WordComparable> wordsAvg){
        try(PrintWriter writer = new PrintWriter("output.txt", "UTF-8")) {
            for(WordComparable wa : wordsAvg){
                writer.println(wa);
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
