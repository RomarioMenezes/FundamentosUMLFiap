package exercicios;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;

public class Exercicio2 {

	public static void main(String[] args) {

		LocalDateTime data = LocalDateTime.of(2012, 9, 10, 12, 00);
		System.out.println("a. "+data.format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")));
		System.out.println("b. "+data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")));
		System.out.println("c. "+data.getDayOfWeek()+" (dia da semana)");
		System.out.println("d. "+data.getYear()+" (ano)");
	
		
	}
}
