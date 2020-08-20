package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product6;

public class Program6 {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product6> list = new ArrayList<>();// declaracao da lista

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine(); //entrar com os dados da pasta

		File sourceFile = new File(sourceFileStr); // instanciado objeto que receberá como parametro o que foi passado
		String sourceFolderStr = sourceFile.getParent(); //retorna toda url da pasta menos o nome do arquivo
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir(); // cria uma pasta no diretorio informado + \\out com o nome
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv"; //cria um arquivo dentro da pasta informada

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product6(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product6 item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}