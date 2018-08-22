package br.com.twitterbot.conection;

import br.com.twitterbot.util.TwitterBotProperties;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterConection extends TwitterBotProperties{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4407973624346660395L;

	public Twitter getTwitter() {
		
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setOAuthConsumerKey(getAuthConsumerKey().trim());

		builder.setOAuthConsumerSecret(getAuthConsumerSecret().trim());
		Configuration configuration = builder.build();

		TwitterFactory factory = new TwitterFactory(configuration);
		Twitter twitter = factory.getInstance();
		AccessToken accessToken = loadAccessToken();
		twitter.setOAuthAccessToken(accessToken);
		
		return twitter;
	}

	private  AccessToken loadAccessToken() {
		String token = getToken().trim();
		String tokenSecret = getTokenSecret().trim();
		return new AccessToken(token, tokenSecret);
	}
}
