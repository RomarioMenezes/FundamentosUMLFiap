package br.com.twitterbot.interfaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.twitterbot.conection.TwitterConection;
import br.com.twitterbot.enums.TipoStatus;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.TwitterException;

public class ImplTwitterBotUtils extends TwitterConection implements TwitterBotUtils {

	private static final long serialVersionUID = -9110363861677626044L;

	@Override
	public void tweetsActions(Query query, TipoStatus tipoStatus) throws TwitterException {

		SimpleDateFormat spf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar cl = Calendar.getInstance();
		
		cl.add(Calendar.WEEK_OF_MONTH, -1);
		List<Status> statusList = new ArrayList<>();
	
		QueryResult result = null;
		query.setSince(spf.format(cl.getTime()));
		query.setUntil(spf.format(Calendar.getInstance().getTime()));
		result = getTwitter().search(query);
				
		
			TwitterConection conexao = new TwitterConection();
			while (result.hasNext())
			{
				query = result.nextQuery();

				for (Status status : result.getTweets()) {
					statusList.add(status);
				}
				result = conexao.getTwitter().search(query);
			}
			

			System.out.println("\nQuantidade por dia de tweets da última semana\n");
			TipoStatus.TWITTERS.action(statusList);
			
			System.out.println("\nQuantidade por dia de retweets da última semana\n");
			TipoStatus.RETTWITTERS.action(statusList);
			
			System.out.println("\nQuantidade por dia de favoritações da última semana.\n");
			TipoStatus.FAVORITS.action(statusList);
		    
			System.out.println("\nOrdenar os tweets pelo nome do autor, e exibir o primeiro nome e o último nome.\n");
			TipoStatus.ORDERBYNAME.action(statusList);
			
			System.out.println("\nOrdenar os tweets pelo nome do autor, e exibir o primeiro nome e o último nome.\n");
			TipoStatus.ORDERBYDATE.action(statusList);
			
			
		
	}

	@Override
	public void tweet(String tweet) throws TwitterException {
		Status status = getTwitter().updateStatus(tweet);
		System.out.println("Tweet postado com sucesso! [" + status.getText() + "].");
	}


}
