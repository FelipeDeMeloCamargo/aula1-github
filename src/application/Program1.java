package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct1;
import entities.Product1;
import entities.UsedProduct1;

public class Program1 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product1> list = new ArrayList<>(); // instanciar a lista
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data: ");
			System.out.print("Common, used of imported? (c/u/i): ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();

			if (ch == 'i') {
				System.out.println("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product1 prod = new ImportedProduct1(name, price, customsFee); // apos entrar no if, o mesmo salvará tudo que está no for + o if
				list.add(prod); 
				//Adicionamos conteudo do produto importado na lista
			}
			else if(ch == 'u') {
				System.out.println("Manufacture Date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				Product1 prod = new UsedProduct1(name, price, manufactureDate);
				list.add(prod);
			}
			else {
			Product1 prod = new Product1(name, price);
			list.add(prod);
			}
		}
		
			
		System.out.println();
		System.out.println("Price Tags: ");
		//percorrer uma lista para imprimir
		for(Product1 prod : list) {
			System.out.println(prod.priceTag()); //imprime todos os priceTag formatado de acordo com cada classe

		}
		sc.close();

	}

}
