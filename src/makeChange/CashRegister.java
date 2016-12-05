package makeChange;

import java.util.Scanner;

public class CashRegister {
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
		double[] denom = { 100, 50, 20, 10, 5, 1, .25, .1, .05, .009 };
		String[] billName = { "Hundreds", "Fifties\t", "Twenties", "Tens\t", "Fives\t", "Singles\t", "Quarters",
				"Dimes\t", "Nickels\t", "Pennies\t" };

		System.out.println("\n\n\n\tChange: ");
		System.out.println("-------------------------");

		for (int i = 0; i < denom.length; i++) {
			if (change >= denom[i]) {
				System.out.print(billName[i]);
				change = howMany(change, denom[i]);
			}
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
