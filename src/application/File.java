package application;

import java.util.Scanner;

public class File {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		//Para retornar quais pastas estao em um caminho expecificado
		System.out.println("Enter a folder path: ");
		String strPath = sc.nextLine();
		
		java.io.File path = new java.io.File(strPath); //instanciando o objeto
		
		java.io.File[] folders = path.listFiles(java.io.File::isDirectory); // cria um vetor do tipo file. Listar somente o que é diretorio ou pasta
		
		System.out.println("Folders: ");
		for (java.io.File folder : folders) {
			System.out.println(folder); //faz um for para imprimir cada caminho das pastas
		}
		
		//Para retornar quais arquivos
		
		java.io.File[] files = path.listFiles(java.io.File :: isFile);
		
		System.out.println();
		System.out.println("Files: ");
		for(java.io.File file : files) {
			System.out.println(file);
		}
		
		//para criar uma sub pasta
		
		boolean success = new java.io.File(strPath + "\\subdir").mkdir(); //irá criar uma sub pasta chamado subdir a partir da pasta que eu declarar
		//Irá retornar um boolean (F/V) se der certo criar a pasta ou não
		System.out.println("Directory created successfully " + success);
		sc.close();
	}

}
