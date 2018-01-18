package com.upgrad.assignment;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class EvmUtil {

	private static int[] EVM_DATA = new int[900000];
	private static int[] CANDIDATE_DATA = new int[900];
	private static final String EVM_DELIMETER = "\t";

	private void loadEvmData() throws IOException {
		String line = null;
		StringTokenizer tokennizer = null;
		BufferedReader bufferedReader = new BufferedReader(new FileReader(
				"/Users/Admin/eclipse-workspace/Assignment/src/data.txt"));
		while ((line = bufferedReader.readLine()) != null) {
			tokennizer = new StringTokenizer(line, EVM_DELIMETER);
			int voterId = Integer.parseInt(tokennizer.nextToken());
			int candidateId = Integer.parseInt(tokennizer.nextToken());
			EVM_DATA[voterId-100000]=candidateId;
			CANDIDATE_DATA[candidateId-100]++;
		}
	}

	public static void main(String[] args) throws IOException {
		EvmUtil evnutil = new EvmUtil();
		System.out.println("************************** LOADING EVM DATA ********************");
		evnutil.loadEvmData();
		System.out.println("************************** EVM DATA LOADED ********************");
		String choice = null;
		int id=0;
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println(
					"\nEnter 1 to find Candidate id for a given voter id \nEnter 2 to find the number of votes received by a candidate ");
			choice = scanner.nextLine();
			if (choice.equalsIgnoreCase("1")) {
				
					System.out.println("Please enter a valid voter id::");
					id = scanner.nextInt();
					if (EVM_DATA[id-100000] != 0) {
						System.out.println("Candidate Id for voter id " + id + " ::" + EVM_DATA[id-100000]);
					} else {
						System.out.println("Given voter id is not present");
					}
				
			}
			if (choice.equalsIgnoreCase("2")) {
				System.out.println("Please enter a valid candidate id::");
				id=scanner.nextInt();
				int count=CANDIDATE_DATA[id-100];
				System.out.println("Candidate with id " + id + " received " + count + " votes ");
			}
			

			}
		}

}



