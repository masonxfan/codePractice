package questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//choose smarter guessing word

public class arr843GuesstheWord {
	 public void findSecretWord(String[] wordlist, Master master) {
	        List<String> words = Arrays.asList(wordlist);
	    
	        for (int i = 0; i < 10; i++) {
	            words = guessAndFilterWords(words, master);
	        }
	    }
	    
	    private List<String> guessAndFilterWords(List<String> words, Master master) {
	        String guess = bestGuess(words);
	        int right = master.guess(guess);
	        System.out.println(guess + ":" + right);
	        
	        return words.stream()
	            .filter(word -> {
	                int match = 0;
	                for (int i = 0; i < word.length(); i++) {
	                    if (word.charAt(i) == guess.charAt(i)) match++;
	                }
	                return match == right;
	            })
	            .collect(Collectors.toList());
	    }
	    
	    private String bestGuess(List<String> words) {
	        List<Map<Character, Integer>> allLetterFreqs = new ArrayList<>(6);
	        for (int letter = 0; letter < 6; letter++) {
	            allLetterFreqs.add(getLetterFreqs(words, letter));
	        }
	        
	        String bestGuessWord = "";
	        int bestGuessScore = 0;
	        for (String word : words) {
	            int score = score(allLetterFreqs, word);
	            if (score > bestGuessScore) {
	                bestGuessWord = word;
	                bestGuessScore = score;
	            }
	        }
	        return bestGuessWord;
	    }
	    
	    private int score(List<Map<Character, Integer>> allLetterFreqs, String word) {
	        int score = 0;
	        for (int i = 0; i < 6; i++) {
	            char letter = word.charAt(i);
	            int matches = allLetterFreqs.get(i).get(letter);
	            score += matches;
	        }
	        return score;
	    }
	    
	    private Map<Character, Integer> getLetterFreqs(List<String> words, int index) {
	        Map<Character, Integer> characterFreq = new HashMap<>();
	        
	        for (String word : words) {
	            characterFreq.merge(word.charAt(index), 1, Integer::sum);
	        }
	        
	        return characterFreq;
	    }
}
