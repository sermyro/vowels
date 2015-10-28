package com.sm;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class WordComparable implements Comparable<WordComparable> {
    private Set<Character> charSet = new TreeSet<Character>();
	private int wordLength;
	private int totalVowel;
	private int count = 1;
	
	WordComparable(int wordLength) {		
		this.wordLength = wordLength;
	}
	public void add(char c, int totalVowel) {
		charSet.add(c);
		this.totalVowel = totalVowel;
	}

	public void addCount() {
		this.count ++;
	}	
	
	public void addTotalVowel(int totalVowel) {
		this.totalVowel += totalVowel;
	}
	
	public void setCharSet(Set<Character> charSet) {
		this.charSet = charSet;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordComparable wordSet = (WordComparable) o;
        return Objects.equals(wordLength, wordSet.wordLength) &&
                Objects.equals(charSet, wordSet.charSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charSet, wordLength);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        Iterator<Character> iterator = charSet.iterator();
        if (! iterator.hasNext())
            sb.append("{}");
        else {
            sb.append("{");
            for (; ; ) {
                sb.append(iterator.next());
                if (!iterator.hasNext()){
                    sb.append('}').toString();
                    break;
                }
                sb.append(',').append(' ');
            }
        }

        DecimalFormat formatter = new DecimalFormat("#.##");
        sb.append(", "+wordLength+") -> "+formatter.format(((double)totalVowel)/count));

        return sb.toString();
    }


    @Override
    public int compareTo(WordComparable ws)
    {
        if(ws.charSet.size() - this.charSet.size() == 0){
            return ws.wordLength -this.wordLength;
        }else return ws.charSet.size() - this.charSet.size();
    }
}
