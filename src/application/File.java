package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {

	public static void main(String[] args) {
		
		String [] lines = new String[] {"Good Morning","Good afternoon","Google night"};
		
		String path = "C:\\Users\\mlwkt500\\Documents\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ //colocando o true apos a variavel, ele complementa o arquivo ao inves de recria-lo
			for (String line : lines) {
				bw.write(line); //Insere uma linha
				bw.newLine(); //d� uma quebra de linha
			}
		}
		catch (IOException e) {
			e.printStackTrace();// ir� imprimir o erro
		}
	}

}
