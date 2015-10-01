package com.asideas.recruitmenttests.newsapp;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * This is the main class of the news application.
 * 
 * @author Tino
 *
 */
public class NewsApplication extends ResourceConfig {

	public NewsApplication() {
		super();

		// Register packages which include the URI mapping
		packages("com.asideas.recruitmenttests.newsapp.rest");
	}
	
}
