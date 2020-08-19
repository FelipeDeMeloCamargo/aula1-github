package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account5;
import model.exceptions.DomainException;

public class Program5 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try { // tentar tratar as excessoes
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();

			Account5 acc = new Account5(number, holder, initialBalance, withdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double withdraw = sc.nextDouble();
			acc.withdraw(withdraw); // chamada do metodo
			System.out.print("New balance: " + acc);
			
			

			sc.close();
		} 
		catch (DomainException e) {
			System.out.println("Withdraw error :" + e.getMessage());
		}
		
	}

}
