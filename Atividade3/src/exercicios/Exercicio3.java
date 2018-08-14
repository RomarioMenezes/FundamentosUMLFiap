package exercicios;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;
import java.util.WeakHashMap;

public class Exercicio3 {
	
	
	 public static void main(String[] args) {
		
		 
		   ArrayList<Integer> arrayList = new ArrayList<>();
		   LinkedList<Integer> linkedList = new LinkedList<>();
		   Stack<Integer> stackList = new Stack<>();
		   HashSet<Integer> hashSetList = new HashSet<>();
		   HashMap<Integer, Integer> hashMap = new HashMap<>();
		   WeakHashMap<Integer, Integer> weakHashMap = new WeakHashMap<Integer, Integer>();
		   
		   
		   HashMap<String, Long> insert = new HashMap<>();
		   HashMap<String, Long> consult = new HashMap<>();
		  
		   /**ARRAYLIST*/
			LocalDateTime inicio = LocalDateTime.now();
			int tamanho = 10000;
			for (int i = 0; i < tamanho; i++) {
				arrayList.add(i);
			}

			LocalDateTime fim = LocalDateTime.now();
			insert.put("ArrayList", ChronoUnit.MILLIS.between(inicio, fim));
			
			inicio = LocalDateTime.now();
			arrayList.get(tamanho/2);
			fim = LocalDateTime.now();
			consult.put("ArrayList", ChronoUnit.MILLIS.between(inicio, fim));
			
			/**LINKEDLIST*/
			inicio = LocalDateTime.now();
			
			for (int i = 0; i < tamanho ; i++) {
				linkedList.add(i);
			}

			fim = LocalDateTime.now();
			insert.put("LinkedList", ChronoUnit.MILLIS.between(inicio, fim));
			
			inicio = LocalDateTime.now();
			linkedList.get(tamanho/2);
			fim = LocalDateTime.now();
			consult.put("LinkedList", ChronoUnit.MILLIS.between(inicio, fim));
			
			/**STARKLIST*/
			inicio = LocalDateTime.now();
			
			for (int i = 0; i < tamanho ; i++) {
				stackList.add(i);
			}

			fim = LocalDateTime.now();
			insert.put("StarkList", ChronoUnit.MILLIS.between(inicio, fim));

			inicio = LocalDateTime.now();
			stackList.get(tamanho/2);
			fim = LocalDateTime.now();
			consult.put("StarkList", ChronoUnit.MILLIS.between(inicio, fim));
			
			/**HASHSET*/
			inicio = LocalDateTime.now();
			
			for (int i = 0; i < tamanho ; i++) {
				hashSetList.add(i);
			}

			fim = LocalDateTime.now();
			insert.put("HashSet", ChronoUnit.MILLIS.between(inicio, fim));

			inicio = LocalDateTime.now();
		
			hashSetList.forEach(h -> {
			    if(h.equals(tamanho/2)) {
			    	int hashValue = h; 
			    	System.out.println(hashValue);		
			    }
			});
			
			fim = LocalDateTime.now();
			consult.put("HashSet", ChronoUnit.MILLIS.between(inicio, fim));
						
	 
			/**HASHMAP*/
			inicio = LocalDateTime.now();
			
			for (int i = 0; i < tamanho ; i++) {
				hashMap.put(i,i);
			}
	
			fim = LocalDateTime.now();
			insert.put("HashMap", ChronoUnit.MILLIS.between(inicio, fim));
	
			inicio = LocalDateTime.now();		
			hashMap.get(tamanho/2);
			fim = LocalDateTime.now();
			consult.put("HashMap", ChronoUnit.MILLIS.between(inicio, fim));
		
			/**WEAKHASHMAP*/
			inicio = LocalDateTime.now();
			
			for (int i = 0; i < tamanho ; i++) {
				weakHashMap.put(i,i);
			}
	
			fim = LocalDateTime.now();
			insert.put("WeakHashMap", ChronoUnit.MILLIS.between(inicio, fim));
	
			inicio = LocalDateTime.now();		
			weakHashMap.get(tamanho/2);
			fim = LocalDateTime.now();
			consult.put("WeakHashMap", ChronoUnit.MILLIS.between(inicio, fim));
			
			System.out.println("Resultados Inserts");
			long valueInsertmin = Collections.min(insert.values());
			long valueInsertmax = Collections.max(insert.values());
			insert.forEach((k,v) ->{
				if(v == valueInsertmin) {
					System.out.println(k+" : "+v+" Lista mais indicada para Inserção");	
				}else if(v == valueInsertmax) {
					System.out.println(k+" : "+v+" Lista menos indicada para Inserção");
				}else {
					System.out.println(k+" : "+v);
				}
				
			});
			
			
			
			System.out.println("Resutados Consultas");
			long valueConsultmin = Collections.min(consult.values());
			long valueConsultmax = Collections.max(consult.values());
			consult.forEach((k,v) ->{
				if(v == valueConsultmin) {
					System.out.println(k+" : "+v+" Lista mais indicada para Consulta");	
				}else if(v == valueConsultmax) {
					System.out.println(k+" : "+v+" Lista menos indicada para Inserção");
				}else {
					System.out.println(k+" : "+v);
				}
				
			});
		
		  }
	}
	 
	 


