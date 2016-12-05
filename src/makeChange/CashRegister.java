package makeChange;

import java.util.Scanner;

public class CashRegister {
	static Scanner kb = new Scanner(System.in);
	public static void main(String[] args) {
		double price, payment, change;
		
		price = itemPrice("Enter the price of the item: ");
		
		payment = moneyTendered("Enter amount paid: ");
		
		change = enoughPaid(payment, price);
		
		changeReturned(change);
		
	}
	
	public static double itemPrice(String prompt){
		System.out.println(prompt);
		double price = kb.nextDouble();
		while (!(price >= 0)){
			System.err.println("Error! Please enter a positive value (or 0 if free item): ");
			price = kb.nextDouble();
		}
		return price;
	}
	
	public static double moneyTendered(String prompt){
		System.out.println(prompt);
		double money = kb.nextDouble();
		if (!(money >= 0)){
			System.err.println("Panic button pressed, Police enroute!");
		}
		return money;
	}
	
	public static double enoughPaid(double payment, double price){
		while (payment < price){
			System.err.println("Error! Amount paid too low!");
			System.err.println("Please enter payment again(MUST BE AT LEAST ITEM PRICE): ");
			payment = kb.nextDouble();
			if (!(payment >= 0)){
				System.err.println("Panic button pressed, Police enroute!");
			}
		}
		if (payment == price){
			System.out.println("Exact amount paid!");
			System.out.println("Thank You, Have A Nice Day!");
			return 0;
		}
		else {
			double change = payment - price;
			return change;
		}
		
	}
	public static void changeReturned(double change){
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
		
		System.out.println("Change: ");
		if (change > hundreds){					// Finds if any units of current size can be given as change
			System.out.print("Hundreds: ");
			change = howMany(change, hundreds);
		}
		if (change > fifties){	
			System.out.print("Fifties: ");
			change = howMany(change, fifties);
		}
		if (change > twenties){	
			System.out.print("Twenties: ");
			change = howMany(change, twenties);
		}
		if (change > tens){	
			System.out.print("Tens: ");
			change = howMany(change, tens);
		}
		if (change > fives){	
		System.out.print("Fives: ");
		change = howMany(change, fives);
		}
		if (change > singles){	
		System.out.print("Singles: ");
		change = howMany(change, singles);
		}
		if (change > quarters){	
		System.out.print("Quarters: ");
		change = howMany(change, quarters);
		}
		if (change > dimes){	
		System.out.print("Dimes: ");
		change = howMany(change, dimes);
		}
		if (change > nickels){	
		System.out.print("Nickels: ");
		change = howMany(change, nickels);
		}
		if (change > pennies){	
		System.out.print("Pennies: ");
		change = howMany(change, pennies);
		}
		
	}
		public static double howMany(double change, double units){
			double money = units;
				units = (int) (change / units);		// Finds how many units of current size to give and casts to whole number
				change = change - (units * money);	// Finds remaining change
				System.out.println(units);
		return change;
		}
}
