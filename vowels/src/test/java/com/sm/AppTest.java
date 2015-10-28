package com.sm;


import org.junit.Assert;
import org.junit.Test;

import com.sm.FileOperations;
import com.sm.WordAvg;
import com.sm.WordComparable;

import java.util.*;

public class AppTest
{
    @Test
    public void test1(){
        List<String> words = FileOperations.readWords(getClass().getClassLoader().getResource("input1.txt").getPath());
        List<WordComparable> wordsAvg = WordAvg.calculateAvg(words);

        WordComparable ws1 = new WordComparable(6);
        Set<Character> ch1 = new HashSet<Character>();
        ch1.add('a');
        ch1.add('o');
        ws1.setCharSet(ch1);
        ws1.addCount();
        ws1.addCount();
        ws1.addTotalVowel(5);

        WordComparable ws2 = new WordComparable(4);
        Set<Character> ch2 = new HashSet<Character>();
        ch2.add('a');
        ch2.add('e');
        ws2.setCharSet(ch2);
        ws2.addCount();
        ws2.addTotalVowel(2);

        WordComparable ws3 = new WordComparable(5);
        Set<Character> ch3 = new HashSet<Character>();
        ch3.add('a');
        ch3.add('o');
        ws3.setCharSet(ch3);
        ws3.addCount();
        ws3.addTotalVowel(2);

        Assert.assertTrue(wordsAvg.contains(ws1));
        Assert.assertTrue(wordsAvg.contains(ws2));
        Assert.assertTrue(wordsAvg.contains(ws3));
        Assert.assertEquals(words.size(), 4);
        Assert.assertEquals(wordsAvg.size(), 3);
    }

    @Test
    public void test2(){
        List<String> words = FileOperations.readWords(getClass().getClassLoader().getResource("input2.txt").getPath());
        List<WordComparable> wordsAvg = WordAvg.calculateAvg(words);

        WordComparable ws1 = new WordComparable(4);
        Set<Character> ch1 = new HashSet<Character>();
        ch1.add('e');
        ws1.setCharSet(ch1);
        ws1.addCount();
        ws1.addTotalVowel(1);

        Assert.assertTrue(wordsAvg.contains(ws1));
        Assert.assertEquals(words.size(), 1);
        Assert.assertEquals(wordsAvg.size(), 1);
    }

    @Test
    public void test3(){
        List<String> words = FileOperations.readWords(getClass().getClassLoader().getResource("input3.txt").getPath());
        List<WordComparable> wordsAvg = WordAvg.calculateAvg(words);

        Assert.assertEquals(wordsAvg.get(0).toString(), "({e, o}, 8) -> 3");
        Assert.assertEquals(wordsAvg.get(1).toString(), "({a, e}, 8) -> 3");
        Assert.assertEquals(wordsAvg.get(2).toString(), "({e, i}, 7) -> 2");
        Assert.assertEquals(wordsAvg.get(3).toString(), "({a, e}, 5) -> 2");
        Assert.assertEquals(wordsAvg.get(4).toString(), "({e}, 3) -> 1");
        Assert.assertEquals(wordsAvg.get(5).toString(), "({o}, 2) -> 1");
    }

    @Test
    public void test4(){
        List<String> words = FileOperations.readWords(getClass().getClassLoader().getResource("input4.txt").getPath());
        Assert.assertTrue(words.isEmpty());
        List<WordComparable> wordsAvg = WordAvg.calculateAvg(words);
        Assert.assertTrue(wordsAvg.isEmpty());
    }
}
