package com.sm;

import java.util.*;

public class App
{
    public static void main( String[] args )
    {
    	// Read a file name argument
        String s = args[0];
        
        if(s.equals("")) {
            System.out.println("Empty file name");
            return;
        }

        // Extract all words from a file
        List<String> words = FileOperations.readWords(s);
        
        List<WordComparable> wordsAvg = WordAvg.calculateAvg(words);
        
        // Write to a file average number of vowels per word grouped 
        // by: set of vowels present in a word and length of the word.
        FileOperations.writeToFile(wordsAvg);
        
        System.out.println("\n Average number of vowels task - COMPLETED");
    }
}
