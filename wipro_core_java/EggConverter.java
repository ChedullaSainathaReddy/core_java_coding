package com.wiprojava;

public class EggConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length == 0) {
            System.out.println("Please provide the number of eggs as a command line argument.");
            return;
        }

        int eggs = Integer.parseInt(args[0]);

        int gross = eggs / 144;
        eggs %= 144;

        int dozen = eggs / 12;
        int leftover = eggs % 12;

        System.out.printf("Your number of eggs is %d gross, %d dozen, and %d%n", gross, dozen, leftover);
    }

	}


