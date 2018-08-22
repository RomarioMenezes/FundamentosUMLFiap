package br.com.twitterbot.interfaces;

import br.com.twitterbot.enums.TipoStatus;
import twitter4j.Query;
import twitter4j.TwitterException;

public interface TwitterBotUtils {

	public void  tweetsActions(Query query,  TipoStatus tipoStatus)  throws TwitterException ;
	
	public void tweet(String tweet) throws TwitterException;
	
}
