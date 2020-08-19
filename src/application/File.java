package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\mlwkt500\\Documents\\in.txt"; //local do arquivo
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){ //declaracao da variavel br
			String line = br.readLine();//serve para ler 1 linha do arquivo
			 
			while (line != null) { //while para verificar se a linha que eu solicitei para ler, não é a ultima
				System.out.println(line);
				line = br.readLine(); // e então lerá novamente o que estiver no arquivo
			}
		}
		catch (IOException e ) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}

}
