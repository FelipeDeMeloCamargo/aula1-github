package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;  //Ligando o programa as classes
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department`s name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter Worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.println("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Base Salary: ");
		Double baseSalary = sc.nextDouble();
		
		//instanciar a classe
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.println("How many contracts to this worker: ");
		int n = sc.nextInt();
		//for para ler os contratos
		for(int i=1;i<=n;i++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); //sc.next receberá o que o usuario digitar
			System.out.print("Valur per hour: ");
			Double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt(); 
			//instanciar o contrato
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			//Associar esse contrato com o trabalhador
			worker.addContract(contract); 
			//esse for será realizado N vezes até instanciar todos os contratos e associa-los ao trabalhador
		}
		System.out.println();
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); //recorta o mes da informacao recebida e o transforma em String
		int year = Integer.parseInt(monthAndYear.substring(3)); //recorda da barra em diante
		System.out.println("Name: " + worker.getName());
		System.out.println("Departmend " + worker.getDepartment().getName());//acessa a classe department pelo nome e o exibe. Acessa o worker, acessa o objeto department e depois associa o nome 
		System.out.println("Income for: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month))); //Acessa a classe worker e retorna o income pela data informada
		
		
		
		sc.close();

	}

}
