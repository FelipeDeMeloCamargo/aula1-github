package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalEntity4;
import entities.PhysicalPerson4;
import entities.TaxPayer4;

public class Program4 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer4> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.print("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Annual income: ");
			double annualIncome = sc.nextDouble();

			if (ch == 'i') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				list.add(new PhysicalPerson4(name, annualIncome, health)); // adicionados os dados na lista
			} else {
				System.out.print("Number of Employees: ");
				int employees = sc.nextInt();
				list.add(new LegalEntity4(name, annualIncome, employees));
			}
		}
		System.out.println("Taxes Payd: ");
		for (TaxPayer4 tax : list) {
			System.out.println(tax.toString());
		}
		double sum = 0.0;
		for (TaxPayer4 tax : list) {
			sum += tax.taxPaid();
		}
		System.out.println();
		System.out.println("Total Taxes: $ " + sum);
		sc.close();
	}

}
