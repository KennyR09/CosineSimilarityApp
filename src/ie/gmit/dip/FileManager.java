package ie.gmit.dip;

import java.io.*;
import java.util.*;
/**
 * @author Ronan Kenny
 * @version Java SE 15
 * 
 *
 */
public class FileManager {
	private static Map<Integer, Integer> QueryMap = new HashMap<>();
	private static Map<Integer, Integer> SubjectMap = new HashMap<>();
	private static final String file = "./file.txt";

/**
 *Allows user to pass in a file 
 * @param file
 * @return
 * @throws IOException
 */
	public Map<Integer, Integer> getMap(String file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = null;

		while ((line = br.readLine()) != null) {
			String[] words = line.split(file);
			for (String word : words) {
				int hash = word.hashCode();
				int frequency = 1;
				if (SubjectMap.containsKey(hash)) {
					frequency += SubjectMap.get(hash);
				}
				SubjectMap.put(hash, frequency);
			}
		}
		br.close();
		return SubjectMap;
	}
}
