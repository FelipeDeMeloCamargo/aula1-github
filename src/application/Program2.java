package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program2 {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birth = sdf.parse(sc.next());
		
		
		Client client = new Client(name, email, birth); //instanciado classe client
		
		System.out.println();
		System.out.print("Enter order data");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next()); //realiza a leitura de acordo com o orderStatus enum que o é recebido pelo usuario
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), status, client); //Instanciar o order associado ao client
		
		for(int i=1 ;i<=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product Name: ");
			String productName = sc.next();
			System.out.print("Product price");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			//Instanciando as classes
			Product product = new Product(productName, productPrice); //instanciando classe produto
			
			OrderItem it = new OrderItem(quantity, productPrice, product); //product foi instanciado acima
			
			order.addItem(it);
			
		}
		
			System.out.println("Order Summary: ");
			System.out.println(order);
			
		sc.close();

	}

}
