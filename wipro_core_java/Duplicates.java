package com.wiprojava;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] input = {2, 3, 54, 1, 6, 7, 7};
	        Set<Integer> unique = new HashSet<>();
	        int sum = 0;

	        for (int num : input) {
	            if (unique.add(num) && num % 2 == 0) {
	                sum += num;
	            }
	        }
	        System.out.println("Sum of unique even numbers: " + sum);
	    }

	}

//OUTPUT:Sum of unique even numbers: 62
