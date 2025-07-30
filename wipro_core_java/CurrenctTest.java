package com.wiprojava;

enum Currency {
	ONE, TWO, FIVE, TEN, TWENTY, FIFTY
}

public class CurrenctTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (Currency c : Currency.values()) {
			System.out.println("Currency: " + c);
			switch (c) {
			case ONE -> System.out.println("One rupee coin.");
			case TWO -> System.out.println("Two rupee coin.");
			case FIVE -> System.out.println("Five rupee coin.");
			case TEN -> System.out.println("Ten rupee note.");
			case TWENTY -> System.out.println("Twenty rupee note.");
			case FIFTY -> System.out.println("Fifty rupee note.");
			}
		}

	}

}
//OUTPUT:Currency: ONE
//One rupee coin.
//Currency: TWO
//Two rupee coin.
//Currency: FIVE
//Five rupee coin.
//Currency: TEN
//Ten rupee note.
//Currency: TWENTY
//Twenty rupee note.
//Currency: FIFTY
//Fifty rupee note.