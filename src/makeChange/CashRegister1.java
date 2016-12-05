package makeChange;

import java.util.Scanner;

public class CashRegister1 {
	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		double price, payment, change;

		price = itemPrice("\nEnter the price of the item: ");

		payment = moneyTendered("\nEnter amount paid: ");

		change = enoughPaid(payment, price);

		changeReturned(change);

		kb.close();

	}

	public static double itemPrice(String prompt) {
		System.out.println(prompt);
		System.out.print("> ");
		double price = kb.nextDouble();
		while (!(price >= 0)) {
			System.err.println("\n\nError! Please enter a positive value (or 0 if free item): ");
			System.out.print("> ");
			price = kb.nextDouble();
		}
		return price;
	}

	public static double moneyTendered(String prompt) {
		System.out.println(prompt);
		System.out.print("> ");
		double money = kb.nextDouble();
		if (!(money >= 0)) {
			System.err.println("\n\n\n\nPanic button pressed, Police enroute!\n\n\n\n");
		}
		return money;
	}

	public static double enoughPaid(double payment, double price) {
		while (payment < price) {
			System.err.println("\n\nError! Amount paid too low!");
			System.err.println("Please enter payment again(MUST BE AT LEAST ITEM PRICE): ");
			System.out.print("> ");
			payment = kb.nextDouble();
			if (!(payment >= 0)) {
				System.err.println("\n\n\n\nPanic button pressed, Police enroute!\n\n\n\n");
				break;
			}
		}
		if (payment == price) {
			System.out.println("\n\nExact amount paid!");
			System.out.println("Thank You, Have A Nice Day!\n\n");
			return 0;
		} else {
			double change = payment - price;
			return change;
		}

	}

	public static void changeReturned(double change) {
		int hundreds = 100;
		int fifties = 50;
		int twenties = 20;
		int tens = 10;
		int fives = 5;
		int singles = 1;
		double quarters = .25;
		double dimes = .10;
		double nickels = .05;
		double pennies = .009;

		System.out.println("\n\n\n\tChange: ");
		System.out.println("-------------------------");
		if (change >= hundreds) { 

			System.out.print("Hundreds: ");
			change = howMany(change, hundreds);
		}
		if (change >= fifties) {
			System.out.print("Fifties: ");
			change = howMany(change, fifties);
		}
		if (change >= twenties) {
			System.out.print("Twenties: ");
			change = howMany(change, twenties);
		}
		if (change >= tens) {
			System.out.print("Tens: \t");
			change = howMany(change, tens);
		}
		if (change >= fives) {
			System.out.print("Fives: \t");
			change = howMany(change, fives);
		}
		if (change >= singles) {
			System.out.print("Singles: ");
			change = howMany(change, singles);
		}
		if (change >= quarters) {
			System.out.print("Quarters: ");
			change = howMany(change, quarters);
		}
		if (change >= dimes) {
			System.out.print("Dimes: \t");
			change = howMany(change, dimes);
		}
		if (change >= nickels) {
			System.out.print("Nickels: ");
			change = howMany(change, nickels);
		}
		if (change >= pennies) {
			System.out.print("Pennies: ");
			change = howMany(change, pennies);
		}
		System.out.println("\n\n");

	}

	public static double howMany(double change, double units) {
		double money = units;
		units = (int) (change / units);
		change %= money;
		System.out.println("\t\t" + (int) units);
		return change;
	}
}
