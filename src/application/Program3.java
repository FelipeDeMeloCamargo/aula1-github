package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program3 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub

		System.out.println("Enter the number of employee: ");
		
		int n = sc.nextInt();
		List<Employee> list = new ArrayList<>(); //criando uma lista
		
		for(int i=0;i<n;i++) {//for para realizar a inserção dos funcionarios
			System.out.println("Employee " + (i+1) + " data: ");
			System.out.print("Outsourced (y/n)? ");
			char ch = sc.next().charAt(0); //lê o caractere
			System.out.print("Name: ");
			sc.nextLine(); //consumir o espaco em branco 
			String name = sc.nextLine();
			System.out.print("Hours: ");
			int hours  = sc.nextInt();
			System.out.print("Valour per Hour: ");
			double valuePerHour = sc.nextDouble();
			
			
			//tomada de decisoes
			
			if(ch == 'y') {
				System.out.print("Additional charge: ");
				double additionalCharge = sc.nextDouble();
				//declaracao de variavel usando a classe Employee
				//upcasting
				Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);//instanciado o funcionario tercerizado
				list.add(emp); //adicionado a lista cria para classe Employee
				//A instanciação pode dar lugar ao EMP dentro da lista ficando assim 
				//list.add(new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
			}
			else {
				Employee emp = new Employee(name, hours, valuePerHour); //Instanciado a variavel emp para classe Employee usando o construtor sem o additionalCharge
				list.add(emp);
			}
		
		}
		
		System.out.println();
		System.out.println("Payments: ");
		//Precisamos imprimir a lista contendo o nome e o psgamento de cada um
		//como fazer? basta percorrer a lista, solicitando imprimir o nome e o salario
		for(Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));//percorrerá a lista e trará o nome e o salario final
		}
		
		
		sc.close();
	}

}
