package br.com.twitterbot.enums;

import java.util.Collections;
import java.util.List;

import twitter4j.QueryResult;
import twitter4j.Status;

public enum TipoStatus {
		
	TWITTERS {
		@Override
		public void action(QueryResult result) {
			
			status = result.getTweets();
			count = 0;
			status.forEach(s ->{
				count+=s.getRetweetCount();
			});
			System.out.println("Quantidade de Twitter : "+count);
			
						
		}
	},
	RETTWITTERS {
		@Override
		public void action(QueryResult result) {
			
			status = result.getTweets();
			count = 0;
			status.forEach(s ->{
				count+=s.getRetweetCount();
			});
			System.out.println("Quantidade de ReTwitter : "+count);
		}
	},
	FAVORITS {
		@Override
		public void action(QueryResult result) {
			
			status = result.getTweets();
			count = 0;
			status.forEach(s ->{
				count += s.getFavoriteCount();
			});
			System.out.println("Quantidade de Favoritações : "+count);
		}
	},
	 ORDERBYNAME{
		@Override
		public void action(QueryResult result) {
			
			status = result.getTweets();

			Collections.sort(status,(u1, u2) -> u1.getUser().getName().compareTo(u2.getUser().getName()));
			
			System.out.println("LISTA ORDENADA");
			status.forEach(s -> {
				System.out.println("Nome do autor: "+s.getUser().getName());
				System.out.println("Tweet: "+s.getText());
			});
			
			System.out.println("Primeiro Nome: "+status.get(1).getUser().getName());
			System.out.println("Ultimo Nome:" +status.get(status.size()-1).getUser().getName());
			
			
		}
	},
	ORDERBYDATE {
		@Override
		public void action(QueryResult result) {
			
			status = result.getTweets();
			
			status.forEach(s -> {	
				System.out.println("Nome do autor: "+s.getUser().getName());
				System.out.println("Tweet: "+s.getText());
			});
			
			
		}
	};
	
	
	private static List<Status> status;
	private static long count;
	
	public abstract void action(QueryResult result);
	
}
