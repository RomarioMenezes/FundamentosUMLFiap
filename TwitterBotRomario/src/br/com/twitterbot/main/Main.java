package br.com.twitterbot.main;

import br.com.twitterbot.interfaces.ImplTwitterBotUtils;
import br.com.twitterbot.util.TwitterBotProperties;
import twitter4j.Query;

public class Main {

	static TwitterBotProperties properts = new TwitterBotProperties();

	public static void main(String[] args) {
		
		try {
			Query query = new Query("#jvm");
			
			new ImplTwitterBotUtils().tweetsActions(query, null);
			
			new ImplTwitterBotUtils().tweet("Referenciando professor @michelpf");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	


}
