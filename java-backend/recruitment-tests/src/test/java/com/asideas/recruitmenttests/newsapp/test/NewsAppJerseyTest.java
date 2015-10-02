package com.asideas.recruitmenttests.newsapp.test;

import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import com.asideas.recruitmenttests.newsapp.NewsApplication;
import com.asideas.recruitmenttests.newsapp.pojo.NewsPojo;

public class NewsAppJerseyTest extends JerseyTest {
	
	private String newsXML = "";
	private String newsJSON = ""; 
	
	@Override
	public Application configure() {
		try {
			newsXML = new String(Files.readAllBytes(
					Paths.get(getClass().getResource("./news.xml").toURI())));
			newsJSON = new String(Files.readAllBytes(
					Paths.get(getClass().getResource("./news.json").toURI())));
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return new NewsApplication();
	}
	
	@Test
	public void insertNews() {
		Assert.assertEquals(
				target("v1/news").request(MediaType.APPLICATION_JSON).post(
						Entity.entity(newsJSON, MediaType.APPLICATION_JSON))
						.getStatus(), 200);
	}
	
	@Test
	public void getNews() {
		Assert.assertEquals(target("v1/news").request().get().getStatus(), 200);
		target("v1/news/5731d173-063f-4921-99dd-9e417d64171a").request().get().readEntity(NewsPojo.class);
	}
	
}
