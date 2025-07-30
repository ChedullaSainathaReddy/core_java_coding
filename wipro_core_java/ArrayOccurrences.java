package com.wiprojava;

import java.util.HashMap;
import java.util.Map;

public class ArrayOccurrences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 1, 3, 2, 4, 1, 5, 3, 2 };
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int num : arr) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		System.out.println("Occurrences of each element:");
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			System.out.println(entry.getKey() + " occurred " + entry.getValue() + " times");
		}
	}

}
//OUTPUT:Occurrences of each element:
//1 occurred 3 times
//2 occurred 3 times
//3 occurred 2 times
//4 occurred 1 times
//5 occurred 1 times

