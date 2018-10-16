/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Sept 2018
 * Created for: ICS4U
 * This program generates a list of 250 random values and sorts them. It then
 * 		allows the user to input a number and searches for that number in the
 * 		list
 *
 ****************************************************************************/

//error is still not fixed

import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) { 
		Scanner userInput = new Scanner(System.in);
		Random randGen = new Random();
		int[] values = new int[250]; 
		
		System.out.print("Generated values:\n");
		
		int randNum;
		
		for(int counter = 0; counter < values.length; counter++) {
			randNum = randGen.nextInt(500) + 1;
			values[counter] = randNum;
			System.out.println(randNum);
			
		}
		
		System.out.println("\nSorted values: ");
		NumSort(values);
		
		//int newArrLen = values.length;
		//int addInd = 0;
		
		do {
			System.out.println("\nEnter a number from 1 to 500 to search in values (-1 to exit): ");
			int userNum = userInput.nextInt();
			
			if(userNum < -1 || userNum > 500) {
				System.out.print("\nInvalid.");
				System.exit(0);
			}
			else if(userNum == -1) {
				System.out.print("\nGoodbye.");
				System.exit(0);
			} 
			else {
				String search = NumSearch(values, userNum);
				System.out.print("\n" + search);
				
				//if(search == "Not found.") {
					//System.out.print(" Add number to values? (1 for yes, 2 for no) ");
					//userInput.nextLine();
					//int userAdd = userInput.nextInt();
					
					//if(userAdd == 1) {
					//	addInd ++;
					//	newArrLen += addInd;
					//	int[] newValues = new int[newArrLen];
					//	
					//	for(int counter = 0; counter < values.length - 1; counter++) {
					//		newValues[counter] = values[counter];
					//		System.out.println("\n" + newValues[counter] + " - " + values[counter]);
					//	}
					//	newValues[newArrLen] = userNum;
					//	
					//	System.out.println("\nAdded. New Sorted values: ");
					//	NumSort(newValues);
					//}
					//else if(userAdd == 2) {
					//	System.out.print("Ok.\n");
					//}
					//else {
					//	System.out.print("Invalid.\n");
					//	System.exit(0);
					//}
				//}
			}
		} while(true);
	}
	
	public static void NumSort(int array[]) {
		// sorts elements in array in numerical order 
		int arrLen = array.length;
		
		for(int nextNum = 0; nextNum < arrLen; nextNum ++) {
			for(int prevNum = 0; prevNum < arrLen; prevNum++) {
				if(array[nextNum] < array[prevNum]) {
					int sub = array[nextNum];
					array[nextNum] = array[prevNum];
					array[prevNum] = sub;
				}
			}
		}
		for(int counter = 0; counter < arrLen; counter++) {
			System.out.println(array[counter]);
		}
	} 
	
	public static String NumSearch(int array[], int srchNum) {
		// searches for user number in array and returns whether or not number is found
		
		int lowInd = 0;
		int highInd = array.length - 1;
		int midInd;
		
		while(lowInd <= highInd) {
			midInd = (lowInd + highInd)/2;
			
			if(srchNum == array[midInd]) {
				return "Found at " + (midInd+1) + "\n";
			} 
			else if(srchNum > array[midInd]) {
				lowInd = midInd + 1;
			} 
			else if(srchNum < array[midInd]) {
				highInd = midInd - 1;
			}
			else if(lowInd > highInd) {
				return "Not found.";
			}
			else {
				// if you are here you are in trouble!
			}
		}
		return "Not found.";
	}	
}
