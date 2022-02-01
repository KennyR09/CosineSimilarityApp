package ie.gmit.dip;

import java.util.*;
/**
 * @author Ronan Kenny
 * @version Java SE 15
 * 
 *
 */
public class Cosine{
	Map<String, Integer> subject = new HashMap<String, Integer>();
	Map<String, Integer> query = new HashMap<String, Integer>();
	/**
	 * get Frequency of terms between Query file and Subject file 
	 * @param terms in terms in each file 
	 * @return unique terms and their frequency
	 */
    public static Map<String, Integer> Frequency(String[] terms) {
        Map<String, Integer> Frequency = new HashMap<>();
        for (String term : terms) {
            Integer n = Frequency.get(term);
            n = (n == null) ? 1 : ++n;
            Frequency.put(term, n);
        }
        return Frequency;
    }
    
    public static double cosineSimilarity(String word, String words) {
        //Get vectors
    	/**
    	 * 
    	 * 
    	 */
        Map<String, Integer> s = Frequency(word.split(""));
        Map<String, Integer> q = Frequency(words.split(""));

        //Get unique words from both sequences
        HashSet<String> intersection = new HashSet<>(s.keySet());
        intersection.retainAll(q.keySet());

        double dotProduct = 0, subject = 0, query = 0;

        //Calculate dot product
        for (String item : intersection) {
            dotProduct += s.get(item) * q.get(item);
        }

        //Calculate magnitude of subject
        for (String k : s.keySet()) {
            subject += Math.pow(s.get(k), 2);
        }

        //Calculate magnitude of query
        for (String k : q.keySet()) {
            query += Math.pow(q.get(k), 2);
        }

        //return cosine similarity
        return dotProduct / Math.sqrt(subject * query);
    }
	
	

}
