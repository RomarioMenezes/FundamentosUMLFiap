package br.com.twitterbot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Arquivo de configuracao 
 */
public class TwitterBotProperties extends Properties {

	private static final long serialVersionUID = 1L;

	public TwitterBotProperties() {
       
    	try (FileInputStream file = new FileInputStream((new File("PropertsTwitterBot.properties")).getAbsoluteFile());) {

           this.load(file);
           
        } catch (IOException e) {
            Logger.getLogger(TwitterBotProperties.class.getName()).log(Level.SEVERE, null, e);
        }

    }

    
    public String getAuthConsumerKey(){
    	return this.getProperty("AuthConsumerKey");
    }
    
    public String getAuthConsumerSecret(){
    	return this.getProperty("AuthConsumerSecret");
    }
    
    public String getToken(){
    	return this.getProperty("Token");
    }
    
    public String getTokenSecret(){
    	return this.getProperty("TokenSecret");
    }
    
    
    
}
