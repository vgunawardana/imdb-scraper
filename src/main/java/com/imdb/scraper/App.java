package com.imdb.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class App 
{
    public static void main( String[] args )
    {
    	
    	try {
    		//to find out default user agent
			/*
			 * String str = Jsoup.connect("http://www.useragentstring.com/")
			 * .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
			 * ) .get().text();
			 * 
			 * System.out.println(str);
			 */
    		
    		Document doc = Jsoup.connect("https://www.imdb.com/search/title/?groups=top_250&sort=user_rating").get();
    		
    		Elements movieItems = doc.select("h3.lister-item-header");
    		
    		int i=0;
    		
    		for(Element movieItem : movieItems) {
    			i++;
    			System.out.println(i+ " " +movieItem.getElementsByTag("a").first().text());
    		}
    		
    		
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
        
    }
}
