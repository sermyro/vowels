package com.sm;

import java.util.*;

public class WordAvg
{
    public static List<WordComparable> calculateAvg(List<String> words) {
        List<WordComparable> wordsAvg = new LinkedList<>();

        for(String w : words) {        	
            final WordComparable wordSet = new WordComparable(w.length());
            int vowelsCount = 0;
            
            for(char c : w.toCharArray()) {
                if(c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u') {
                    wordSet.add(c, ++vowelsCount);
                }
            }

			if (wordsAvg.contains(wordSet)) {
				for (WordComparable wa : wordsAvg)
					if (wa.equals(wordSet)) {
						wa.addCount();
						wa.addTotalVowel(vowelsCount);
						break;
					}
			} else {
				wordsAvg.add(wordSet);
			}
        }
        Collections.sort(wordsAvg);
        return wordsAvg;
    }
}
