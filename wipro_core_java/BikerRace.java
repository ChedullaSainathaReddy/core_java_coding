package com.wiprojava;

import java.util.Scanner;

public class BikerRace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] speed = new int[5];
		int total = 0;

		for (int i = 0; i < 5; i++) {
			System.out.print("Enter speed of racer " + (i + 1) + ": ");
			speed[i] = sc.nextInt();
			total += speed[i];
		}

		double avg = total / 5.0;
		System.out.println("Qualified Racers (speed > avg " + avg + "):");
		for (int s : speed) {
			if (s > avg)
				System.out.println(s);
		}
	}

}
//OUTPUT:Enter speed of racer 1: 4
//Enter speed of racer 2: 3
//Enter speed of racer 3: 7
//Enter speed of racer 4: 6
//Enter speed of racer 5: 4
//Qualified Racers (speed > avg 4.8):
//7
//6
