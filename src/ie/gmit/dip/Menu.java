package ie.gmit.dip;

import java.util.*;

import jdk.jfr.Frequency;

import java.io.*;

/**
 * @author Ronan Kenny
 * @version Java SE 15
 * Menu class used as UI between command line and user input to paser in 
 * text files via FileManager class
 *
 */
public class Menu  {
	FileManager fm = new FileManager();
	private Scanner user;
	private boolean keepRunning = true;

	public Menu() throws FileNotFoundException {
		user = new Scanner(System.in);
	}

	/**
	 * @throws IOException if other then options 1 - 4 are selected 
	 * Show options method to give user a selection of options 
	 */
	public void start() throws IOException {

		while (keepRunning) {
			showOptions();
			int choice = Integer.parseInt(user.next());
			if (choice == 1) {
				selectQuery();
			} else if (choice == 2) {// Select Query File
				selectSubject();
			} else if (choice == 3) {// Select Query File
				Frequency(null);
			} else if (choice == 4) {// Select Subject File
				System.out.println("Shutting down");
				keepRunning = false;
			} else {
				System.out.println("ERROR Invalid input.");
			}
		}
	}

	/**
	 * Allows user to select a text file 
	 * @throws FileNotFoundException if no file found 
	 */
	private void selectQuery() throws FileNotFoundException {
		System.out.println("[INFO] Select Query file  >");
		Scanner user = new Scanner(System.in);
		String inputFileName;
		inputFileName = user.nextLine().trim();
		File input = new File(inputFileName);
		user = new Scanner(input);
	}

	/**
	 * Allows user to select a text file 
	 * @throws FileNotFoundException if no file found 
	 */
	private void selectSubject() throws FileNotFoundException {
		System.out.println("[INFO] Select Subject file  ");
		Scanner user = new Scanner(System.in);
		String inputFileName;
		inputFileName = user.nextLine().trim();
		File input = new File(inputFileName);
		user = new Scanner(input);
	}

	/**
	 * get Frequency of terms between Query file and Subject file 
	 * @param file
	 * @return unique terms and their frequency
	 */
	public static Map<String, Integer> Frequency(String[] file) {
		Map<String, Integer> Frequency = new HashMap<>();
		for (String term : file) {
			Integer n = Frequency.get(term);
			n = (n == null) ? 1 : ++n;
			Frequency.put(term, n);
		}
		return Frequency;
	}

	private void showOptions() {
		System.out.println("----------------------------------");
		System.out.println("-- Doucment Comparison App v1.0 --");
		System.out.println("----------------------------------");
		System.out.println("(1) Select Query File: ");
		System.out.println("(2) Select Subject File: ");
		System.out.println("(3) Get Similarity: ");
		System.out.println("(4) Quit");
		System.out.println("----------------------------------");
		System.out.println("Similarity:" );
		System.out.println("----------------------------------");
		System.out.println("Select an Option [1-4]");
	}

}
