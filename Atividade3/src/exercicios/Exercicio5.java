package exercicios;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Exercicio5 {
	
	public static void main(String[] args) throws IOException {

		StringBuilder frase = new StringBuilder(JOptionPane.showInputDialog("Digite a frase que quer Codificar."));
		codificar(frase);
		decodificar(frase);
	}

	
	public static void codificar(StringBuilder frase) throws IOException {
		
		for(int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);
			int ic = c;
			frase.setCharAt(i, (char) (ic+1)); 
		}
		
		try(
				FileWriter fw = new FileWriter("mensagemCodificada.txt");
				PrintWriter out = new PrintWriter(fw);
				){
			out.print(frase);
		}
		
	}
	
	public static void decodificar(StringBuilder frase) throws IOException {
		
		for(int i = 0; i < frase.length(); i++) {
			char c = frase.charAt(i);
			int ic = c;
			frase.setCharAt(i, (char) (ic-1)); 
		}
		
		try(
				FileWriter fw = new FileWriter("mesagemDecodificada.txt");
				PrintWriter out = new PrintWriter(fw);
				){
			out.print(frase);
		}
		
	}
}
