package pl.coderslab.konserwatywnyliberal;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Most_Popular_Words {

	public static void main(String[] args) throws IOException {
		
		long time = System.currentTimeMillis();
		
		 Map<String, Word> countMap = new HashMap<String, Word>();

	        
	        System.out.println("Downloading page...");
	        Document doc = Jsoup.connect("https://www.wykop.pl").get();

	       
	        String text = ((org.jsoup.nodes.Document) doc).body().text();

	        System.out.println("Analyzing text...");
	        
	        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8))));
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] words = line.split("[^A-ZÃƒâ€¦Ãƒâ€žÃƒâ€“a-zÃƒÂ¥ÃƒÂ¤ÃƒÂ¶]+");
	            for (String word : words) {
	                if ("".equals(word)) {
	                    continue;
	                }

	                Word wordObj = countMap.get(word);
	                if (wordObj == null) {
	                    wordObj = new Word();
	                    wordObj.word = word;
	                    wordObj.count = 0;
	                    countMap.put(word, wordObj);
	                }

	                wordObj.count++;
	            }
	        }

	        reader.close();

	        SortedSet<Word> sortedWords = new TreeSet<Word>(countMap.values());
	        int i = 0;
	        int maxWordsToDisplay = 20;

	        String[] wordsToIgnore = {"the", "and", "a", "i", "z", "o"};

	        for (Word word : sortedWords) {
	            if (i >= maxWordsToDisplay) { 
	                break;
	            }

	            if (Arrays.asList(wordsToIgnore).contains(word.word)) {
	                i++;
	                maxWordsToDisplay++;
	            } else {
	                System.out.println(word.count + "\t" + word.word);
	                i++;
	            }

	        }

	        time = System.currentTimeMillis() - time;

	        System.out.println("Finished in " + time + " ms");
	    }

	    public static class Word implements Comparable<Word> {
	        String word;
	        int count;

	        @Override
	        public int hashCode() { return word.hashCode(); }

	        @Override
	        public boolean equals(Object obj) { return word.equals(((Word)obj).word); }

	        @Override
	        public int compareTo(Word b) { return b.count - count; }
	    }
	

	

}
