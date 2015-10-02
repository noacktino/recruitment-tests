package com.asideas.recruitmenttests.newsapp.test;

import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import com.asideas.recruitmenttests.newsapp.NewsApplication;
import com.asideas.recruitmenttests.newsapp.pojo.NewsPojo;

public class NewsAppJerseyTest extends JerseyTest {
	
	@Override
	public Application configure() {
		return new NewsApplication();
	}
	
	@Test
	public void getAllNews() {
		Assert.assertEquals(target("v1/news").request().get().getStatus(), 200);
	}
	
	@Test
	public void getSpecificNewsEntry() {
		Assert.assertEquals(
				target("v1/news/5731d173-063f-4921-99dd-9e417d64171a")
				.request().get().getStatus(), 200);
	}
	
	@Test
	public void deleteSpecificNewsEntry() {
		Assert.assertEquals(
				target("v1/news/071c74c2-1885-4739-8690-af9907afb977")
				.request().delete().getStatus(), 200);		
	}
	
	@Test
	public void putSpecificNewsEntry() {
		NewsPojo pojo = new NewsPojo();
		pojo.setHeader("Test Header");
		pojo.setShortDescription("Test Description");
		pojo.setId(UUID.fromString("5731d173-063f-4921-99dd-9e417d64171a"));
	    Response res = target("v1/news/5731d173-063f-4921-99dd-9e417d64171a")
	    		.request().put(Entity.entity(pojo, MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, res.getStatus());				
	}
	
	@Test
	public void insertNews() {
		NewsPojo pojo = new NewsPojo();
		pojo.setHeader("Test Header");
		pojo.setShortDescription("Test Description");
	    Response res = target("v1/news").request().post(
	    		Entity.entity(pojo, MediaType.APPLICATION_JSON));
		Assert.assertEquals(200, res.getStatus());
	}
	
}
