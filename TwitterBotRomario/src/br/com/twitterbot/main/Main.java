package br.com.twitterbot.main;

import br.com.twitterbot.enums.TipoStatus;
import br.com.twitterbot.interfaces.ImplTwitterBotUtils;
import br.com.twitterbot.util.TwitterBotProperties;
import twitter4j.Query;

public class Main {

	static TwitterBotProperties properts = new TwitterBotProperties();

	public static void main(String[] args) {
		
		try {
			Query query = new Query("#jvm");
			
			System.out.println("\nQuantidade por dia de tweets da última semana\n");
			new ImplTwitterBotUtils().tweetsActions(query, TipoStatus.TWITTERS);
			
			System.out.println("\nQuantidade por dia de retweets da última semana\n");
			new ImplTwitterBotUtils().tweetsActions(query, TipoStatus.RETTWITTERS);
			
			System.out.println("\nQuantidade por dia de favoritações da última semana.\n");
			new ImplTwitterBotUtils().tweetsActions(query, TipoStatus.FAVORITS);
		    
			System.out.println("\nOrdenar os tweets pelo nome do autor, e exibir o primeiro nome e o último nome.\n");
			new ImplTwitterBotUtils().tweetsActions(query, TipoStatus.ORDERBYDATE);
			
			
			new ImplTwitterBotUtils().tweet("Referenciando professor @michelpf");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	


}
