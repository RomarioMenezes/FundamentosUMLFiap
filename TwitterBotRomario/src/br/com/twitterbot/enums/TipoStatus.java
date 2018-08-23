package br.com.twitterbot.enums;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import twitter4j.Status;
import twitter4j.User;

public enum TipoStatus {
		
	
	TWITTERS {
		@Override
		public void action(List<Status> status) {
			SimpleDateFormat spf = new SimpleDateFormat("YYYY-MM-dd");
			Set<String> dates = status.stream().map(Status::getCreatedAt).map(s -> spf.format(s)).sorted().
			collect(Collectors.toCollection(HashSet::new));
			
			dates.forEach(d -> {
				count = 0;
				status.forEach(s -> {
					if(d.equals(spf.format(s.getCreatedAt()))) {
						count++;   
					}
				});
				System.out.println("Quantidades de Twitters do dia "+d+" : "+count);
			});
			
			System.out.println("Quantidade de Twitter da semana: "+ status.size());
						
		}
	},
	RETTWITTERS {
		@Override
		public void action(List<Status> status) {
			
			SimpleDateFormat spf = new SimpleDateFormat("YYYY-MM-dd");
			Set<String> dates = status.stream().map(Status::getCreatedAt).map(s -> spf.format(s)).sorted().
			collect(Collectors.toCollection(HashSet::new));
			countTotal = 0;
			dates.forEach(d -> {
				count = 0;
				status.forEach(s -> {
					if(d.equals(spf.format(s.getCreatedAt()))) {
						count+=s.getRetweetCount();   
					}
				});
				System.out.println("Quantidades de Retwitters do dia "+d+" : "+count);
				countTotal+=count;
			});
			
			System.out.println("Quantidade de Rewitter da semana: "+ countTotal);

			
		}
	},
	FAVORITS {
		@Override
		public void action(List<Status> status) {
			
			SimpleDateFormat spf = new SimpleDateFormat("YYYY-MM-dd");
			Set<String> dates = status.stream().map(Status::getCreatedAt).map(s -> spf.format(s)).sorted().
			collect(Collectors.toCollection(HashSet::new));
			countTotal = 0;
			dates.forEach(d -> {
				count = 0;
				status.forEach(s -> {
					if(d.equals(spf.format(s.getCreatedAt()))) {
						count+=s.getFavoriteCount();   
					}
				});
				System.out.println("Quantidades de Retwitters do dia "+d+" : "+count);
				countTotal+=count;
			});
			
			System.out.println("Quantidade de Favoritações da semana: "+ countTotal);
			
		}
	},
	 ORDERBYNAME{
		@Override
		public void action(List<Status> status) {
			
			Set<String> users = status.stream().map(Status::getUser).map(User::getName).sorted().
            collect(Collectors.toCollection(HashSet::new));
			List<String> nomes = new ArrayList<>(users);
			Collections.sort(nomes);
			
			nomes.forEach(n -> {
				System.out.println("Nome do Autor : "+ n);
				status.forEach(s -> {
					if(n.equals(s.getUser().getName())) {
						System.out.println("tweet: "+s.getText());
					}
				});
				System.out.println("\n");
			});
			
			
			System.out.println("\nPrimeiro Nome: "+nomes.get(0));
			System.out.println("Ultimo Nome:" +nomes.get(nomes.size()-1));
			
		}
	},
	ORDERBYDATE {
		@Override
		public void action(List<Status> status) {

			
			SimpleDateFormat spf = new SimpleDateFormat("dd-MM-YYYY");
			Set<String> dates = status.stream().map(Status::getCreatedAt).map(s -> spf.format(s)).sorted().
			collect(Collectors.toCollection(HashSet::new));

			List<String> datasOrds = new ArrayList<>(dates);
			Collections.sort(datasOrds, (u1,u2) -> u1.compareTo(u2));
			
			datasOrds.forEach(d -> {
				System.out.println("Tweets do dia: "+d);
				status.forEach(s -> {
					if(d.equals(spf.format(s.getCreatedAt()))) {
						System.out.println("tweet: "+s.getText());
					}
				});
				System.out.println("\n");
			});
			
			System.out.println("DATA MAIS ANTIGA: "+status.get(0).getCreatedAt());
			System.out.println("DATA MAIS RECENTE: "+status.get(status.size()-1).getCreatedAt());
			
		}
	};
	
	
	private static long countTotal;
	private static long count;
	public abstract void action(List<Status> status);
	
}
