package exercicios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import model.Pessoa;

public class Exercicio4 {
	
	public static void main(String[] args) {
		
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("João Garcia", "AIK Enterprise", 20, 'M'));
		pessoas.add(new Pessoa("Maria Martins", "Simples", 44, 'F')	);
		pessoas.add(new Pessoa("Henrique Fernando", "AIK Enterprise", 43, 'M'));
		pessoas.add(new Pessoa("Inácio Luis", "Magazine André", 33, 'M'));

		pessoas.remove(new Random().nextInt(pessoas.size()));  
		
		System.out.println("\nAntes de Sortear\n");
		pessoas.forEach(p -> {
			System.out.println(p.getNome());
		});
		
		Collections.sort(pessoas);

		System.out.println("\nDepois de Sortear\n");
		pessoas.forEach(p -> {
			System.out.println(p.getNome());
		});

		//pessoas.remove(1);
	} 

	
}
