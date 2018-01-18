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

	private static Map<Integer, Integer> EVM_DATA = new HashMap<Integer, Integer>();
	private static Map<Integer, Integer> CANDIDATE_DATA = new HashMap<Integer, Integer>();
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
			EVM_DATA.put(voterId, candidateId);
			if (CANDIDATE_DATA.get(candidateId) == null) {
				CANDIDATE_DATA.put(candidateId, 1);
			} else {
				Integer couter = CANDIDATE_DATA.get(candidateId);
				CANDIDATE_DATA.put(candidateId, ++couter);
			}
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
					"\nEnter 1 to find Candidate id for a given voter id \nEnter 2 to find the number of votes received by a candidate \nEnter 3 to find the vote count for all the candidates");
			choice = scanner.nextLine();
			if (choice.equals("1")) {
				
					System.out.println("Please enter a valid voter id::");
					id = scanner.nextInt();
					if (EVM_DATA.get(id) != null) {
						System.out.println("Candidate Id for voter id " + id + " ::" + EVM_DATA.get(id));
					} else {
						System.out.println("Given voter id is not present");
					}
				}
				
			if (choice.equalsIgnoreCase("2")) {
					System.out.println("Please enter a valid candidate id::");
					id=scanner.nextInt();
					if (CANDIDATE_DATA.get(id) !=null) {
					System.out.println("Candidate with id " + id + " received " + CANDIDATE_DATA.get(id) + " votes ");
					}
					else System.out.println("Candidate with id " + id + " received 0 votes");
			}
			
			if (choice.equalsIgnoreCase("3")) {
				Set<Integer> keyset = CANDIDATE_DATA.keySet();
				for (int key : keyset) {
					System.out.println("For candidate id " + key + " count is ::" + CANDIDATE_DATA.get(key));
				}

			}
		}

	}

}
