package br.com.twitterbot.interfaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.twitterbot.conection.TwitterConection;
import br.com.twitterbot.enums.TipoStatus;
import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;

public class ImplTwitterBotUtils extends TwitterConection implements TwitterBotUtils {

	private static final long serialVersionUID = -9110363861677626044L;

	@Override
	public void tweetsActions(Query query, TipoStatus tipoStatus) throws TwitterException {

		SimpleDateFormat spf = new SimpleDateFormat("YYYY-MM-dd");
		Calendar cl = Calendar.getInstance();
		String data = spf.format(cl.getTime());
		cl.add(Calendar.WEEK_OF_MONTH, -1);
		List<String> listData = new ArrayList<>();
	
			while (!spf.format(cl.getTime()).equals(data)) {
					System.out.println("\nDia : " + spf.format(cl.getTime()) + "\n");
					listData.add(spf.format(cl.getTime()));
					
					query.setSince(spf.format(cl.getTime()));
					tipoStatus.action(getTwitter().search(query));
					cl.add(Calendar.DAY_OF_YEAR, 1);	
				}
			
			if(tipoStatus.name().equals(TipoStatus.ORDERBYDATE.name())) {
				System.out.println("\nDATA MAIS ANTIGA DA ULTIMA SEMANA: "+listData.get(0)+"\n");
				query.setSince(listData.get(0));
				tipoStatus.action(getTwitter().search(query));
				
				System.out.println("\nDATA MAIS RECENTE DA ULTIMA SEMANA: "+listData.get(listData.size()-1)+"\n");
				query.setSince(listData.get(listData.size()-1));		
				tipoStatus.action(getTwitter().search(query));
			}
		
	}

	@Override
	public void tweet(String tweet) throws TwitterException {
		Status status = getTwitter().updateStatus(tweet);
		System.out.println("Tweet postado com sucesso! [" + status.getText() + "].");
	}


}
