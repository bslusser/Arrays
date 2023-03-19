/*
 * @author Brandon Slusser
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class GenMethods {
	
	public String getIdentificationString() {
		return "Program 4, Brandon Slusser";
	}
	
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			//Makes the list nonduplicate
			if(!newList.contains(list.get(i))) {
				newList.add(list.get(i));
			}
		}
		//Returns the new ArrayList
		return newList;
	}
	
	public static <E> void shuffle(ArrayList<E> list) {
		Random rand = new Random(340L);		
		int index1;
		int index2;
		//Does 30 swaps
		for(int i = 0; i<30; i++) {
			index1 = rand.nextInt(list.size());
			index2 = rand.nextInt(list.size());
			Collections.swap(list, index1, index2);
		}
		
	}
	
	
	public static <E extends Comparable<E>> E max(ArrayList<E> list) {
		E max = list.get(0);
		for(int i = 1; i<list.size(); i++) {
			if(list.get(i).compareTo(max)>0) {
				max = list.get(i);
			}
			
		}
		//Returns the largest element in the ArrayList
		return max;
	}
	
	
	public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
		//Does linear search
		for(int i = 0; i <list.length; i++) {
			if(key.compareTo(list[i])==0) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	public static <E extends Comparable<E>> E max(E[] list) {
		E max = list[0];
		for(int i = 1; i<list.length; i++) {
			if (list[i].compareTo(max)>0) {
				max = list[i];
			}
		}
		//Returns the maximum element in the array
		return max;
	}
	
	
	public static <E extends Comparable<E>> E max(E[][] list) {
		E max = list[0][0];
		for(int i = 0; i<list.length;i++) {
			for(int j = 0; j<list[i].length; j++) {
				if(list[i][j].compareTo(max)>0) {
					max = list[i][j];
				}
			}
		}
		//Returns the maximum element in the 2D Array
		return max;
	}
	
	
	public static void main(String[] args) {
		GenMethods studentMain = new GenMethods();
		String studentResult = studentMain.getIdentificationString();
		
        int n;
        Scanner scnr = new Scanner(System.in);
        //Reads in a number n
        n = scnr.nextInt();

        Integer[] list = new Integer[n];
        LinkedList<Integer> linked = new LinkedList<>();

       for (int i = 0; i<n; i++){
            list[i] = scnr.nextInt();
            linked.add(list[i]);
        }
       
        //Prints list
        System.out.println(Arrays.toString(list));
        //Prints linked
        System.out.println(linked);

        //Reads in k values
        int k = scnr.nextInt();
        //Searches for k
        int result = linearSearch(list, k);
        //Prints where k was found
        if(result != -1) {
        	System.out.println("Key " + k + " was found at position " + result);
        }
        	else {
        		System.out.println("Key " + k + " was not found");
        	}
        
        
        //Calls maximum value in the list
        result = max(list);
        //Prints the max element
        System.out.println(result + " is the max element");

        //Reads in integer m for the first dimension of the 2D Array
        int m = scnr.nextInt();
        //Reads in integer p for the second dimension of the 2D Array
        int p = scnr.nextInt();
        //Uses m and p to initialize a 2D array
        Integer[][] list2 = new Integer[m][p];
        for (int i = 0; i<m; i++)
            for(int j =0; j<p; j++)
                list2[i][j] = scnr.nextInt();

        for(int i = 0; i<list2.length; i++) {
        	for(int j = 0; j<list2[i].length; j++) {
        		System.out.println(list2[i][j] +" ");
        		System.out.println();
        	}
        }

        result = max(list2);
        //Prints max value of list2
        System.out.println(result + " is the max element");
        
        //Instantiates an ArrayList of type Integer from 'linked'
        ArrayList<Integer> alist = new ArrayList<Integer>(linked);
        //Prints alist
        System.out.println(alist);
        
        //Removes the duplicates from alist
        alist = removeDuplicates(alist);
        //Prints alist without duplicates
        System.out.println(removeDuplicates(alist));
        
        //Calls the shuffle method
        shuffle(alist);
        System.out.println(alist);
        
        //Finds the max element of alist and prints it
        System.out.println(max(alist) + " is the max element");
        
        
    }
}